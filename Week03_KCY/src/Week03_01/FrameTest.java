package Week03_01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameTest {
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Frame Test");
		f.setTitle("MyFrame");
		f.setSize(300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
