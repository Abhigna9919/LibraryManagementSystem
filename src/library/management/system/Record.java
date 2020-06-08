package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Record extends JFrame{

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;

    public static void main(String[] args)
    {
        new Record().setVisible(true);
    }

    public void issueBook() {
	try {
            conn con =  new conn();
            String sql = "select * from issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
	}
        catch (Exception e) 
        {
	 e.printStackTrace();
	}
    }

    public void returnBook() {
        try {
            conn con = new conn();
            String sql = "select * from returnBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
	}
        catch (Exception e)
        {
	  e.printStackTrace();		
	}
    }

    public Record() 
    {
        super("Record");
        setLocation(80,100);
        setBounds(400, 200, 810, 594);
	contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(40, 51, 708, 217);
	contentPane.add(scrollPane);

       JButton b3=new JButton("BACK");
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
	b3.setBounds(28, 2, 95, 30);
	contentPane.add(b3);
        
        table = new JTable();
	table.setBackground(Color.CYAN);
	table.setForeground(Color.BLACK);
	table.setFont(new Font("TimesRoman", Font.BOLD, 12));
	scrollPane.setViewportView(table);

	JPanel panel = new JPanel();
        TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"ISSUE BOOK DETAILS",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel.setBorder(tb);
        tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
	panel.setBounds(26, 26, 737, 250);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);

	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(40, 316, 717, 217);
	contentPane.add(scrollPane_1);

	table_1 = new JTable();
	table_1.setBackground(Color.CYAN);
	table_1.setForeground(Color.BLACK);
	table_1.setFont(new Font("TimesRoman", Font.BOLD, 12));
	scrollPane_1.setViewportView(table_1);

	JPanel panel_1 = new JPanel();
	TitledBorder tb2=new TitledBorder(new LineBorder(Color.BLACK,3),"RETURN BOOK DETAILS",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	panel_1.setBorder(tb2);
        tb2.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
	panel_1.setBounds(26, 289, 741, 250);
        panel_1.setBackground(Color.WHITE);
	contentPane.add(panel_1);
        
	issueBook();
	returnBook();
    }
}