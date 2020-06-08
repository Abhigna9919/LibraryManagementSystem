package library.management.system;

import java.awt.*;
import java.awt.event.*; //event is a sub package of awt
import javax.swing.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener 
   {
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;

	public Login_user() //constructor 
        {
            super("Login");
            setLocation(80,100);
        //all the JFrame coding is done here    
	setBackground(Color.cyan);//sets the frame color
        setBounds(600,300,600,400);//x,y coordinates, length and breadth of JFrame
		
        panel = new JPanel();
	panel.setBackground(Color.cyan);//sets the pane color
	setContentPane(panel);//sets the content pane property of the window to panel
        //content pane is a layer that holds objects
	panel.setLayout(null);//not using predefined layouts

	JLabel l1 = new JLabel("USERNAME: ");//this appears as it is on the frame
	l1.setBounds(124,89,95,24);//x,y coordinates, length and breadth of Label
	panel.add(l1);//adding the label to the panel

	JLabel l2 = new JLabel("PASSWORD: ");
	l2.setBounds(124,124,95,24);
	panel.add(l2);

	textField = new JTextField();//textfield for entering the username
	textField.setBounds(210,93,157,20);
	panel.add(textField);
	
	passwordField = new JPasswordField();//this is for pswd, the content written here will
	passwordField.setBounds(210, 128, 157, 20);//not be visible to the user
	panel.add(passwordField);

	b1 = new JButton("LOGIN");//login button
	b1.addActionListener(this);//whenever this button is clicked an event will be called
                
	b1.setForeground(Color.black);//button text color
	b1.setBackground(Color.white);//button bckgrnd color
	b1.setBounds(149,181,113,39);
	panel.add(b1);
		
        b2 = new JButton("SIGN UP");//sign up button
	b2.addActionListener(this);
	
	b2.setForeground(Color.black);
	b2.setBackground(Color.white);
	b2.setBounds(289,181,113,39);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(Color.black);
	b3.setBackground(Color.white);
	b3.setBounds(199,231,179,39);
	panel.add(b3);
        
        JPanel panel2 = new JPanel();
	panel2.setBackground(Color.CYAN);
	panel2.setBounds(24,40,434,263);
	panel.add(panel2);
        }   
        
        //overriding the actionperformed method in the action listener interface
        public void actionPerformed(ActionEvent ae)
        {
            //Action Event class tells us what button the user has pressed
            if(ae.getSource() == b1)//getsource method gets the button obj that has been clicked
            {
		try 
                {
                    //obj of connection class is used to access the database
                    conn con = new conn();
                    //this is a parameterized query
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, textField.getText());
                   //this method replaces the parameter on index 1 with text obtained from TextField
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();//executes the query
                    //data in the mysql DB is matched with data in the tables
                    if (rs.next()) 
                    {//checks the table row by row
                        this.setVisible(false);//the login page is closed
                        new Loading().setVisible(true);//the loading page is opened
                    } 
                    else
			JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                     //This is used for pop-ups, the mssg is printed on the pop-up
                     //null field can be used for formatting
		} 
                catch (Exception e2)
                {
                    e2.printStackTrace();
                    //prints the exception along with other details like line no, class name, etc.
		}
            }
            
            if(ae.getSource() == b2)//checks if its signup button
            {
                this.setVisible(false);//closing the login frame
		new Signup().setVisible(true);//openeing the signup frame
            }   
            
            if(ae.getSource() == b3)//checks if its forgot password button
            {
                this.setVisible(false);//closing the login frame
		new Forgot().setVisible(true);//opening the forgot password frame
            }
        }
        
  	public static void main(String[] args)
        {
            //by default all Jframes are set false (they are not visible)
                new Login_user().setVisible(true);
            //setting the login frame visibility true
	}

}