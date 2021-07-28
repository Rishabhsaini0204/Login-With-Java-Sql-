import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Register extends JFrame implements ActionListener{
	
	JFrame frame;
	JLabel UserName,Password ,Email,phoneNumber,label;
	JTextField textField1,Emailinput,Phoneinput;

	JPasswordField passwordField;
	JButton Cancel,Register;
	 private Connection con;
	    private PreparedStatement ps;
	    private Statement st;
	
	Register(){
	
		frame=new JFrame("Registration");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(700,400);
		frame.setLocation(500,300);
		frame.setVisible(true);
		
		UserName=new JLabel("UserName");
		UserName.setForeground(Color.black);
		UserName.setBounds(40,20,100,30);
		UserName.setFont(new Font("Courier new",Font.BOLD,20));
		
		textField1=new JTextField(10);
		textField1.setForeground(Color.blue);
		textField1.addActionListener(this);
		textField1.setBounds(170,20,150,30);

		Password=new JLabel("Password");
		Password.setForeground(Color.black);
		Password.setBounds(40,70,150,30);
		Password.setFont(new Font("Courier new",Font.BOLD,20));
		
		passwordField=new JPasswordField(10);
		passwordField.setForeground(Color.blue);
		passwordField.setEchoChar('*');
    	passwordField.addActionListener(this);
		passwordField.setBounds(170,70,150,30);
		
		Email=new JLabel("Email");
		Email.setForeground(Color.black);
		Email.setBounds(40,120,150,30);
		Email.setFont(new Font("Courier new",Font.BOLD,20));
		
		Emailinput=new JTextField(10);
		Emailinput.setForeground(Color.blue);
		Emailinput.addActionListener(this);
		Emailinput.setBounds(170,120,150,30);
		
		phoneNumber=new JLabel("Ph.Number");
		phoneNumber.setForeground(Color.black);
		phoneNumber.setBounds(40,170,150,30);
		phoneNumber.setFont(new Font("Courier new",Font.BOLD,20));
		
		Phoneinput=new JTextField(10);
		Phoneinput.setForeground(Color.blue);
		Phoneinput.addActionListener(this);
		Phoneinput.setBounds(170,170,150,30);

		

Cancel=new JButton("Cancel");
Cancel.setForeground(Color.white);
Cancel.setBackground(Color.black);
Cancel.setFont(new Font("serif",Font.BOLD,15));
Cancel.addActionListener(this);
Cancel.setBounds(40,220,120,30);

Register=new JButton("Register");
Register.setForeground(Color.white);
Register.setBackground(Color.black);
Register.setFont(new Font("serif",Font.BOLD,15));
Register.addActionListener(this);
Register.setBounds(200,220,120,30);
		
		frame.getContentPane().add(UserName);
		frame.getContentPane().add(Email);
		frame.getContentPane().add(phoneNumber);
		frame.getContentPane().add(Password);
		frame.getContentPane().add(textField1);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(Phoneinput);		
		frame.getContentPane().add(Emailinput);
		frame.getContentPane().add(Cancel);
		frame.getContentPane().add(Register);
		frame.getContentPane().add(label);

		   
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Register) {
			 try{   
				   String user = textField1.getText();
			        String pass = passwordField.getText();
			        String phone=Phoneinput.getText();
			        String Email=Emailinput.getText();
			        
				 String url="jdbc:mysql://localhost:3306/test";
 	    		String DBuser="root";
 	    		String password="root";
 	        	 Class.forName("com.mysql.cj.jdbc.Driver"); 
 	            con =DriverManager.getConnection(url, DBuser, password);
                st =(Statement)con.createStatement();  
				ps=con.prepareStatement("INSERT INTO rawentry (Name, Password,Email,Phone)values (?,?,?,?)");
				  ps.setString(1,user);
				  ps.setString(2,pass);
				  ps.setString(3,Email);
				  ps.setString(4,phone);
				  ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Succesful !");
                    textField1.setText("");
                    passwordField.setText("");
                    Phoneinput.setText("");
                    Emailinput.setText("");
                    
			        
			 }
			 catch(Exception ae){
			        ae.printStackTrace();
			    }
		}
		else if(e.getSource()==Cancel) {
			
			frame.setVisible(false);
			System.exit(0);
			
		}
	}
	
	
	
	
}
