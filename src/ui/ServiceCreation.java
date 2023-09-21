package ui;

import model.Event;
import model.EventLog;
import model.ServiceContact;
import model.ServiceGroup;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents the creation of a service contact
public class ServiceCreation implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton backButton;
    private static JTextField name;
    private static JTextField phoneNumber;
    private static JTextField email;
    private static JTextField type;
    private static JTextArea notes;
    private static JButton submitButton;
    private static ServiceGroup sg;
    private static JButton yesButton;
    private static JButton maybeButton;
    private static JButton noButton;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String SERVICE_STORE = "data/ServiceContactInfo.json";

    // Effect: initializes stuff
    public static void init() {
        sg = new ServiceGroup();
        serviceContact();
    }

    // modifies: this
    // Effect: Creates frame with panels and elements
    public static void serviceContact() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setTitle("Create a Contact");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        setBackButton();
        intro();
        panelLabels();
        panelTextboxes();
    }

    // Effect: Creates back button
    public static void setBackButton() {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ServiceCreation());
        panel.add(backButton);
    }

    // Effect: Creates brief intro
    public static void intro() {
        JLabel infoLabel = new JLabel("Create a new service", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);
    }

    // Effect: creates labels for what to enter
    public static void panelLabels() {
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 30, 80, 25);
        panel.add(nameLabel);

        JLabel numberLabel = new JLabel("Phone:");
        numberLabel.setBounds(10, 70, 80, 25);
        panel.add(numberLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(10, 150, 80, 25);
        panel.add(typeLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 190, 80, 25);
        panel.add(notesLabel);
    }

    // Effect: Creates textboxes with panels
    public static void panelTextboxes() {
        name = new JTextField();
        name.setBounds(100, 30, 165, 25);
        panel.add(name);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(100, 70, 165, 25);
        panel.add(phoneNumber);

        email = new JTextField();
        email.setBounds(100, 110, 165, 25);
        panel.add(email);

        type = new JTextField();
        type.setBounds(100, 150, 165, 25);
        panel.add(type);

        notes = new JTextArea();
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 190, 165, 150);
        panel.add(scroll);

        submitting();
    }

    // Effect: Creates submit button
    public static void submitting() {
        submitButton = new JButton("Create Contact");
        submitButton.setBounds(100, 375, 150, 25);
        submitButton.addActionListener(new ServiceCreation());
        panel.add(submitButton);
    }

    // Effect: Creates transition to decide
    public static void transition() {
        frame = new JFrame();
        frame.setSize(400, 150);
        frame.setMinimumSize(new Dimension(400, 150));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                EventLog el = EventLog.getInstance();
                for (Event next : el) {
                    System.out.println(next.toString());
                }
                //THEN you can exit the program
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);

        frame.add(panel);

        JLabel infoLabel = new JLabel("Press either button");
        infoLabel.setBounds(125, 10, 150, 25);
        panel.add(infoLabel);

        buttons(panel);
    }

    // Effect: Creates buttons for user to decide what to do
    public static void buttons(JPanel panel) {
        yesButton = new JButton("Save");
        yesButton.setBounds(50, 50, 100, 50);
        yesButton.addActionListener(new ServiceCreation());
        panel.add(yesButton);

        maybeButton = new JButton("Create New");
        maybeButton.setBounds(150, 50, 100, 50);
        maybeButton.addActionListener(new ServiceCreation());
        panel.add(maybeButton);

        noButton = new JButton("Go to menu");
        noButton.setBounds(250, 50, 100, 50);
        noButton.addActionListener(new ServiceCreation());
        panel.add(noButton);
        frame.setVisible(true);
    }

    // Effect: Handles user interactions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton || ae.getSource() == noButton) {
            frame.dispose();
            Menu.mainWindow();
        }
        if (ae.getSource() == submitButton) {
            submitter();
            frame.dispose();
            transition();
        }

        if (ae.getSource() == maybeButton) {
            frame.dispose();
            serviceContact();
        }

        if (ae.getSource() == yesButton) {
            writing();
            frame.dispose();
            Menu.mainWindow();
        }
    }

    // Modifies: this
    // Effect: Creates object and stores in list
    public void submitter() {
        String inputName = name.getText();
        String inputNumber = phoneNumber.getText();
        String inputEmail = email.getText();
        String inputType = type.getText();
        String inputNotes = notes.getText();

        ServiceContact sc = new ServiceContact(inputName, inputNumber, inputEmail, inputType,
                inputNotes);

        sg.addMember(sc);
    }

    // Effect: writes to file
    public void writing() {
        jsonWriter = new JsonWriter(SERVICE_STORE);
        try {
            jsonReader = new JsonReader(SERVICE_STORE);
            jsonWriter.prevDataLoad(jsonReader.prevData());
            jsonWriter.open();

            for (int i = 0; i < sg.getServices().size(); i++) {
                jsonWriter.serviceWrite(sg.getServices().get(i), i);
            }

        } catch (Exception e) {
            System.out.println("Unable to write to file: " + SERVICE_STORE);
        }
    }
}
