package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;

public class AddStudent extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3,comboBox_11,comboBox_22;
    JButton b1,b2;
    int flag=0;

    public static void main(String[] args) 
    {
        new AddStudent().setVisible(true);
    }

    public AddStudent() 
    {
        super("Add Student");//this appears on the top of the Jframe
        setLocation(80,100);
	setBounds(600,200,438,442);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Roll no.");
	l1.setForeground(Color.BLACK);
	l1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l1.setBounds(64, 63, 102, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("First Name");
	l2.setForeground(Color.BLACK);
	l2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l2.setBounds(64, 97, 102, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Last Name");
	l3.setForeground(Color.BLACK);
	l3.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l3.setBounds(64, 130, 102, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Branch");
	l4.setForeground(Color.BLACK);
	l4.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l4.setBounds(64, 201, 102, 22);
	contentPane.add(l4);

        JLabel l5 = new JLabel("Year");
	l5.setForeground(Color.BLACK);
	l5.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l5.setBounds(64, 233, 102, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Semester");
	l6.setForeground(Color.BLACK);
	l6.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l6.setBounds(64, 266, 102, 22);
	contentPane.add(l6);

	t1 = new JTextField();
	t1.setForeground(Color.BLACK);
	t1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t1.setBounds(174, 66, 156, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(Color.BLACK);
	t2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(174, 100, 156, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(Color.BLACK);
	t3.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(174, 133, 156, 20);
	contentPane.add(t3);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "ECE", "CSE", "IT", "EEE", "Civil", "Mech"}));
	comboBox.setForeground(Color.BLACK);
	comboBox.setFont(new Font("TimesRoman", Font.BOLD, 14));
	comboBox.setBounds(176, 205, 154, 20);
	contentPane.add(comboBox);

	comboBox_1 = new JComboBox();//combobox for ME
        comboBox_1.setVisible(false);
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"I","II"}));
	comboBox_1.setForeground(Color.BLACK);
	comboBox_1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	comboBox_1.setBounds(176, 238, 154, 20);
	contentPane.add(comboBox_1);
        
        comboBox_11 = new JComboBox();//combobox for ME
        comboBox_11.setVisible(false);
	comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"I","II","III","IV"}));
	comboBox_11.setForeground(Color.BLACK);
	comboBox_11.setFont(new Font("TimesRoman", Font.BOLD, 14));
	comboBox_11.setBounds(176, 238, 154, 20);
	contentPane.add(comboBox_11);

	comboBox_2 = new JComboBox();//combobox for BE
        comboBox_2.setVisible(false);
	comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4"}));
	comboBox_2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	comboBox_2.setForeground(Color.BLACK);
	comboBox_2.setBounds(176, 271, 154, 20);
	contentPane.add(comboBox_2);
        
        comboBox_22 = new JComboBox();//combo box for BE
        comboBox_22.setVisible(false);
	comboBox_22.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4","5","6","7","8"}));
	comboBox_22.setFont(new Font("TimesRoman", Font.BOLD, 14));
	comboBox_22.setForeground(Color.BLACK);
	comboBox_22.setBounds(176, 271, 154, 20);
	contentPane.add(comboBox_22);

	b1 = new JButton("DONE");
	b1.addActionListener(this);
	b1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	b1.setBounds(80, 320, 100, 33);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
	contentPane.add(b1);

	b2 = new JButton("BACK");
	b2.addActionListener(this);
	b2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	b2.setBounds(252,320,100,33);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLACK);
	contentPane.add(b2);

	JLabel l7 = new JLabel("Course");
	l7.setForeground(Color.BLACK);
	l7.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l7.setBounds(64, 167, 102, 22);
	contentPane.add(l7);

	comboBox_3 = new JComboBox();
	comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "B.E", "M.E"}));
        comboBox_3.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent arg0) 
            {  //this is done to check wether user has selcted BE ME
                int row= comboBox_3.getSelectedIndex();
              //  System.out.println(row);
                if(row==0)
                {
                   comboBox_1.setVisible(false);
                   comboBox_2.setVisible(false);
                    comboBox_22.setVisible(true);
                    comboBox_11.setVisible(true);
                }
                if(row==1)
                {
                    comboBox_1.setVisible(true);
                    comboBox_2.setVisible(true);
                   comboBox_22.setVisible(false);
                    comboBox_11.setVisible(false);
                }
            }
	});
	comboBox_3.setForeground(Color.BLACK);
	comboBox_3.setFont(new Font("TimesRoman", Font.BOLD, 14));
	comboBox_3.setBounds(176, 170, 154, 20);
	contentPane.add(comboBox_3);

	JPanel panel = new JPanel();
	TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"ADD STUDENT",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel.setBorder(tb);
        tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
	panel.setBounds(12, 16, 398, 354);
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==b1)//when done is clicked
            {
                try
                {
                conn con = new conn();
		String sql2 = "select * from student where roll_no=?";
                PreparedStatement st2 = con.c.prepareStatement(sql2);
                st2.setString(1, t1.getText());
                //this method replaces the parameter on index 1 with text obtained from TextField
                ResultSet rs = st2.executeQuery();//executes the query
                //data in the mysql DB is matched with data in the tables
                if (rs.next()) 
                {//checks the table row by row
                  JOptionPane.showMessageDialog(null, "Student already Added!!!");  
                  flag=1;
                 } 
                else if(flag!=1)
                {                  
                String sql = "insert into student(roll_no, first_name,last_name, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		st.setString(2, t2.getText());
		st.setString(3, t3.getText());
		st.setString(4, (String) comboBox_3.getSelectedItem());
		st.setString(5, (String) comboBox.getSelectedItem());
		st.setString(6, (String) comboBox_1.getSelectedItem());
		st.setString(7, (String) comboBox_2.getSelectedItem());
		if (st.executeUpdate() > 0)
                    JOptionPane.showMessageDialog(null, "Student Added!");
		else
                    JOptionPane.showMessageDialog(null, "Student NOT Added!!!");
                }
                t1.setText("");
                t2.setText("");//setting everything back to empty strings
                t3.setText("");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2)//when back is clicked
            {
                this.setVisible(false);//closing the add student frame
		new Home().setVisible(true);//opening the home frame		
            }
        }
        catch(Exception e)
        {
          e.printStackTrace();  
        }
    }
}
