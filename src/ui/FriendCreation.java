package ui;

import model.Event;
import model.EventLog;
import model.FriendContact;
import model.FriendGroup;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents the creation of a friend contact
public class FriendCreation implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton backButton;
    private static JTextField Firstname;
    private static JTextField Lastname;
    private static JTextField phoneNumber;
    private static JTextField birthday;
    private static JTextField currentAddress;
    private static JTextArea notes;
    private static JButton submitButton;
    private static FriendGroup fg;
    private static JButton yesButton;
    private static JButton maybeButton;
    private static JButton noButton;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String FRIEND_STORE = "data/FriendContactInfo.json";

    // Effect: initializes list and starts method
    public static void init() {
        fg = new FriendGroup();
        friendContact();
    }

    // Effect: creates frame with elements and panels
    public static void friendContact() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
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

    // effect: creates back button
    public static void setBackButton() {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new FriendCreation());
        panel.add(backButton);
    }

    // Effect: gives brief intro for what to do
    public static void intro() {
        JLabel infoLabel = new JLabel("Create a new friend", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);
    }

    // Effect: adds elements to panel
    public static void panelLabels() {
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 30, 80, 25);
        panel.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 70, 80, 25);
        panel.add(lastNameLabel);

        JLabel numberLabel = new JLabel("Phone:");
        numberLabel.setBounds(10, 110, 80, 25);
        panel.add(numberLabel);

        JLabel birthdayLabel = new JLabel("Birthday:");
        birthdayLabel.setBounds(10, 150, 80, 25);
        panel.add(birthdayLabel);

        JLabel currentAddressLabel = new JLabel("Address:");
        currentAddressLabel.setBounds(10, 190, 80, 25);
        panel.add(currentAddressLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 230, 80, 25);
        panel.add(notesLabel);
    }

    // Effect: initializes text box for user input
    public static void panelTextboxes() {
        Firstname = new JTextField();
        Firstname.setBounds(100, 30, 165, 25);
        panel.add(Firstname);

        Lastname = new JTextField();
        Lastname.setBounds(100, 70, 165, 25);
        panel.add(Lastname);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(100, 110, 165, 25);
        panel.add(phoneNumber);

        birthday = new JTextField();
        birthday.setBounds(100, 150, 165, 25);
        panel.add(birthday);

        currentAddress = new JTextField();
        currentAddress.setBounds(100, 190, 165, 25);
        panel.add(currentAddress);


        notes = new JTextArea();
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 230, 165, 150);
        panel.add(scroll);

        submitting();
    }

    // effect: creates button
    public static void submitting() {
        submitButton = new JButton("Create Contact");
        submitButton.setBounds(100, 400, 150, 25);
        submitButton.addActionListener(new FriendCreation());
        panel.add(submitButton);
    }

    // effect: gives user options for what they want to do
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

    // effect: buttons for those options said above
    public static void buttons(JPanel panel) {
        yesButton = new JButton("Save");
        yesButton.setBounds(50, 50, 100, 50);
        yesButton.addActionListener(new FriendCreation());
        panel.add(yesButton);

        maybeButton = new JButton("Create New");
        maybeButton.setBounds(150, 50, 100, 50);
        maybeButton.addActionListener(new FriendCreation());
        panel.add(maybeButton);

        noButton = new JButton("Go to menu");
        noButton.setBounds(250, 50, 100, 50);
        noButton.addActionListener(new FriendCreation());
        panel.add(noButton);
        frame.setVisible(true);
    }

    // Effect: handles user input
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
            friendContact();
        }

        if (ae.getSource() == yesButton) {
            writing();
            frame.dispose();
            Menu.mainWindow();
        }
    }

    // modifies: this
    // effect: creates friend object and puts in list
    public void submitter() {
        String inputFirstName = Firstname.getText();
        String inputLastName = Lastname.getText();
        String inputNumber = phoneNumber.getText();
        String inputBirthday = birthday.getText();
        String inputAddress = currentAddress.getText();
        String inputNotes = notes.getText();

        FriendContact fc = new FriendContact(inputFirstName, inputLastName, inputBirthday, inputNumber, inputAddress,
                inputNotes);

        fg.addMember(fc);
    }

    // effect: writes to file
    public void writing() {
        jsonWriter = new JsonWriter(FRIEND_STORE);
        try {
            jsonReader = new JsonReader(FRIEND_STORE);
            jsonWriter.prevDataLoad(jsonReader.prevData());
            jsonWriter.open();

            for (int i = 0; i < fg.getFriends().size(); i++) {
                jsonWriter.friendWrite(fg.getFriends().get(i), i);
            }

        } catch (Exception e) {
            System.out.println("Unable to write to file: " + FRIEND_STORE);
        }
    }
}
