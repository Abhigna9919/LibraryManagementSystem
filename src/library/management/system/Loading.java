package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

//using Runnable interface to implement the multithreading concept
public class Loading extends JFrame implements Runnable 
{
	private JPanel contentPane;//creating a panel
	private JProgressBar progressBar;//the speed of this is controlled using multithreading
	Connection conn;//reference to Connection interface
	int s;
	Thread th;//reference to Thread class

	public static void main(String[] args)
        {
            new Loading().setVisible(true);
	}

	public void setUploading() 
        {
            th.start();
            //the start() method invokes the run() method
	}

	public Loading()//Loading class constructor
        {
            super("Loading");//this appears as the frame heading
            //super() calls parent class(JFrame's constructor)
            setLocation(80,100);
            th = new Thread((Runnable) this);
            
            setBounds(600,300,600,400);
            contentPane=new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);//not using any predefined layouts

            JLabel lb1=new JLabel("PLEASE WAIT");
            lb1.setForeground(Color.BLUE);
            lb1.setFont(new Font("TimesRoman", Font.BOLD, 20));
            //setting the font style and size
            lb1.setBounds(200,46,150,20);//creating a custom layout
            contentPane.add(lb1);//adding it to the panel
	
            progressBar=new JProgressBar();//creating the progress bar object
            progressBar.setFont(new Font("TimesRoman", Font.BOLD, 11));
            progressBar.setStringPainted(true);
            progressBar.setBounds(130,135,300,25);
            contentPane.add(progressBar);//adding it to the panel

            JLabel lb2=new JLabel("Loading......");
            lb2.setFont(new Font("TimesRoman", Font.BOLD, 17));
            lb2.setForeground(Color.BLUE);
            lb2.setBounds(220,165,150,20);
            contentPane.add(lb2);

            JPanel panel=new JPanel();
            panel.setBackground(Color.white);
            panel.setBounds(0,0,590,390);
            contentPane.add(panel);
            
            setUploading();//calling the method, which starts the thread
	}
        
        public void run() //overriding the run() method in Runnable interface
        {//it provides the entry point for the thread
            try 
            {
                for (int i=0;i<100;i++) 
                {
                    s=s+1;
                    if(progressBar.getValue()<progressBar.getMaximum())
                        progressBar.setValue(progressBar.getValue()+1);
                    Thread.sleep(25);//setting a pause of 25 milliseconds between each thread
                }
                //after the progress bar loading is completed
                this.setVisible(false);//closing the loading frame
                new Home().setVisible(true);//opening the Home frame
            } 
            catch (Exception e) 
            {
		e.printStackTrace();
            }
	}
}