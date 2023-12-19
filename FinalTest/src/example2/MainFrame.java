package example2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class MainFrame extends JFrame{
	private JButton stopButton;
    private JButton startButton;
    public MainFrame() {
        
        setSize(500,500);
        setTitle("BubbleGame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //MainPanel mp = new MainPanel();
        //add(mp);
        setVisible(true);
        
       
        

        startButton = new JButton("게임 시작");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MainPanel mp = new MainPanel();
                add(mp);
                setVisible(true);
            }
        });
        add(startButton);
        startButton.setBounds(120,400,125,23);
        
        stopButton = new JButton("게임 중지");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MainPanel mp = new MainPanel();
                add(mp);
            	setVisible(false);
            }
        });
        add(stopButton);
        stopButton.setBounds(260,400,125,23);
        
        
                
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        new MainFrame();
    }
 
}