package com.adventnet.nms.extend;

import com.adventnet.nms.topodb.*;


public  class specialMO2 extends com.adventnet.nms.topodb.TopoObject
{
	//<Begin_Variable_Declarations>
	public String specialName;
	public int specialStatus;
	public String operStatus;
	public String adminStatus;
	public String mo2;
	//<End_Variable_Declarations>

  
  public  void setSpecialName(String specialNameArg)
  {
    //<Begin_setSpecialName_String> 
    if(specialNameArg != null)
    {
	specialName = specialNameArg;
    }
  
    //<End_setSpecialName_String>
  } 
  
  public  String getSpecialName()
  {
        //<Begin_getSpecialName> 
	return specialName;
  
        //<End_getSpecialName>
  } 
  
  public  void setSpecialStatus(int specialStatusArg)
  {
    //<Begin_setSpecialStatus_int> 
    specialStatus = specialStatusArg;
  
    //<End_setSpecialStatus_int>
  } 
  
  public  int getSpecialStatus()
  {
        //<Begin_getSpecialStatus> 
	return specialStatus;
  
        //<End_getSpecialStatus>
  } 
  
  public  void setOperStatus(String operStatusArg)
  {
    //<Begin_setOperStatus_String> 
    if(operStatusArg != null)
    {
	operStatus = operStatusArg;
    }
  
    //<End_setOperStatus_String>
  } 
  
  public  String getOperStatus()
  {
        //<Begin_getOperStatus> 
	return operStatus;
  
        //<End_getOperStatus>
  } 
  
  public  void setAdminStatus(String adminStatusArg)
  {
    //<Begin_setAdminStatus_String> 
    if(adminStatusArg != null)
    {
	adminStatus = adminStatusArg;
    }
  
    //<End_setAdminStatus_String>
  } 
  
  public  String getAdminStatus()
  {
        //<Begin_getAdminStatus> 
	return adminStatus;
  
        //<End_getAdminStatus>
  } 
  
   
  
   
  
  public java.util.Properties getProperties()
  {
        //<Begin_getProperties> 
	java.util.Properties mosource_prop;
	mosource_prop = super.getProperties();

	mosource_prop.put("specialName",getSpecialName());
	mosource_prop.put("specialStatus",String.valueOf(getSpecialStatus()));
	mosource_prop.put("operStatus",getOperStatus());
	mosource_prop.put("adminStatus",getAdminStatus());
	mosource_prop.put("mo2",getMo2());
	return mosource_prop;
  
        //<End_getProperties>
  } 
  
  public void setProperties(java.util.Properties p)
  {
        //<Begin_setProperties_java.util.Properties> 

	String specialNamevalue=p.getProperty("specialName");
	if(specialNamevalue!=null)
	{ 
		specialName=specialNamevalue;
		p.remove("specialName");
	} 

	String specialStatusvalue=p.getProperty("specialStatus");
	if(specialStatusvalue!=null)
	{ 
		specialStatus=(new Integer(specialStatusvalue).intValue());
		p.remove("specialStatus");
	} 

	String operStatusvalue=p.getProperty("operStatus");
	if(operStatusvalue!=null)
	{ 
		operStatus=operStatusvalue;
		p.remove("operStatus");
	} 

	String adminStatusvalue=p.getProperty("adminStatus");
	if(adminStatusvalue!=null)
	{ 
		adminStatus=adminStatusvalue;
		p.remove("adminStatus");
	} 

	String mo2value=p.getProperty("mo2");
	if(mo2value!=null)
	{ 
		mo2=mo2value;
		p.remove("mo2");
	} 
	super.setProperties( p);

  
        //<End_setProperties_java.util.Properties>
  } 
  
  public Object clone()
  {
        //<Begin_clone> 
	return super.clone();
  
        //<End_clone>
  } 
  
  public int checkStatus() throws java.rmi.RemoteException
  {
        //<Begin_checkStatus> 
	return super.checkStatus();
  
        //<End_checkStatus>
  } 


 
  
  public  void setMo2(String mo2Arg)
  {
    //<Begin_setMo2_String> 
    if(mo2Arg != null)
    {
	mo2 = mo2Arg;
    }
  
    //<End_setMo2_String>
  } 
  
  public  String getMo2()
  {
        //<Begin_getMo2> 
	return mo2;
  
        //<End_getMo2>
  }
} 
