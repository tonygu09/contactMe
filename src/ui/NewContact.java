package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Prompts the user to create a new contact under a group
public class NewContact implements ActionListener {

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

    // Effect: Creates frame with panels
    public static void contactGroups() {
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

    // Effect: Creates panels with backgrounds and layouts
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

    // Effect: Creates back button to go to menu
    public static void backing() {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 75, 25);
        backButton.addActionListener(new NewContact());
        panel1.add(backButton);
    }

    // Effect: Creates elements on panels
    public static void panelElements() {
        backing();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel helloMessage = new JLabel("What group is your contact under?", SwingConstants.CENTER);
        helloMessage.setFont(new Font("Arial", Font.BOLD, 30));
        panel1.add(helloMessage, BorderLayout.CENTER);

        buyingButton = new JButton("Buying Client");
        buyingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyingButton.addActionListener(new NewContact());
        panel5.add(buyingButton);

        sellingButton = new JButton("Selling Client");
        sellingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sellingButton.addActionListener(new NewContact());
        panel5.add(sellingButton);

        friendButton = new JButton("Friend");
        friendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        friendButton.addActionListener(new NewContact());
        panel5.add(friendButton);

        serviceButton = new JButton("Service");
        serviceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        serviceButton.addActionListener(new NewContact());
        panel5.add(serviceButton);
    }

    // Effect: Deals with user button interactions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            frame.dispose();
            Menu.mainWindow();
        }

        if (ae.getSource() == buyingButton) {
            frame.dispose();
            BuyingCreation.init();
        }

        if (ae.getSource() == sellingButton) {
            frame.dispose();
            SellingCreation.init();
        }

        if (ae.getSource() == friendButton) {
            frame.dispose();
            FriendCreation.init();
        }

        if (ae.getSource() == serviceButton) {
            frame.dispose();
            ServiceCreation.init();
        }

    }
}
