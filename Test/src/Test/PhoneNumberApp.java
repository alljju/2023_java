package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberApp {
    private JFrame frame;
    private Map<String, String> phoneNumberBook;

    public PhoneNumberApp() {
        phoneNumberBook = loadPhoneNumberBook();

        frame = new JFrame("전화번호 입력기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel(new GridLayout(4, 3));
        JTextField displayField = new JTextField();
        displayField.setEditable(false);

        for (int i = 1; i <= 9; i++) {
            String number = String.valueOf(i);
            JButton button = new JButton(number);
            button.addActionListener(new NumberButtonActionListener(displayField, number));
            panel.add(button);
        }

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new NumberButtonActionListener(displayField, "0"));

        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(new SaveButtonActionListener(displayField));

        JButton callButton = new JButton("전화");
        callButton.addActionListener(new CallButtonActionListener(displayField));

        panel.add(zeroButton);
        panel.add(saveButton);
        panel.add(callButton);

        frame.add(displayField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class NumberButtonActionListener implements ActionListener {
        private JTextField displayField;
        private String number;

        public NumberButtonActionListener(JTextField displayField, String number) {
            this.displayField = displayField;
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            displayField.setText(displayField.getText() + number);
        }
    }

    private class SaveButtonActionListener implements ActionListener {
        private JTextField displayField;

        public SaveButtonActionListener(JTextField displayField) {
            this.displayField = displayField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String phoneNumber = displayField.getText();
            if (phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "번호를 입력해주세요.");
                return;
            }

            String name = JOptionPane.showInputDialog(frame, "이름을 입력하세요:");
            if (name != null && !name.isEmpty()) {
                phoneNumberBook.put(name, phoneNumber);
                savePhoneNumberBook();
                JOptionPane.showMessageDialog(frame, name + "님의 전화번호가 저장되었습니다.");
                displayField.setText("");
            }
        }
    }

    private class CallButtonActionListener implements ActionListener {
        private JTextField displayField;

        public CallButtonActionListener(JTextField displayField) {
            this.displayField = displayField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String phoneNumber = displayField.getText();
            String name = null;

            for (Map.Entry<String, String> entry : phoneNumberBook.entrySet()) {
                if (entry.getValue().equals(phoneNumber)) {
                    name = entry.getKey();
                    break;
                }
            }

            if (name != null) {
                JOptionPane.showMessageDialog(frame, name + "님의 전화번호는 " + phoneNumber + "입니다.");
            } else {
                JOptionPane.showMessageDialog(frame, "어떤 번호는 저장되어 있지 않습니다.");
            }
        }
    }

    private Map<String, String> loadPhoneNumberBook() {
        Map<String, String> book = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("phonebook.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    book.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    private void savePhoneNumberBook() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("phonebook.txt"))) {
            for (Map.Entry<String, String> entry : phoneNumberBook.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PhoneNumberApp app = new PhoneNumberApp();
        Runtime.getRuntime().addShutdownHook(new Thread(app::savePhoneNumberBook));
    }
}
