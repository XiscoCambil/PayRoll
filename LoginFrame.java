import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
/**
 * Esta clase es utilizada por la clase PlayROll para la autentificacion de usuarios.
 */
public class LoginFrame extends JFrame implements ActionListener {
    static JFrame frame;
    private String username;
    private String password;
    private static JFrame loginFrame;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private JButton loginBtn;
    private JButton exitBtn;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    String dialogmessage;
    String dialogs;
    private JLabel nameLbl;
    private JLabel userLbl;
    private JLabel passwordLbl;
    private static JTextField userTxt;
    private static JPasswordField passwordTxt;

    /**Variable definidas para poder obtener el nombre de usuario*/
    public String loginname;
    /**Variable definida para obtener la contraseña del usuario*/
    public String loginpass;
    
    // class Veriables
    clsConnection connect = new clsConnection();
    //Connection variable
    
    Connection conn;
    	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
    
    static Date td 			= new Date();	
    /**
     * Constructor de la clase Login Frame, este constructor se encarga de inicializar
     * todos aquellos componentes necesarios para el correcto desarollo de la clase.
     * */
    public LoginFrame()
    {
    
 	  
   panel1 = new JPanel();
   panel1.setLayout(new FlowLayout());
   nameLbl = new JLabel("WELCOME TO GEC'S PAYROLL SYSTEM");
    
   panel2 = new JPanel();
   panel2.setLayout(new GridLayout(2,2));
   userLbl = new JLabel("Username :");
   userTxt = new JTextField(20);
  
   passwordLbl = new JLabel("Password :");
   
   passwordTxt = new JPasswordField(20);
   
   panel3 = new JPanel();
   panel3.setLayout(new FlowLayout());
   
   loginBtn = new JButton("Login", new ImageIcon("images/key.gif"));
   
   loginBtn.addActionListener(this);
   exitBtn = new JButton("Exit", new ImageIcon("images/Keys.gif"));
   
   exitBtn.addActionListener(this);
	panel1.add(nameLbl);
	panel1.setOpaque(true);
    panel2.add(userLbl);
	panel2.add(userTxt);
	panel2.add(passwordLbl);
	panel2.add(passwordTxt);
	panel2.setOpaque(true);
   	panel3.add(loginBtn);
	panel3.add(exitBtn);
	panel3.setOpaque(true);
	frame = new JFrame("PayRoll User Login...");
       frame.setSize(300,200);
        
	Container pane = frame.getContentPane();   
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    //pane.setLayout(new GridLayout(3,1));
	pane.add(panel1);
	pane.add(panel2);
	pane.add(panel3);
	frame.setLocation((screen.width - 500)/2,((screen.height-350)/2));	
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter()
        {

        /**
         * Metodo publico windowClosing
         * @param e Este metodo necesita un atributo de tipo WindowEvent.
         * */
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
     


    }
    /**
     * Metodo publico actionPerformed, este metodo realiza la funcion de autentificar una vez se a apretado el boton del jframe
     *@param event Hay que introducir un atributo de tipo AcrionEvent.
     * */
       public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source.equals(loginBtn))
        {
           login();
           
        } 
        else if(source.equals(exitBtn))
        {
            		System.exit(0);
        }
    }

    /**
     * Metodo publico login, utilizamos este metodo para recojer el nombre y contraseña del usuario y comprobarlos con la base de datos.
     * */
        public void login()
        {
        	loginname = userTxt.getText().trim();
           	loginpass = passwordTxt.getText().trim();
           
                   
            try {
                conn = connect.setConnection(conn,"");
            }
            catch(Exception e)
            {
            }
            try{
             	
             
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM Login WHERE USERNAME='" + loginname + 
                        "'AND PASSWORD='"+loginpass+"'";
                ResultSet rs = stmt.executeQuery(query);
                boolean recordfound = rs.next();
                if (recordfound)
                {
                	
                	dialogmessage = "Welcome - " +loginname;
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    userTxt.setText("");
                    passwordTxt.setText("");
                    frame.setVisible(false);
                    frame.dispose();
                    MainMenu menu = new MainMenu(loginname,td);
                  	
                	
                }
                else
                {
                	dialogmessage = "Login Failed!";
                    JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD!",
                            "WARNING!!",JOptionPane.WARNING_MESSAGE);
                    
                    userTxt.setText("");
                    passwordTxt.setText("");
                }
                conn.close();
        }
        catch(Exception ex)
          {
          	JOptionPane.showMessageDialog(null,"GENERAL EXCEPTION", "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
          	}		
    }

    /**
     *Metodo publico isLogged, no demanda nigun parametro de entrada.
     *@return Esta funcion nos devuelve un resultado de tipo boleano
     *
     * */
    public boolean isLogged(){
        return !loginname.isEmpty() && !loginpass.isEmpty();
    }
    
    /**
     * Metodo publico Main donde inicia el proyecto PayRoll
     *@param args EL parametro args es un atributo de tipo String.
     * */
    public static void main(String[] args)
    {
        
        LoginFrame frame1 = new LoginFrame();
		frame1.addNotify();
		frame1.pack();
                     
	
    }
   
    
    
}

