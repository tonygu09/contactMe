package ui;

import model.*;
import model.Event;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// represents a class where users can both view and edit their contacts
public class ContactList implements ActionListener {
    private static JFrame frame;
    private static JButton backButton;
    private static JButton buyingButton;
    private static JButton sellingButton;
    private static JButton friendButton;
    private static JButton serviceButton;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private static JPanel panel4;
    private static JPanel panel5;
    private static final String BUYING_STORE = "data/BuyingContactInfo.json";
    private static final String SELLING_STORE = "data/SellingContactInfo.json";
    private static final String FRIEND_STORE = "data/FriendContactInfo.json";
    private static final String SERVICE_STORE = "data/ServiceContactInfo.json";
    private static JsonReader reader;
    private static JLabel infoLabel;
    private static int lengthOfPast = 0;
    private static String wantToView = "";
    private static JButton editButton;
    private static Object objPhoneNumber;
    private static Object objEmail;
    private static Object objAddress;
    private static Object objInterested;
    private static Object objNotes;
    private static Object objType;
    private static Object objBirthday;
    private static JCheckBox detachedHouse;
    private static JCheckBox semidetatchedHouse;
    private static JCheckBox apartment;
    private static JCheckBox land;
    private static JButton deleteButton;
    private static JTextField Firstname;
    private static JTextField Lastname;
    private static JTextField phoneNumber;
    private static JTextField birthday;
    private static JTextField currentAddress;
    private static JTextArea notes;
    private static JTextField serviceName;
    private static JTextField email;
    private static JTextField type;
    private static JButton serviceSubmitButton;
    private static JButton friendSubmitButton;
    private static JButton buyingSubmitButton;
    private static JButton sellingSubmitButton;
    private static ArrayList<String> inputedInterest;
    private static String housingInterests = "";


    // modifies: this
    // effect: creation of frame and elements for one page
    public static void contacts() {
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(700, 300));
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setTitle("Contacts Application");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();

        panelling();
    }

    // modifies: this
    // effect: adds elements and panels to page
    public static void panelling() {
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));


        Color c = new Color(152, 255, 152);
        panel1.setBackground(c);
        panel2.setBackground(c);
        panel3.setBackground(c);
        panel4.setBackground(c);
        panel5.setBackground(c);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.add(panel4, BorderLayout.WEST);
        frame.add(panel5, BorderLayout.CENTER);

        panel1.setLayout(new BorderLayout());
        panel5.setLayout(new GridBagLayout());

        panelElements();
    }

    // Effect: creates button for users to use
    public static void backing() {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        panel1.add(backButton);
    }

    // effect: creates elements for users
    public static void panelElements() {
        backing();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel helloMessage = new JLabel("What group would you like to view?", SwingConstants.CENTER);
        helloMessage.setFont(new Font("Arial", Font.BOLD, 30));
        panel1.add(helloMessage, BorderLayout.CENTER);

        buyingButton = new JButton("Buying Client");
        buyingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyingButton.addActionListener(new ContactList());
        panel5.add(buyingButton);

        sellingButton = new JButton("Selling Client");
        sellingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sellingButton.addActionListener(new ContactList());
        panel5.add(sellingButton);

        friendButton = new JButton("Friend");
        friendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        friendButton.addActionListener(new ContactList());
        panel5.add(friendButton);

        serviceButton = new JButton("Service");
        serviceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        serviceButton.addActionListener(new ContactList());
        panel5.add(serviceButton);
    }

    // effect: creates one view of creating buyer contacts
    public static void buyerView() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        printer(frame);
        frame.setSize(350, 650);
        frame.setTitle("Edit/View Contacts");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        viewElements(panel);
        displayTable(panel, BUYING_STORE);
    }

    // effect: creates one view of creating seller contacts
    public static void sellerView() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        printer(frame);
        frame.setSize(350, 650);
        frame.setTitle("Edit/View Contacts");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        viewElements(panel);
        displayTable(panel, SELLING_STORE);
    }

    // effect: creates one view of creating friend contacts
    public static void friendView() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        printer(frame);
        frame.setSize(350, 650);
        frame.setTitle("Edit/View Contacts");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        viewElements(panel);
        displayTable(panel, FRIEND_STORE);
    }

    // effect: creates one view of creating service contacts
    public static void serviceView() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        printer(frame);
        frame.setSize(350, 650);
        frame.setTitle("Edit/View Contacts");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        viewElements(panel);
        displayTable(panel, SERVICE_STORE);
    }

    // effect: creates buttons for user to press and general ifo
    public static void viewElements(JPanel pane) {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        pane.add(backButton);

        infoLabel = new JLabel("Edit/View Contacts", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        pane.add(infoLabel);
    }

    // effect: displays table of users
    public static void displayTable(JPanel panel, String source) {
        reader = new JsonReader(source);
        String[][] tableElements;
        try {
            lengthOfPast = reader.keys().size();

            tableElements = new String[lengthOfPast][2];

            List<String> allKeys = new ArrayList<>(reader.keys());
            JSONObject jsonObject = reader.stored();

            for (int j = 0; j < lengthOfPast; j++) {
                JSONObject jsonChildObject = (JSONObject) jsonObject.get(allKeys.get(j));
                Object uploadName = jsonChildObject.get("name");
                Object uploadDate = jsonChildObject.get("CreationTime");
                for (int k = 0; k < 2; k++) {
                    if (k == 1) {
                        tableElements[j][k] = (String) uploadDate;
                    } else {
                        tableElements[j][k] = (String) uploadName;
                    }
                }
            }
            fillTable(tableElements, panel);
        } catch (Exception e) {
            infoLabel.setText("There are no contacts created yet..");
        }
    }

    public static void printer(JFrame frame) {
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
    }

    // modifies: this
    // effect: fills the table up with elements
    public static void fillTable(String[][] tableElements, JPanel panel) {
        // Column Names
        String[] columnNames = { "Name", "Date Created" };

        // Initializing the JTable
        JTable j = new JTable(tableElements, columnNames) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        j.setAutoCreateRowSorter(true);
        j.setFocusable(true);
        j.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column
                    wantToView = (String) j.getValueAt(row, column);
                    if (column == 0) {
                        frame.dispose();
                        ContactList.viewContact();
                    }
                }
            }
        });

        scrollPane(j, panel);
    }

    // modifies: this
    // effect: adds scroll pane to table if too full
    public static void scrollPane(JTable j, JPanel panel) {
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        sp.setBounds(10, 100, 330, 500);
        panel.add(sp);
    }

    // effect: user decision tree
    public static void viewContact() {
        switch (reader.getSource()) {
            case BUYING_STORE:
                buyingClient();
                break;
            case SELLING_STORE:
                sellingClient();
                break;
            case FRIEND_STORE:
                friendClient();
                break;
            case SERVICE_STORE:
                serviceClient();
                break;
        }
    }

    // effect: represents the viewing of a buyer
    public static void buyingClient() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 650);
        frame.setTitle("View Contact Information");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        buyingButtons(panel);
        buyingIntro(panel);
        buyingInfo();
        buyingLabels(panel);
        buyingOptions();
        buyingOptionPanel(panel);
        buyingData(panel);
        buyingNotes(panel);
    }

    // effect: pre-info instruction
    public static void buyingIntro(JPanel panel) {
        JLabel infoLabel = new JLabel("View Contact Info", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);

        JLabel statusLabel = new JLabel("Here is their information", SwingConstants.CENTER);
        statusLabel.setBounds(10, 525, 330, 25);
        panel.add(statusLabel);
    }

    // effect: getting buyer information
    public static void buyingInfo() {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];
        String combinedName = firstPart + secondPart;

        try {
            JSONObject jsonObject = reader.stored();
            JSONObject jsonChildObject = (JSONObject) jsonObject.get(combinedName);
            objPhoneNumber = jsonChildObject.get("number");
            objEmail = jsonChildObject.get("email");
            objAddress = jsonChildObject.get("address");
            objInterested = jsonChildObject.get("interested");
            objNotes = jsonChildObject.get("notes");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    // effect: creates button for buyer view
    public static void buyingButtons(JPanel panel) {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        panel.add(backButton);

        editButton = new JButton("Edit");
        editButton.setBounds(275, 0, 75, 25);
        editButton.addActionListener(new ContactList());
        panel.add(editButton);

        deleteButton = new JButton("Delete Contact");
        deleteButton.setBounds(100, 575, 150, 25);
        deleteButton.addActionListener(new ContactList());
        panel.add(deleteButton);
    }

    // effect: creates labels
    public static void buyingLabels(JPanel panel) {
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

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 190, 80, 25);
        panel.add(addressLabel);

        JLabel interestLabel = new JLabel("Housing:");
        interestLabel.setBounds(10, 230, 80, 25);
        panel.add(interestLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 350, 80, 25);
        panel.add(notesLabel);
    }

    // effect: represents the previously filled in data of check boxes
    public static void buyingOptions() {
        detachedHouse = new JCheckBox();
        detachedHouse.setText("Detached");
        detachedHouse.setBounds(100, 230, 165, 25);

        semidetatchedHouse = new JCheckBox();
        semidetatchedHouse.setText("Semi-Detached");
        semidetatchedHouse.setBounds(100, 255, 165, 25);

        apartment = new JCheckBox();
        apartment.setText("Apartment");
        apartment.setBounds(100, 280, 165, 25);

        land = new JCheckBox();
        land.setText("Land");
        land.setBounds(100, 305, 165, 25);

        String interested = objInterested.toString();
        interested = interested.replaceAll("\\[", "").replaceAll("\\]","");
        String[] items = interested.split("\\s*,\\s*");

        for (String item : items) {
            buyingCheckboxes(item);
        }

        detachedHouse.setEnabled(false);
        semidetatchedHouse.setEnabled(false);
        apartment.setEnabled(false);
        land.setEnabled(false);
    }

    // effect: adds checkboxes to buyer
    public static void buyingOptionPanel(JPanel panel) {
        panel.add(detachedHouse);
        panel.add(semidetatchedHouse);
        panel.add(apartment);
        panel.add(land);
    }

    // modifies: this
    // effect: represents checker for boxes based off previous data
    public static void buyingCheckboxes(String s) {
        switch (s) {
            case "Detached":
                detachedHouse.doClick();
                break;
            case "Semi-Detached":
                semidetatchedHouse.doClick();
                break;
            case "Apartment":
                apartment.doClick();
                break;
            case "Land":
                land.doClick();
                break;
        }
    }

    // effect: represents the viewing of a buyer's data
    public static void buyingData(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        JLabel firstName = new JLabel(firstPart);
        firstName.setBounds(100, 30, 240, 25);
        panel.add(firstName);

        JLabel lastName = new JLabel(secondPart);
        lastName.setBounds(100, 70, 240, 25);
        panel.add(lastName);

        JLabel email = new JLabel(objEmail.toString());
        email.setBounds(100, 110, 240, 25);
        panel.add(email);

        JLabel phoneNumber = new JLabel(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 150, 240, 25);
        panel.add(phoneNumber);

        JLabel address = new JLabel(objAddress.toString());
        address.setBounds(100, 190, 240, 25);
        panel.add(address);
    }

    // effect: gets the buyers notes
    public static void buyingNotes(JPanel panel) {
        JTextArea notes = new JTextArea(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        notes.setEnabled(false);
        notes.setBackground(new Color(152, 255, 152));
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 350, 165, 150);
        panel.add(scroll);
    }

    // effect: frame and panel creation for seller
    public static void sellingClient() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 650);
        frame.setTitle("View Contact Information");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        sellingButtons(panel);
        sellingIntro(panel);
        sellingInfo();
        sellingLabels(panel);
        sellingOptions();
        sellingOptionPanel(panel);
        sellingData(panel);
        sellingNotes(panel);
    }

    // effect: creates brief intro for seller
    public static void sellingIntro(JPanel panel) {
        JLabel infoLabel = new JLabel("View Contact Info", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);

        JLabel statusLabel = new JLabel("Here is their information", SwingConstants.CENTER);
        statusLabel.setBounds(10, 525, 330, 25);
        panel.add(statusLabel);
    }

    // effect: represents the getting of data about seller
    public static void sellingInfo() {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];
        String combinedName = firstPart + secondPart;

        try {
            JSONObject jsonObject = reader.stored();
            JSONObject jsonChildObject = (JSONObject) jsonObject.get(combinedName);
            objPhoneNumber = jsonChildObject.get("number");
            objEmail = jsonChildObject.get("email");
            objAddress = jsonChildObject.get("address");
            objType = jsonChildObject.get("type");
            objNotes = jsonChildObject.get("notes");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    // effect: creates buttons for selling view page
    public static void sellingButtons(JPanel panel) {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        panel.add(backButton);

        editButton = new JButton("Edit");
        editButton.setBounds(275, 0, 75, 25);
        editButton.addActionListener(new ContactList());
        panel.add(editButton);

        deleteButton = new JButton("Delete Contact");
        deleteButton.setBounds(100, 575, 150, 25);
        deleteButton.addActionListener(new ContactList());
        panel.add(deleteButton);
    }

    // effect: creates labels for seller view page
    public static void sellingLabels(JPanel panel) {
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

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 190, 80, 25);
        panel.add(addressLabel);

        JLabel interestLabel = new JLabel("Housing:");
        interestLabel.setBounds(10, 230, 80, 25);
        panel.add(interestLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 350, 80, 25);
        panel.add(notesLabel);
    }

    // effect: creates checkbox display for seller
    public static void sellingOptions() {
        detachedHouse = new JCheckBox();
        detachedHouse.setText("Detached");
        detachedHouse.setBounds(100, 230, 165, 25);

        semidetatchedHouse = new JCheckBox();
        semidetatchedHouse.setText("Semi-Detached");
        semidetatchedHouse.setBounds(100, 255, 165, 25);

        apartment = new JCheckBox();
        apartment.setText("Apartment");
        apartment.setBounds(100, 280, 165, 25);

        land = new JCheckBox();
        land.setText("Land");
        land.setBounds(100, 305, 165, 25);

        String interested = objType.toString();
        interested = interested.replaceAll("\\[", "").replaceAll("\\]","");
        String[] items = interested.split("\\s*,\\s*");

        for (String item : items) {
            sellingCheckboxes(item);
        }

        detachedHouse.setEnabled(false);
        semidetatchedHouse.setEnabled(false);
        apartment.setEnabled(false);
        land.setEnabled(false);
    }

    // effect: adds checkboxes to panel
    public static void sellingOptionPanel(JPanel panel) {
        panel.add(detachedHouse);
        panel.add(semidetatchedHouse);
        panel.add(apartment);
        panel.add(land);
    }

    // modifies: this
    // effect: checks off checkboxes based off previous data
    public static void sellingCheckboxes(String s) {
        switch (s) {
            case "Detached":
                detachedHouse.doClick();
                break;
            case "Semi-Detached":
                semidetatchedHouse.doClick();
                break;
            case "Apartment":
                apartment.doClick();
                break;
            case "Land":
                land.doClick();
                break;
        }
    }

    // effect: represents display of seller data
    public static void sellingData(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        JLabel firstName = new JLabel(firstPart);
        firstName.setBounds(100, 30, 240, 25);
        panel.add(firstName);

        JLabel lastName = new JLabel(secondPart);
        lastName.setBounds(100, 70, 240, 25);
        panel.add(lastName);

        JLabel email = new JLabel(objEmail.toString());
        email.setBounds(100, 110, 240, 25);
        panel.add(email);

        JLabel phoneNumber = new JLabel(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 150, 240, 25);
        panel.add(phoneNumber);

        JLabel address = new JLabel(objAddress.toString());
        address.setBounds(100, 190, 240, 25);
        panel.add(address);
    }

    // effect: represents the notes of the seller
    public static void sellingNotes(JPanel panel) {
        JTextArea notes = new JTextArea(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        notes.setEnabled(false);
        notes.setBackground(new Color(152, 255, 152));
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 350, 165, 150);
        panel.add(scroll);
    }

    // effect: represents the viewing of a friend
    public static void friendClient() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
        frame.setTitle("View Contact Information");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        friendIntro(panel);
        friendButtons(panel);
        friendInfo();
        friendLabels(panel);
        friendData(panel);
        friendNotes(panel);
    }

    // effect: represents the intro of a friend
    public static void friendIntro(JPanel panel) {
        JLabel infoLabel = new JLabel("View Contact Info", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);

        JLabel statusLabel = new JLabel("Here is their information", SwingConstants.CENTER);
        statusLabel.setBounds(10, 525, 330, 25);
        panel.add(statusLabel);
    }

    // modifies: this
    // effect: represents the getting of info about friend
    public static void friendInfo() {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];
        String combinedName = firstPart + secondPart;

        try {
            JSONObject jsonObject = reader.stored();
            JSONObject jsonChildObject = (JSONObject) jsonObject.get(combinedName);
            objBirthday = jsonChildObject.get("birthday");
            objPhoneNumber = jsonChildObject.get("number");
            objAddress = jsonChildObject.get("address");
            objNotes = jsonChildObject.get("notes");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    // effect: creates button for friend view page
    public static void friendButtons(JPanel panel) {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        panel.add(backButton);

        editButton = new JButton("Edit");
        editButton.setBounds(275, 0, 75, 25);
        editButton.addActionListener(new ContactList());
        panel.add(editButton);

        deleteButton = new JButton("Delete Contact");
        deleteButton.setBounds(100, 400, 150, 25);
        deleteButton.addActionListener(new ContactList());
        panel.add(deleteButton);
    }

    // effect: creates labels for friend view page
    public static void friendLabels(JPanel panel) {
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 30, 80, 25);
        panel.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 70, 80, 25);
        panel.add(lastNameLabel);

        JLabel emailLabel = new JLabel("Birthday:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        JLabel numberLabel = new JLabel("Phone:");
        numberLabel.setBounds(10, 150, 80, 25);
        panel.add(numberLabel);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 190, 80, 25);
        panel.add(addressLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 230, 80, 25);
        panel.add(notesLabel);
    }

    // effect: represents the data of friend
    public static void friendData(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        JLabel firstName = new JLabel(firstPart);
        firstName.setBounds(100, 30, 240, 25);
        panel.add(firstName);

        JLabel lastName = new JLabel(secondPart);
        lastName.setBounds(100, 70, 240, 25);
        panel.add(lastName);

        JLabel birthday = new JLabel(objBirthday.toString());
        birthday.setBounds(100, 110, 240, 25);
        panel.add(birthday);

        JLabel phoneNumber = new JLabel(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 150, 240, 25);
        panel.add(phoneNumber);

        JLabel address = new JLabel(objAddress.toString());
        address.setBounds(100, 190, 240, 25);
        panel.add(address);
    }

    // effect: represents the note of friend
    public static void friendNotes(JPanel panel) {
        JTextArea notes = new JTextArea(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        notes.setEnabled(false);
        notes.setBackground(new Color(152, 255, 152));
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 230, 165, 150);
        panel.add(scroll);
    }

    // effect: represents the viewing of a service
    public static void serviceClient() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setTitle("View Contact Information");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        serviceIntro(panel);
        serviceInfo();
        serviceButtons(panel);
        serviceLabels(panel);
        serviceData(panel);
        serviceNotes(panel);
    }

    // effect: represents the intro of service
    public static void serviceIntro(JPanel panel) {
        JLabel infoLabel = new JLabel("View Contact Info", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);

        JLabel statusLabel = new JLabel("Here is their information", SwingConstants.CENTER);
        statusLabel.setBounds(10, 525, 330, 25);
        panel.add(statusLabel);
    }

    // effect: represents the getting of data from buyer
    public static void serviceInfo() {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];
        String combinedName = firstPart + secondPart;

        try {
            JSONObject jsonObject = reader.stored();
            JSONObject jsonChildObject = (JSONObject) jsonObject.get(combinedName);
            objPhoneNumber = jsonChildObject.get("number");
            objEmail = jsonChildObject.get("email");
            objType = jsonChildObject.get("type");
            objNotes = jsonChildObject.get("note");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    // effect: represents the buttons of services
    public static void serviceButtons(JPanel panel) {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        panel.add(backButton);

        editButton = new JButton("Edit");
        editButton.setBounds(275, 0, 75, 25);
        editButton.addActionListener(new ContactList());
        panel.add(editButton);

        deleteButton = new JButton("Delete Contact");
        deleteButton.setBounds(100, 365, 150, 25);
        deleteButton.addActionListener(new ContactList());
        panel.add(deleteButton);
    }

    // effect: represents the labels of services
    public static void serviceLabels(JPanel panel) {
        JLabel firstNameLabel = new JLabel("Name:");
        firstNameLabel.setBounds(10, 30, 80, 25);
        panel.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Number:");
        lastNameLabel.setBounds(10, 70, 80, 25);
        panel.add(lastNameLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        JLabel numberLabel = new JLabel("Type:");
        numberLabel.setBounds(10, 150, 80, 25);
        panel.add(numberLabel);


        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 190, 80, 25);
        panel.add(notesLabel);
    }

    // modifies: this
    // effect: represents the display of data for services
    public static void serviceData(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        JLabel serviceName = new JLabel(firstPart + " " + secondPart);
        serviceName.setBounds(100, 30, 240, 25);
        panel.add(serviceName);

        JLabel number = new JLabel(objPhoneNumber.toString());
        number.setBounds(100, 70, 240, 25);
        panel.add(number);

        JLabel email = new JLabel(objEmail.toString());
        email.setBounds(100, 110, 240, 25);
        panel.add(email);

        JLabel type = new JLabel(objType.toString());
        type.setBounds(100, 150, 240, 25);
        panel.add(type);
    }

    // effect: displays services notes
    public static void serviceNotes(JPanel panel) {
        JTextArea notes = new JTextArea(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        notes.setEnabled(false);
        notes.setBackground(new Color(152, 255, 152));
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 190, 165, 150);
        panel.add(scroll);
    }

    // effect: creates page for editing buyers
    public static void editBuying() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 650);
        frame.setTitle("Create a Contact");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        setBackButton(panel);
        intro(panel);
        buyingPanelLabels(panel);
        housingOptions(panel);
        buyingPanelTextBoxes(panel);
        buyingEditedNotes(panel);
        buyingSubmitting(panel);
    }

    // effect: creates labels for buyer
    public static void buyingPanelLabels(JPanel panel) {
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

        JLabel interestLabel = new JLabel("Housing:");
        interestLabel.setBounds(10, 230, 80, 25);
        panel.add(interestLabel);

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(10, 385, 80, 25);
        panel.add(notesLabel);
    }

    // effect: creates text fields for buyers
    public static void buyingPanelTextBoxes(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        Firstname = new JTextField();
        Firstname.setText(firstPart);
        Firstname.setBounds(100, 30, 165, 25);
        panel.add(Firstname);

        Lastname = new JTextField();
        Lastname.setText(secondPart);
        Lastname.setBounds(100, 70, 165, 25);
        panel.add(Lastname);

        email = new JTextField();
        email.setText(objEmail.toString());
        email.setBounds(100, 110, 165, 25);
        panel.add(email);

        phoneNumber = new JTextField();
        phoneNumber.setText(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 150, 165, 25);
        panel.add(phoneNumber);

        currentAddress = new JTextField();
        currentAddress.setText(objAddress.toString());
        currentAddress.setBounds(100, 190, 165, 25);
        panel.add(currentAddress);
    }

    // effect: gets edited buyer note
    public static void buyingEditedNotes(JPanel panel) {
        notes = new JTextArea();
        notes.setText(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 385, 165, 150);
        panel.add(scroll);
    }

    // effect: displays housing types for selection
    public static void housingOptions(JPanel panel) {
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

        String interested = objInterested.toString();
        interested = interested.replaceAll("\\[", "").replaceAll("\\]","");
        String[] items = interested.split("\\s*,\\s*");

        for (String item : items) {
            buyingCheckboxes(item);
        }
    }

    // effect: creating submit button for buyers
    public static void buyingSubmitting(JPanel panel) {
        buyingSubmitButton = new JButton("Update!");
        buyingSubmitButton.setBounds(100, 550, 150, 25);
        buyingSubmitButton.addActionListener(new ContactList());
        panel.add(buyingSubmitButton);
    }

    // effect: represents the editing of a seller
    public static void editSelling() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 650);
        frame.setTitle("Create a Contact");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        setBackButton(panel);
        intro(panel);
        sellingPanelLabels(panel);
        sellingHousingOptions(panel);
        sellingPanelTextBoxes(panel);
        sellingEditedNotes(panel);
        sellingSubmitting(panel);
    }

    // effect: represents the selling labels
    public static void sellingPanelLabels(JPanel panel) {
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

    // effect: represents the text boxes of a seller
    public static void sellingPanelTextBoxes(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        Firstname = new JTextField();
        Firstname.setText(firstPart);
        Firstname.setBounds(100, 30, 165, 25);
        panel.add(Firstname);

        Lastname = new JTextField();
        Lastname.setText(secondPart);
        Lastname.setBounds(100, 70, 165, 25);
        panel.add(Lastname);

        email = new JTextField();
        email.setText(objEmail.toString());
        email.setBounds(100, 110, 165, 25);
        panel.add(email);

        phoneNumber = new JTextField();
        phoneNumber.setText(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 150, 165, 25);
        panel.add(phoneNumber);

        currentAddress = new JTextField();
        currentAddress.setText(objAddress.toString());
        currentAddress.setBounds(100, 190, 165, 25);
        panel.add(currentAddress);
    }

    // effect: represents the edited notes of a seller
    public static void sellingEditedNotes(JPanel panel) {
        notes = new JTextArea();
        notes.setText(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 385, 165, 150);
        panel.add(scroll);
    }

    // effect: represents housing types of the seller
    public static void sellingHousingOptions(JPanel panel) {
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

        String interested = objType.toString();
        interested = interested.replaceAll("\\[", "").replaceAll("\\]","");
        String[] items = interested.split("\\s*,\\s*");

        for (String item : items) {
            sellingCheckboxes(item);
        }
    }

    // effect: represents the update button of seller
    public static void sellingSubmitting(JPanel panel) {
        sellingSubmitButton = new JButton("Update!");
        sellingSubmitButton.setBounds(100, 550, 150, 25);
        sellingSubmitButton.addActionListener(new ContactList());
        panel.add(sellingSubmitButton);
    }

    // effect: represents the editing of a friend
    public static void editFriend() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
        frame.setTitle("Create a Contact");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        setBackButton(panel);
        intro(panel);
        friendPanelLabels(panel);
        friendEditedNotes(panel);
        friendPanelTextboxes(panel);
        friendSubmitting(panel);
    }

    // effect: represents back button of viewing
    public static void setBackButton(JPanel panel) {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new ContactList());
        panel.add(backButton);
    }

    // effect: represents the intro of a friend
    public static void intro(JPanel panel) {
        JLabel infoLabel = new JLabel("Edit the contact", SwingConstants.CENTER);
        infoLabel.setBounds(100, 0, 150, 25);
        panel.add(infoLabel);
    }

    // effect: represents the labels of a buyer
    public static void friendPanelLabels(JPanel panel) {
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

    // // effect: represents textboxes of a friend
    public static void friendPanelTextboxes(JPanel panel) {
        String[] name = wantToView.split(" ");
        String firstPart = name[0];
        String secondPart = name[1];

        Firstname = new JTextField();
        Firstname.setText(firstPart);
        Firstname.setBounds(100, 30, 165, 25);
        panel.add(Firstname);

        Lastname = new JTextField();
        Lastname.setText(secondPart);
        Lastname.setBounds(100, 70, 165, 25);
        panel.add(Lastname);

        phoneNumber = new JTextField();
        phoneNumber.setText(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 110, 165, 25);
        panel.add(phoneNumber);

        birthday = new JTextField();
        birthday.setText(objBirthday.toString());
        birthday.setBounds(100, 150, 165, 25);
        panel.add(birthday);

        currentAddress = new JTextField();
        currentAddress.setText(objAddress.toString());
        currentAddress.setBounds(100, 190, 165, 25);
        panel.add(currentAddress);
    }

    // effect: represents the edited notes of a friend
    public static void friendEditedNotes(JPanel panel) {
        notes = new JTextArea();
        notes.setText(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 230, 165, 150);
        panel.add(scroll);
    }

    // effect: represents the submit/update button of a friend
    public static void friendSubmitting(JPanel panel) {
        friendSubmitButton = new JButton("Update!");
        friendSubmitButton.setBounds(100, 400, 150, 25);
        friendSubmitButton.addActionListener(new ContactList());
        panel.add(friendSubmitButton);
    }

    // effect: represents the editing of service
    public static void editService() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
        frame.setTitle("Create a Contact");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 255, 152));
        panel.setLayout(null);
        frame.add(panel);

        setBackButton(panel);
        intro(panel);
        servicePanelLabels(panel);
        servicePanelLabels(panel);
        servicePanelTextboxes(panel);
        serviceSubmitting(panel);
    }

    // effect: represents the viewing of a edited service
    public static void servicePanelLabels(JPanel panel) {
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

    // effect: represents the textboxes of a service
    public static void servicePanelTextboxes(JPanel panel) {
        serviceName = new JTextField();
        serviceName.setText(wantToView);
        serviceName.setBounds(100, 30, 165, 25);
        panel.add(serviceName);

        phoneNumber = new JTextField();
        phoneNumber.setText(objPhoneNumber.toString());
        phoneNumber.setBounds(100, 70, 165, 25);
        panel.add(phoneNumber);

        email = new JTextField();
        email.setText(objEmail.toString());
        email.setBounds(100, 110, 165, 25);
        panel.add(email);

        type = new JTextField();
        type.setText(objType.toString());
        type.setBounds(100, 150, 165, 25);
        panel.add(type);

        notes = new JTextArea();
        notes.setText(objNotes.toString());
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(notes);
        scroll.setBounds(100, 190, 165, 150);
        panel.add(scroll);
    }

    // effect: represents the button submit of a service
    public static void serviceSubmitting(JPanel panel) {
        serviceSubmitButton = new JButton("Update!");
        serviceSubmitButton.setBounds(100, 400, 150, 25);
        serviceSubmitButton.addActionListener(new ContactList());
        panel.add(serviceSubmitButton);
    }

    // effect: represents user interaction buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            frame.dispose();
            Menu.mainWindow();
        }

        if (ae.getSource() == buyingButton) {
            frame.dispose();
            buyerView();
        }

        if (ae.getSource() == sellingButton) {
            frame.dispose();
            sellerView();
        }

        if (ae.getSource() == friendButton) {
            frame.dispose();
            friendView();
        }

        if (ae.getSource() == serviceButton) {
            frame.dispose();
            serviceView();
        }

        extentsion(ae);
    }

    // effect: is an extention to actionlistener
    public void extentsion(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            delete();
        }

        if (ae.getSource() == editButton) {
            frame.dispose();
            String source = reader.getSource();
            decider(source);
        }

        if (ae.getSource() == buyingSubmitButton) {
            buyerSubmitter();
        }

        if (ae.getSource() == sellingSubmitButton) {
            sellingSubmitter();
        }

        if (ae.getSource() == friendSubmitButton) {
            friendSubmitter();
        }

        if (ae.getSource() == serviceSubmitButton) {
            serviceSubmitter();
        }
    }



    // modifies: this
    // effect: creates edited buyer object
    public void buyerSubmitter() {
        frame.dispose();
        String inputFirstName = Firstname.getText();
        String inputLastName = Lastname.getText();
        String inputEmail = email.getText();
        String inputNumber = phoneNumber.getText();
        String inputAddress = currentAddress.getText();
        inputedInterest = new ArrayList<>();
        String inputNotes = notes.getText();

        interests();
        BuyingClient bc = new BuyingClient(inputFirstName, inputLastName, inputNumber, inputEmail, inputAddress,
                housingInterests, inputNotes);

        buyerWriter(bc);
        Menu.mainWindow();
    }

    // modifies: this
    // effect: selects what has been selected
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

        housingInterests = inputedInterest.toString();
    }

    // modifies: this
    // effect; writes to file through json object
    public void buyerWriter(BuyingClient bc) {
        String previous;
        try {
            JSONObject jsonObject = reader.stored();
            int i = reader.keys().size();
            String[] name = wantToView.split(" ");
            String firstPart = name[0];
            String secondPart = name[1];
            String combinedName = firstPart + secondPart;

            jsonObject.remove(combinedName);
            previous = jsonObject.toString();
            JsonWriter writer = new JsonWriter(reader.getSource());
            if (i > 1) {
                writer.prevDataLoad(previous);
            }
            writer.prevDataLoad("");
            writer.buyingWrite(bc, 0);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    // modifies: this
    // effect: creates a seller object
    public void sellingSubmitter() {
        frame.dispose();
        String inputFirstName = Firstname.getText();
        String inputLastName = Lastname.getText();
        String inputEmail = email.getText();
        String inputNumber = phoneNumber.getText();
        String inputAddress = currentAddress.getText();
        inputedInterest = new ArrayList<>();
        String inputNotes = notes.getText();

        sellingInterests();
        SellingClient sc = new SellingClient(inputFirstName, inputLastName, inputNumber, inputEmail, inputAddress,
                housingInterests, inputNotes);

        sellingWriter(sc);
        Menu.mainWindow();
    }

    // modifies: this
    // effect: selects options for sellers
    public static void sellingInterests() {
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

        housingInterests = inputedInterest.toString();
    }

    // modifies: this
    // effect; writes to file through json object
    public void sellingWriter(SellingClient sc) {
        String previous;
        try {
            JSONObject jsonObject = reader.stored();
            int i = reader.keys().size();
            String[] name = wantToView.split(" ");
            String firstPart = name[0];
            String secondPart = name[1];
            String combinedName = firstPart + secondPart;

            jsonObject.remove(combinedName);
            previous = jsonObject.toString();
            JsonWriter writer = new JsonWriter(reader.getSource());
            if (i > 1) {
                writer.prevDataLoad(previous);
            }
            writer.prevDataLoad("");
            writer.sellingWrite(sc, 0);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    // modifies: this
    // effect: creates friend object (edited)
    public void friendSubmitter() {
        frame.dispose();
        String inputFirstName = Firstname.getText();
        String inputLastName = Lastname.getText();
        String inputNumber = phoneNumber.getText();
        String inputBirthday = birthday.getText();
        String inputAddress = currentAddress.getText();
        String inputNotes = notes.getText();

        FriendContact fc = new FriendContact(inputFirstName, inputLastName, inputBirthday, inputNumber, inputAddress,
                inputNotes);

        friendWriter(fc);
        Menu.mainWindow();
    }

    // modifies: this
    // effect; writes to file through json object
    public void friendWriter(FriendContact fc) {
        String previous;
        try {
            JSONObject jsonObject = reader.stored();
            int i = reader.keys().size();
            String[] name = wantToView.split(" ");
            String firstPart = name[0];
            String secondPart = name[1];
            String combinedName = firstPart + secondPart;

            jsonObject.remove(combinedName);
            previous = jsonObject.toString();
            JsonWriter writer = new JsonWriter(reader.getSource());
            if (i > 1) {
                writer.prevDataLoad(previous);
            }
            writer.prevDataLoad("");
            writer.friendWrite(fc, 0);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    // modifies: this
    // effect; creates service object
    public void serviceSubmitter() {
        frame.dispose();
        String inputName = serviceName.getText();
        String inputNumber = phoneNumber.getText();
        String inputEmail = email.getText();
        String inputType = type.getText();
        String inputNotes = notes.getText();

        ServiceContact sc = new ServiceContact(inputName, inputNumber, inputEmail, inputType, inputNotes);

        serviceWriter(sc);
        Menu.mainWindow();
    }

    // modifies: this
    // effect; writes to file through json object
    public void serviceWriter(ServiceContact sc) {
        String previous;
        try {
            JSONObject jsonObject = reader.stored();
            int i = reader.keys().size();
            String[] name = wantToView.split(" ");
            String firstPart = name[0];
            String secondPart = name[1];
            String combinedName = firstPart + secondPart;

            jsonObject.remove(combinedName);
            previous = jsonObject.toString();
            JsonWriter writer = new JsonWriter(reader.getSource());
            if (i > 1) {
                writer.prevDataLoad(previous);
            }
            writer.prevDataLoad("");
            writer.serviceWrite(sc, 0);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

    }

    // effect; decides what edit to go down
    public void decider(String source) {
        switch (source) {
            case BUYING_STORE:
                editBuying();
                break;
            case SELLING_STORE:
                editSelling();
                break;
            case FRIEND_STORE:
                editFriend();
                break;
            case SERVICE_STORE:
                editService();
                break;
        }
    }

    // modifies: this
    // effect; deletes element of list
    public void delete() {
        String previous;
        try {
            JSONObject jsonObject = reader.stored();
            String[] name = wantToView.split(" ");
            String firstPart = name[0];
            String secondPart = name[1];
            String combinedName = firstPart + secondPart;

            jsonObject.remove(combinedName);
            previous = jsonObject.toString();
            try (FileWriter file = new FileWriter(reader.getSource())) {
                file.write(previous);
            } catch (Exception e) {
                System.out.println("Failure");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        frame.dispose();
        contacts();
    }
}