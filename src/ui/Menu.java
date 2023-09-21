package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Menu page for user to decide what they want to do
public class Menu implements ActionListener {

    private static JFrame frame;
    private static JButton createButton;
    private static JButton viewButton;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private static JPanel panel4;
    private static JPanel panel5;

    // Effect: Creates frame with panels
    public static void mainWindow() {
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setTitle("Contacts Application");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        printer(frame);

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();

        panelling();
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

    // Effect: Adds background and layouts to panels
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
        panel4.setLayout(new BorderLayout());
        panel5.setLayout(new GridBagLayout());

        panelElements();
    }

    // Effect: Adds elements to panels
    public static void panelElements() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel helloMessage = new JLabel("Hello!", SwingConstants.CENTER);
        helloMessage.setFont(new Font("Arial", Font.BOLD, 30));
        panel1.add(helloMessage, BorderLayout.CENTER);

        createButton = new JButton("Create Contact");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createButton.addActionListener(new Menu());
        panel5.add(createButton);

        viewButton = new JButton("Edit/View Contacts");
        viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewButton.addActionListener(new Menu());
        panel5.add(viewButton);

        ImageIcon imageIcon = new ImageIcon("data/download.jpg"); // Replace with your image path
        int desiredWidth = 100;
        int desiredHeight = 100;
        Image scaledImage = imageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        panel3.add(imageLabel, BorderLayout.PAGE_START);

    }

    // Effect: deals with user button interaction
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == createButton) {
            frame.dispose();
            NewContact.contactGroups();
        }
        if (ae.getSource() == viewButton) {
            frame.dispose();
            ContactList.contacts();
        }
    }
}
