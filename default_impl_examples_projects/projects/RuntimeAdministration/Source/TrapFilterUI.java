

// Please do not edit code in between the comments "//<Begin_...>" and "//<End_...>
// Any changes made within the comments will be lost ,if  regenerated.
// For more details please see EditingSourceFiles.html present in the docs directory

package com.adventnet.nms.runtimeconfig;




//$Id: TrapFilterUI.java,v 1.2 2007/02/22 15:03:07 srajeswari Exp $


import javax.swing.table.TableColumn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TrapFilterUI extends JPanel implements ActionListener,ApplyToServerInterface
{
	//<Begin_Variable_Declarations>
	private boolean initialized = false;
	private java.applet.Applet applet = null;
	private String localePropertiesFileName = "RuntimeAdministrationResources";
	static com.adventnet.apiutils.BuilderResourceBundle resourceBundle = null;
	private boolean running=false;
	javax.swing.JPanel Top = null;
	javax.swing.JPanel JPanel1 = null;
	javax.swing.JPanel JPanel9 = null;
	javax.swing.JLabel JLabel4 = null;
	javax.swing.JLabel JLabel1 = null;
	javax.swing.JLabel JLabel6 = null;
	javax.swing.JPanel JPanel2 = null;
	javax.swing.JLabel JLabel8 = null;
	javax.swing.JPanel JPanel5 = null;
	javax.swing.JScrollPane JScrollPane1 = null;
	javax.swing.JTable table = null;
	javax.swing.JPanel JPanel7 = null;
	javax.swing.JLabel JLabel2 = null;
	javax.swing.JLabel JLabel9 = null;
	javax.swing.JLabel JLabel3 = null;
	javax.swing.JLabel JLabel10 = null;
	javax.swing.JPanel JPanel4 = null;
	javax.swing.JPanel JPanel6 = null;
	javax.swing.JButton addButton = null;
	javax.swing.JButton modifyButton = null;
	javax.swing.JButton deleteButton = null;
	javax.swing.JButton detailsButton = null;
	javax.swing.JPanel JPanel8 = null;
	javax.swing.JButton applyButton = null;
	javax.swing.JButton reloadButton = null;
	javax.swing.JPanel JPanel3 = null;
	javax.swing.JTextArea JTextArea1 = null;
	javax.swing.JTextArea JTextArea2 = null;
	javax.swing.JLabel JLabel5 = null;
	javax.swing.JLabel JLabel7 = null;
	javax.swing.table.DefaultTableModel tableModel = null;
	GridBagConstraints cons = new GridBagConstraints();
	Insets inset;
	//<End_Variable_Declarations>

	TrapFilterModel trapFilterModel = null;
  	TrapAddModify addModifyDialog = null;
	Hashtable temphash = null;
	boolean shiftFlag = false;
	boolean controlFlag = false;
	int startRow =0;  
	boolean isModified = false;
	boolean refetchFlag = false;	
	Vector reloadVector = new Vector();













   


  

	public void actionPerformed(ActionEvent ae)
	{}

  

  

  
    public void setConstraints(int x,int y,int width,int height,double wtX,double wtY,int anchor,int fill,Insets inset,int padX,int padY )
  { 

  //<Begin_setConstraints_int_int_int_int_double_double_int_int_Insets_int_int> 
	cons.gridx = x;
	cons.gridy = y;
	cons.gridwidth = width;
	cons.gridheight = height;
	cons.weightx = wtX;
	cons.weighty = wtY;
	cons.anchor = anchor;
	cons.fill = fill;
	cons.insets = inset;
	cons.ipadx = padX;
	cons.ipady = padY;
	
  
         //<End_setConstraints_int_int_int_int_double_double_int_int_Insets_int_int>
  } 
  public void setUpProperties()
  { 

  //<Begin_setUpProperties> 

          try
          {
            JPanel9.setBorder(new javax.swing.border.EtchedBorder(1));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel9,ex); 
          }

//<UserCode_Begin_Bean_JPanel9>

//<UserCode_End_Bean_JPanel9>

          try
          {
            JLabel1.setText(resourceBundle.getString("Trap Filter Configuration"));
            JLabel1.setHorizontalAlignment(0);
            JLabel1.setForeground(new Color(-16764109));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JLabel1,ex); 
          }

//<UserCode_Begin_Bean_JLabel1>

//<UserCode_End_Bean_JLabel1>

          try
          {
            JLabel6.setForeground(new Color(-16764109));
            JLabel6.setText(resourceBundle.getString("( trap.filters )"));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JLabel6,ex); 
          }

//<UserCode_Begin_Bean_JLabel6>

//<UserCode_End_Bean_JLabel6>

          try
          {
            JPanel2.setBorder(new javax.swing.border.EtchedBorder(0));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel2,ex); 
          }

//<UserCode_Begin_Bean_JPanel2>

//<UserCode_End_Bean_JPanel2>

          try
          {
            table.setModel(tableModel);
            table.setToolTipText(resourceBundle.getString("Please double-click to view details"));
            table.setRowHeight(22);
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+table,ex); 
          }

//<UserCode_Begin_Bean_table>

//<UserCode_End_Bean_table>

          try
          {
            JPanel7.setBorder(new javax.swing.border.EtchedBorder(1));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel7,ex); 
          }

//<UserCode_Begin_Bean_JPanel7>

//<UserCode_End_Bean_JPanel7>

          try
          {
            JLabel9.setText(resourceBundle.getString("Enabled Filters"));
            JLabel9.setHorizontalAlignment(2);
            JLabel9.setFont(new Font("Dialog",0,12));
            JLabel9.setForeground(new Color(-16764109));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JLabel9,ex); 
          }

//<UserCode_Begin_Bean_JLabel9>

//<UserCode_End_Bean_JLabel9>

          try
          {
            JLabel10.setText(resourceBundle.getString("Disabled Filters"));
            JLabel10.setHorizontalAlignment(2);
            JLabel10.setForeground(new Color(-16777216));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JLabel10,ex); 
          }

//<UserCode_Begin_Bean_JLabel10>

//<UserCode_End_Bean_JLabel10>

          try
          {
            JPanel4.setBorder(new javax.swing.border.EtchedBorder(0));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel4,ex); 
          }

//<UserCode_Begin_Bean_JPanel4>

//<UserCode_End_Bean_JPanel4>

          try
          {
            JPanel6.setBorder(new javax.swing.border.BevelBorder(1));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel6,ex); 
          }

//<UserCode_Begin_Bean_JPanel6>

//<UserCode_End_Bean_JPanel6>

          try
          {
            addButton.setText(resourceBundle.getString("Add"));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+addButton,ex); 
          }

//<UserCode_Begin_Bean_addButton>

//<UserCode_End_Bean_addButton>

          try
          {
            modifyButton.setText(resourceBundle.getString("Modify"));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+modifyButton,ex); 
          }

//<UserCode_Begin_Bean_modifyButton>

//<UserCode_End_Bean_modifyButton>

          try
          {
            deleteButton.setText(resourceBundle.getString("Delete"));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+deleteButton,ex); 
          }

//<UserCode_Begin_Bean_deleteButton>

//<UserCode_End_Bean_deleteButton>

          try
          {
            detailsButton.setText(resourceBundle.getString("View Details"));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+detailsButton,ex); 
          }

//<UserCode_Begin_Bean_detailsButton>

//<UserCode_End_Bean_detailsButton>

          try
          {
            JPanel8.setBorder(new javax.swing.border.BevelBorder(1));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel8,ex); 
          }

//<UserCode_Begin_Bean_JPanel8>

//<UserCode_End_Bean_JPanel8>

          try
          {
            applyButton.setText(resourceBundle.getString("Apply"));
            applyButton.setForeground(new Color(-16764109));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+applyButton,ex); 
          }

//<UserCode_Begin_Bean_applyButton>

//<UserCode_End_Bean_applyButton>

          try
          {
            reloadButton.setText(resourceBundle.getString("Reload"));
            reloadButton.setForeground(new Color(-16764109));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+reloadButton,ex); 
          }

//<UserCode_Begin_Bean_reloadButton>

//<UserCode_End_Bean_reloadButton>

          try
          {
            JPanel3.setBorder(new javax.swing.border.EtchedBorder(0));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JPanel3,ex); 
          }

//<UserCode_Begin_Bean_JPanel3>

//<UserCode_End_Bean_JPanel3>

          try
          {
            JTextArea1.setText(resourceBundle.getString(""));
            JTextArea1.setBackground(new Color(-1));
            JTextArea1.setOpaque(false);
            JTextArea1.setLineWrap(true);
            JTextArea1.setWrapStyleWord(true);
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JTextArea1,ex); 
          }

//<UserCode_Begin_Bean_JTextArea1>

//<UserCode_End_Bean_JTextArea1>

          try
          {
            JTextArea2.setBackground(new Color(-6684673));
            JTextArea2.setText(resourceBundle.getString(""));
            JTextArea2.setOpaque(false);
            JTextArea2.setLineWrap(true);
            JTextArea2.setWrapStyleWord(true);
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JTextArea2,ex); 
          }

//<UserCode_Begin_Bean_JTextArea2>

//<UserCode_End_Bean_JTextArea2>

          try
          {
            JLabel5.setBackground(new Color(-16764109));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JLabel5,ex); 
          }

//<UserCode_Begin_Bean_JLabel5>

//<UserCode_End_Bean_JLabel5>

          try
          {
            JLabel7.setBackground(new Color(-16764109));
          }
          catch(Exception ex)
          {
             showStatus(resourceBundle.getString("Exception while setting properties for bean ")+JLabel7,ex); 
          }

//<UserCode_Begin_Bean_JLabel7>

//<UserCode_End_Bean_JLabel7>

//<UserCode_Begin_Bean_tableModel>
tableModel.setDataVector(
             new Object[0][0],
            new Object[]{" ",resourceBundle.getString("Filter Name "),resourceBundle.getString("Class Name")});
//<UserCode_End_Bean_tableModel>
		reloadButton.setPreferredSize(new Dimension(reloadButton.getPreferredSize().width+10,reloadButton.getPreferredSize().height+0));
		applyButton.setPreferredSize(new Dimension(applyButton.getPreferredSize().width+10,applyButton.getPreferredSize().height+0));
		detailsButton.setPreferredSize(new Dimension(detailsButton.getPreferredSize().width+18,detailsButton.getPreferredSize().height+0));
		deleteButton.setPreferredSize(new Dimension(deleteButton.getPreferredSize().width+8,deleteButton.getPreferredSize().height+0));
		modifyButton.setPreferredSize(new Dimension(modifyButton.getPreferredSize().width+12,modifyButton.getPreferredSize().height+0));
		addButton.setPreferredSize(new Dimension(addButton.getPreferredSize().width+16,addButton.getPreferredSize().height+0));
		JLabel10.setPreferredSize(new Dimension(JLabel10.getPreferredSize().width+26,JLabel10.getPreferredSize().height+0));
		JLabel9.setPreferredSize(new Dimension(JLabel9.getPreferredSize().width+9,JLabel9.getPreferredSize().height+0));
		JPanel7.setPreferredSize(new Dimension(JPanel7.getPreferredSize().width+88,JPanel7.getPreferredSize().height+10));
		JScrollPane1.setPreferredSize(new Dimension(JScrollPane1.getPreferredSize().width+2,JScrollPane1.getPreferredSize().height+2));
		JPanel5.setPreferredSize(new Dimension(JPanel5.getPreferredSize().width+10,JPanel5.getPreferredSize().height+10));
		JLabel8.setPreferredSize(new Dimension(JLabel8.getPreferredSize().width+158,JLabel8.getPreferredSize().height+168));
		JLabel6.setPreferredSize(new Dimension(JLabel6.getPreferredSize().width+24,JLabel6.getPreferredSize().height+0));
		JLabel1.setPreferredSize(new Dimension(JLabel1.getPreferredSize().width+43,JLabel1.getPreferredSize().height+0));

  
          //<End_setUpProperties>
tableModel.setDataVector(
             new Object[0][0],
            new Object[]{" ",resourceBundle.getString("Filter Name"),resourceBundle.getString("Class Name")});
  } 
  public void init()
  { 

  //<Begin_init> 
	if(getParameter("RESOURCE_PROPERTIES" ) != null)
	{
		localePropertiesFileName = getParameter("RESOURCE_PROPERTIES");
	}
	resourceBundle = com.adventnet.apiutils.Utility.getBundle(localePropertiesFileName,getParameter("RESOURCE_LOCALE"),applet);
        if (initialized) return; 
        setPreferredSize(new Dimension(getPreferredSize().width+698,getPreferredSize().height+519)); 
        setSize(getPreferredSize()); 
        Container container = this;
        container.setLayout(new BorderLayout()); 
        try 
        { 
          initVariables(); 
          setUpGUI(container); 
          setUpProperties(); 
          setUpConnections(); 
        } 
        catch(Exception ex) 
        { 
          showStatus(resourceBundle.getString("Error in init method"),ex); 
        } 
        // let us set the initialized variable to true so  
        // we dont initialize again even if init is called 
        initialized = true; 

  
         //<End_init>
	table.getTableHeader().setReorderingAllowed(false);
	TableColumn checkColumn = table.getColumnModel().getColumn(0);
    checkColumn.setMaxWidth(22);
	TrapFilterRenderer t = new TrapFilterRenderer();
	//t.setHorizontalAlignment(SwingConstants.CENTER) ;
	//t.setOpaque(true);
	checkColumn.setCellRenderer(t); 
	TableColumn firstColumn = table.getColumnModel().getColumn(1);
	firstColumn.setCellRenderer(new TrapStateRenderer());
	TableColumn secondColumn = table.getColumnModel().getColumn(2);
	secondColumn.setCellRenderer(new TrapStateRenderer());	
	table.setDefaultEditor(Object.class,null);
	JLabel8.setIcon(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("filters.png","images/runtimeadmin"));
	JLabel5.setIcon(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("tips.png","images/runtimeadmin"));
	JLabel7.setIcon(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("tips.png","images/runtimeadmin"));
	JLabel4.setIcon(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("trapfilter.png", "images/runtimeadmin"));
	JLabel2.setIcon(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("selected.png","images/runtimeadmin"));
	JLabel3.setIcon(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("deselected.png","images/runtimeadmin"));
	JTextArea1.setText(resourceBundle.getString("The filters will be invoked in the same order as listed in the table. Drag and Drop to change the order of the filters."));
	JTextArea2.setText(resourceBundle.getString("Use reload option to load TrapFilter classes again in the WebNMS server at runtime."));
	JTextArea1.setEditable(false);
	JTextArea2.setEditable(false);
	reloadButton.setEnabled(false);
	addButton.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	modifyButton.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	JLabel6.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	JLabel9.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	JLabel10.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	deleteButton.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	reloadButton.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	applyButton.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	detailsButton.setFont(RuntimeConfigFrame.getCommonBuilderUIImpl().getFont());
	applyButton.setEnabled(false);
	detailsButton.setEnabled(false);
	modifyButton.setEnabled(false);
	deleteButton.setEnabled(false);
  } 
  public void setUpConnections()
  { 

  //<Begin_setUpConnections> 

      table_table_conn3 table_table_conn31 =  new table_table_conn3();
      table.addMouseMotionListener(table_table_conn31);
      table_table_conn2 table_table_conn21 =  new table_table_conn2();
      table.addMouseListener(table_table_conn21);
      table_table_conn1 table_table_conn11 =  new table_table_conn1();
      table.addKeyListener(table_table_conn11);
      addButton_addButton_conn1 addButton_addButton_conn11 =  new addButton_addButton_conn1();
      addButton.addActionListener(addButton_addButton_conn11);
      detailsButton_detailsButton_conn1 detailsButton_detailsButton_conn11 =  new detailsButton_detailsButton_conn1();
      detailsButton.addActionListener(detailsButton_detailsButton_conn11);
      modifyButton_modifyButton_conn1 modifyButton_modifyButton_conn11 =  new modifyButton_modifyButton_conn1();
      modifyButton.addActionListener(modifyButton_modifyButton_conn11);
      classpathButton_classpathButton_conn1 classpathButton_classpathButton_conn11 =  new classpathButton_classpathButton_conn1();
      applyButton.addActionListener(classpathButton_classpathButton_conn11);
      reloadButton_reloadButton_conn1 reloadButton_reloadButton_conn11 =  new reloadButton_reloadButton_conn1();
      reloadButton.addActionListener(reloadButton_reloadButton_conn11);
      deleteButton_deleteButton_conn1 deleteButton_deleteButton_conn11 =  new deleteButton_deleteButton_conn1();
      deleteButton.addActionListener(deleteButton_deleteButton_conn11);
  
      //<End_setUpConnections>
  } 
  public void initVariables()
  { 

  //<Begin_initVariables> 
        Top= new javax.swing.JPanel();
        JPanel1= new javax.swing.JPanel();
        JPanel9= new javax.swing.JPanel();
        JLabel4= new javax.swing.JLabel();
        JLabel1= new javax.swing.JLabel();
        JLabel6= new javax.swing.JLabel();
        JPanel2= new javax.swing.JPanel();
        JLabel8= new javax.swing.JLabel();
        JPanel5= new javax.swing.JPanel();
        JScrollPane1= new javax.swing.JScrollPane();
        table= new javax.swing.JTable();
        JPanel7= new javax.swing.JPanel();
        JLabel2= new javax.swing.JLabel();
        JLabel9= new javax.swing.JLabel();
        JLabel3= new javax.swing.JLabel();
        JLabel10= new javax.swing.JLabel();
        JPanel4= new javax.swing.JPanel();
        JPanel6= new javax.swing.JPanel();
        addButton= new javax.swing.JButton();
        modifyButton= new javax.swing.JButton();
        deleteButton= new javax.swing.JButton();
        detailsButton= new javax.swing.JButton();
        JPanel8= new javax.swing.JPanel();
        applyButton= new javax.swing.JButton();
        reloadButton= new javax.swing.JButton();
        JPanel3= new javax.swing.JPanel();
        JTextArea1= new javax.swing.JTextArea();
        JTextArea2= new javax.swing.JTextArea();
        JLabel5= new javax.swing.JLabel();
        JLabel7= new javax.swing.JLabel();
        tableModel= new javax.swing.table.DefaultTableModel();

  
        //<End_initVariables>
  } 
   
  public void setUpGUI(Container container)
  { 

  //<Begin_setUpGUI_Container> 
container.add(Top,BorderLayout.CENTER);
Top.setLayout(new GridBagLayout());
inset = new Insets(15,5,5,5);
setConstraints(0,0,1,1,0.0,0.0,cons.CENTER,cons.HORIZONTAL,inset,0,0);
Top.add(JPanel1,cons);
JPanel1.setLayout(new GridLayout(1,0,5,5));
JPanel1.add(JPanel9);
JPanel9.setLayout(new FlowLayout(1,10,5));
JPanel9.add(JLabel4);
JPanel9.add(JLabel1);
JPanel9.add(JLabel6);
inset = new Insets(5,5,5,5);
setConstraints(0,2,1,1,0.1,0.1,cons.CENTER,cons.BOTH,inset,0,0);
Top.add(JPanel2,cons);
JPanel2.setLayout(new BorderLayout(5,5));
JPanel2.add(JLabel8,BorderLayout.WEST);
JPanel2.add(JPanel5,BorderLayout.CENTER);
JPanel5.setLayout(new BorderLayout(5,5));
JPanel5.add(JScrollPane1,BorderLayout.CENTER);
JScrollPane1.getViewport().add(table);
JPanel5.add(JPanel7,BorderLayout.SOUTH);
JPanel7.setLayout(new FlowLayout(2,10,5));
JPanel7.add(JLabel2);
JPanel7.add(JLabel9);
JPanel7.add(JLabel3);
JPanel7.add(JLabel10);
inset = new Insets(5,5,5,5);
setConstraints(0,3,1,1,0.0,0.0,cons.CENTER,cons.HORIZONTAL,inset,0,0);
Top.add(JPanel4,cons);
JPanel4.setLayout(new GridBagLayout());
inset = new Insets(0,0,0,0);
setConstraints(0,0,1,1,0.1,0.0,cons.WEST,cons.HORIZONTAL,inset,0,0);
JPanel4.add(JPanel6,cons);
JPanel6.setLayout(new FlowLayout(1,5,5));
JPanel6.add(addButton);
JPanel6.add(modifyButton);
JPanel6.add(deleteButton);
JPanel6.add(detailsButton);
inset = new Insets(0,10,0,0);
setConstraints(1,0,1,1,0.1,0.0,cons.EAST,cons.HORIZONTAL,inset,0,0);
JPanel4.add(JPanel8,cons);
JPanel8.setLayout(new FlowLayout(1,5,5));
JPanel8.add(applyButton);
JPanel8.add(reloadButton);
inset = new Insets(5,5,5,5);
setConstraints(0,1,1,1,0.0,0.0,cons.CENTER,cons.HORIZONTAL,inset,0,0);
Top.add(JPanel3,cons);
JPanel3.setLayout(new GridBagLayout());
inset = new Insets(5,5,5,5);
setConstraints(1,0,1,1,0.1,0.0,cons.NORTHWEST,cons.HORIZONTAL,inset,0,0);
JPanel3.add(JTextArea1,cons);
inset = new Insets(5,5,5,5);
setConstraints(1,1,1,1,0.0,0.0,cons.NORTHWEST,cons.HORIZONTAL,inset,0,0);
JPanel3.add(JTextArea2,cons);
inset = new Insets(5,5,5,5);
setConstraints(0,1,1,1,0.0,0.0,cons.NORTHWEST,cons.NONE,inset,0,0);
JPanel3.add(JLabel5,cons);
inset = new Insets(5,5,5,5);
setConstraints(0,0,1,1,0.0,0.0,cons.NORTHWEST,cons.NONE,inset,0,0);
JPanel3.add(JLabel7,cons);

  
//<End_setUpGUI_Container>
  } 
   
  public void stop()
  { 

  //<Begin_stop> 
       if(!running)
 return;
 running=false;

  
       //<End_stop>
  } 
  public void start()
  { 

  //<Begin_start> 
       if(running)
 return;
 running=true;

  
       //<End_start>
  } 
  public String getParameter(String input)
  { 

  //<Begin_getParameter_String> 
           String value = null;
           if ( applet != null)
           {    
                 value = applet.getParameter(input);
           }    
           else
           {    
                 value = (String)com.adventnet.apiutils.Utility.getParameter(input);
           }    
           if(value == null)
           {
            if (input.equals("HOST")) value = "localhost"; 
            if (input.equals("RESOURCE_PROPERTIES")) value = "RuntimeAdministrationResources"; 
            if (input.equals("PORT")) value = "161"; 
            }
        return value;

  
           //<End_getParameter_String>
  } 

     

  
  public void showStatus(String message)
  {
     //<Begin_showStatus_String>
     System.out.println("Internal Error :"+ message);
     //<End_showStatus_String>
  }
  public void showStatus(String message,Exception ex)
  {
     //<Begin_showStatus_String_Exception>
     System.out.println("Internal Error :"+ message);
     ex.printStackTrace();
     //<End_showStatus_String_Exception>
  }



   


  public TrapFilterUI()
  {
    //<Begin_TrapFilterUI>
    this.init();
  
    //<End_TrapFilterUI>
  	initializeVariables();
  }

  private void initializeVariables()
  {
	trapFilterModel = new TrapFilterModel(this);
	RuntimeConfigFrame.setStatusText(resourceBundle.getString("Loading Trap filter data....."));
	trapFilterModel.getFilterNodes();
	RuntimeConfigFrame.setBusyCursor(this);
	
  }

  public TrapFilterUI(java.applet.Applet applet)
  {
    //<Begin_TrapFilterUI_java.applet.Applet>
    this.applet = applet;
    this.init();
  
    //<End_TrapFilterUI_java.applet.Applet>

  	initializeVariables();

  }


	public void authenticationFailed(String err)
	{
		JOptionPane.showMessageDialog(null,resourceBundle.getString(err),resourceBundle.getString("Message"),JOptionPane.INFORMATION_MESSAGE);
		RuntimeConfigFrame.setDefaultCursor(this);
		RuntimeConfigFrame.setStatusText(resourceBundle.getString("Done"));
		return;
	}

	public void updateTheUI()
	{
		RuntimeConfigFrame.setDefaultCursor(this);
		RuntimeConfigFrame.applied();
	}
	
	public void updateTheUI(Hashtable mainHash) //Issue ID 11384942
	{
			updateTheUI(mainHash,null); //Issue ID 11384942
	}


	public void updateTheUI(Hashtable mainHash,Vector filterIndex) //Issue ID 11384942
	{
		if(!refetchFlag)
		{
            RuntimeConfigFrame.setStatusText(resourceBundle.getString("Done"));
			RuntimeConfigFrame.setDefaultCursor(this);
		}
		temphash = mainHash;
		//Change for Issue ID 11384942 (Incorrect TrapFilter order shown in RTA) starts
		//Enumeration enumerate = mainHash.keys();
		Enumeration enumerate = null;
		if (filterIndex==null) 
		{
			enumerate=mainHash.keys();
		}
		else
		{
			enumerate=filterIndex.elements();
		}
		//Change for Issue ID 11384942 ends
		while (enumerate.hasMoreElements())
		{
			String filterName = enumerate.nextElement().toString();
			Hashtable childHash = (Hashtable)temphash.get(filterName);
			String className = childHash.get("classname").toString();;
			String enable = childHash.get("enable").toString();
			if(enable.equalsIgnoreCase("false"))
			{
				filterName = filterName+"*";
				className = className+"*";
			}
			Vector v = new Vector();
			if(enable.equals("true"))
				v.add(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("selected.png","images/runtimeadmin"));
			else
				v.add(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("deselected.png","images/runtimeadmin"));
			v.add(filterName);
			v.add(className);
			tableModel.addRow(v);
		}
	}

 
//<Begin__class_detailsButton_detailsButton_conn1>

 class detailsButton_detailsButton_conn1 implements java.awt.event.ActionListener, java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_detailsButton_detailsButton_conn1>



     //Listener Interface Methods Are Added Below 


     public void actionPerformed( java.awt.event.ActionEvent arg0)
     {
  detailsButtonActionPerformed();
     }
//<UserCode_End_Connection_detailsButton_detailsButton_conn1>
 }//<End__class_detailsButton_detailsButton_conn1>
	
	public void detailsButtonActionPerformed()
	{
		boolean detailsFlag = false;
		int row = table.getSelectedRow();
		if(row != -1)
		{
			String filterName = table.getValueAt(row,1).toString();
			if(filterName.indexOf("*") != -1)
			filterName = (filterName.substring(0,filterName.indexOf("*")));
			Hashtable childhash = (Hashtable)temphash.get(filterName);
			addModifyDialog = new TrapAddModify(this,applet);
			addModifyDialog.init();
			addModifyDialog.showCloseButton(true);
			addModifyDialog.populateUI(detailsFlag,filterName,childhash);
			addModifyDialog.setVisible(true);
		}
	}


	public void addElement(Hashtable hash,String name) 
	{
		isModified = true;
		name = name.trim();
		String classname = hash.get("classname").toString().trim();
		boolean validity = true;
		/*for(int i=0;i<table.getRowCount();i++)
		{
			String temp = table.getValueAt(i,2).toString();
			if(temp.indexOf("*") != -1)
				temp = temp.substring(0,temp.indexOf("*"));
			if(temp.equals(classname))
			{
				validity = false;
			}
		}*/
		if(temphash == null)
			temphash = new Hashtable();
		Enumeration enumerate = temphash.keys();
		while(enumerate.hasMoreElements())
		{
			Hashtable temp = (Hashtable)temphash.get(enumerate.nextElement());
			String tempstr = temp.get("classname").toString();
			if(tempstr.equals(classname))
			{
				validity = false;
			}
		}
		if(validity)
		{
			reloadVector.add(classname);
		}
		int modifyRow = 0;
		boolean addFlag = true;
		for(int i=0;i<table.getRowCount();i++)
		{
			String temp = table.getValueAt(i,1).toString();
			if(temp.indexOf("*") != -1)
				temp = temp.substring(0,temp.indexOf("*"));
			if(temp.equals(name))
			{
				addFlag  =false;
				modifyRow = i;
				break;
			}
		}
		Vector v = new Vector();
		String state = hash.get("enable").toString();
		if(state.equalsIgnoreCase("true"))
		{
			v.add(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("selected.png","images/runtimeadmin"));
			v.add(name);
			v.add(hash.get("classname").toString());
		}
		else
		{
			v.add(RuntimeConfigFrame.getCommonBuilderUIImpl().getImage("deselected.png","images/runtimeadmin"));			
			v.add(name+"*");
			v.add(hash.get("classname").toString()+"*");
		}
		if(addFlag)
		{
			tableModel.addRow(v);
			reloadButton.setEnabled(false);
			table.getSelectionModel().clearSelection();		
			//table.getSelectionModel().addSelectionInterval(table.getRowCount()-1,table.getRowCount()-1);
			if(name.indexOf("*") != -1)
			{
				temphash.put(name.substring(0,name.indexOf("*")),hash);
				//reloadVector.add(name.substring(0,name.indexOf("*")));
			}
			else
			{
				temphash.put(name,hash);
				//reloadVector.add(name);
			}
			applyButton.setEnabled(true);
		}
		else
		{
			reloadButton.setEnabled(false);			
			tableModel.insertRow(modifyRow,v);
			tableModel.removeRow(modifyRow+1);
			table.getSelectionModel().clearSelection();
			//table.getSelectionModel().addSelectionInterval(modifyRow,modifyRow);
			if(name.indexOf("*") != -1)
			{
				temphash.put(name.substring(0,name.indexOf("*")),hash);
				//reloadVector.add(name.substring(0,name.indexOf("*")));
			}
			else
			{
				temphash.put(name,hash);
				//reloadVector.add(name);
			}	
			applyButton.setEnabled(true);
			modifyButton.setEnabled(false);
			deleteButton.setEnabled(false);
			detailsButton.setEnabled(false);
			reloadButton.setEnabled(false);			
		}
	}

 
//<Begin__class_modifyButton_modifyButton_conn1>

 class modifyButton_modifyButton_conn1 implements java.awt.event.ActionListener, java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_modifyButton_modifyButton_conn1>



     //Listener Interface Methods Are Added Below 


     public void actionPerformed( java.awt.event.ActionEvent arg0)
     {
  modifyButtonActionPerformed();
     }
//<UserCode_End_Connection_modifyButton_modifyButton_conn1>
 }//<End__class_modifyButton_modifyButton_conn1>
	
	public void modifyButtonActionPerformed()
	{
		int row = table.getSelectedRow();
		boolean flag = true;
		if(row != -1)
		{
			String filterName = table.getValueAt(row,1).toString();
			if(filterName.indexOf("*") != -1)
			filterName = (filterName.substring(0,filterName.indexOf("*")));
			Hashtable childhash = (Hashtable)temphash.get(filterName);
			addModifyDialog = new TrapAddModify(this,applet);
			addModifyDialog.init();
			addModifyDialog.showCloseButton(false);
			addModifyDialog.populateUI(flag,filterName,childhash);
			addModifyDialog.setVisible(true);			
		}
	}


 
//<Begin__class_addButton_addButton_conn1>

 class addButton_addButton_conn1 implements java.awt.event.ActionListener, java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_addButton_addButton_conn1>



     //Listener Interface Methods Are Added Below 


     public void actionPerformed( java.awt.event.ActionEvent arg0)
     {
  addButtonActionPerformed();
     }
//<UserCode_End_Connection_addButton_addButton_conn1>
 }//<End__class_addButton_addButton_conn1>
	
	public void addButtonActionPerformed()
	{
		TrapAddModify add = new TrapAddModify(this,applet);
		add.init();
		add.setVisible(true);
	}

 
//<Begin__class_table_table_conn3>

 class table_table_conn3 extends java.awt.event.MouseMotionAdapter implements java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_table_table_conn3>



     //Listener Interface Methods Are Added Below 


     public void mouseDragged( java.awt.event.MouseEvent arg0)
     {
  tableMouseDraggedEvent(arg0);
     }
//<UserCode_End_Connection_table_table_conn3>
 }//<End__class_table_table_conn3>
//<Begin__class_table_table_conn2>

 class table_table_conn2 extends java.awt.event.MouseAdapter implements java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_table_table_conn2>



     //Listener Interface Methods Are Added Below 


     public void mousePressed( java.awt.event.MouseEvent arg0)
     {
  tableMousePressedEvent(arg0);
     }



     public void mouseReleased( java.awt.event.MouseEvent arg0)
     {
  tableMouseReleasedEvent(arg0);
     }
 


     public void mouseClicked( java.awt.event.MouseEvent arg0)
     {
  tableMouseClickedEvent();
  if(arg0.getClickCount() == 2)
  {
   detailsButtonActionPerformed();
  }
     }
  
//<UserCode_End_Connection_table_table_conn2>
 }//<End__class_table_table_conn2>
//<Begin__class_table_table_conn1>

 class table_table_conn1 extends java.awt.event.KeyAdapter implements java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_table_table_conn1>



     //Listener Interface Methods Are Added Below 


     public void keyPressed( java.awt.event.KeyEvent arg0)
     {
  tableKeyPressedEvent(arg0);
     }



     public void keyReleased( java.awt.event.KeyEvent arg0)
     {
  tableKeyReleasedEvent(arg0);
     }
 
//<UserCode_End_Connection_table_table_conn1>
 }//<End__class_table_table_conn1>
	
	public void tableMouseReleasedEvent(MouseEvent arg0)
	{
		if(shiftFlag || controlFlag)
		{}
		else  if (shiftFlag && controlFlag)
		{}
		else
		{
			RuntimeConfigFrame.gip.mouseReleased(SwingUtilities.convertMouseEvent(arg0.getComponent(),arg0,RuntimeConfigFrame.gip)); 
		}
		int index = ((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
		if(index == -1)
		{
			modifyButton.setEnabled(false);
			deleteButton.setEnabled(false);
			detailsButton.setEnabled(false);
			reloadButton.setEnabled(false);
		}
		else
		{
				modifyButton.setEnabled(true);
				deleteButton.setEnabled(true);
			detailsButton.setEnabled(true);
		}
		table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		if(index != -1 && startRow != -1)
		{
			if(startRow != index)
			{
				isModified = true;
				applyButton.setEnabled(true);
				//reOrder = true;
			}
			if(startRow >= index)
			{
				Vector temp = new Vector();
				temp.add(table.getValueAt(startRow,0));
				temp.add(table.getValueAt(startRow,1));  
				temp.add(table.getValueAt(startRow,2));
				tableModel.insertRow(index,temp);
				tableModel.removeRow(startRow+1);
			}
			else
			{
				Vector temp = new Vector();
				temp.add(table.getValueAt(startRow,0));  
				temp.add(table.getValueAt(startRow,1));  
				temp.add(table.getValueAt(startRow,2));
			  	tableModel.insertRow(index+1,temp);
				tableModel.removeRow(startRow);
			}
			int j = index;
			if(!shiftFlag && !controlFlag)
			table.getSelectionModel().addSelectionInterval(j,index);
		}
	}

	public void tableMouseDraggedEvent(MouseEvent arg0)
	{
		if(shiftFlag || controlFlag)
		{}
		else
		{	
			
			RuntimeConfigFrame.gip.mouseDragged(SwingUtilities.convertMouseEvent(arg0.getComponent(),arg0,RuntimeConfigFrame.gip)); 
		}		
		table.getSelectionModel().clearSelection(); 

	}

	public void tableMousePressedEvent(MouseEvent arg0)
	{
		if(table.getSelectedRow() == -1)
		{
			modifyButton.setEnabled(false);
			deleteButton.setEnabled(false);
			detailsButton.setEnabled(false);
			reloadButton.setEnabled(false);
		}
		else
		{
				modifyButton.setEnabled(true);
				deleteButton.setEnabled(true);
				detailsButton.setEnabled(true);
		}
		startRow = ((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
		setReloadState(startRow);
		if(startRow == -1)
			return;
		String str1 = table.getValueAt(startRow,1).toString();
		String str2 = table.getValueAt(startRow,2).toString();
		if(str1.indexOf("*") != -1)
			str1 = (str1.substring(0,str1.indexOf("*")));
		if(str2.indexOf("*") != -1)
			str2 = (str2.substring(0,str2.indexOf("*")));
		String str = str1+"   |   "+str2;
		if(shiftFlag || controlFlag)
		{
		}
		else if (shiftFlag && controlFlag)
		{}
		else 
		{
			RuntimeConfigFrame.gip.showGlassPanel(this,(JFrame)SwingUtilities.windowForComponent(this),1,null,str,shiftFlag,controlFlag);
		}

	}

	public void tableKeyPressedEvent(KeyEvent arg0)
	{
		 if(arg0.getKeyCode() == KeyEvent.VK_SHIFT)
 		 {
		 	shiftFlag = true; 
		 } 
 		 if(arg0.getKeyCode() == KeyEvent.VK_CONTROL)
		 {
		 	controlFlag = true; 
		 }
	}

	public void tableKeyReleasedEvent(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_SHIFT)
 		{
		 	shiftFlag = false; 
		} 
 		if(arg0.getKeyCode() == KeyEvent.VK_CONTROL)
		{
		 	controlFlag = false; 
		}
	}
//changed for  RTA SPP fix

	public boolean  applyToServer()
	{
       try
       {
		if(isModified())
		{
			RuntimeConfigFrame.setBusyCursor(this);
			RuntimeConfigFrame.applyStatus();
			reloadButton.setEnabled(true);
	//		isModified = false;
		   	int total = table.getRowCount();
			Hashtable setArray[] = new Hashtable[total+1];
			for (int i=0;i <=total-1;i++)
		   	{
				setArray[i] = new Hashtable(); 
				String tempclass = (String)table.getValueAt(i,1); 
				if(tempclass.indexOf("*") != -1)
					tempclass = (tempclass.substring(0,tempclass.indexOf("*")));
				setArray[i] = (Hashtable)temphash.get(tempclass);
			}
			trapFilterModel.setFilterNodes(setArray) ;
			reloadVector.removeAllElements();
            isModified = false;
			applyButton.setEnabled(false);
		}
      }  
      catch(Exception exce)
      {
            RuntimeConfigFrame.setDefaultCursor(this);
            return false;
      }
        return true;
	}
	public boolean isModified()
	{
		return isModified;
	}


//<Begin__class_deleteButton_deleteButton_conn1>

 class deleteButton_deleteButton_conn1 implements java.awt.event.ActionListener, java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_deleteButton_deleteButton_conn1>



     //Listener Interface Methods Are Added Below 


     public void actionPerformed( java.awt.event.ActionEvent arg0)
     {
  deleteButtonActionPerformed();
     }
//<UserCode_End_Connection_deleteButton_deleteButton_conn1>
 }//<End__class_deleteButton_deleteButton_conn1>
	
	public void deleteButtonActionPerformed()
	{
		int [] selectedRows = table.getSelectedRows();
		int length = selectedRows.length;
		if(length == 0)
		{
			return;
		}
		JOptionPane jp = new JOptionPane(); 
		int option =  jp.showConfirmDialog(null, resourceBundle.getString("Are you sure about deleting the selected item(s)"),null,jp.YES_NO_OPTION);
		if (option == jp.YES_OPTION)
		{ 
			isModified = true;
			for(int j=length-1;j >=0;j--)
			{
				tableModel.removeRow(selectedRows[j]);
			} 
			applyButton.setEnabled(true);
  	   	}
	}


//<Begin__class_reloadButton_reloadButton_conn1>

 class reloadButton_reloadButton_conn1 implements java.awt.event.ActionListener, java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_reloadButton_reloadButton_conn1>



     //Listener Interface Methods Are Added Below 


     public void actionPerformed( java.awt.event.ActionEvent arg0)
     {
  reloadButtonActionPerformed();
     }
//<UserCode_End_Connection_reloadButton_reloadButton_conn1>
 }//<End__class_reloadButton_reloadButton_conn1>
	
		public void reloadButtonActionPerformed()
		{
			int [] selectedRows = table.getSelectedRows();
			int count = selectedRows.length;
			if(count == 0)
			{
				return;
			}
			Vector reloadVector = new Vector();
			for(int i=0;i<count;i++)
			{ 
					String name = table.getValueAt(selectedRows[i],1).toString();
					if(name.indexOf("*") != -1)
						name = (name.substring(0,name.indexOf("*")));	
					reloadVector.add(name);
			} 
			trapFilterModel.reloadFilterNode(reloadVector); 
		}


//<Begin__class_classpathButton_classpathButton_conn1>

 class classpathButton_classpathButton_conn1 implements java.awt.event.ActionListener, java.io.Serializable 
  {

     //<TOP_PART>
//<UserCode_Begin_Connection_classpathButton_classpathButton_conn1>



     //Listener Interface Methods Are Added Below 


     public void actionPerformed( java.awt.event.ActionEvent arg0)
     {
  applyToServer();
     }
//<UserCode_End_Connection_classpathButton_classpathButton_conn1>
 }//<End__class_classpathButton_classpathButton_conn1>
	
	public void classpathButtonActionPerformed()
	{
        ClassPathDialog classPathDialog = new ClassPathDialog(this.applet);
		classPathDialog.init();
		classPathDialog.populateUI(RuntimeConfigFrame.getClassPath(),RuntimeConfigFrame.getClassPathDelimiter());
		classPathDialog.setVisible(true);
	}

	public void tableMouseClickedEvent()
	{
		if(table.getSelectedRow() == -1)
		{
			modifyButton.setEnabled(false);
			deleteButton.setEnabled(false);
			detailsButton.setEnabled(false);
		}
		else
		{
				modifyButton.setEnabled(true);
				deleteButton.setEnabled(true);
			detailsButton.setEnabled(true);
		}
	}

	public void refetchData()
	{
		int i=tableModel.getRowCount();
		if(i != 0)
		{
			for(int j=i-1;j >=0;j--)
			{
				tableModel.removeRow(j);
			}
		}
		refetchFlag = true;
		isModified = false;	
		applyButton.setEnabled(false);
		modifyButton.setEnabled(false);
		detailsButton.setEnabled(false);
		deleteButton.setEnabled(false);
		reloadButton.setEnabled(false);
		reloadVector.removeAllElements();
		trapFilterModel.getFilterNodes();
	}

	public void setReloadState(int row)
	{
		if(row == -1)
		{
			reloadButton.setEnabled(false);
		}
		else
		{
			String temp = table.getValueAt(row,2).toString();
			if(temp.indexOf("*") != -1)
						temp = (temp.substring(0,temp.indexOf("*")));
			boolean enable = true;
			for(int j=0;j<reloadVector.size();j++)
			{
				String str = reloadVector.elementAt(j).toString();
				if(str.equals(temp))
				{
					reloadButton.setEnabled(false);
					enable = false;
				}
			}
			if(enable)
			{
				reloadButton.setEnabled(true);
			}
		}
		if(table.getSelectedRow() == -1)
		{
			//disable
			reloadButton.setEnabled(false);
		}
	}

 
  public void setProperties(java.util.Properties props)
  {
  //<Begin_setProperties_java.util.Properties> 

  
  //<End_setProperties_java.util.Properties>
  }

  //added for  RTA fix for spp team
  public void dispose(){
  
          trapFilterModel.eventConfiguartionSession.dispose();
          trapFilterModel=null;
          addModifyDialog=null;
          temphash=null;
          reloadVector=null;
          Top=null;
          table=null;
                                                                                                            
 }  
 //end of addition
}























