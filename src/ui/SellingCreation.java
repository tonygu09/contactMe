package ui;

import model.Event;
import model.EventLog;
import model.SellingClient;
import model.SellingGroup;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// represents creating a selling client contact
public class SellingCreation implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JButton backButton;
    private static JTextField Firstname;
    private static JTextField Lastname;
    private static JTextField phoneNumber;
    private static JTextField email;
    private static JTextField currentAddress;
    private static JCheckBox detachedHouse;
    private static JCheckBox semidetatchedHouse;
    private static JCheckBox apartment;
    private static ArrayList<String> inputedInterest = new ArrayList<String>();
    private static String housingType;
    private static JCheckBox land;
    private static JTextArea notes;
    private static JButton submitButton;
    private static SellingGroup sg = new SellingGroup();
    private static JButton yesButton;
    private static JButton maybeButton;
    private static JButton noButton;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String SELLING_STORE = "data/SellingContactInfo.json";

    // Effect; Initialization
    public static void init() {
        sg = new SellingGroup();
        sellingContact();
    }

    // modifies: this
    // Effect: Creates frame with panels and adds elements
    public static void sellingContact() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 650);
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
        backButton.addActionListener(new ui.SellingCreation());
        panel.add(backButton);
    }

    // Effect: Creates intro at the top with brief instructions
    public static void intro() {
        JLabel infoLabel = new JLabel("Create a new seller", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);
    }

    // Effect: Creates elements for panels
    public static void panelLabels() {
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 30, 80, 25);
        panel.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 70, 80, 25);
        panel.add(lastNameLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        JLabel numberLabel = new JLabel("Phone:");
        numberLabel.setBounds(10, 150, 80, 25);
        panel.add(numberLabel);

        JLabel currentAddressLabel = new JLabel("Address:");
        currentAddressLabel.setBounds(10, 190, 80, 25);
        panel.add(currentAddressLabel);

        JLabel interestLabel = new JLabel("Type:");
        interestLabel.setBounds(10, 230, 80, 25);
        panel.add(interestLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 385, 80, 25);
        panel.add(notesLabel);
    }

    // Effect: Creates textboxes for panels
    public static void panelTextboxes() {
        Firstname = new JTextField();
        Firstname.setBounds(100, 30, 165, 25);
        panel.add(Firstname);

        Lastname = new JTextField();
        Lastname.setBounds(100, 70, 165, 25);
        panel.add(Lastname);

        email = new JTextField();
        email.setBounds(100, 110, 165, 25);
        panel.add(email);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(100, 150, 165, 25);
        panel.add(phoneNumber);

        currentAddress = new JTextField();
        currentAddress.setBounds(100, 190, 165, 25);
        panel.add(currentAddress);

        housingOptions();

        notes = new JTextArea();
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 385, 165, 150);
        panel.add(scroll);

        submitting();
    }

    // Effect: Creates check boxes for panel
    public static void housingOptions() {
        detachedHouse = new JCheckBox("Detatched");
        detachedHouse.setBounds(100, 230, 165, 25);
        panel.add(detachedHouse);

        semidetatchedHouse = new JCheckBox("Semi-Detatched");
        semidetatchedHouse.setBounds(100, 260, 165, 25);
        panel.add(semidetatchedHouse);

        apartment = new JCheckBox("Apartment");
        apartment.setBounds(100, 290, 165, 25);
        panel.add(apartment);

        land = new JCheckBox("Land");
        land.setBounds(100, 320, 165, 25);
        panel.add(land);
    }

    // Effect: Creates submit button for panel
    public static void submitting() {
        submitButton = new JButton("Create Contact");
        submitButton.setBounds(100, 570, 150, 25);
        submitButton.addActionListener(new ui.SellingCreation());
        panel.add(submitButton);
    }

    // Effect: Creates frame where user can decide if they want to save or save later
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

    // Effect: Creates buttons for the panel
    public static void buttons(JPanel panel) {
        yesButton = new JButton("Save");
        yesButton.setBounds(50, 50, 100, 50);
        yesButton.addActionListener(new ui.SellingCreation());
        panel.add(yesButton);

        maybeButton = new JButton("Create New");
        maybeButton.setBounds(150, 50, 100, 50);
        maybeButton.addActionListener(new ui.SellingCreation());
        panel.add(maybeButton);

        noButton = new JButton("Go to menu");
        noButton.setBounds(250, 50, 100, 50);
        noButton.addActionListener(new ui.SellingCreation());
        panel.add(noButton);
        frame.setVisible(true);
    }

    // Effect: Handles user interacitons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton || ae.getSource() == noButton) {
            frame.dispose();
            ui.Menu.mainWindow();
        }
        if (ae.getSource() == submitButton) {
            submitter();
            frame.dispose();
            transition();
        }

        if (ae.getSource() == maybeButton) {
            frame.dispose();
            sellingContact();
        }

        if (ae.getSource() == yesButton) {
            writing();
            frame.dispose();
            Menu.mainWindow();
        }
    }

    // Modifies: this
    // Effect: Creates user input into an object and stores it inside a list
    public void submitter() {
        String inputFirstName = Firstname.getText();
        String inputLastName = Lastname.getText();
        String inputEmail = email.getText();
        String inputNumber = phoneNumber.getText();
        String inputAddress = currentAddress.getText();
        inputedInterest = new ArrayList<String>();
        String inputNotes = notes.getText();

        interests();
        SellingClient sc = new SellingClient(inputFirstName, inputLastName, inputNumber, inputEmail, inputAddress,
                housingType, inputNotes);

        sg.addMember(sc);
    }

    // Effect: Registers checked off boxes
    public static void interests() {
        if (detachedHouse.isSelected()) {
            inputedInterest.add("Detached");
        }
        if (semidetatchedHouse.isSelected()) {
            inputedInterest.add("Semi-Detached");
        }
        if (apartment.isSelected()) {
            inputedInterest.add("Apartment");
        }
        if (land.isSelected()) {
            inputedInterest.add("Land");
        }

        housingType = inputedInterest.toString();
    }

    // Effect: Writes to the file for all the data in the list
    public void writing() {
        jsonWriter = new JsonWriter(SELLING_STORE);
        try {
            jsonReader = new JsonReader(SELLING_STORE);
            jsonWriter.prevDataLoad(jsonReader.prevData());
            jsonWriter.open();

            for (int i = 0; i < sg.getSellers().size(); i++) {
                jsonWriter.sellingWrite(sg.getSellers().get(i), i);
            }

        } catch (Exception e) {
            System.out.println("Unable to write to file: " + SELLING_STORE);
        }
    }
}