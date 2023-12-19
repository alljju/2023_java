package example2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class MainPanel extends JPanel{
	
    public MainPanel() {
        setLayout(null);
        addMouseListener( new MyMouseAdapter());
        
    }
    
    class MyMouseAdapter extends MouseAdapter    {
        
        public void mousePressed(MouseEvent e) {
            
            BThread bt = new BThread(e.getX(),e.getY());
            bt.start();
            
        }
        
    }
    
    class BThread extends Thread {
        
        JLabel label ;
        
        public BThread(int bx, int by) {
            
            ImageIcon img = new ImageIcon("bubble.jpg");
            label = new JLabel(img);
            label.setSize(img.getIconWidth(), img.getIconHeight());
            label.setLocation(bx, by);
            add(label);
                        
        }
        public void run() {
            
            while(true) {
                int x = label.getX();
                int y = label.getY()-1;
                
                if(y<0) {
                    remove(label);
                    repaint();
                }
                label.setLocation(x, y);
                repaint();
                
                try {sleep(2);}
                catch(InterruptedException e) {}
                    
                
            }
        }
        
    }
 
}
