package Test;
//한글-영문 변환기
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class Translate {
    private JFrame frame;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton translateButton;

    private HashMap<String, String> dictionary;

    public Translate() {
        frame = new JFrame("영문-한글 변환기");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dictionary = new HashMap<>();
        dictionary.put("hello", "안녕하세요");
        dictionary.put("world", "세계");
        dictionary.put("computer", "컴퓨터");
        // 더 많은 단어들을 추가할 수 있습니다.

        inputArea = new JTextArea();
        inputArea.setBounds(50, 50, 150, 50);

        outputArea = new JTextArea();
        outputArea.setBounds(50, 150, 300, 50);
        outputArea.setEditable(false);

        translateButton = new JButton("번역");
        translateButton.setBounds(220, 50, 100, 50);
        translateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputArea.getText().trim().toLowerCase();
                String translation = dictionary.get(inputText);

                if (translation != null) {
                    outputArea.setText(translation);
                } else {
                    outputArea.setText("해당 단어를 찾을 수 없습니다.");
                }
            }
        });

        frame.add(inputArea);
        frame.add(outputArea);
        frame.add(translateButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Translate();
    }
}
