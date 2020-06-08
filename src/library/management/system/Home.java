package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
	private JPanel contentPane;
        private JButton b1,b2,b3,b4,b5,b6,b7,b8;//creating six buttons
	public static void main(String[] args)
        {
            new Home().setVisible(true);
	}  
        public Home()//constructor
        {
            setBounds(400,60,982,600);
            setLocation(80,100);
            contentPane=new JPanel();
            //The content pane sub-part of JFrame is set to content pane panel
            setContentPane(contentPane);
            contentPane.setLayout(null);
           
            //menubar on the frame is created using JMenuBar
            JMenuBar menuBar=new JMenuBar();
            menuBar.setBackground(Color.CYAN);
            menuBar.setBounds(0,10,982,35);//x,y coordinates, length & breadth of the menubar
            contentPane.add(menuBar);
            
            //creating a Quit menu in the menubar
            JMenu mnQuit=new JMenu("Quit");
            mnQuit.setFont(new Font("TimesRoman",Font.BOLD,17));
            
            //creating menu items of the Quit menu
            JMenuItem mntmLogout=new JMenuItem("Logout");
            mntmLogout.setBackground(Color.WHITE);
            mntmLogout.setForeground(Color.BLACK);
            mntmLogout.addActionListener(this);//adding an action listener on a menu item
            mnQuit.add(mntmLogout);//adding the Logout menu item to quit menu
            
            JMenuItem mntmExit=new JMenuItem("Exit");
            mntmExit.setForeground(Color.BLACK);
            mntmExit.setBackground(Color.WHITE);
            mntmExit.addActionListener(this);
            mnQuit.add(mntmExit);//adding the Exit menu item to quit menu
            
            
            //Creating a details menu in the menu bar
            JMenu mnHome=new JMenu("Home");
            mnHome.setFont(new Font("TimesRoman", Font.BOLD, 17));
            
            //Creating menu items of details menu
            JMenuItem LMS=new JMenuItem("LMS   ");
            LMS.addActionListener(this);
            LMS.setBackground(Color.WHITE);
            LMS.setForeground(Color.BLACK);
            mnHome.add(LMS);//adding book details menu item to details menu
            
            //adding the menus to the menubar
            menuBar.add(mnHome);
            menuBar.add(mnQuit);

            JLabel l1=new JLabel("Library Management System");
            l1.setForeground(Color.BLUE);
            l1.setFont(new Font("TimesRoman", Font.BOLD, 30));
            l1.setBounds(260,25,701,80);
            contentPane.add(l1);//adding the label to the panel

            JLabel l2=new JLabel("");
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/second.png"));
            Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            l2=new JLabel(i3);
            l2.setBounds(44,90,159,163);
            contentPane.add(l2);

            JLabel l3=new JLabel("");
            ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/third.png"));
            Image i5=i4.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
            ImageIcon i6=new ImageIcon(i5);
            l3=new JLabel(i6);
            l3.setBounds(760,90,159,163);
            contentPane.add(l3);

            JLabel l4=new JLabel("");
            ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fourth.jpg"));
            Image i8=i7.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
            ImageIcon i9=new ImageIcon(i8);
            l4=new JLabel(i9);
            l4.setBounds(286,90,159,163);
            contentPane.add(l4);

            JLabel l9=new JLabel("");
            ImageIcon ia=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/student.png"));
            Image ib=ia.getImage().getScaledInstance(135,135,Image.SCALE_DEFAULT);
            ImageIcon ic=new ImageIcon(ib);
            l9=new JLabel(ic);
            l9.setBounds(520,90,159,163);
            contentPane.add(l9);
            
            b1 = new JButton("ADD BOOK");
            b1.addActionListener(this);
            b1.setBackground(Color.CYAN);
            b1.setForeground(Color.BLACK);
            b1.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b1.setBounds(40, 260, 196, 44);
            contentPane.add(b1);

            b2=new JButton("RECORDS");
            b2.addActionListener(this);
            b2.setBackground(Color.CYAN);
            b2.setForeground(Color.BLACK);
            b2.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b2.setBounds(739,260,196,44);
            contentPane.add(b2);

            b3=new JButton("ADD STUDENT");
            b3.addActionListener(this);
            b3.setBackground(Color.CYAN);
            b3.setForeground(Color.BLACK);
            b3.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b3.setBounds(273,260,196,44);
            contentPane.add(b3);

            b4=new JButton("ISSUE BOOK");
            b4.addActionListener(this);
            b4.setBackground(Color.CYAN);
            b4.setForeground(Color.BLACK);
            b4.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b4.setBounds(40,500,196,44);
            contentPane.add(b4);

            b5=new JButton("RETURN BOOK");
            b5.addActionListener(this);
            b5.setBackground(Color.CYAN);
            b5.setForeground(Color.BLACK);
            b5.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b5.setBounds(273,500,196,44);
            contentPane.add(b5);

            b6=new JButton("ABOUT US");
            b6.addActionListener(this);
            b6.setBackground(Color.CYAN);
            b6.setForeground(Color.BLACK);
            b6.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b6.setBounds(739,500,196,44);
            contentPane.add(b6);
            
            b7=new JButton("BOOK DETAILS");
            b7.addActionListener(this);
            b7.setBackground(Color.CYAN);
            b7.setForeground(Color.BLACK);
            b7.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b7.setBounds(506,500,196,44);
            contentPane.add(b7);
            
            b8=new JButton("STUDENT DETAILS");
            b8.addActionListener(this);
            b8.setBackground(Color.CYAN);
            b8.setForeground(Color.BLACK);
            b8.setFont(new Font("TimesRoman", Font.BOLD, 17));
            b8.setBounds(506,260,196,44);
            contentPane.add(b8);

            JLabel l5=new JLabel("");
            //Obtaining the image 
            ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fifth.png"));
            //Scaling the image to required length and breadth, it returns Image class object
            Image i11=i10.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            //Image class obj is converted into ImageIcon class obj
            ImageIcon i12=new ImageIcon(i11);
            //it is then put inside the label
            l5=new JLabel(i12);
            l5.setBounds(44,340,159,163);
            //The label is added to the JFrame
            contentPane.add(l5);

            JLabel l6=new JLabel("");
            ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/sixth.png"));
            Image i14=i13.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
            ImageIcon i15=new ImageIcon(i14);
            l6=new JLabel(i15);
            l6.setBounds(286,340,159,163);
            contentPane.add(l6);

            JLabel l7=new JLabel("");
            ImageIcon i16=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/seventh.png"));
            Image i17=i16.getImage().getScaledInstance(180, 140,Image.SCALE_DEFAULT);
            ImageIcon i18=new ImageIcon(i17);
            l7=new JLabel(i18);
            l7.setBounds(745,340,159,163);
            contentPane.add(l7);
            
            JLabel l10=new JLabel("");
            ImageIcon ia1=new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/book.png"));
            Image ib1=ia1.getImage().getScaledInstance(105,105,Image.SCALE_DEFAULT);
            ImageIcon ic1=new ImageIcon(ib1);
            l10=new JLabel(ic1);
            l10.setBounds(520,340,159,163);
            contentPane.add(l10);
            
            getContentPane().setBackground(Color.WHITE);
            contentPane.setBackground(Color.WHITE);
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            String msg=ae.getActionCommand();//This is used to check which menu item has been clicked
            if(msg.equals("Logout"))
            {
                this.setVisible(false);
		new Login_user().setVisible(true);
            }
            else if(msg.equals("Exit"))
            {
                System.exit(0);//Closing the application
            }
            else if(msg.equals("LMS   "))
            {
                this.setVisible(false);
		new LibraryManagementSystem().setVisible(true);
            }
            if(ae.getSource()==b1)
            {
                this.setVisible(false);
                new AddBook().setVisible(true);
            }
            if(ae.getSource()==b2)
            {
                this.setVisible(false);
                new Record().setVisible(true);
            }
            if(ae.getSource()==b3)
            {
                this.setVisible(false);
                new AddStudent().setVisible(true);
            }
            if(ae.getSource()==b4)
            {
                this.setVisible(false);
                new IssueBook().setVisible(true);
            }
            if(ae.getSource()==b5)
            {
                this.setVisible(false);
                new ReturnBook().setVisible(true);
            
            }
            if(ae.getSource()==b6)
            {
                this.setVisible(false);
                new aboutUs().setVisible(true);
            }
            if(ae.getSource()==b7)
            {
                this.setVisible(false);
                new BookDetails().setVisible(true);
            }
            if(ae.getSource()==b8)
            {
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            }
            
        }
}