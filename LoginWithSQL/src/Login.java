import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener
{
JFrame frame;
JLabel label1,label2;
JTextField textField1;
JPasswordField passwordField;
JButton Login,Cancel,Register;

Login()
{
frame=new JFrame("Login");
frame.getContentPane().setLayout(null);
frame.getContentPane().setBackground(Color.WHITE);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("loginphoto.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
    


label1=new JLabel("UserName");
label1.setForeground(Color.black);
label1.setBounds(40,20,100,30);
label1.setFont(new Font("Courier new",Font.BOLD,20));

label2=new JLabel("Password");
label2.setForeground(Color.black);
label2.setBounds(40,70,150,30);
label2.setFont(new Font("Courier new",Font.BOLD,20));

textField1=new JTextField(10);
textField1.setForeground(Color.blue);
textField1.addActionListener(this);
textField1.setBounds(150,20,150,30);


passwordField=new JPasswordField(10);
passwordField.setForeground(Color.blue);
passwordField.setEchoChar('*');
passwordField.addActionListener(this);
passwordField.setBounds(150,70,150,30);

Login=new JButton("Login");
Login.setForeground(Color.WHITE);
Login.setBackground(Color.BLACK);
Login.setFont(new Font("serif",Font.BOLD,15));
Login.addActionListener(this);
Login.setBounds(40,140,120,30);


Cancel=new JButton("Cancel");
Cancel.setForeground(Color.white);
Cancel.setBackground(Color.black);
Cancel.setFont(new Font("serif",Font.BOLD,15));
Cancel.addActionListener(this);
Cancel.setBounds(180,140,120,30);

Register=new JButton("Register");
Register.setForeground(Color.white);
Register.setBackground(Color.black);
Register.setFont(new Font("serif",Font.BOLD,15));
Register.addActionListener(this);
Register.setBounds(40,180,260,30);


frame.getContentPane().add(label1);
frame.getContentPane().add(label2);
frame.getContentPane().add(textField1);
frame.getContentPane().add(passwordField);
frame.getContentPane().add(Login);
frame.getContentPane().add(Cancel);
frame.getContentPane().add(Register);
frame.getContentPane().add(l3);
frame.setSize(600,300);
frame.setLocation(500,300);
frame.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==Login) {
    try{
    	
        conn c1 = new conn();
        String u = textField1.getText();
        String v = passwordField.getText();
     String q = "select * from login where Name='"+u+"' and password='"+v+"'";
        
        ResultSet rs = c1.s.executeQuery(q); 
        
        if(textField1.getText().length()==0||passwordField.getText().length()==0)
    	{
    	JOptionPane.showMessageDialog(null,"Fields are empty");
    	}
        else if(rs.next()){
        
             frame.setVisible(false);
//        	System.out.print("login Succesful");
             JOptionPane.showMessageDialog(this, "Login Succesful !");
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Invalid login");
            
        }
    }catch(Exception e){
        e.printStackTrace();
    }
	}
if(ae.getSource()==Cancel)
{
frame.setVisible(false);
System.exit(0);
}

if(ae.getSource()==Register) {
	frame.setVisible(false);
	Register register=new Register();
}
}
public static void main(String[] args) {
 	new Login();

}

}










