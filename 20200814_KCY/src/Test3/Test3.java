package Test3;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

class Contact1 {
	private String name;
    private String phoneNumber;
    private String address;

    public Contact1(String name, String phoneNumber, String address) {
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

public class Test3 {
	
	private JFrame frame;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextArea displayArea;
    private ArrayList<Contact1> contactList;
    private static final String FILE_PATH = "contacts.txt";

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

    // Add this method to save contacts to a file
    private static void saveContactsToFile(ArrayList<Contact1> contacts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add this method to load contacts from a file
    private static ArrayList<Contact1> loadContactsFromFile() {
        ArrayList<Contact1> contacts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            contacts = (ArrayList<Contact1>) ois.readObject();
            System.out.println("Contacts loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    // Add this method to calculate the average of grades
    private static double calculateAverageGrade(ArrayList<Contact1> contacts) {
        double totalGrade = 0;
        for (Contact1 contact : contacts) {
            // Assuming the "address" field in Contact represents the grade
            totalGrade += Double.parseDouble(contact.getAddress());
        }
        return totalGrade / contacts.size();
    }

    // Add this method to get the total number of contacts
    private static int getTotalContacts(ArrayList<Contact1> contacts) {
        return contacts.size();
    }
}
