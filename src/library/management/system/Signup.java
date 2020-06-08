package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;//border is a sub-package of swing, used for creating title borders

//implementing actionlistener interface since we want our buttons to open other events
public class Signup extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField textField1;//creating 4 textFields
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton b1,b2;//two buttons for create and back
    private JComboBox comboBox;//this is for the dropdown menu for security question

    public static void main(String[] args) 
    {
        new Signup().setVisible(true);
    }

    public Signup() //constructor
    {
        super("Sign Up");
        setLocation(80,100);
         setBounds(600,200,438,442);
	contentPane=new JPanel();
	setContentPane(contentPane);
        contentPane.setBackground(Color.white);
	contentPane.setLayout(null);

	JLabel lblUsername=new JLabel("Username :");
	lblUsername.setForeground(Color.BLACK);
	lblUsername.setFont(new Font("TimesRoman",Font.BOLD,14));
	lblUsername.setBounds(60,86,92,26);
	contentPane.add(lblUsername);

	JLabel lblName=new JLabel("Name :");
	lblName.setForeground(Color.BLACK); 
	lblName.setFont(new Font("TimesRoman",Font.BOLD,14));
	lblName.setBounds(60,123,92,26);
	contentPane.add(lblName);

	JLabel lblPassword=new JLabel("Password :");
	lblPassword.setForeground(Color.BLACK);
	lblPassword.setFont(new Font("TimesRoman",Font.BOLD,14));
	lblPassword.setBounds(60,160,92,26);
	contentPane.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.BLACK);
	lblAnswer.setFont(new Font("TimesRoman",Font.BOLD,14));
	lblAnswer.setBounds(60,234,92,26);
	contentPane.add(lblAnswer);

	comboBox=new JComboBox();//this is used for creating the dropdown menu (security questions)
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "NickName", "Mother's Maiden Name","Favourite Comic", "Pet's Name","First School"}));
	comboBox.setBounds(226,202,148,20);
	contentPane.add(comboBox);

	JLabel lblSecurityQuestion=new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.BLACK);
	lblSecurityQuestion.setFont(new Font("TimesRoman",Font.BOLD,14));
	lblSecurityQuestion.setBounds(60,197,140,26);
	contentPane.add(lblSecurityQuestion);

        textField1=new JTextField();
        textField1.setColumns(10);//limits the textfield size to 10
        //doesnt alter the no. of characters that can be entered
	textField1.setBounds(226,91,148,20);
	contentPane.add(textField1);

	textField2=new JTextField();
	textField2.setColumns(10);
	textField2.setBounds(226,128,148,20);
	contentPane.add(textField2);

        textField3=new JTextField();
	textField3.setColumns(10);
	textField3.setBounds(226,165,148,20);
	contentPane.add(textField3);

	textField4= new JTextField();
	textField4.setColumns(10);
	textField4.setBounds(226,239,148,20);
	contentPane.add(textField4);

	b1 = new JButton("DONE");
	b1.addActionListener(this);//on clicking this some other event will happen
	b1.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), null));
        b1.setFont(new Font("TimesRoman", Font.BOLD, 16));
	b1.setBounds(80, 300, 100, 33);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
	contentPane.add(b1);

	b2 = new JButton("BACK");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), null));
	b2.setFont(new Font("TimesRoman", Font.BOLD, 16));
	b2.setBounds(252,300,100,33);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLACK);
        contentPane.add(b2);

	JPanel panel=new JPanel();
        //creates a border around the panel of title type (line)
        //3 is the width of the border
	TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"SIGN UP",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel.setBorder(tb);
        tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
	panel.setBounds(12, 16, 398, 354);
	//leading,top means the legend text will appear in top center
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae)
    {//overiding the actionperfomed function in the action listener interface
        try
        {
            conn con = new conn();    
            if(ae.getSource()==b1)
            {//checking if the username and password has already been used
                   String sql2 = "select * from account where username=?";
                    PreparedStatement st2 = con.c.prepareStatement(sql2);
                    st2.setString(1, textField1.getText());
                   //this method replaces the parameter on index 1 with text obtained from TextField
                    ResultSet rs = st2.executeQuery();//executes the query
                    //data in the mysql DB is matched with data in the tables
                    if (rs.next()) 
                    {//checks the table row by row
                      JOptionPane.showMessageDialog(null, "Username already exists!!!");  
                    } 
                    else
                    {
                //only if the username and password has not been used will the account be created        
                //whenever the user clicks the Finish button all the data will be stored in the account table
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);//parameterized query
		st.setString(1,textField1.getText());
                st.setString(2,textField2.getText());
		st.setString(3,textField3.getText());
		st.setString(4,(String)comboBox.getSelectedItem());//the selected option is returned here
                //getSelectedItem() returns an obj of obj it has to be typecasted to string
		st.setString(5,textField4.getText());
                
                //if exceuteUpdate() returns true (1), then pop up the mssg Account Created
		if (st.executeUpdate()>0)
                    JOptionPane.showMessageDialog(null, "Account Created!");
                  }
                            
                //setting the textfields dynamically to empty strings immediately after the pop up occurs
                textField1.setText("");
                textField2.setText("");
		textField3.setText("");
		textField4.setText("");
            }
            if(ae.getSource()==b2)//when the user clicks back button
            {
                this.setVisible(false);//closing signup frame
		new Login_user().setVisible(true);//opening the login frame
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}