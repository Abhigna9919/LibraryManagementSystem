package library.management.system;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;

public class aboutUs extends JFrame
{
   
	private JPanel contentPane;
        public static void main(String[] args) 
        {
            new aboutUs().setVisible(true);			
	}
        
        public aboutUs() 
        {
            super("About Us");
            setLocation(80,100);
            setBackground(Color.WHITE);
            setBounds(500, 250, 800, 600);//setting the JFrame size to 800*600
            
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setBackground(Color.WHITE);
            contentPane.setLayout(null);
            
             JButton b3=new JButton("BACK");
	     b3.addMouseListener(new MouseAdapter() 
            {
              @Override
	      public void mouseClicked(MouseEvent e) 
               {
                 setVisible(false);
                 new Home().setVisible(true);   
	       }
	    });
             b3.setForeground(Color.BLACK);
             b3.setBackground(Color.CYAN);
	     b3.setFont(new Font("TimesRoman", Font.BOLD, 18));
	     b3.setBounds(190,460, 400, 30);
	     contentPane.add(b3);

              JButton b4=new JButton("EXIT");
	     b4.addMouseListener(new MouseAdapter() 
            {
              @Override
	      public void mouseClicked(MouseEvent e) 
               {
                 System.exit(0);  
	       }
	    });
             b4.setForeground(Color.BLACK);
             b4.setBackground(Color.CYAN);
	     b4.setFont(new Font("TimesRoman", Font.BOLD, 18));
	     b4.setBounds(190,500, 400, 30);
	     contentPane.add(b4);
        
        
             TitledBorder tb=new TitledBorder(new LineBorder(Color.BLACK,3),"ABOUT US",TitledBorder.CENTER, TitledBorder.TOP,null, Color.CYAN);
	     contentPane.setBorder(tb);
             tb.setTitleFont(new Font("TimesRoman", Font.BOLD, 20));//setting the title's font size
             contentPane.setBounds(490,240, 790, 560);
        
            JLabel l1 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/logo.png")));
            l1.setBounds(190, 120, 400, 400);
            l1.setBackground(Color.WHITE);
            contentPane.add(l1);

            JLabel l3 = new JLabel("VASAVI COLLEGE OF ENGINEERING");
            l3.setForeground(Color.BLUE);
            l3.setBackground(Color.WHITE);
            l3.setFont(new Font("TimesRoman", Font.BOLD, 30));
            l3.setBounds(130,40,700, 55);
            contentPane.add(l3);
            
            JLabel l2 = new JLabel("DEPARTMENT OF ECE");
            l2.setForeground(Color.BLUE);
            l2.setBackground(Color.WHITE);
            l2.setFont(new Font("TimesRoman", Font.BOLD, 30));
            l2.setBounds(220, 100,600, 55);
            contentPane.add(l2);
	}
        

}