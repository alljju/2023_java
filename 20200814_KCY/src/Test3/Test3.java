package Test3;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private Map<String, String> ContackBook;

    public Contact(String name, String phoneNumber, String address) {
    	
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        
        System.out.println("이름: " + name + ", 학번: " + phoneNumber + ", 성적: " + address);
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 학번: " + phoneNumber + ", 성적: " + address;
    }
}

public class Test3{
    private static final Map<String, String> ContactBook = null;
	private JFrame frame;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private ArrayList<Contact> contactList;
    String filePath = "phonebook.txt";
    
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Test3 window = new Test3();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        });
    }

    public Test3() {
        contactList = new ArrayList<>();
        ArrayList<Double> scores = new ArrayList<>();

        frame = new JFrame();
        frame.setTitle("덕성여대화이팅");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(29, 32, 57, 15);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("학번");
        lblNewLabel_1.setBounds(29, 67, 57, 15);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("성적");
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
        
        double total = 0;
        for (double addressField : scores) {
            total += addressField;
        }

        // 평균을 계산합니다.
        double average = total / scores.size();
        
        System.out.println("나머지 점수들의 평균: " + average);

        

        JButton btnNewButton = new JButton("등록하기");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneField.getText();
                String address = addressField.getText();
                

                Contact contact = new ContactBook(name, phoneNumber, address);
                saveContactBook();
                
                for (Map.Entry<String, String> entry : ContactBook.entrySet()) {
                    if (entry.getValue().equals(phoneNumber)) {
                        name = entry.getKey();
                        break;
                    }
                }
                
            }
        });
        btnNewButton.setBounds(29, 150, 185, 23);
        frame.getContentPane().add(btnNewButton);

        
    }
    
        private Map<String, String> LoadContactBook() {
            Map<String, String> contact = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("phonebook.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                    	contact.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return contact;
        }

        private void saveContactBook() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("phonebook.txt"))) {
                for (Map.Entry<String, String> entry : ContactBook.entrySet()) {
                    writer.write(entry.getKey() + "," + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    
}




