
package cafe.management.system;


import javax.swing.*;
import java.awt.*;

public class SplashScreenDemo {
    JFrame frame;
    JLabel image=new JLabel(new ImageIcon());
    JLabel text=new JLabel("Please wait .....");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    SplashScreenDemo()
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,480);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(207, 0, 15));
        frame.setVisible(true);

    }
    public void addImage(){
        image.setSize(600,250);
        frame.add(image);
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,36));
        text.setBounds(180,220,500,50);
        text.setForeground(Color.white);
        frame.add(text);
    }
    public void addMessage()
    {
        message.setBounds(250,320,300,60);
        message.setForeground(Color.white);
        message.setFont(new Font("arial",Font.BOLD,24));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(110,280,400,40);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("LOADING "+Integer.toString(i)+"%");
                i++;
                if(i==100){
                    //frame.dispose();
                    frame.setVisible(false);
                Login login = new Login();
                    //mss.setVisible(false);
                    login.setVisible(true);
                }  
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
