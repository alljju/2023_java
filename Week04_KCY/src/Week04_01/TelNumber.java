package Week04_01;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Contact {
    private String name;
    private String phoneNumber;
    private String address;

    public Contact(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Address: " + address;
    }
}

public class TelNumber {
    private JFrame frame;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextArea displayArea;
    private ArrayList<Contact> contactList;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelNumber window = new TelNumber();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelNumber() {
        contactList = new ArrayList<>();

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(29, 32, 57, 15);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("전화번호");
        lblNewLabel_1.setBounds(29, 67, 57, 15);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("주소");
        lblNewLabel_2.setBounds(29, 102, 57, 15);
        frame.getContentPane().add(lblNewLabel_2);

        nameField = new JTextField();
        nameField.setBounds(98, 29, 116, 21);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        phoneField = new JTextField();
        phoneField.setBounds(98, 64, 116, 21);
        frame.getContentPane().add(phoneField);
        phoneField.setColumns(10);

        addressField = new JTextField();
        addressField.setBounds(98, 99, 116, 21);
        frame.getContentPane().add(addressField);
        addressField.setColumns(10);

        JButton btnNewButton = new JButton("저장");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneField.getText();
                String address = addressField.getText();

                Contact contact = new Contact(name, phoneNumber, address);
                contactList.add(contact);

                displayContacts();
            }
        });
        btnNewButton.setBounds(29, 150, 185, 23);
        frame.getContentPane().add(btnNewButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBounds(254, 29, 160, 144);
        frame.getContentPane().add(displayArea);
    }

    private void displayContacts() {
        displayArea.setText("");

        for (Contact contact : contactList) {
            displayArea.append(contact.toString() + "\n");
        }
    }
}


