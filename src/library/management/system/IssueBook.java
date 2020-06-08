package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    JDateChooser dateChooser;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private JButton b1,b2,b3,b4;
    int c=0;

    public static void main(String[] args) 
    {
	new IssueBook().setVisible(true);
			
    }

    public IssueBook() 
    {
        setBounds(300, 200, 740, 500);
        setLocation(80,100);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Book ID");
	l1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l1.setForeground(Color.BLACK);
	l1.setBounds(37, 63, 100, 23);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Book Name");
	l2.setForeground(Color.BLACK);
	l2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l2.setBounds(37, 97, 100, 23);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Copies");
	l3.setForeground(Color.BLACK);
	l3.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l3.setBounds(37, 131, 100, 23);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Publisher");
	l4.setForeground(Color.BLACK);
	l4.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l4.setBounds(37, 165, 100, 23);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Edition");
	l5.setForeground(Color.BLACK);
	l5.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l5.setBounds(37, 199, 100, 23);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Price");
	l6.setForeground(Color.BLACK);
	l6.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l6.setBounds(37, 233, 100, 23);
	contentPane.add(l6);

	JLabel l7 = new JLabel("Pages");
	l7.setForeground(Color.BLACK);
	l7.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l7.setBounds(37, 267, 100, 23);
	contentPane.add(l7);

	t1 = new JTextField();
	t1.setForeground(Color.BLACK);
	t1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t1.setBounds(126, 66, 86, 20);
	contentPane.add(t1);
	
	b1 = new JButton("FIND");
	b1.addActionListener(this);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
	b1.setFont(new Font("TimesRoman", Font.BOLD, 14));
	b1.setBounds(234, 59, 100, 30);
        
	contentPane.add(b1);

	t2 = new JTextField();
	t2.setEditable(false);
	t2.setForeground(Color.BLACK);
	t2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t2.setBounds(126, 100, 208, 20);
	contentPane.add(t2);
	t2.setColumns(10);

	t3 = new JTextField();
	t3.setEditable(false);
	t3.setForeground(Color.BLACK);
	t3.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(126, 131, 208, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setEditable(false);
	t4.setForeground(Color.BLACK);
	t4.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(126, 168, 208, 20);
	contentPane.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);
	t5.setForeground(Color.BLACK);
	t5.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(126, 202, 208, 20);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setEditable(false);
	t6.setForeground(Color.BLACK);
	t6.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(126, 236, 208, 20);
	contentPane.add(t6);

	t7 = new JTextField();
	t7.setEditable(false);
	t7.setForeground(Color.BLACK);
	t7.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t7.setColumns(10);
	t7.setBounds(126, 270, 208, 20);
	contentPane.add(t7);

	JPanel panel = new JPanel();
        TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"ISSUE BOOK",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel.setBorder(tb);
        tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));
	panel.setBounds(10, 28, 345, 300);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);

	JLabel l8 = new JLabel("Roll no");
	l8.setForeground(Color.BLACK);
	l8.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l8.setBounds(384, 63, 100, 23);
	contentPane.add(l8);

	JLabel l9 = new JLabel("First Name");
	l9.setForeground(Color.BLACK);
	l9.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l9.setBounds(384, 97, 100, 23);
	contentPane.add(l9);

	JLabel l10 = new JLabel("Last Name");
	l10.setForeground(Color.BLACK);
	l10.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l10.setBounds(384, 131, 100, 23);
	contentPane.add(l10);

	JLabel l11 = new JLabel("Course");
	l11.setForeground(Color.BLACK);
	l11.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l11.setBounds(384, 165, 100, 23);
	contentPane.add(l11);

	JLabel l12 = new JLabel("Branch");
	l12.setForeground(Color.BLACK);
	l12.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l12.setBounds(384, 199, 100, 23);
	contentPane.add(l12);

	JLabel l13 = new JLabel("Year");
	l13.setForeground(Color.BLACK);
	l13.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l13.setBounds(384, 233, 100, 23);
	contentPane.add(l13);

	JLabel l14 = new JLabel("Semester");
	l14.setForeground(Color.BLACK);
	l14.setFont(new Font("TimesRoman", Font.BOLD, 14));
	l14.setBounds(384, 267, 100, 23);
	contentPane.add(l14);

	t8 = new JTextField();
	t8.setForeground(Color.BLACK);
	t8.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t8.setColumns(10);
	t8.setBounds(448, 66, 125, 20);
	contentPane.add(t8);

	b2 = new JButton("FIND");
	b2.addActionListener(this);
	b2.setFont(new Font("TimesRoman", Font.BOLD, 14));
	b2.setBounds(584, 59, 100, 30);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLACK);
	contentPane.add(b2);

	t9 = new JTextField();
	t9.setForeground(Color.BLACK);
	t9.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t9.setEditable(false);
	t9.setColumns(10);
	t9.setBounds(478, 100, 208, 20);
	contentPane.add(t9);

	t10 = new JTextField();
	t10.setForeground(Color.BLACK);
	t10.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t10.setEditable(false);
	t10.setColumns(10);
	t10.setBounds(478, 131, 208, 20);
	contentPane.add(t10);

	t11 = new JTextField();
	t11.setForeground(Color.BLACK);
	t11.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t11.setEditable(false);
	t11.setColumns(10);
	t11.setBounds(478, 168, 208, 20);
	contentPane.add(t11);

	t12 = new JTextField();
	t12.setForeground(Color.BLACK);
	t12.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t12.setEditable(false);
	t12.setColumns(10);
	t12.setBounds(478, 202, 208, 20);
	contentPane.add(t12);

	t13 = new JTextField();
	t13.setForeground(Color.BLACK);
	t13.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t13.setEditable(false);
	t13.setColumns(10);
	t13.setBounds(478, 236, 208, 20);
	contentPane.add(t13);

	t14 = new JTextField();
	t14.setForeground(Color.BLACK);
	t14.setFont(new Font("TimesRoman", Font.BOLD, 14));
	t14.setEditable(false);
	t14.setColumns(10);
	t14.setBounds(478, 270, 208, 20);
	contentPane.add(t14);

	JPanel panel_1 = new JPanel();
        TitledBorder tb2=new TitledBorder(new LineBorder(Color.BLACK,3),"STUDENT DETAILS",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel_1.setBorder(tb2);
        tb2.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));
	panel_1.setBounds(360, 28, 345, 300);
        panel_1.setBackground(Color.WHITE);
	contentPane.add(panel_1);
        
	JLabel l15 = new JLabel("DATE OF ISSUE:");
	l15.setForeground(Color.BLACK);
	l15.setFont(new Font("TimesRoman", Font.BOLD, 15));
	l15.setBounds(220, 340, 130, 26);
	contentPane.add(l15);

	dateChooser = new JDateChooser();
	dateChooser.setForeground(Color.WHITE);
	dateChooser.setBounds(360, 337, 200, 29);
	contentPane.add(dateChooser);
        
       
	b3 = new JButton("ISSUE");
	b3.addActionListener(this);
	b3.setFont(new Font("TimesRoman", Font.BOLD, 14));
	b3.setBounds(250, 377, 118, 33);
	b3.setBackground(Color.CYAN);
        b3.setForeground(Color.BLACK);
        contentPane.add(b3);

	b4 = new JButton("BACK");
	b4.addActionListener(this);
	b4.setFont(new Font("TimesRoman", Font.BOLD, 14));
	b4.setBounds(400, 377, 100, 33);
	b4.setBackground(Color.CYAN);
        b4.setForeground(Color.BLACK);
        contentPane.add(b4);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1)
            {
                String sql = "select * from book where book_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
                if(rs.next()) 
                {
                    t2.setText(rs.getString("book_name"));
                    String s=rs.getString("copies");
                    t3.setText(s);
                    t4.setText(rs.getString("publisher"));
                    t5.setText(rs.getString("edition"));
                    t6.setText(rs.getString("price"));
                    t7.setText(rs.getString("pages"));  
                  if(s.equals("0"))
                       JOptionPane.showMessageDialog(null, "NO Copies of Book Available!!!");  
		}
                else
                {
                   JOptionPane.showMessageDialog(null, "Wrong BOOK id!!!"); 
                   t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                }  
		st.close();
		rs.close();
            }
            if(ae.getSource() == b2)
            {
                String sql = "select * from student where roll_no = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t8.getText());
		ResultSet rs = st.executeQuery();
                if(rs.next()) 
                {
                    c=rs.getInt("count");
                    if(c>=3)
                        JOptionPane.showMessageDialog(null,"3 BOOKS ISSUED ALREADY!!");
                    else
                    {
                    t9.setText(rs.getString("first_name"));
                    t10.setText(rs.getString("last_name"));
                    t11.setText(rs.getString("course"));
                    t12.setText(rs.getString("branch"));
                    t13.setText(rs.getString("year"));
                    t14.setText(rs.getString("semester"));
                    }
		}
                else
                {
                   JOptionPane.showMessageDialog(null, "Wrong Roll no!!!"); 
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
                t14.setText("");
                }  
		st.close();
		rs.close();
            }
            if(ae.getSource() == b3)
            {
               try
               {
                String sql = "insert into issueBook(book_id, roll_no, bname, sname, course, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		st.setString(2, t8.getText());
		st.setString(3, t2.getText());
		st.setString(4, t9.getText());
		st.setString(5, t11.getText());
		st.setString(6, t12.getText());
		st.setString(7, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
		int i = st.executeUpdate();
		if (i > 0)
                {
                    JOptionPane.showMessageDialog(null, "Book Issued!");
                    String sql3 = "update book set copies=? where book_id=?";
		  PreparedStatement st3 = con.c.prepareStatement(sql3);
		  st3.setString(1, String.valueOf(Integer.parseInt(t3.getText())-1));
                  st3.setString(2, t1.getText());
                  
                  String sql4 = "update student set count=? where roll_no=?";
		  PreparedStatement st4 = con.c.prepareStatement(sql4);
		  st4.setString(1, String.valueOf(c+1));
                  st4.setString(2, t8.getText());
                  if(st3.executeUpdate()>0 && st4.executeUpdate()>0)
                    JOptionPane.showMessageDialog(null,"Student Book Count Updated!!\nCopies Updated!!");
                  st3.close();
                }
		else
                    JOptionPane.showMessageDialog(null, "Book NOT Issued!!!");
                }
                catch(Exception e)
                {
                   e.printStackTrace();
                }
                 t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
                t14.setText("");  
            }
            if(ae.getSource() == b4)
            {
                this.setVisible(false);
		new Home().setVisible(true);	
            }
            //setting all textfield back to empty
            con.c.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
    }
}