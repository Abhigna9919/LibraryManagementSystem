package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class StudentDetails extends JFrame 
{

    private JPanel contentPane;
    private JTable table;
    private JTextField search;

    public static void main(String[] args)
    {
	new StudentDetails().setVisible(true);//opening the book details frame
    }
    
    public void Student() 
    {
	try 
        {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //needed to dynamically take data from the datbase and put it in the JTable
            //otherwise the table will not be visible
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setBackground(Color.CYAN);
            table.setForeground(Color.BLACK);
            table.setFont(new Font("TimesRoman", Font.BOLD, 13));
            rs.close();
            st.close();
            con.c.close();
	} 
        catch (Exception e) 
        {
          e.printStackTrace();
	}
    }

    public StudentDetails() //Constructor
    {
        //Creating a frame
        super("Student Details");
        setBounds(330, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
	setContentPane(contentPane);
	contentPane.setLayout(null);

        //a table cant be created directly
        //we have to create a scroll pane obj and then add the table to it
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(59, 133, 771, 282);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setForeground(Color.WHITE);
	contentPane.add(scrollPane);

	table = new JTable();//Creating a table with empty cells
	table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0) 
            {  
                int row;//selecting the entire row which has been clicked using the mouse
                row = table.getSelectedRow();
		//settimg the search text
                search.setText(table.getModel().getValueAt(row,1).toString());
                //getModel() returns the table model, and the 1st column value from that row is obtained
                //and converted into a string
            }
	});
	table.setBackground(Color.WHITE);
	table.setForeground(Color.BLACK);
	table.setFont(new Font("TimesRoman", Font.BOLD, 13));
	scrollPane.setViewportView(table);//we dont have add in JScrollPane instead we have setViewPortView

	JButton b1 = new JButton("Search");
	b1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                conn con = new conn();
                String sql = "select * from student where concat(first_name, roll_no) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
	b1.setForeground(Color.BLACK);
        b1.setBackground(Color.CYAN);
	b1.setFont(new Font("TimesRoman", Font.BOLD, 18));
	b1.setBounds(544, 89, 138, 33);
	contentPane.add(b1);

	JButton b2 = new JButton("Delete");
	b2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                     conn con = new conn();
                      String sql = "delete from student where first_name = '" + search.getText() + "'";
		PreparedStatement st = con.c.prepareStatement(sql);
		JDialog.setDefaultLookAndFeelDecorated(true);//for the window to not expand in other os
		int response = JOptionPane.showConfirmDialog(null, "Want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		 if (response == JOptionPane.YES_OPTION) 
                 {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student Deleted!!!");
                    //To remove row from JTable
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    //typecasting to DEfaultTabelModel
                    model.removeRow(table.getSelectedRow());
                 } 
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Student NOT Deleted");
                 }
                st.close();
            }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.CYAN);
	b2.setFont(new Font("TimesRoman", Font.BOLD, 18));
	b2.setBounds(692, 89, 138, 33);
	contentPane.add(b2);

        
	search = new JTextField();
	search.setBackground(Color.WHITE);
	search.setForeground(Color.BLACK);
	search.setFont(new Font("TimesRoman", Font.PLAIN, 15));
	search.setBounds(166, 89, 370, 33);
	contentPane.add(search);
	search.setColumns(10);

        JButton b3=new JButton("Back");
	b3.addMouseListener(new MouseAdapter() 
        {
           @Override
	   public void mouseClicked(MouseEvent e) 
            {//if the back button is clicked
	     setVisible(false);//closing the bookdetails frame
	     new Home().setVisible(true);//opening the home frame
	    }
	});
	b3.setForeground(Color.BLACK);
        b3.setBackground(Color.CYAN);
	b3.setFont(new Font("TimesRoman", Font.BOLD, 18));
	b3.setBounds(62, 89, 100, 33);
	contentPane.add(b3);

	JPanel panel = new JPanel();
        TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"STUDENT DETAILS",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel.setBorder(tb);
        tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
        panel.setBounds(47, 54, 793, 368);
	contentPane.add(panel);
        panel.setBackground(Color.WHITE);
	Student();
    }
}
