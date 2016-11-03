//$Id: EventCountPolicy.java,v 1.1.1.1 2006/11/16 15:39:58 gramkumar Exp $
package test;

import java.io.*;
import java.util.*;

import java.text.SimpleDateFormat;
import com.adventnet.management.policydb.PolicyEvent;
import com.adventnet.management.policydb.NmsPolicyAPI;
import com.adventnet.management.policydb.PeriodicPolicyObject;
import com.adventnet.nms.util.NmsLogMgr;
import com.adventnet.nms.util.NmsUtil ;
import com.adventnet.nms.util.PureUtils;
import com.adventnet.nms.eventdb.EventAPI;
import com.adventnet.nms.eventdb.InputEvent;
import com.adventnet.nms.severity.SeverityInfo;
import com.adventnet.nms.eventdb.Event;

import java.rmi.Naming;

/**
 * This periodic policy, creates EventReports in the form of HTML tables. This table
 * shows the number of Events generated for a particular Managed Object. 
 * This Event Report is generated based on the Events generated between last execution time
 * and current execution time. For example, if the period of this policy
 * is set as x hours, it will generate a report for Events which are generated
 * in the last x hours.
 * 
 * Report which is generated by this policy shows the number of Events generated for all entities
 * belongs to a particular source. Basically source-entity-severity, relationship 
 * is captured here. By extending this policy, insteadof source-entity-severity relationship,
 * any property relationship can be captured. This policy can be extended to modify the report output. 
 * Instead of html files, you can generate your own reports.
 */

public class EventCountPolicy extends PeriodicPolicyObject 
{

	//The time at which the last file was created.
	private long lastTime;
   	
    //This is just to check the first execution of this policy.
    private static boolean firstTime=true;
    
   	//The id of the last Event which was stored in the previous file
    private int lastId;

    //Utility class which is used to convert Events into HTML tables.
    private HTMLUtility util = null;

    /**
     * Default Constructor which initializes the policy period and directory under
     * which html reports are to be stored. Also initializes the utility classes.
     */
    public EventCountPolicy()
    {
		super();
		policyObjectCustomizer = "com.adventnet.nms.policies.EventPolicyCustomizer"; 
        period = 24*3600;
        util = HTMLUtility.getInstance();
        setUserProperty("Events_Directory","EventCount");
    }

    /**
     * Sets the properties for this policy object
     * Following are the user properites of this policy which are stored in database.
     * lastId -- Id of the last logged Event.
     * lastTime -- time at which last execution of this policy was performed.
     * @param p the property to be set.
     */
    public void setProperties(Properties p)
    {
		String temp = (String)p.remove("Events_Directory");
		//instance variables are saved in DB as user properties
		if( temp != null )
		{
           setUserProperty("Events_Directory",temp.trim());
		}
        temp = (String)p.remove("lastId");
        if( temp != null )
        {
            setUserProperty("lastId",temp.trim());
        }
        temp =(String)p.remove("lastTime");
        if ( temp != null )
        {
            setUserProperty("lastTime",temp.trim());
        }
		super.setBaseProperties(p);
    }

    /**
     * Returns the Properties of this policy
     * @return Properties of this policy
     */
    public Properties getProperties()
    {
        Properties p = super.getBaseProperties();
        return p;
    }

    /**
     * Returns the URL in String form. This page will be opened
     * when help button is clicked in the client
     */
    public String getHelpURL()
    {
		return null;  
    }

   	
    /**
     * Instead of the default policy UI, if user wants he can create his own GUI
     * for his policy. This method returns name of the class which extends PolicyObjectCustomizer.
     */
    public String getPolicyObjectCustomizer()
    {
		return policyObjectCustomizer;
    }

	/**
     * Core method, invokded when ever this policy needs execution. 
     * This method gets all Events through EventAPI method call, 
     * and using HTML utility, reports are created.
     */
    public void executeAction(PolicyEvent policyEvt)
	{
        try
        {
			//default directory is "EventCount"
			String directory = "EventCount";
            //Properties got from API and from that properties instance variables are assigned
			NmsPolicyAPI api = (NmsPolicyAPI)NmsUtil.getAPI("NmsPolicyAPI");
            Properties tempProp = api.getPolicy(getName()).getProperties(); 
            String temp =(String)tempProp.get("Events_Directory");
            if(temp !=null)
            {
                directory = temp;
            }
            temp = (String)tempProp.get("lastId");
            if(temp != null)
            {
                lastId = Integer.parseInt(temp);
            }
            temp = (String)tempProp.get("lastTime");
            if(temp != null)
            {
                lastTime = Long.parseLong(temp);
            }
            temp = (String)tempProp.get("period");
            if(temp != null)
            {
                period = Integer.parseInt(temp);
            }
			Date now = new Date();
        	SimpleDateFormat formatter = new SimpleDateFormat ("MM-dd-yy_H-mm-ss");
        	String timestamp = formatter.format(now);	
            File dir = new File(PureUtils.rootDir+directory);
        	String title ="";
            if(firstTime)
            {
                title = "EVENT REPORT :    "+now.toString();
                firstTime=false;
            }
            else
            {
                title = "EVENT REPORT :    "+new Date(lastTime).toString()+"  -  "+now.toString();
            }
            Vector eventVector=getEvents(now);
            if(eventVector != null && eventVector.size()!=0)	
            {	
				eventVector=checkForId(eventVector);
				lastId=((Event)eventVector.lastElement()).getId();
                if (!dir.exists()) dir.mkdirs();
           		FileOutputStream fileout =new FileOutputStream(directory+"/"+"EventsCount_"+timestamp+".html");
            	PrintWriter out = new PrintWriter(fileout);
                
                String countData= util.getCountData(eventVector,title);
                out.write(countData);
                
				out.flush();
        		fileout.close();
                
            }
            //setting the modified instance variables as userProperties of policy and updating the policy
			setUserProperty("Events_Directory",directory);
            setUserProperty("lastId",String.valueOf(lastId));
            setUserProperty("lastTime",String.valueOf(lastTime));
            api.updatePolicy(name,getProperties());
		}
        catch(Exception e)	
        {
        	NmsLogMgr.POLICYERR.fail(NmsUtil.GetString("Error in execution of EventCountPolicy")+e,e);
        }
    }
    
    /**
     * Utility method, which is used to identify missing of Events
     */
    private Vector checkForId(Vector eventVector) throws Exception
    {
        EventAPI eventAPI=(EventAPI)NmsUtil.getAPI("EventAPI");
		if(eventAPI == null)
        {
            System.err.println(" EventAPI is null in EventPolicy");
            return null;
        }
    	int firstId=((Event)eventVector.firstElement()).getId();
    	int position=0;
    	if((lastId+1)!=firstId)
    	{
    		for(int i=lastId+1;i<firstId;i++)
    		{
				Event ev = null;

				try
				{			
    				ev = eventAPI.getEventByID(i);
				}
				catch(Exception fe)
				{	
					System.err.println("Exception while getting the event. ");
					throw fe;
				}	
                if(ev != null)
                {
                    eventVector.add(position, ev);
                    position++;
                }
    		}
    	}
    	return eventVector;	
    }

    /**
     * Utility method which is used to fetch Events from database
     */
    private Vector getEvents(Date now) throws Exception
    {
		EventAPI eventAPI=null;
	    Vector eventVector=null;
    	eventAPI= (EventAPI)NmsUtil.getAPI("EventAPI");
    	if(eventAPI == null)
        {
            System.err.println(" EventAPI is null in EventPolicy");
            return null;
        }
        InputEvent event1 = new InputEvent();
        InputEvent event2 = new InputEvent();
        event1.setTime(lastTime);
        event2.setTime(now.getTime());
        eventVector = eventAPI.getEvents(event1,event2);
        lastTime=now.getTime();
		return eventVector;
    }
}
