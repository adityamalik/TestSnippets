//$Id: AddCustom.java,v 1.2 2007/02/22 15:02:57 srajeswari Exp $
package com.adventnet.nms.example;

//swing imports
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.table.TableColumn;

//awt imports
import java.awt.*;
import java.awt.event.*;

//util imports
import java.util.*;

//WebNMS imports
import com.adventnet.nms.util.NmsClientUtil;
import com.adventnet.nms.util.*;


/** 
 * This is an example data form customizer class invoked in the Events module
 * to Add a Custom View. The class extends the abstract class 
 * com.adventnet.nms.util.DataFormCustomizer and overrides the 
 * methods getCustomizer(), setCustomViewProperties() and getCustomViewProperties()
 * in it.
 * 
 * <p>The Web NMS on instantiating this class registers itself as a PropertyChangeListener
 * to this class and calls the setCustomViewProperties() method on this class
 * passing a Vector of CustomViewObjects as a parameter. The class using
 * this, constructs a Dialog. Then the Web NMS subsequently calls
 * the getCustomizer() method to get the Dialog UI and displays it. 
 * 
 * <p>After the user had finished entering the criterias for the new Custom View
 * and presses the 'Add' button two possible alternatives to add the custom view
 * is given in the actionPerformed() method
 * 
 *<pre>
 *		1. Adding the Custom Views using the APIs present in com.adventnet.nms.util.NmsUiAPI
 *		
 *		2. Calling the firePropertyChange() method which will intimate the Web NMS
 *		   that the customizer class has completed its function. The Web NMS
 *		   on receiving this intimation will call the getCustomViewProperties()
 *		   method to get the modified CustomViewObjects vector and then proceeds
 *		   to add the Custom View.
 * </pre>
 * 
 * <p>By default the first alternative is used and the second alternative
 * is commented if the user wishes to use it, then the second option could
 * be uncommented, after commenting the first alternative. 
 * 
 * 
 */


public class AddCustom extends GroupedDataFormCustomizer implements ActionListener
{
	
	
	private JDialog dialog;       //dialog used to construt UI
	private JFrame parentFrame;	  //parent frame for the dialog 	
	private JPanel displayPanel;  // panel for displaying all components
	private JPanel buttonPanel;   // panel for adding buttons
	private JPanel parentPanel;   // this acts as the contentpane of dialog 
	private JPanel treePanel;
	private JPanel mainPanel;
	private JPanel titlePanel;    // to display CustomViewName 
	private JPanel formPanel;
	private JPanel userPanel;

	private GridBagLayout gbLayout;
	private GridBagConstraints constraints;
	private JButton butAdd;           //  button for adding customViews
	private JButton butCancel;


	private Hashtable getObjects  = new Hashtable();
	private Hashtable save  = new Hashtable();

	private Vector objects;       // handle to hold CustomViewObjects
	private Vector custom;
	private Vector form;
	private Vector getCustomObject;
	private Vector getFormObject;
	private Vector formVector = new Vector();
	private Vector textVector = new Vector();

	private Vector componentVector=new Vector();  // for adding the Components that are created
	private Vector checkBoxVector=new Vector();    // for adding checkBoxes that are used to select display name
	private Vector disNameVector=new Vector();     // for adding textfields that contains heading names	
	private Font font = NmsClientUtil.getFont();
	private Color color=new Color(10,50,120);
	private int size,offset=0;
	private int noOfColumns =2;
	private int countRows=1;
	private String customViewName="";//No Internationalisation
	private String key="";//No Internationalisation
	private boolean flag = true;
	
	private JTabbedPane tabPane = new JTabbedPane(); 		
	private JScrollPane jscroll;
	private JTextField customNameTextField;   // to display customViewName
	
	
	/**
	 * This method overrides its corresponding couterpart 
	 * in com.adventnet.nms.util.DataFormCustomizer. This method is called
	 * by Web NMS to get the UI as a Window Object. The Window Object returned
	 * will contain the necessary information to get the new criteria to 
	 * add a Custom View constructed  with the CustomViewObjects passed by 
	 * NMS using setCustomViewProperties() method.
	 * 
	 * @return "Window"  which has the UI corresponding to CustomViewObjects
	 */	

	public Window getCustomizer()
	{
		return init(objects);  //constructs UI and returns a window
		
	}
	
	/** 
	 * This method overrides its corresponding counterpart  
	 * in com.adventnet.nms.util.DataFormCustomizer. This method will be called by Web NMS 
	 * as soon as this class is instantiated and Web NMS has registered itself
	 * as a PropertyChangeListener to the instantiated object. Web NMS passes
	 * the properties of the Custom View as a Vector of CustomViewObjects using
	 * which we construct the UI to be shown for Adding the Custom View.
	 * 
	 * 
	 * @param "property"   This is a Vector of CustomViewObjects which will be 
	 *                     passed to this class by Web NMS.
	 * 
	 */
	
	public void setCustomViewProperties(Vector property)
	{
		objects=property;   // sets the CustomViewObjects     
	}


	/** 
	 * This method overrides its corresponding couterpart in com.adventnet.nms.util.DataFormCustomizer. 
	 * Web NMS calls this method after this class fires a 
	 * firePropertyChange() method to Web NMS. On receiving the
	 * firePropertyChange() intimation Web NMS calls this 
	 * method to get the Vector of CustomViewObjects which will contain
	 * the criteria for the new Custom View to be Added and and 
	 * proceeds to Add it.
	 * 
	 * @return "Vector"   Returns a Vector of CustomViewObjects which gives the properties
	 *                    of the Custom View objects updated by the user.
	 */
	
	public Vector getCustomViewProperties()
	{
		return objects;       // returns modified customViewObjects
	}
	
	/**This method gets CustomViewObjects as a Vector and constructs an UI
	 * 
	 * 
	 * @param "objects"  This a vector containing CustomViewObjects
	 * @return "Window"  Returns the constructed UI as a Window
	 */
	private Window init (Vector objects)
	{
		this.objects=objects;
		//int sizeOfObjects=objects.size();        // size of the Vector containing customViewObjects		
		butAdd=new JButton(NmsClientUtil.GetString("Add"));
        butAdd.setActionCommand("Add");
		butCancel=new JButton(NmsClientUtil.GetString("Cancel"));
        butCancel.setActionCommand("Cancel");
        butAdd.addActionListener(this);    //adding actionListeners to the buttons
		butCancel.addActionListener(this);

		
		
		gbLayout=new GridBagLayout();
		constraints=new GridBagConstraints();
		
		displayPanel=new JPanel(gbLayout);
		treePanel = new JPanel(new BorderLayout());
		formPanel = new JPanel(gbLayout);
		jscroll=new JScrollPane(formPanel);
		treePanel.add(jscroll,BorderLayout.CENTER);
		


		parentPanel=new JPanel(new BorderLayout());
		buttonPanel=new JPanel();
		mainPanel = new JPanel(new BorderLayout());
		titlePanel=new JPanel(gbLayout);

		
		modifyGirdConstraints(0,0);  // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		constraints.gridwidth=3;
	
		JLabel title_Name=new JLabel(" "+NmsClientUtil.GetString("Custom View  Name")+"   :   ");     // label for displaying header
		title_Name.setForeground(color);
		gbLayout.setConstraints(title_Name,constraints);
		titlePanel.add(title_Name);
		
		modifyGirdConstraints(3,0); // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		constraints.gridwidth=1;
		
		customNameTextField=new JTextField(10);        // textfield to display CustomViewName
		customNameTextField.setText(customViewName);
		customNameTextField.setForeground(color);
		gbLayout.setConstraints(customNameTextField,constraints);
		titlePanel.add(customNameTextField);
		
		modifyGirdConstraints(0,0);  // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		constraints.gridheight=3;
		constraints.gridwidth=8;
		constraints.insets=new Insets(10,0,10,0);
		
		gbLayout.setConstraints(titlePanel,constraints);
		displayPanel.add(titlePanel);
		
		constraints.gridheight=1;
		constraints.gridwidth=2;
		constraints.insets=new Insets(10,0,10,0);
		
		JLabel column_Name=new JLabel("    "+NmsClientUtil.GetString("Name")+"    ");       //  column header
		column_Name.setBorder(new BevelBorder(BevelBorder.RAISED));
		column_Name.setForeground(color);
		
		JLabel column_Value=new JLabel("                      "+NmsClientUtil.GetString("Value")+"                     ");    //column header
		column_Value.setBorder(new BevelBorder(BevelBorder.RAISED));
		column_Value.setForeground(color);
		
		JLabel column_Select=new JLabel(" "+NmsClientUtil.GetString("Select")+" ");      //  column header//No Internationalisation
		column_Select.setBorder(new BevelBorder(BevelBorder.RAISED));
		column_Select.setForeground(color);
		
		JLabel column_DisName=new JLabel("  "+NmsClientUtil.GetString("Display Name")+"   ");       //  column header//No Internationalisation
		column_DisName.setBorder(new BevelBorder(BevelBorder.RAISED));
		column_DisName.setForeground(color);
		
		modifyGirdConstraints(0,3);      // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		gbLayout.setConstraints(column_Name,constraints);
		displayPanel.add(column_Name);
		
		modifyGirdConstraints(2,3);   // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		gbLayout.setConstraints(column_Value,constraints);
		displayPanel.add(column_Value);
		
		JLabel justForAlignment=new JLabel("         ");      //for good alignment//No Internationalisation
		
		modifyGirdConstraints(4,3);     // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		
		gbLayout.setConstraints(justForAlignment,constraints);
		displayPanel.add(justForAlignment);
		
		modifyGirdConstraints(6,3);     // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		gbLayout.setConstraints(column_Select,constraints);
		displayPanel.add(column_Select);
		
		modifyGirdConstraints(8,3);    // method to set gridx,gridy positions for constraints (constraints is a instance of GridBagConstraints)
		gbLayout.setConstraints(column_DisName,constraints);
		displayPanel.add(column_DisName);
		
		constraints.insets=new Insets(6,0,0,0);
		buttonPanel.add(butAdd);
		buttonPanel.add(butCancel);
		//parentPanel.add(buttonPanel,BorderLayout.SOUTH);
		mainPanel.add(buttonPanel,BorderLayout.SOUTH);
		getComponent(key,getObjects);
		JScrollPane jsp=new JScrollPane(displayPanel);
		parentPanel.add(jsp,BorderLayout.CENTER);
		
		parentFrame = getParentFrame();
		dialog=new JDialog(parentFrame," "+NmsClientUtil.GetString("Add Custom View")+" ",false);  //No Internationalisation
		tabPane=createPane();
		mainPanel.add(tabPane);
		dialog.getContentPane().add(mainPanel);
		dialog.setSize(500,500);

		dialog.addWindowListener(new WindowAdapter()
			{
			public void windowClosing(WindowEvent we)
			{
			we.getWindow().dispose();
			}
			
			}
								 );

		return dialog;
	}

	
	/** 
	 * This method displays the passed error message in a JOptionPane.
	 * 
	 * 
	 * @param message  ErrorMessage as a String
	 */
	private void showErrorMessage(String message)
	{
		JOptionPane errorMessage=new JOptionPane();
		errorMessage.showMessageDialog(dialog,message,NmsClientUtil.GetString("Error"),JOptionPane.ERROR_MESSAGE);
		errorMessage.setVisible(true);
	}
	
	
	/** 
	 * This method is used to display the properties of CustomViewObjects
	 * depending upon it's properties. Object with a property name as 'Filter View Name'
	 * is taken as the form name.  If the property name is 'time' then a method called 
	 * getDateComponents() is invoked and it's fields are displayed accordingly.
	 * If the customViewObject has a list of possible values then combobox is choosen to display 
	 * it's multiple possible values. If all the above conditions are not met then textfield is 
	 * choosen for it's display .
	 * 
	 * 
	 * @param customObject   This is the CustomViewObject for which the appropriate
	 *                       display component would be shown.
	 */
	
	private void displayCustomViewObject(String key,Object obj)
	{
		Component component;
		Component formComponent;
			if(key.equalsIgnoreCase("CUSTOMVIEW_PROPERTIES"))
			{
			CustomViewObject customObject =(CustomViewObject)obj;
		
		Vector values=customObject.getValuesList();
		
		
		//   if the CustomViewObject name is Filter property name then sets 
		//   the current value to the customViewName
		//   textfield which is nothing but the name of CustomView
		
		if(customObject.getPropertyName().equalsIgnoreCase("Filter View Name"))//No Internationalisation
		{
			//customNameTextField.setText(customObject.getCurrentValue().toString());
			customNameTextField.setEnabled(customObject.isEditable());	
		}
		else if(customObject.getPropertyName().equalsIgnoreCase("time"))//No Internationalisation
        {
			// if the CustomViewObject name is date then getDateComponents method is called			
			getDateComponents(customObject,"");
        }
        else if(customObject.getPropertyName().equalsIgnoreCase("modTime") || customObject.getPropertyName().equalsIgnoreCase("createTime"))
        {
            getDateComponents(customObject, customObject.getPropertyName());            
        }
		else
		{
			getJlabel(NmsClientUtil.GetString(customObject.getPropertyName()),key);  // display property name in label
			if(values!=null && customObject.isEditable()==true)
			{	
				component=getComboBox(customObject);      // if the CustomViewObject contains list of values then values
				//  are displayed in comboBox
				
				componentVector.addElement(component);    //  created components are then and there added to component Vector
				//   which are used to upadate modified values
			}
			else
			{
				// if list of values are null then current value is displayed in textfield
				component=getJtextField(customObject.getCurrentValue().toString(),customObject.isEditable());
				
				componentVector.addElement(component);//  created components are then and there added to component Vector
				//   which are used to upadate modified values
			}
			putComponent(component);
			getDisOptions(customObject);     // this method displays checkbox and textfield  that is used to get display name
		}
		}
			else if (key.equalsIgnoreCase("XMLNODE_PROPERTIES"))//No Internationalisation
			{

				FormObject form =(FormObject)obj;
				getJlabel(NmsClientUtil.GetString(form.getPropertyName()),key);
				formComponent =getJtextField(form.getCurrentValue().toString(),form.isEditable());
				formVector.addElement(formComponent);
				putFormComponent(formComponent);

			}
	}


	
	
	/**
	 * This method gets called to display time component (From,To) .
	 * This has a "From" Date and "To" Date TextFileds.
	 * 
	 * @param customObject  This is a CustomViewObject for which date
	 *			            component is to be shown
	 */
	
	private void getDateComponents(CustomViewObject customObject, String str)
	{
		Component component;
		
		Date dt1,dt2;  // Two Date instances one for "From" and another is for "To"//No Internationalisation
		
		String dateValue=customObject.getCurrentValue().toString();
		
		String arr[]=NmsClientUtil.splitDate(dateValue);  // This method splits date into two parts (From ,To)
		
		getJlabel(str+" "+NmsClientUtil.GetString("From")+" ");	            // Label to display "From"//No Internationalisation
		component=getJtextField(arr[0],customObject.isEditable());   //Textcomponent to display From date value
		
		componentVector.addElement(component);  //"From" date component is added to component vector//No Internationalisation
		
		putComponent(component);   // method to add JTextComponent to displaypanel
		
		constraints.gridheight=2;
		getDisOptions(customObject);      //  Display name option for Date component
		constraints.gridheight=1;
		
		offset++;        
		getJlabel(str+" "+NmsClientUtil.GetString("To")+" ");	  // Label to diasplay "To" //No Internationalisation
		component=getJtextField(arr[1],customObject.isEditable());  //Textfield to display "To"  date value//No Internationalisation
		componentVector.addElement(component);   // "To" date component is added to component vector//No Internationalisation
		putComponent(component);  // method to add JTextComponent to displaypanel
	}
	
	
	/**
	 * This method is used to set gridx and gridy positions
	 * to constraints (an instance of GridBagConstraints)
	 * 
	 * @param x   This is to set gridx of GridBagConstraints
	 * @param y   This is to set gridy of GridBagConstraints
	 * 
	 */
	private void modifyGirdConstraints(int x,int y)
	{
		constraints.gridx=x;
		constraints.gridy=y;
	}
	
	/** 
	 * This method creates a JLabel which holds customViewObject property name
	 * 
	 * @param  text  String for JLabel
	 */
	private void getJlabel(String text,String key)
	{
		text=text.trim();
		text=text.substring(0,1).toUpperCase()+text.substring(1).toLowerCase();
		JLabel temp=new JLabel(text);
		temp.setHorizontalAlignment(JLabel.LEFT);
		temp.setForeground(Color.black);
		
		constraints.gridx=0;
		constraints.gridy=(size+offset+4);
		constraints.anchor=GridBagConstraints.WEST;
		gbLayout.setConstraints(temp,constraints);
		constraints.anchor=GridBagConstraints.CENTER;
		if(key.equalsIgnoreCase("CUSTOMVIEW_PROPERTIES"))//No Internationalisation
		{
		displayPanel.add(temp);		
		}
		else if(key.equalsIgnoreCase("XMLNODE_PROPERTIES"))//No Internationalisation
		{
			formPanel.add(temp);
		}
	}

	private void getJlabel(String text)
	{
		text=text.trim();
		text=text.substring(0,1).toUpperCase()+text.substring(1).toLowerCase();
		JLabel temp=new JLabel(text);
		temp.setHorizontalAlignment(JLabel.LEFT);
		temp.setForeground(Color.black);
		
		constraints.gridx=0;
		constraints.gridy=(size+offset+4);
		constraints.anchor=GridBagConstraints.WEST;
		gbLayout.setConstraints(temp,constraints);
		constraints.anchor=GridBagConstraints.CENTER;
		displayPanel.add(temp);		
	}

	/**
	 * This method creates a textfield and returns a handle to the TextField
	 * 
	 * @param   text      Textfield 's Contents
	 * @param	editable  This value tells wheather the TextField is enabled or not.
	 * 
	 * @return	"JTextField"   created TextField 's handle
	 */
	private Component getJtextField(String text ,boolean editable)
	{
		JTextField tfTemp=new JTextField(20);
		tfTemp.setText(text);
		tfTemp.setEnabled(editable);
		
		BevelBorder border=new BevelBorder(BevelBorder.RAISED);
		tfTemp.setBorder(border);
		
		return tfTemp;
	}
	
	/**
	 * This method gets called if the CustomViewObject has a list of
	 * possible of values.
	 * 
	 * @param customObject   This is a CustomViewObject that has list of values to be displayed
	 * 
	 * @return "JComboBox"   Returns a Component which is a ComboBox
	 */	
	private Component getComboBox(CustomViewObject customObject)
	{
		JComboBox combo=new JComboBox(customObject.getValuesList());
		try
		{
			if(customObject.getCurrentValue().toString()!=null)
				combo.setSelectedItem(customObject.getCurrentValue());
			else
				combo.setSelectedItem(new String("all"));//No Internationalisation
		}
		catch (Exception e)
		{
			combo.setSelectedItem(new String("all"));//No Internationalisation
		}
		combo.setPreferredSize(new Dimension(220,20));
		return combo;
	}
	
	/** 
	 * This method is used to add components like textfield , combobox 
	 * and textarea to the displaypanel
	 * 
	 * @param comp  This is the Component to be added to displaypanel
	 */
	private void putComponent(Component comp)
	{
		constraints.gridx=2;
		constraints.gridy=(size+offset+4);
		gbLayout.setConstraints(comp,constraints);
		displayPanel.add(comp);
	}
	private void putFormComponent(Component comp)
	{
		constraints.gridx=2;
		constraints.gridy=(size+offset+4);
		gbLayout.setConstraints(comp,constraints);
		formPanel.add(comp);
	}
	
	/** 
	 * This method is used to add checkbox, which is checked if the particular property is 
	 * to be displayed or notThe column's heading can de given in the TextFiled  
	 * 
	 * @param customObject  This is the CustomViewObject
	 * 
	 */	

	private void getDisOptions(CustomViewObject customObject)
	{		
		JCheckBox select=new JCheckBox();
		select.setSelected(customObject.isDisplayed());
		
		constraints.anchor=GridBagConstraints.CENTER;
		constraints.gridwidth=2;
		modifyGirdConstraints(6,size+offset+4);
		gbLayout.setConstraints(select,constraints);
		displayPanel.add(select);
		
		checkBoxVector.addElement(select);              // holding reference of all CheckBox added
		
		String disNameValue=customObject.getDisplayName();    // holds the optional display name
		JTextField textField=new JTextField(9);
		textField.setText(disNameValue);
		constraints.gridx=8;
		gbLayout.setConstraints(textField,constraints);
		displayPanel.add(textField);

		disNameVector.addElement(textField);     // holding reference of all textfields added
		
	}
	

	/**
	 * In this method when if the user had clicked 'Add' button, the new Custom 
	 * View will be added. By default the custom View will be added
	 * using the APIs present in com.adventnet.nms.util.NmsUiAPI. 
	 * The code for adding the custom view by firing the firePropertyChange()
	 * method is also present but its commented. If the user likes
	 * to verify it they can uncomment after commenting the default 
	 * method, which is done using APIs. 
	 * 
	 */
	public void actionPerformed(ActionEvent ae)
	{
		String actionCommand=ae.getActionCommand();
		if(actionCommand.equals("Add") && updateValues())//No Internationalisation
		{
			/**
			* Using API to add the Custom View
			* Please Note to uncomment any one of the
			* methodology between //START and //END 
			*/
			//START - Method One
			
            //API: method used to get the Current Module Id
			// and current Custom View
			//String moduleId = NmsUiAPI.getCurrentModuleId();
			
			//String rootName = NmsUiAPI.getCurrentCustomView();
			
			//Putting the properties(or criteria) in a hash table
			//Hashtable propertyHash = getPropertiesInHash();
			
			//dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			
			//API: The following method gets the current timeout
			//interval for the client on synchronous requests sent
			//to the server.
			//long currentTimeOut = NmsUiAPI.getTimeOut();
			
			//API: The following method call sets the timeout interval
			//for the synchronous request to be sent.
			//NmsUiAPI.setTimeOut(30000);
			
			//API: invokes the addCustomView() method with sync parameter set to 
			//true , to make the call synchronous;
			//boolean retVal = NmsUiAPI.addCustomView(moduleId,rootName,customViewName,propertyHash,true);
			
			//Setting back the timeout to the previous value
			//NmsUiAPI.setTimeOut(currentTimeOut);
			//dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));        
			/*if(retVal)
			{
				System.out.println("Successfully Added");//No Internationalisation
			}
			else
			{
				System.out.println("Failed to Add");//No Internationalisation
			}*/
			//END - Method One
			
					
			/**
			* Using Data Form Customizer firePropertyChange Method
			*/
			//The class fires back to Web NMS that it has completed
			//its work, asking NMS to take over.
			
			//START - Method Two - Uncomment the following line to use this method
			  firePropertyChange();
            //END - Method Two		
            dialog.dispose();
            dialog.setVisible(false);            		    
        }
		else if(actionCommand.equals("Cancel"))//No Internationalisation
		{
            		dialog.dispose();
			dialog.setVisible(false);            
		}		


	}
	
	/**
	 * This method is used for updating all customViewObjectValues and  it's 
	 * display properties. First all updated values are stored in modifiedObjects vector 
	 * and  reassigned to the original vector
	 * 
	 * @return "boolean"    a boolean value -true on it's successful completion , false otherwise
	 */
	private boolean updateValues()
	{
		for(Enumeration enumerate=getObjects.keys();enumerate.hasMoreElements();)
		{
			String returnValue=(String)enumerate.nextElement();
		int sizeofObjects=custom.size();
		int indexOffset=0;
		int offset_For_CustomViewName=0;
		
		Vector modifiedObjects=new Vector();
		Vector values;
		
		boolean result=false;
		
		JComboBox comboBox;
		JCheckBox checkBox;
		JTextComponent textComponent;
		CustomViewObject customObject,cobject;
		

		if(returnValue.equalsIgnoreCase("CUSTOMVIEW_PROPERTIES"))//No Internationalisation
		{	
		for(int i=0;i< sizeofObjects;i++)
		{
			customObject=(CustomViewObject)(custom.elementAt(i));
			
			if(customObject.getPropertyName().equalsIgnoreCase("Filter View Name"))//No Internationalisation
			{
				customObject.setCurrentValue(customNameTextField.getText());
				modifiedObjects.addElement(customObject);
				offset_For_CustomViewName--;
				continue;
			}

			checkBox=(JCheckBox)(checkBoxVector.elementAt(i+offset_For_CustomViewName));

			if(checkBox.isSelected())
			{
				textComponent=(JTextComponent)(disNameVector.elementAt(i+offset_For_CustomViewName));
				customObject.setDisplay(true);
				customObject.setDisplayName(textComponent.getText());
			}	
			else
			{
				customObject.setDisplay(false);
			}
			
			if(customObject.getPropertyName().equalsIgnoreCase("time"))//No Internationalisation
			{
				JTextComponent temp1=(JTextComponent)(componentVector.elementAt(i+indexOffset+offset_For_CustomViewName));
				indexOffset++;
				JTextComponent temp2=(JTextComponent)(componentVector.elementAt(i+indexOffset+offset_For_CustomViewName));
				result=dateValidation(temp1,temp2);
				if(result==false)
					return false;
				customObject.setCurrentValue(NmsClientUtil.concateDate(temp1.getText(),temp2.getText()));
			}
            else if(customObject.getPropertyName().equalsIgnoreCase("modTime") || customObject.getPropertyName().equalsIgnoreCase("createTime"))
            {
                JTextComponent temp1=(JTextComponent)(componentVector.elementAt(i+indexOffset+offset_For_CustomViewName));
				indexOffset++;
				JTextComponent temp2=(JTextComponent)(componentVector.elementAt(i+indexOffset+offset_For_CustomViewName));
				result=dateValidation(temp1,temp2);
				if(result==false)
					return false;
				customObject.setCurrentValue(NmsClientUtil.concateDate(temp1.getText(),temp2.getText()));
            }
			else
			{
				values=customObject.getValuesList();
				if(!(customObject.isEditable()))
				{
					modifiedObjects.addElement(customObject);
					continue;
				}
				if(values!=null && customObject.isEditable()==true)
				{
					comboBox=(JComboBox)(componentVector.elementAt(i+indexOffset+offset_For_CustomViewName));
					customObject.setCurrentValue(comboBox.getSelectedItem());
				}					
				else
				{
					textComponent=(JTextComponent)(componentVector.elementAt(i+indexOffset+offset_For_CustomViewName));
					Object temp=new String(textComponent.getText());
					customObject.setCurrentValue(temp);	
				}
				
			}
			
			modifiedObjects.addElement(customObject);
		}
		custom=modifiedObjects;
		save.put("CUSTOMVIEW_PROPERTIES",custom);//No Internationalisation
		}
		else if (returnValue.equalsIgnoreCase("XMLNODE_PROPERTIES"))//No Internationalisation
		{
			FormObject formObject;
			JTextField textField;
			Object obj;
			int sizeofFormObjects=form.size();
			int count=0;
			for(Enumeration getElements = form.elements();getElements.hasMoreElements();)
			{
				formObject =(FormObject)getElements.nextElement();
				if(count<size)
				{
					obj=formVector.elementAt(count);
					if(obj instanceof JTextField)
					{
						textField=(JTextField)obj;
						Object getValue=textField.getText();
						formObject.setCurrentValue(getValue);
						form.setElementAt(formObject,count);

					}
				}
					count++;
			}
			save.put("XMLNODE_PROPERTIES",form);//No Internationalisation

		}
	}		



		return true;
	}
	
	/** 
	 * This method performs validation for the time component and it 
	 * returns true if the entered data is correct. Otherwise it gives out an
	 * appropriate error message and a false value is returned
	 *
	 * If time is not specified then returns true and takes the present time.
	 * If "From" time is specified and is greater then present time then an error
	 * message will appear and false is returned. If "From" time alone specified then
	 * "To" time will be taken as the present time and true is returned.
	 * If "To" time alone is specified then  
	 * Error message appears. On successful validation boolean-true is returned.
	 * 
	 * 
	 * @param from   This is the TextComponent reference of From field
	 * @param to     This is the TextComponent reference of To field
	 * 
	 * @return "boolean"  Returns a boolean value true time is valid, false otherwise
	 */
	private boolean  dateValidation(JTextComponent from,JTextComponent to)
	{

		String str_Date1=from.getText().trim();
		String str_Date2=to.getText().trim();
		
		Date dt1=null,dt2=null;
		if(!(str_Date1.equals("")))//No Internationalisation
		{						
			try
			{
				dt1=NmsClientUtil.parseDate(str_Date1);
				
			}catch (Exception e)
			{
				dt1=null;
				showErrorMessage(NmsClientUtil.GetString("Invalid From Date Value") + " " + str_Date1 + " - " + NmsClientUtil.GetString("Use the Pattern")+NmsClientUtil.GetString(NmsClientUtil.NmsFormatter.format(new Date())) );
				from.requestFocus();
				return false;
			}
		}			
		if(!(str_Date2.equals("")))//No Internationalisation
		{						
			try
			{
				dt2=NmsClientUtil.parseDate(str_Date2);
				
			}catch (Exception e)
			{
				dt2=null;
				showErrorMessage(NmsClientUtil.GetString("Invalid To Date Value") + " " + str_Date2 + " - " + NmsClientUtil.GetString("Use the Pattern")+NmsClientUtil.GetString(NmsClientUtil.NmsFormatter.format(new Date())));
				to.requestFocus();			
				return false ;
			}
		}			
		
		
		if(dt1!=null && dt2!=null && dt1.compareTo(dt2)==0)
		{	
			showErrorMessage(NmsClientUtil.GetString("Both dates are Equal") );
			from.requestFocus();
			return false;
		}
		if(dt1!=null && dt2!=null && dt1.compareTo(dt2)>0 )
		{
			showErrorMessage(NmsClientUtil.GetString("From date value is greater than To Date value ") );
			from.requestFocus();
			return false;
		}
		return true;
		
	}

	/**
	 * This method will be called when the custom view is being added using
	 * APIs( which is the default) to get the properties of the custom 
	 * view to be added in a hash table. 
	 */
	private Hashtable getPropertiesInHash()
	{
		String fieldsWanted = "";//No Internationalisation
		Hashtable hash= new Hashtable();
		for(Enumeration enumerate = objects.elements(); enumerate.hasMoreElements();)
		{
			CustomViewObject customViewObject = (CustomViewObject) enumerate.nextElement();
			String key = customViewObject.getPropertyName();
			String value = (String)customViewObject.getCurrentValue();
			if(key == null || value == null)
			{
				continue;
			}
			else if(key.equals("Filter View Name"))//No Internationalisation
			{
				customViewName = value;
				continue;
			}
			else if(key.equals("severity") && !value.trim().equals(""))//No Internationalisation
			{
				if(!value.trim().equals("all"))//No Internationalisation
				{
					hash.put("stringseverity",value);//No Internationalisation
				}
			}
			else if(!value.trim().equals(""))//No Internationalisation
			{
				hash.put(key,value);                   
			}
			if(customViewObject.isDisplayed())
			{
				value = customViewObject.getDisplayName();
				value.replace('=','_');
				value.replace(';',':');
				if(key.equals("time"))//No Internationalisation
					key = "date";//No Internationalisation
				fieldsWanted = fieldsWanted + value + "=" + key + ";";//No Internationalisation
			}           
		}
		if(!fieldsWanted.equals(""))//No Internationalisation
		{
			hash.put("FieldsWanted",fieldsWanted);//No Internationalisation
		}
		if (!customViewName.trim().equals(""))//No Internationalisation
			customViewName = customViewName.replace(' ','_');
		return hash;
	}






		public void setGroupCustomViewFormProperties(Hashtable table)
		{

			for(Enumeration enumerate =table.keys();enumerate.hasMoreElements();)
			{
				 key = (String)enumerate.nextElement();
				 if(key.equalsIgnoreCase("CUSTOMVIEW_PROPERTIES"))//No Internationalisation
				 {
					getCustomObject=(Vector)table.get("CUSTOMVIEW_PROPERTIES");//No Internationalisation
					getObjects.put(key,getCustomObject);
				 }
				 else if(key.equalsIgnoreCase("XMLNODE_PROPERTIES"))//No Internationalisation
				 {
					getFormObject=(Vector)table.get("XMLNODE_PROPERTIES");	//No Internationalisation
					getObjects.put(key,getFormObject);
				 }
			}


		}


		private void getComponent(String key,Hashtable hasht)
		{
			 custom =(Vector)hasht.get("CUSTOMVIEW_PROPERTIES");//No Internationalisation
			 form =(Vector)hasht.get("XMLNODE_PROPERTIES");//No Internationalisation
			int sizeOfCustomObject=custom.size();
			int sizeOfFormObject=form.size();
			for(Enumeration enumerate=hasht.keys();enumerate.hasMoreElements();)
			{
				String keyValue=(String)enumerate.nextElement();

			 if(keyValue.equalsIgnoreCase("XMLNODE_PROPERTIES"))//No Internationalisation
			{
				for(size=0;size<sizeOfFormObject;size++)
				{
					FormObject temp_form =(FormObject)form.elementAt(size);
					displayCustomViewObject(keyValue,temp_form);
				}
			}
			else if(keyValue.equalsIgnoreCase("CUSTOMVIEW_PROPERTIES"))//No Internationalisation
			{
				for(size=0;size<sizeOfCustomObject;size++)
				{
					CustomViewObject temp_Obj=(CustomViewObject)custom.elementAt(size); 	
					displayCustomViewObject(keyValue,temp_Obj);            
				}
			}
			}



		}


		public Hashtable getGroupCustomViewFormProperties()
		{

			return save;
		}


		

		private JTabbedPane  createPane()
		{
				JTabbedPane tab = new JTabbedPane();
				tab.addTab("CustomViewProperties",parentPanel);//No Internationalisation
				tab.addTab("TreeNodeProperties",treePanel);//No Internationalisation
				return tab;
				
		} 


			
}	

