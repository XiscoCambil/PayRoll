import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.lang.String;
import java.text.DateFormat;
import java.util.Date;


  public class Emprptwindow extends JInternalFrame implements ActionListener {
  
	JFrame JFParentFrame;
	
	static Date td  = new Date();
	static String sDate 	= DateFormat.getDateTimeInstance().format(td);

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel5_1;
	private JPanel panel5_2;
	private JPanel panel6;
	private JPanel panel6_1;
	private JPanel panel6_2;
	private JPanel panel7;
	private JPanel panel8_1;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel panel13;
	private JPanel panel14;
		
	private JButton GenerateBtn;
	private JButton PrintBtn;
	private JButton ExitBtn;
	
	
	private JTextField TxtCategory_Type,TxtCategory_Name;
	private JComboBox MonthCombo;	
	private JTextField TxtYear;
	private JLabel LblMonth;
	private String[] Month_Name =       {"January",
                                        "February",
                                        "March",
                                        "April",
                                        "May",
                                        "June",
                                        "July",
                                        "August",
                                        "September",
                                        "October",
                                        "November",
                                        "December"};
   
	
	String dialogmessage;
    String dialogs;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    public static int record;
    
        
    
     // Class Variables
     
     clsConfiguracions settings = new clsConfiguracions();
     clsConnection connect = new clsConnection();
     
     // Connection
     Connection conn;
     
     ////// Report Variables
     
     private JLabel Lblcollege1, Lblcollege2, Lblcollege3, Lbldate, LblSalary_Slip;
     private JLabel LblEmp_Name, LblEmp_Code, LblEmp_Desi, LblBasic_Pay, LblAllowance, LblDeduction;
     private JLabel LblDA, LblHRA, LblWA, LblGPF, LblIT, LblGIS, LblPF, LblLIC;
     private JLabel LblTot_Allowance, LblTot_Deduction, LblNet_Salary;
     
     private JTextField TxtDate, TxtEmp_Name1, TxtEmp_Name2 , TxtEmp_Code,TxtSalary_Month, TxtEmp_Desi, TxtBasic_Pay;
     private JTextField TxtDA, TxtHRA, TxtWA, TxtGPF, TxtIT, TxtGIS, TxtPF, TxtLIC;
     private JTextField TxtTot_Allowance, TxtTot_Deduction, TxtNet_Salary;
    
    
    public String sEmp_Code = "";
	public String sEmp_Name1 = "";
	public	String sEmp_Name2 = "";
	public	String sEmp_Desi = "";
	
    public String sCategory_Type = "";
    public String sCategory_Name = "";
    public String sBasic_Pay = "";
    public String sDA = "";
    public String sHRA = "";
    public String sWA = "";
    public String sGPF = "";
    public String sIT = "";
    public String sGIS = "";
    public String sPF = "";
    public String sLIC = "";
    public String sDA_Allow = "";
    public String sHRA_Allow = "";
    public String sWA_Allow = "";
    public String sGPF_Dedu = "";
    public String sIT_Dedu = "";
    public String sGIS_Dedu = "";
    public String sPF_Dedu = "";
    public String sLIC_Dedu = "";
    public String sAllow = "";
    public String sDedu = "";
    public String sNet_Salary = "";
    
    public String Emp_Month;
    public String Emp_Year;
    
    
    	public static int vBasic_Pay, DA_Rs, HRA_Rs ,WA_Rs , GPF_Rs, IT_Rs, GIS_Rs, PF_Rs, LIC_Rs;
    	public static int DA_Value,HRA_Value, WA_Value, GPF_Value, IT_Value, GIS_Value, PF_Value, LIC_Value;  
    	public static int Allow, Dedu, Net_Salary;
    
        
    
     
    public Emprptwindow(JFrame getParentFrame) 
 
    {
       super("Employee PaySlip",true,true,true,true);
       setSize(600,700);
       JFParentFrame = getParentFrame;
       
       
                     
    	panel1 = new JPanel();
    	panel1.setLayout(new FlowLayout());
    	LblEmp_Code = new JLabel("Employee Code: ");
    	TxtEmp_Code = new JTextField(10);
		LblMonth = new JLabel("For the Month :");
		
		
		MonthCombo = new JComboBox();
		MonthCombo.addActionListener(this);
				
    	for ( int i = 0; i <= 11; i++ )
    	{
    		MonthCombo.addItem(Month_Name[i]); 
    	}
    	TxtYear = new JTextField(5);    	
    	
    	panel1.add(LblEmp_Code);
    	panel1.add(TxtEmp_Code);
    	panel1.add(LblMonth);
    	panel1.add(MonthCombo);
    	panel1.add(TxtYear);
    	
    	
    	    	
    	panel2 = new JPanel();
    	panel2.setLayout(new FlowLayout());
    	
    	LblEmp_Name = new JLabel("Employee Name :");
    	TxtEmp_Name1 = new JTextField(10);
    	TxtEmp_Name2 = new JTextField(10);
    	
    	TxtEmp_Name1.setEditable(false);
    	TxtEmp_Name2.setEditable(false);
    	
    	panel2.add(LblEmp_Name);
    	panel2.add(TxtEmp_Name1);
    	panel2.add(TxtEmp_Name2);
    	
    	
    	panel3 = new JPanel();
    	panel3.setLayout(new FlowLayout());
    	
    	LblEmp_Desi = new JLabel("Designation :");
    	TxtEmp_Desi = new JTextField(20);
    	TxtEmp_Desi.setEditable(false);
    	
    
    	panel3.add(LblEmp_Desi);
    	panel3.add(TxtEmp_Desi);
    	
    
    	
    	panel4 = new JPanel();
    	panel4.setLayout(new FlowLayout());
    	
    	GenerateBtn = new JButton("Generate");
		GenerateBtn.addActionListener(this);
    	panel4.add(GenerateBtn);
    	
    

    	  ////// Report Variables
    
    	 
    	 

    	 Lblcollege2 = new JLabel("GOVT ENGINEERING COLLEGE AURANGABAD");
    	 Lbldate = new JLabel         ("   Date :");
    	 LblSalary_Slip = new JLabel  ("   Salary Slip :");
    	 LblBasic_Pay = new JLabel    ("   Basic Pay :");	
    	 LblAllowance = new JLabel    ("********** A  L  L  O  W  A  N  C  E ********");
    	 LblDeduction = new JLabel    ("********** D  E  D  U  C  T  I  O  N ********");	
    	 LblDA  = new JLabel          ("    DA :");
    	 LblHRA = new JLabel          ("    HRA :");
    	 LblWA  = new JLabel          ("    WA :");
    	 LblGPF = new JLabel          ("    GPF :");
    	 LblIT  = new JLabel          ("    IT :");
    	 LblGIS = new JLabel          ("    GIS :");
    	 LblPF  = new JLabel          ("    PF :");
    	 LblLIC = new JLabel          ("    LIC :");
    	 LblTot_Allowance = new JLabel("    Total Allowances :");
    	 LblTot_Deduction = new JLabel("    Total Deduction  :");
    	 LblNet_Salary = new JLabel   ("    Net Salary       :");
    	   
    
    	 TxtDate = new JTextField(10);
    	 
    	 TxtSalary_Month = new JTextField(20);
    	 TxtBasic_Pay = new JTextField(10);
    	 TxtDA = new JTextField(5);
    	 TxtHRA = new JTextField(5);
    	 TxtWA = new JTextField(5);
    	 TxtGPF = new JTextField(5);
    	 TxtIT = new JTextField(5);
    	 TxtGIS = new JTextField(5);
    	 TxtPF = new JTextField(5);
    	 TxtLIC = new JTextField(5);
    	 TxtTot_Allowance = new JTextField(6);
    	 TxtTot_Deduction = new JTextField(6);
    	 TxtNet_Salary = new JTextField(6);
    	 
    	 TxtDate.setEditable(false);
    	 TxtSalary_Month.setEditable(false);
    	 TxtBasic_Pay.setEditable(false);
    	 TxtDA.setEditable(false);
    	 TxtHRA.setEditable(false);
    	 TxtWA.setEditable(false);
    	 TxtGPF.setEditable(false);
    	 TxtIT.setEditable(false);
    	 TxtGIS.setEditable(false);
    	 TxtPF.setEditable(false);
    	 TxtLIC.setEditable(false);
    	 
    	 TxtTot_Allowance.setEditable(false);
    	 TxtTot_Deduction.setEditable(false);
    	 TxtNet_Salary.setEditable(false);
    	 
    	 
    	 
    	 
    	 panel5 = new JPanel();
    	 panel5.setLayout(new FlowLayout());
    	 panel5.add(Lblcollege2, BorderLayout.CENTER);
    	 
    	 
    	 panel5_1 = new JPanel();
    	 panel5_1.setLayout(new GridLayout(3,3));
    	 panel5_1.add(Lbldate);
    	 panel5_1.add(TxtDate);
    	 
    	
    	 panel5_1.add(LblSalary_Slip, "CENTER");
    	 panel5_1.add(TxtSalary_Month,"RIGHT");
    	 
    	 
    	 
    	 panel5_1.add(LblBasic_Pay,"LEFT");
    	 panel5_1.add(TxtBasic_Pay,"CENTER");
    	 
    	 panel7 = new JPanel();
    	 panel7.setLayout(new FlowLayout());
    	    	 
    	 panel7.add(LblAllowance, "CENTER");
    	 
    	 
    	 panel8_1 = new JPanel();
    	 panel8_1.setLayout(new GridLayout(3,2));
    	 panel8_1.add(LblDA);
    	 panel8_1.add(TxtDA);
    	 panel8_1.add(LblHRA);
    	 panel8_1.add(TxtHRA);
    	 panel8_1.add(LblWA);
    	 panel8_1.add(TxtWA);
    	 
    	 panel9 = new JPanel();
    	 panel9.setLayout(new GridLayout(1,3));
    	 
    	 panel9.add(LblTot_Allowance, "EAST");
    	 panel9.add(TxtTot_Allowance, "EAST");
    	     	 
    	 panel10 = new JPanel();
    	 panel10.setLayout(new FlowLayout());
    	 panel10.add(LblDeduction, "CENTER");
    	 
    	 panel11 = new JPanel();
    	 panel11.setLayout(new GridLayout(5,5));
    	 panel11.add(LblGPF);
    	 panel11.add(TxtGPF);
    	 panel11.add(LblIT);
    	 panel11.add(TxtIT);
    	 panel11.add(LblGIS);
    	 panel11.add(TxtGIS);
    	 panel11.add(LblPF);
    	 panel11.add(TxtPF);
    	 panel11.add(LblLIC);
    	 panel11.add(TxtLIC);
    	 
    	 panel12 = new JPanel();
    	 panel12.setLayout(new GridLayout(1,3));
    	 
    	 panel12.add(LblTot_Deduction);
    	 panel12.add(TxtTot_Deduction);
    	 
    	 panel13 = new JPanel();
    	 panel13.setLayout(new FlowLayout());
    	 panel13.add(LblNet_Salary);
    	 panel13.add(TxtNet_Salary);
    	 
    	 
		
		panel14 = new JPanel();
    	panel14.setLayout(new FlowLayout());
    	
    	PrintBtn = new JButton("Preview", new ImageIcon("images/prints.png"));
    	PrintBtn.addActionListener(this);
		ExitBtn = new JButton("Exit", new ImageIcon("images/exit.png"));
		ExitBtn.addActionListener(this);
    	
    	panel14.add(PrintBtn);
    	panel14.add(ExitBtn);
    	
       
   			Container pane = getContentPane();
    		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
			pane.add(panel1);
			pane.add(panel2);
			pane.add(panel3);
			pane.add(panel4);
			pane.add(panel5);
			pane.add(panel5_1);
			pane.add(panel7);
			pane.add(panel8_1);
			
			pane.add(panel9);
			pane.add(panel10);
			pane.add(panel11);
			pane.add(panel12);
			pane.add(panel13);
			pane.add(panel14);
			
			
		
       		setFrameIcon(new ImageIcon( "images/New.gif"));
       	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	 pack();	
       
     }
    
    public void actionPerformed(ActionEvent event)
    {
    		Object source = event.getSource();
    	
    				if ( source  == MonthCombo)
    	{
				
    			String Emp_Month = (String)MonthCombo.getSelectedItem();
    			
    			
    		
    	}
    	
    	if (source == PrintBtn)
    	{
    		printwindow prn = new printwindow();
    		prn.fill_data(sEmp_Name1,sEmp_Name2,Emp_Month, Emp_Year,sEmp_Code,sDate,
    					  sEmp_Desi, sBasic_Pay, sDA_Allow, sHRA_Allow, sWA_Allow,
    					  sGPF_Dedu, sIT_Dedu, sGIS_Dedu, sPF_Dedu,sLIC_Dedu , sAllow, sDedu, sNet_Salary );
       
       
       
       
    	}
    			
    	if (source == GenerateBtn)
    	{
    		sEmp_Code = TxtEmp_Code.getText().trim();
    		Get_Data(sEmp_Code);
    		Generate_Report(sEmp_Desi);
    		
    		
    	}
    	   	
    	if (source == ExitBtn)
    	{
    		setVisible (false);
    		dispose();
    		    		
    	}
    		
    }
    

    public void Get_Data(String code)
    {
    			 	
		
		
		try {
                conn = connect.setConnection(conn,"");
            }
            catch(Exception e)
            {
            }
				 try {
			    		
			    Statement stmt = conn.createStatement();          
    		
         if (!code.equals(""))
         {	
     			String query = "SELECT * FROM EMPLOYEE WHERE Emp_Code = '" + code +"'";
     		
                ResultSet rs = stmt.executeQuery(query);
                int foundrec = 0;
                while (rs.next())
                {
                		sEmp_Code = code;
                		sEmp_Name1 = rs.getString(2).trim();
                		sEmp_Name2 = rs.getString(3).trim();
						sEmp_Desi = rs.getString(4).trim();
						
						Emp_Month = (String)MonthCombo.getSelectedItem();
						Emp_Year = TxtYear.getText().trim();
						
						
						foundrec = 1;
                    	
                    	
                    	
                    
                }
                
     		if (foundrec == 0)
                {
                    dialogmessage = "No Such Employuee";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   
                   
                }
                
         }
         else
         {
         			dialogmessage = "No Blank Field Allowed";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   
                   
         }    
		  
          
     		
			 }
				 catch(Exception e)
            {
                System.out.println("\nUnknown Error at Genrate_Data");
            }
           
           
				   
		 }
		 
		 
		 public void Generate_Report(String Desi)
		 {
		 	
		 	
		 	
		try {
                conn = connect.setConnection(conn,"");
            }
            catch(Exception e)
            {
            }
				 try {
			    		
			    Statement stmt = conn.createStatement();          
    		
         if (!Desi.equals(""))
         {	
     			String query = "SELECT * FROM Settings WHERE Category_Name = '" + Desi +"'";
     			 
                ResultSet rs = stmt.executeQuery(query);
                int foundrec = 0;
              
                while (rs.next())
                {
                	
                sCategory_Type = rs.getString(1).trim();
                sCategory_Name = rs.getString(2).trim();
                vBasic_Pay = rs.getInt(3); 
                	               
				sDA = rs.getString(4).trim();
				sHRA = rs.getString(5).trim();
				sWA = rs.getString(6).trim();
				sGPF = rs.getString(7).trim();
				sIT = rs.getString(8).trim();
				sGIS = rs.getString(9).trim();
				sPF = rs.getString(10).trim();
				sLIC = rs.getString(11).trim();
              

                DA_Value = rs.getInt(12);
    			HRA_Value = rs.getInt(13);
    			WA_Value = rs.getInt(14);
    			GPF_Value = rs.getInt(15);
    			IT_Value = rs.getInt(16);
    			GIS_Value = rs.getInt(17);
    			PF_Value = rs.getInt(18);
    			LIC_Value = rs.getInt(19);
    		
    			
    			if (sDA.equals("true") )
    			{
    				DA_Rs =  vBasic_Pay*DA_Value/100;
    		
    			}
    			else
    			{
    				DA_Rs = DA_Value;
    			
    			}
    			
    			if (sHRA.equals("true"))
    			{
    				HRA_Rs = (vBasic_Pay * HRA_Value) / 100;	
    			}
    			else
    			{
    				HRA_Rs = HRA_Value;
    			}
    			
    			if (sWA.equals("true"))
    			{
    				WA_Rs = (vBasic_Pay * WA_Value) / 100;	
    			}
    			else
    			{
    				WA_Rs = WA_Value;
    			}
    			
    			if (sGPF.equals("true"))
    			{
    				GPF_Rs = (vBasic_Pay * GPF_Value) / 100;	
    			}
    			else
    			{
    				GPF_Rs = GPF_Value;
    			}
    			
    			if (sIT.equals("true"))
    			{
    				IT_Rs = (vBasic_Pay * IT_Value) / 100;	
    			}
    			else
    			{
    				IT_Rs = IT_Value;
    			}
    			
    			if (sGIS.equals("true"))
    			{
    				GIS_Rs = (vBasic_Pay * GIS_Value) / 100;	
    			}
    			else
    			{
    				GIS_Rs = GIS_Value;
    			}
    			
    				if (sPF.equals("true"))
    			{
    				PF_Rs = (vBasic_Pay * PF_Value) / 100;	
    			}
    			else
    			{
    				PF_Rs = PF_Value;
    			}
    			
    			
    				if (sLIC.equals("true"))
    			{
    				LIC_Rs = (vBasic_Pay * LIC_Value) / 100;	
    			}
    			else
    			{
    				LIC_Rs = LIC_Value;
    			}
    			
    		
    			
    			Allow = DA_Rs + HRA_Rs + WA_Rs;
    			Dedu = GPF_Rs + IT_Rs + GIS_Rs + PF_Rs + LIC_Rs;
    			Net_Salary = (vBasic_Pay + Allow) - Dedu ;
    		
    			
    			sBasic_Pay = Integer.toString(vBasic_Pay);
    			sDA_Allow = Integer.toString(DA_Rs);
    			sHRA_Allow = Integer.toString(HRA_Rs);
    			sWA_Allow = Integer.toString(WA_Rs);
    			sGPF_Dedu = Integer.toString(GPF_Rs);
    			sIT_Dedu = Integer.toString(IT_Rs);
    			sGIS_Dedu = Integer.toString(GIS_Rs);
    			sPF_Dedu = Integer.toString(PF_Rs);
    			sLIC_Dedu = Integer.toString(LIC_Rs);
    			sAllow = Integer.toString(Allow);
    			sDedu = Integer.toString(Dedu);
    			sNet_Salary = Integer.toString(Net_Salary);
    			
    			///// Feeding values to the form
				 TxtDate.setText(sDate);    			
    			TxtEmp_Name1.setText(sEmp_Name1);
    			TxtEmp_Name2.setText(sEmp_Name2);
    			TxtSalary_Month.setText("For the Month of " + Emp_Month + " , " + Emp_Year);
    			TxtEmp_Code.setText(sEmp_Code);
    			TxtEmp_Desi.setText(sEmp_Desi);
    			
    			TxtBasic_Pay.setText(sBasic_Pay);
    			
    			TxtDA.setText(sDA_Allow);
    			TxtHRA.setText(sHRA_Allow);
    			TxtWA.setText(sWA_Allow);
    			TxtTot_Allowance.setText(sAllow);
    			
    			TxtGPF.setText(sGPF_Dedu);
    			TxtIT.setText(sIT_Dedu);
    			TxtGIS.setText(sGIS_Dedu);
    			TxtPF.setText(sPF_Dedu);
    			TxtLIC.setText(sLIC_Dedu);
    			TxtTot_Deduction.setText(sDedu);
    			TxtNet_Salary.setText(sNet_Salary);
    			
    			
    			
    			 
    			foundrec = 1;
                    
                }
                
     		if (foundrec == 0)
                {
                    dialogmessage = "No Such Employuee";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                   
                }
                
         }
         else
         {
         			dialogmessage = "No Blank Field Allowed";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   
                   
         }    
		  conn.close();
          
     		
			 }
				 catch(Exception e)
            {
                System.out.println("\nUnknown Errorat Generate -report");
            }
           
           		   
		 }

	  //Constructor Ejercicio
	  public Emprptwindow(JFrame JFParentFrame, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5, JPanel panel5_1, JPanel panel5_2, JPanel panel6, JPanel panel6_1, JPanel panel6_2, JPanel panel7, JPanel panel8_1, JPanel panel9, JPanel panel10, JPanel panel11, JPanel panel12, JPanel panel13, JPanel panel14, JButton generateBtn, JButton printBtn, JButton exitBtn, JTextField txtCategory_Type, JTextField txtCategory_Name, JComboBox monthCombo, JTextField txtYear, JLabel lblMonth, String[] month_Name, String dialogmessage, String dialogs, int dialogtype, clsConfiguracions settings, clsConnection connect, Connection conn, JLabel lblcollege1, JLabel lblcollege2, JLabel lblcollege3, JLabel lbldate, JLabel lblSalary_Slip, JLabel lblEmp_Name, JLabel lblEmp_Code, JLabel lblEmp_Desi, JLabel lblBasic_Pay, JLabel lblAllowance, JLabel lblDeduction, JLabel lblDA, JLabel lblHRA, JLabel lblWA, JLabel lblGPF, JLabel lblIT, JLabel lblGIS, JLabel lblPF, JLabel lblLIC, JLabel lblTot_Allowance, JLabel lblTot_Deduction, JLabel lblNet_Salary, JTextField txtDate, JTextField txtEmp_Name1, JTextField txtEmp_Name2, JTextField txtEmp_Code, JTextField txtSalary_Month, JTextField txtEmp_Desi, JTextField txtBasic_Pay, JTextField txtDA, JTextField txtHRA, JTextField txtWA, JTextField txtGPF, JTextField txtIT, JTextField txtGIS, JTextField txtPF, JTextField txtLIC, JTextField txtTot_Allowance, JTextField txtTot_Deduction, JTextField txtNet_Salary, String sEmp_Code, String sEmp_Name1, String sEmp_Name2, String sEmp_Desi, String sCategory_Type, String sCategory_Name, String sBasic_Pay, String sDA, String sHRA, String sWA, String sGPF, String sIT, String sGIS, String sPF, String sLIC, String sDA_Allow, String sHRA_Allow, String sWA_Allow, String sGPF_Dedu, String sIT_Dedu, String sGIS_Dedu, String sPF_Dedu, String sLIC_Dedu, String sAllow, String sDedu, String sNet_Salary, String emp_Month, String emp_Year) {
		  this.JFParentFrame = JFParentFrame;
		  this.panel1 = panel1;
		  this.panel2 = panel2;
		  this.panel3 = panel3;
		  this.panel4 = panel4;
		  this.panel5 = panel5;
		  this.panel5_1 = panel5_1;
		  this.panel5_2 = panel5_2;
		  this.panel6 = panel6;
		  this.panel6_1 = panel6_1;
		  this.panel6_2 = panel6_2;
		  this.panel7 = panel7;
		  this.panel8_1 = panel8_1;
		  this.panel9 = panel9;
		  this.panel10 = panel10;
		  this.panel11 = panel11;
		  this.panel12 = panel12;
		  this.panel13 = panel13;
		  this.panel14 = panel14;
		  GenerateBtn = generateBtn;
		  PrintBtn = printBtn;
		  ExitBtn = exitBtn;
		  TxtCategory_Type = txtCategory_Type;
		  TxtCategory_Name = txtCategory_Name;
		  MonthCombo = monthCombo;
		  TxtYear = txtYear;
		  LblMonth = lblMonth;
		  Month_Name = month_Name;
		  this.dialogmessage = dialogmessage;
		  this.dialogs = dialogs;
		  this.dialogtype = dialogtype;
		  this.settings = settings;
		  this.connect = connect;
		  this.conn = conn;
		  Lblcollege1 = lblcollege1;
		  Lblcollege2 = lblcollege2;
		  Lblcollege3 = lblcollege3;
		  Lbldate = lbldate;
		  LblSalary_Slip = lblSalary_Slip;
		  LblEmp_Name = lblEmp_Name;
		  LblEmp_Code = lblEmp_Code;
		  LblEmp_Desi = lblEmp_Desi;
		  LblBasic_Pay = lblBasic_Pay;
		  LblAllowance = lblAllowance;
		  LblDeduction = lblDeduction;
		  LblDA = lblDA;
		  LblHRA = lblHRA;
		  LblWA = lblWA;
		  LblGPF = lblGPF;
		  LblIT = lblIT;
		  LblGIS = lblGIS;
		  LblPF = lblPF;
		  LblLIC = lblLIC;
		  LblTot_Allowance = lblTot_Allowance;
		  LblTot_Deduction = lblTot_Deduction;
		  LblNet_Salary = lblNet_Salary;
		  TxtDate = txtDate;
		  TxtEmp_Name1 = txtEmp_Name1;
		  TxtEmp_Name2 = txtEmp_Name2;
		  TxtEmp_Code = txtEmp_Code;
		  TxtSalary_Month = txtSalary_Month;
		  TxtEmp_Desi = txtEmp_Desi;
		  TxtBasic_Pay = txtBasic_Pay;
		  TxtDA = txtDA;
		  TxtHRA = txtHRA;
		  TxtWA = txtWA;
		  TxtGPF = txtGPF;
		  TxtIT = txtIT;
		  TxtGIS = txtGIS;
		  TxtPF = txtPF;
		  TxtLIC = txtLIC;
		  TxtTot_Allowance = txtTot_Allowance;
		  TxtTot_Deduction = txtTot_Deduction;
		  TxtNet_Salary = txtNet_Salary;
		  this.sEmp_Code = sEmp_Code;
		  this.sEmp_Name1 = sEmp_Name1;
		  this.sEmp_Name2 = sEmp_Name2;
		  this.sEmp_Desi = sEmp_Desi;
		  this.sCategory_Type = sCategory_Type;
		  this.sCategory_Name = sCategory_Name;
		  this.sBasic_Pay = sBasic_Pay;
		  this.sDA = sDA;
		  this.sHRA = sHRA;
		  this.sWA = sWA;
		  this.sGPF = sGPF;
		  this.sIT = sIT;
		  this.sGIS = sGIS;
		  this.sPF = sPF;
		  this.sLIC = sLIC;
		  this.sDA_Allow = sDA_Allow;
		  this.sHRA_Allow = sHRA_Allow;
		  this.sWA_Allow = sWA_Allow;
		  this.sGPF_Dedu = sGPF_Dedu;
		  this.sIT_Dedu = sIT_Dedu;
		  this.sGIS_Dedu = sGIS_Dedu;
		  this.sPF_Dedu = sPF_Dedu;
		  this.sLIC_Dedu = sLIC_Dedu;
		  this.sAllow = sAllow;
		  this.sDedu = sDedu;
		  this.sNet_Salary = sNet_Salary;
		  Emp_Month = emp_Month;
		  Emp_Year = emp_Year;
	  }

	  //Getter and Setters
	  public JFrame getJFParentFrame() {
		  return JFParentFrame;
	  }

	  public void setJFParentFrame(JFrame JFParentFrame) {
		  this.JFParentFrame = JFParentFrame;
	  }

	  public static Date getTd() {
		  return td;
	  }

	  public static void setTd(Date td) {
		  Emprptwindow.td = td;
	  }

	  public static String getsDate() {
		  return sDate;
	  }

	  public static void setsDate(String sDate) {
		  Emprptwindow.sDate = sDate;
	  }

	  public JPanel getPanel1() {
		  return panel1;
	  }

	  public void setPanel1(JPanel panel1) {
		  this.panel1 = panel1;
	  }

	  public JPanel getPanel2() {
		  return panel2;
	  }

	  public void setPanel2(JPanel panel2) {
		  this.panel2 = panel2;
	  }

	  public JPanel getPanel3() {
		  return panel3;
	  }

	  public void setPanel3(JPanel panel3) {
		  this.panel3 = panel3;
	  }

	  public JPanel getPanel4() {
		  return panel4;
	  }

	  public void setPanel4(JPanel panel4) {
		  this.panel4 = panel4;
	  }

	  public JPanel getPanel5() {
		  return panel5;
	  }

	  public void setPanel5(JPanel panel5) {
		  this.panel5 = panel5;
	  }

	  public JPanel getPanel5_1() {
		  return panel5_1;
	  }

	  public void setPanel5_1(JPanel panel5_1) {
		  this.panel5_1 = panel5_1;
	  }

	  public JPanel getPanel5_2() {
		  return panel5_2;
	  }

	  public void setPanel5_2(JPanel panel5_2) {
		  this.panel5_2 = panel5_2;
	  }

	  public JPanel getPanel6() {
		  return panel6;
	  }

	  public void setPanel6(JPanel panel6) {
		  this.panel6 = panel6;
	  }

	  public JPanel getPanel6_1() {
		  return panel6_1;
	  }

	  public void setPanel6_1(JPanel panel6_1) {
		  this.panel6_1 = panel6_1;
	  }

	  public JPanel getPanel6_2() {
		  return panel6_2;
	  }

	  public void setPanel6_2(JPanel panel6_2) {
		  this.panel6_2 = panel6_2;
	  }

	  public JPanel getPanel7() {
		  return panel7;
	  }

	  public void setPanel7(JPanel panel7) {
		  this.panel7 = panel7;
	  }

	  public JPanel getPanel8_1() {
		  return panel8_1;
	  }

	  public void setPanel8_1(JPanel panel8_1) {
		  this.panel8_1 = panel8_1;
	  }

	  public JPanel getPanel9() {
		  return panel9;
	  }

	  public void setPanel9(JPanel panel9) {
		  this.panel9 = panel9;
	  }

	  public JPanel getPanel10() {
		  return panel10;
	  }

	  public void setPanel10(JPanel panel10) {
		  this.panel10 = panel10;
	  }

	  public JPanel getPanel11() {
		  return panel11;
	  }

	  public void setPanel11(JPanel panel11) {
		  this.panel11 = panel11;
	  }

	  public JPanel getPanel12() {
		  return panel12;
	  }

	  public void setPanel12(JPanel panel12) {
		  this.panel12 = panel12;
	  }

	  public JPanel getPanel13() {
		  return panel13;
	  }

	  public void setPanel13(JPanel panel13) {
		  this.panel13 = panel13;
	  }

	  public JPanel getPanel14() {
		  return panel14;
	  }

	  public void setPanel14(JPanel panel14) {
		  this.panel14 = panel14;
	  }

	  public JButton getGenerateBtn() {
		  return GenerateBtn;
	  }

	  public void setGenerateBtn(JButton generateBtn) {
		  GenerateBtn = generateBtn;
	  }

	  public JButton getPrintBtn() {
		  return PrintBtn;
	  }

	  public void setPrintBtn(JButton printBtn) {
		  PrintBtn = printBtn;
	  }

	  public JButton getExitBtn() {
		  return ExitBtn;
	  }

	  public void setExitBtn(JButton exitBtn) {
		  ExitBtn = exitBtn;
	  }

	  public JTextField getTxtCategory_Type() {
		  return TxtCategory_Type;
	  }

	  public void setTxtCategory_Type(JTextField txtCategory_Type) {
		  TxtCategory_Type = txtCategory_Type;
	  }

	  public JTextField getTxtCategory_Name() {
		  return TxtCategory_Name;
	  }

	  public void setTxtCategory_Name(JTextField txtCategory_Name) {
		  TxtCategory_Name = txtCategory_Name;
	  }

	  public JComboBox getMonthCombo() {
		  return MonthCombo;
	  }

	  public void setMonthCombo(JComboBox monthCombo) {
		  MonthCombo = monthCombo;
	  }

	  public JTextField getTxtYear() {
		  return TxtYear;
	  }

	  public void setTxtYear(JTextField txtYear) {
		  TxtYear = txtYear;
	  }

	  public JLabel getLblMonth() {
		  return LblMonth;
	  }

	  public void setLblMonth(JLabel lblMonth) {
		  LblMonth = lblMonth;
	  }

	  public String[] getMonth_Name() {
		  return Month_Name;
	  }

	  public void setMonth_Name(String[] month_Name) {
		  Month_Name = month_Name;
	  }

	  public String getDialogmessage() {
		  return dialogmessage;
	  }

	  public void setDialogmessage(String dialogmessage) {
		  this.dialogmessage = dialogmessage;
	  }

	  public String getDialogs() {
		  return dialogs;
	  }

	  public void setDialogs(String dialogs) {
		  this.dialogs = dialogs;
	  }

	  public int getDialogtype() {
		  return dialogtype;
	  }

	  public void setDialogtype(int dialogtype) {
		  this.dialogtype = dialogtype;
	  }

	  public static int getRecord() {
		  return record;
	  }

	  public static void setRecord(int record) {
		  Emprptwindow.record = record;
	  }

	  public clsConfiguracions getSettings() {
		  return settings;
	  }

	  public void setSettings(clsConfiguracions settings) {
		  this.settings = settings;
	  }

	  public clsConnection getConnect() {
		  return connect;
	  }

	  public void setConnect(clsConnection connect) {
		  this.connect = connect;
	  }

	  public Connection getConn() {
		  return conn;
	  }

	  public void setConn(Connection conn) {
		  this.conn = conn;
	  }

	  public JLabel getLblcollege1() {
		  return Lblcollege1;
	  }

	  public void setLblcollege1(JLabel lblcollege1) {
		  Lblcollege1 = lblcollege1;
	  }

	  public JLabel getLblcollege2() {
		  return Lblcollege2;
	  }

	  public void setLblcollege2(JLabel lblcollege2) {
		  Lblcollege2 = lblcollege2;
	  }

	  public JLabel getLblcollege3() {
		  return Lblcollege3;
	  }

	  public void setLblcollege3(JLabel lblcollege3) {
		  Lblcollege3 = lblcollege3;
	  }

	  public JLabel getLbldate() {
		  return Lbldate;
	  }

	  public void setLbldate(JLabel lbldate) {
		  Lbldate = lbldate;
	  }

	  public JLabel getLblSalary_Slip() {
		  return LblSalary_Slip;
	  }

	  public void setLblSalary_Slip(JLabel lblSalary_Slip) {
		  LblSalary_Slip = lblSalary_Slip;
	  }

	  public JLabel getLblEmp_Name() {
		  return LblEmp_Name;
	  }

	  public void setLblEmp_Name(JLabel lblEmp_Name) {
		  LblEmp_Name = lblEmp_Name;
	  }

	  public JLabel getLblEmp_Code() {
		  return LblEmp_Code;
	  }

	  public void setLblEmp_Code(JLabel lblEmp_Code) {
		  LblEmp_Code = lblEmp_Code;
	  }

	  public JLabel getLblEmp_Desi() {
		  return LblEmp_Desi;
	  }

	  public void setLblEmp_Desi(JLabel lblEmp_Desi) {
		  LblEmp_Desi = lblEmp_Desi;
	  }

	  public JLabel getLblBasic_Pay() {
		  return LblBasic_Pay;
	  }

	  public void setLblBasic_Pay(JLabel lblBasic_Pay) {
		  LblBasic_Pay = lblBasic_Pay;
	  }

	  public JLabel getLblAllowance() {
		  return LblAllowance;
	  }

	  public void setLblAllowance(JLabel lblAllowance) {
		  LblAllowance = lblAllowance;
	  }

	  public JLabel getLblDeduction() {
		  return LblDeduction;
	  }

	  public void setLblDeduction(JLabel lblDeduction) {
		  LblDeduction = lblDeduction;
	  }

	  public JLabel getLblDA() {
		  return LblDA;
	  }

	  public void setLblDA(JLabel lblDA) {
		  LblDA = lblDA;
	  }

	  public JLabel getLblHRA() {
		  return LblHRA;
	  }

	  public void setLblHRA(JLabel lblHRA) {
		  LblHRA = lblHRA;
	  }

	  public JLabel getLblWA() {
		  return LblWA;
	  }

	  public void setLblWA(JLabel lblWA) {
		  LblWA = lblWA;
	  }

	  public JLabel getLblGPF() {
		  return LblGPF;
	  }

	  public void setLblGPF(JLabel lblGPF) {
		  LblGPF = lblGPF;
	  }

	  public JLabel getLblIT() {
		  return LblIT;
	  }

	  public void setLblIT(JLabel lblIT) {
		  LblIT = lblIT;
	  }

	  public JLabel getLblGIS() {
		  return LblGIS;
	  }

	  public void setLblGIS(JLabel lblGIS) {
		  LblGIS = lblGIS;
	  }

	  public JLabel getLblPF() {
		  return LblPF;
	  }

	  public void setLblPF(JLabel lblPF) {
		  LblPF = lblPF;
	  }

	  public JLabel getLblLIC() {
		  return LblLIC;
	  }

	  public void setLblLIC(JLabel lblLIC) {
		  LblLIC = lblLIC;
	  }

	  public JLabel getLblTot_Allowance() {
		  return LblTot_Allowance;
	  }

	  public void setLblTot_Allowance(JLabel lblTot_Allowance) {
		  LblTot_Allowance = lblTot_Allowance;
	  }

	  public JLabel getLblTot_Deduction() {
		  return LblTot_Deduction;
	  }

	  public void setLblTot_Deduction(JLabel lblTot_Deduction) {
		  LblTot_Deduction = lblTot_Deduction;
	  }

	  public JLabel getLblNet_Salary() {
		  return LblNet_Salary;
	  }

	  public void setLblNet_Salary(JLabel lblNet_Salary) {
		  LblNet_Salary = lblNet_Salary;
	  }

	  public JTextField getTxtDate() {
		  return TxtDate;
	  }

	  public void setTxtDate(JTextField txtDate) {
		  TxtDate = txtDate;
	  }

	  public JTextField getTxtEmp_Name1() {
		  return TxtEmp_Name1;
	  }

	  public void setTxtEmp_Name1(JTextField txtEmp_Name1) {
		  TxtEmp_Name1 = txtEmp_Name1;
	  }

	  public JTextField getTxtEmp_Name2() {
		  return TxtEmp_Name2;
	  }

	  public void setTxtEmp_Name2(JTextField txtEmp_Name2) {
		  TxtEmp_Name2 = txtEmp_Name2;
	  }

	  public JTextField getTxtEmp_Code() {
		  return TxtEmp_Code;
	  }

	  public void setTxtEmp_Code(JTextField txtEmp_Code) {
		  TxtEmp_Code = txtEmp_Code;
	  }

	  public JTextField getTxtSalary_Month() {
		  return TxtSalary_Month;
	  }

	  public void setTxtSalary_Month(JTextField txtSalary_Month) {
		  TxtSalary_Month = txtSalary_Month;
	  }

	  public JTextField getTxtEmp_Desi() {
		  return TxtEmp_Desi;
	  }

	  public void setTxtEmp_Desi(JTextField txtEmp_Desi) {
		  TxtEmp_Desi = txtEmp_Desi;
	  }

	  public JTextField getTxtBasic_Pay() {
		  return TxtBasic_Pay;
	  }

	  public void setTxtBasic_Pay(JTextField txtBasic_Pay) {
		  TxtBasic_Pay = txtBasic_Pay;
	  }

	  public JTextField getTxtDA() {
		  return TxtDA;
	  }

	  public void setTxtDA(JTextField txtDA) {
		  TxtDA = txtDA;
	  }

	  public JTextField getTxtHRA() {
		  return TxtHRA;
	  }

	  public void setTxtHRA(JTextField txtHRA) {
		  TxtHRA = txtHRA;
	  }

	  public JTextField getTxtWA() {
		  return TxtWA;
	  }

	  public void setTxtWA(JTextField txtWA) {
		  TxtWA = txtWA;
	  }

	  public JTextField getTxtGPF() {
		  return TxtGPF;
	  }

	  public void setTxtGPF(JTextField txtGPF) {
		  TxtGPF = txtGPF;
	  }

	  public JTextField getTxtIT() {
		  return TxtIT;
	  }

	  public void setTxtIT(JTextField txtIT) {
		  TxtIT = txtIT;
	  }

	  public JTextField getTxtGIS() {
		  return TxtGIS;
	  }

	  public void setTxtGIS(JTextField txtGIS) {
		  TxtGIS = txtGIS;
	  }

	  public JTextField getTxtPF() {
		  return TxtPF;
	  }

	  public void setTxtPF(JTextField txtPF) {
		  TxtPF = txtPF;
	  }

	  public JTextField getTxtLIC() {
		  return TxtLIC;
	  }

	  public void setTxtLIC(JTextField txtLIC) {
		  TxtLIC = txtLIC;
	  }

	  public JTextField getTxtTot_Allowance() {
		  return TxtTot_Allowance;
	  }

	  public void setTxtTot_Allowance(JTextField txtTot_Allowance) {
		  TxtTot_Allowance = txtTot_Allowance;
	  }

	  public JTextField getTxtTot_Deduction() {
		  return TxtTot_Deduction;
	  }

	  public void setTxtTot_Deduction(JTextField txtTot_Deduction) {
		  TxtTot_Deduction = txtTot_Deduction;
	  }

	  public JTextField getTxtNet_Salary() {
		  return TxtNet_Salary;
	  }

	  public void setTxtNet_Salary(JTextField txtNet_Salary) {
		  TxtNet_Salary = txtNet_Salary;
	  }

	  public String getsEmp_Code() {
		  return sEmp_Code;
	  }

	  public void setsEmp_Code(String sEmp_Code) {
		  this.sEmp_Code = sEmp_Code;
	  }

	  public String getsEmp_Name1() {
		  return sEmp_Name1;
	  }

	  public void setsEmp_Name1(String sEmp_Name1) {
		  this.sEmp_Name1 = sEmp_Name1;
	  }

	  public String getsEmp_Name2() {
		  return sEmp_Name2;
	  }

	  public void setsEmp_Name2(String sEmp_Name2) {
		  this.sEmp_Name2 = sEmp_Name2;
	  }

	  public String getsEmp_Desi() {
		  return sEmp_Desi;
	  }

	  public void setsEmp_Desi(String sEmp_Desi) {
		  this.sEmp_Desi = sEmp_Desi;
	  }

	  public String getsCategory_Type() {
		  return sCategory_Type;
	  }

	  public void setsCategory_Type(String sCategory_Type) {
		  this.sCategory_Type = sCategory_Type;
	  }

	  public String getsCategory_Name() {
		  return sCategory_Name;
	  }

	  public void setsCategory_Name(String sCategory_Name) {
		  this.sCategory_Name = sCategory_Name;
	  }

	  public String getsBasic_Pay() {
		  return sBasic_Pay;
	  }

	  public void setsBasic_Pay(String sBasic_Pay) {
		  this.sBasic_Pay = sBasic_Pay;
	  }

	  public String getsDA() {
		  return sDA;
	  }

	  public void setsDA(String sDA) {
		  this.sDA = sDA;
	  }

	  public String getsHRA() {
		  return sHRA;
	  }

	  public void setsHRA(String sHRA) {
		  this.sHRA = sHRA;
	  }

	  public String getsWA() {
		  return sWA;
	  }

	  public void setsWA(String sWA) {
		  this.sWA = sWA;
	  }

	  public String getsGPF() {
		  return sGPF;
	  }

	  public void setsGPF(String sGPF) {
		  this.sGPF = sGPF;
	  }

	  public String getsIT() {
		  return sIT;
	  }

	  public void setsIT(String sIT) {
		  this.sIT = sIT;
	  }

	  public String getsGIS() {
		  return sGIS;
	  }

	  public void setsGIS(String sGIS) {
		  this.sGIS = sGIS;
	  }

	  public String getsPF() {
		  return sPF;
	  }

	  public void setsPF(String sPF) {
		  this.sPF = sPF;
	  }

	  public String getsLIC() {
		  return sLIC;
	  }

	  public void setsLIC(String sLIC) {
		  this.sLIC = sLIC;
	  }

	  public String getsDA_Allow() {
		  return sDA_Allow;
	  }

	  public void setsDA_Allow(String sDA_Allow) {
		  this.sDA_Allow = sDA_Allow;
	  }

	  public String getsHRA_Allow() {
		  return sHRA_Allow;
	  }

	  public void setsHRA_Allow(String sHRA_Allow) {
		  this.sHRA_Allow = sHRA_Allow;
	  }

	  public String getsWA_Allow() {
		  return sWA_Allow;
	  }

	  public void setsWA_Allow(String sWA_Allow) {
		  this.sWA_Allow = sWA_Allow;
	  }

	  public String getsGPF_Dedu() {
		  return sGPF_Dedu;
	  }

	  public void setsGPF_Dedu(String sGPF_Dedu) {
		  this.sGPF_Dedu = sGPF_Dedu;
	  }

	  public String getsIT_Dedu() {
		  return sIT_Dedu;
	  }

	  public void setsIT_Dedu(String sIT_Dedu) {
		  this.sIT_Dedu = sIT_Dedu;
	  }

	  public String getsGIS_Dedu() {
		  return sGIS_Dedu;
	  }

	  public void setsGIS_Dedu(String sGIS_Dedu) {
		  this.sGIS_Dedu = sGIS_Dedu;
	  }

	  public String getsPF_Dedu() {
		  return sPF_Dedu;
	  }

	  public void setsPF_Dedu(String sPF_Dedu) {
		  this.sPF_Dedu = sPF_Dedu;
	  }

	  public String getsLIC_Dedu() {
		  return sLIC_Dedu;
	  }

	  public void setsLIC_Dedu(String sLIC_Dedu) {
		  this.sLIC_Dedu = sLIC_Dedu;
	  }

	  public String getsAllow() {
		  return sAllow;
	  }

	  public void setsAllow(String sAllow) {
		  this.sAllow = sAllow;
	  }

	  public String getsDedu() {
		  return sDedu;
	  }

	  public void setsDedu(String sDedu) {
		  this.sDedu = sDedu;
	  }

	  public String getsNet_Salary() {
		  return sNet_Salary;
	  }

	  public void setsNet_Salary(String sNet_Salary) {
		  this.sNet_Salary = sNet_Salary;
	  }

	  public String getEmp_Month() {
		  return Emp_Month;
	  }

	  public void setEmp_Month(String emp_Month) {
		  Emp_Month = emp_Month;
	  }

	  public String getEmp_Year() {
		  return Emp_Year;
	  }

	  public void setEmp_Year(String emp_Year) {
		  Emp_Year = emp_Year;
	  }

	  public static int getvBasic_Pay() {
		  return vBasic_Pay;
	  }

	  public static void setvBasic_Pay(int vBasic_Pay) {
		  Emprptwindow.vBasic_Pay = vBasic_Pay;
	  }

	  public static int getDA_Rs() {
		  return DA_Rs;
	  }

	  public static void setDA_Rs(int DA_Rs) {
		  Emprptwindow.DA_Rs = DA_Rs;
	  }

	  public static int getHRA_Rs() {
		  return HRA_Rs;
	  }

	  public static void setHRA_Rs(int HRA_Rs) {
		  Emprptwindow.HRA_Rs = HRA_Rs;
	  }

	  public static int getWA_Rs() {
		  return WA_Rs;
	  }

	  public static void setWA_Rs(int WA_Rs) {
		  Emprptwindow.WA_Rs = WA_Rs;
	  }

	  public static int getGPF_Rs() {
		  return GPF_Rs;
	  }

	  public static void setGPF_Rs(int GPF_Rs) {
		  Emprptwindow.GPF_Rs = GPF_Rs;
	  }

	  public static int getIT_Rs() {
		  return IT_Rs;
	  }

	  public static void setIT_Rs(int IT_Rs) {
		  Emprptwindow.IT_Rs = IT_Rs;
	  }

	  public static int getGIS_Rs() {
		  return GIS_Rs;
	  }

	  public static void setGIS_Rs(int GIS_Rs) {
		  Emprptwindow.GIS_Rs = GIS_Rs;
	  }

	  public static int getPF_Rs() {
		  return PF_Rs;
	  }

	  public static void setPF_Rs(int PF_Rs) {
		  Emprptwindow.PF_Rs = PF_Rs;
	  }

	  public static int getLIC_Rs() {
		  return LIC_Rs;
	  }

	  public static void setLIC_Rs(int LIC_Rs) {
		  Emprptwindow.LIC_Rs = LIC_Rs;
	  }

	  public static int getDA_Value() {
		  return DA_Value;
	  }

	  public static void setDA_Value(int DA_Value) {
		  Emprptwindow.DA_Value = DA_Value;
	  }

	  public static int getHRA_Value() {
		  return HRA_Value;
	  }

	  public static void setHRA_Value(int HRA_Value) {
		  Emprptwindow.HRA_Value = HRA_Value;
	  }

	  public static int getWA_Value() {
		  return WA_Value;
	  }

	  public static void setWA_Value(int WA_Value) {
		  Emprptwindow.WA_Value = WA_Value;
	  }

	  public static int getGPF_Value() {
		  return GPF_Value;
	  }

	  public static void setGPF_Value(int GPF_Value) {
		  Emprptwindow.GPF_Value = GPF_Value;
	  }

	  public static int getIT_Value() {
		  return IT_Value;
	  }

	  public static void setIT_Value(int IT_Value) {
		  Emprptwindow.IT_Value = IT_Value;
	  }

	  public static int getGIS_Value() {
		  return GIS_Value;
	  }

	  public static void setGIS_Value(int GIS_Value) {
		  Emprptwindow.GIS_Value = GIS_Value;
	  }

	  public static int getPF_Value() {
		  return PF_Value;
	  }

	  public static void setPF_Value(int PF_Value) {
		  Emprptwindow.PF_Value = PF_Value;
	  }

	  public static int getLIC_Value() {
		  return LIC_Value;
	  }

	  public static void setLIC_Value(int LIC_Value) {
		  Emprptwindow.LIC_Value = LIC_Value;
	  }

	  public static int getAllow() {
		  return Allow;
	  }

	  public static void setAllow(int allow) {
		  Allow = allow;
	  }

	  public static int getDedu() {
		  return Dedu;
	  }

	  public static void setDedu(int dedu) {
		  Dedu = dedu;
	  }

	  public static int getNet_Salary() {
		  return Net_Salary;
	  }

	  public static void setNet_Salary(int net_Salary) {
		  Net_Salary = net_Salary;
	  }
  }
	
  	
   	 	
		 
    

