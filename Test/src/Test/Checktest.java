package Test;
//체크박스용
import javax.swing.*;
import java.awt.event.*;

public class Checktest{
    public static void main(String[] args) {
        JFrame frame = new JFrame("체크박스 이벤트 예제");

        JCheckBox check = new JCheckBox("Checkbox, false");
        check.setBounds(100, 100, 150, 50);

        check.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("체크상태:" + check.isSelected());
            }
        });

        frame.add(check);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


