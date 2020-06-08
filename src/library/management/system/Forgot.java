package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args)
    {
	new Forgot().setVisible(true);
    }

    public Forgot() //constructor
    {
        super("Forgot Password");//title of the JFrame window
        setLocation(80,100);
        setBounds(600,200,438,442);
	contentPane=new JPanel();
	setContentPane(contentPane);//adding to the frame
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel l1=new JLabel("Username");
	l1.setFont(new Font("TimesRoman",Font.BOLD,13));
	l1.setBounds(28,83,87,29);
	contentPane.add(l1);

	JLabel l2=new JLabel("Name");
	l2.setFont(new Font("TimesRoman",Font.BOLD,13));
	l2.setBounds(28,122,75,21);
	contentPane.add(l2);

	JLabel l3=new JLabel("Security Question");
	l3.setFont(new Font("TimesRoman",Font.BOLD,13));
	l3.setBounds(28,154,156,27);
	contentPane.add(l3);

	JLabel l4=new JLabel("Answer");
	l4.setFont(new Font("TimesRoman",Font.BOLD,13));
	l4.setBounds(28,192,104,21);
	contentPane.add(l4);

	JLabel l5=new JLabel("Password");
	l5.setFont(new Font("TimesRoman",Font.BOLD,13));
	l5.setBounds(28,224,104,21);
	contentPane.add(l5);

	t1 = new JTextField();
	t1.setFont(new Font("TimesRoman", Font.BOLD, 13));
	t1.setForeground(Color.BLACK);
	t1.setColumns(10);
        t1.setBounds(150,88,139,20);
	contentPane.add(t1);
	
	t2 = new JTextField();
	t2.setEditable(false);//the name field is disabled using this
	t2.setFont(new Font("TimesRoman",Font.BOLD,13));
	t2.setForeground(Color.BLUE);
	t2.setColumns(10);
	t2.setBounds(150,123,139,20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setEditable(false);//the security question is disabled
	t3.setFont(new Font("TimesRoman",Font.BOLD,12));
	t3.setForeground(Color.BLUE);
	t3.setColumns(10);
	t3.setBounds(150,161,139,20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setFont(new Font("TimesRoman",Font.BOLD,13));
	t4.setForeground(Color.BLACK);
	t4.setColumns(10);
	t4.setBounds(150,193,139,20);
	contentPane.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);//the password field is disabled
	t5.setFont(new Font("TimesRoman",Font.BOLD,13));
	t5.setForeground(Color.BLUE);
	t5.setColumns(10);
	t5.setBounds(150,225,139,20);
	contentPane.add(t5);

	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setFont(new Font("TimesRoman", Font.BOLD, 16));
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
	b1.setBounds(298,83,101,29);
        contentPane.add(b1);

	b2 = new JButton("Retrieve");
	b2.addActionListener(this);
	b2.setFont(new Font("TimesRoman", Font.BOLD, 16));
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLACK);
        b2.setBounds(296,188,101,29);
	contentPane.add(b2);

        
        b3 = new JButton("BACK");
	b3.addActionListener(this);
	b3.setFont(new Font("TimesRoman", Font.BOLD, 16));
	b3.setBounds(143,300,101,29);
        b3.setBackground(Color.CYAN);
        b3.setForeground(Color.BLACK);
	contentPane.add(b3);

	JPanel panel = new JPanel();
	TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"PASSWORD RETRIEVE",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel.setBorder(tb);
        tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
	panel.setBounds(12, 16, 398, 354);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource()==b1)
            {
                String sql="select * from account where username=?";
                //obtains all the row data from account table where the username matches
		PreparedStatement st=con.c.prepareStatement(sql);
		st.setString(1,t1.getText());
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
                {
                    //getString() finds the value in the current row in the col with the String value that is passed
                    t2.setText(rs.getString("name"));//setting the name field
                    t3.setText(rs.getString("sec_q"));//setting the security question
		}
            }
            
            if(ae.getSource()==b2)
            {
                String sql="select * from account where sec_ans=?";
                //matching the given security answer with the stored answer in the table
		PreparedStatement st=con.c.prepareStatement(sql);
		st.setString(1,t4.getText());
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
                {
                    t5.setText(rs.getString("password"));//retrieving the pswd 
		}

            }
            if(ae.getSource()==b3)
            {
                this.setVisible(false);//closes the forgot frame
		new Login_user().setVisible(true);//opens the login frame
            }
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
    }

}