package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener
{
        JLabel l1;
        JButton b1,b2;       
        public LibraryManagementSystem()
        {	
                setSize(1200,400);
                setLayout(null);
                setLocation(80,100);
                setBackground(Color.WHITE);

		l1 = new JLabel("");
                b1 = new JButton("LOGIN / SIGN UP");
                b2 = new JButton("EXIT");

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/LMS.png"));
                Image i3 = i1.getImage().getScaledInstance(1200, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                l1.setBounds(0, 0, 1200, 400);
                
                b1.setBounds(50,300,200,40);
                b1.setFont(new Font("TimesRoman",Font.BOLD,20));
                b1.addActionListener(this);
                b1.setBackground(Color.CYAN);
                b1.setForeground(Color.BLACK);
                l1.add(b1);
                
                b2.setBounds(50,350,200,40);
                b2.setFont(new Font("TimesRoman",Font.BOLD,20));
                b2.addActionListener(this);
                b2.setBackground(Color.CYAN);
                b2.setForeground(Color.BLACK);
                l1.add(b2);
		add(l1);
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                new Login_user().setVisible(true);
                this.setVisible(false);
            }
            if(ae.getSource()==b2)
                System.exit(0);//closing the application       
        }
        
        public static void main(String[] args) 
        {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}