package Test;
//마우스가 클릭하는데로 사각형이 그려지는 코드
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Rectangle extends JFrame{
	int x, y;
	class MyPanel extends JPanel{
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, 100,100);
			
		}
	}
	
	public Rectangle() {
		setTitle("Basic Painting");
		setSize(600,200);
		add(new MyPanel());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public static void main(String[] args) {
		Rectangle f= new Rectangle();
	}
}
