package ui;

import model.*;
import org.json.JSONException;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ContactMe {
    private static final String BUYING_STORE = "data/BuyingContactInfo.json";
    private static final String SELLING_STORE = "data/SellingContactInfo.json";
    private static final String FRIEND_STORE = "data/FriendContactInfo.json";
    private static final String SERVICE_STORE = "data/ServiceContactInfo.json";
    private Scanner optionScanner;
    private BuyingGroup buyers;
    private FriendGroup friends;
    private SellingGroup sellers;
    private ServiceGroup servicers;
    private String viewContact;
    private String satisfaction;
    private String issue;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECT: runs the ContactMe application
    public ContactMe() throws FileNotFoundException  {
        runContact();
    }

    // MODIFIES: this
    // EFFECT: processes user input
    public void runContact() {
        int selection;
        scannerInit();
        do {
            menu();
            selection = optionScanner.nextInt();
            process(selection);
        } while (selection != 3);
    }

    // MODIFIES: this
    // EFFECT: initializes Scanner
    public void scannerInit() {
        optionScanner = new Scanner(System.in);
        buyers = new BuyingGroup();
        sellers = new SellingGroup();
        friends = new FriendGroup();
        servicers = new ServiceGroup();
    }

    // EFFECT: displays menu of options to users
    public void menu() {
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> new contact");
        System.out.println("\t2 -> view/edit contact");
        System.out.println("\t3 -> quit");
    }

    // EFFECT: process input from the menu
    public void process(int selection) {
        switch (selection) {
            case 1:
                createContact();
                break;
            case 2:
                listContact();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("That was not one of the options...");
        }
    }

    // MODIFIES: this
    // EFFECT: User selects what group they would like to create a contact under
    public void createContact() {
        int contactSelection;
        System.out.println("What group would you like to create the contact under?");
        contactMenu();
        contactSelection = optionScanner.nextInt();
        contactProcess(contactSelection);
    }

    // EFFECT: Displays the different groups the user can create a contact under
    public void contactMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> buying client");
        System.out.println("\t2 -> selling client");
        System.out.println("\t3 -> friends");
        System.out.println("\t4 -> services");
    }

    // EFFECT: process input from the menu
    public void contactProcess(int contactSelection) {
        switch (contactSelection) {
            case 1:
                buyingCreation();
                break;
            case 2:
                sellingCreation();
                break;
            case 3:
                friendCreation();
                break;
            case 4:
                serviceCreation();
                break;
            default:
                System.out.println("That was not one of the options");
        }
    }

    // MODIFIES: this
    // EFFECT: creates a new buying client contact based on user input
    public void buyingCreation() {
        optionScanner.nextLine();

        System.out.println("What is their first name?");
        String firstName = optionScanner.nextLine();

        System.out.println("What is their last name?");
        String lastName = optionScanner.nextLine();

        System.out.println("What is their phone number?");
        String phoneNumber = optionScanner.nextLine();

        System.out.println("What is their email?");
        String email = optionScanner.nextLine();

        System.out.println("What is their current address?");
        String currentAddress = optionScanner.nextLine();

        System.out.println("What are addresses of their interested listings?");
        String interestedListing = optionScanner.nextLine();

        System.out.println("Would you like to record some notes on them?");
        String notes = optionScanner.nextLine();

        BuyingClient buyer = new BuyingClient(firstName, lastName, phoneNumber, email, currentAddress,
                interestedListing, notes);
        buyers.addMember(buyer);

        saveBuyer(buyer);
    }

    // EFFECT: Creates jsonObject to store buyer
    public void saveBuyer(BuyingClient bc) {
        System.out.println("Would you like to save this contact? (\"Yes\" or \"No\")");
        String choice = optionScanner.nextLine();
        if ((choice).equalsIgnoreCase("yes")) {
            jsonWriter = new JsonWriter(BUYING_STORE);
            try {
                jsonReader = new JsonReader(BUYING_STORE);
                //jsonWriter.prevDataLoad(jsonReader.prevData());
                jsonWriter.open();
                //jsonWriter.buyingWrite(bc);
                // jsonWriter.close();
                System.out.println("Saved");
            } catch (Exception e) {
                System.out.println("Unable to write to file: " + BUYING_STORE);
            }
        } else {
            System.out.println("Contact Created but not saved");
        }
    }

    // MODIFIES: this
    // EFFECT: creates a new selling client contact based on user input
    public void sellingCreation() {
        optionScanner.nextLine();

        System.out.println("What is their first name?");
        String firstName = optionScanner.nextLine();

        System.out.println("What is their last name?");
        String lastName = optionScanner.nextLine();

        System.out.println("What is their phone number?");
        String phoneNumber = optionScanner.nextLine();

        System.out.println("What is their email?");
        String email = optionScanner.nextLine();

        System.out.println("What is their current address?");
        String currentAddress = optionScanner.nextLine();

        System.out.println("Would you like to record some notes on them?");
        String notes = optionScanner.nextLine();

        SellingClient seller = new SellingClient(firstName, lastName, phoneNumber, email, currentAddress, "",
                notes);
        sellers.addMember(seller);

        saveSeller(seller);
    }

    // EFFECT: Creates jsonObject to store seller
    public void saveSeller(SellingClient sc) {
        System.out.println("Would you like to save this contact? (\"Yes\" or \"No\")");
        String choice = optionScanner.nextLine();
        if ((choice).equalsIgnoreCase("yes")) {
            jsonWriter = new JsonWriter(SELLING_STORE);
            try {
                jsonReader = new JsonReader(BUYING_STORE);
                //jsonWriter.prevDataLoad(jsonReader.prevData());
                jsonWriter.open();
                //jsonWriter.sellingWrite(sc);
                // jsonWriter.close();
                System.out.println("Saved");
            } catch (Exception e) {
                System.out.println("Unable to write to file: " + SELLING_STORE);
            }
        } else {
            System.out.println("Contact Created but not saved");
        }
    }

    // MODIFIES: this
    // EFFECT: creates a new friend contact based on user input
    public void friendCreation() {
        optionScanner.nextLine();

        System.out.println("What is their first name?");
        String firstName = optionScanner.nextLine();

        System.out.println("What is their last name?");
        String lastName = optionScanner.nextLine();

        System.out.println("When is their birthday? (YYYY/DD?MM)");
        String birthday = optionScanner.nextLine();

        System.out.println("What is their phone number?");
        String phoneNumber = optionScanner.nextLine();

        System.out.println("What is their home address?");
        String homeAddress = optionScanner.nextLine();

        System.out.println("Would you like to record some notes on them?");
        String notes = optionScanner.nextLine();

        FriendContact friend = new FriendContact(firstName, lastName, birthday, phoneNumber, homeAddress, notes);
        friends.addMember(friend);

        System.out.println("Would you like to save this contact? (\"Yes\" or \"No\")");
        String choice = optionScanner.nextLine();
        if ((choice).equalsIgnoreCase("yes")) {
            saveFriend(friend);
        } else {
            System.out.println("Contact Created but not saved");
        }
    }

    // EFFECT: Creates jsonObject to store friend
    public void saveFriend(FriendContact fc) {
        jsonWriter = new JsonWriter(FRIEND_STORE);
        try {
            jsonReader = new JsonReader(BUYING_STORE);
            // jsonWriter.prevDataLoad(jsonReader.prevData());
            jsonWriter.open();
            // jsonWriter.friendWrite(fc);
            // jsonWriter.close();
            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println("Unable to write to file: " + FRIEND_STORE);
        }
    }

    // MODIFIES: this
    // EFFECT: creates a new service contact based on user input
    public void serviceCreation() {
        optionScanner.nextLine();

        System.out.println("What is the service name?");
        String serviceName = optionScanner.nextLine();

        System.out.println("What is their phone number?");
        String phoneNumber = optionScanner.nextLine();

        System.out.println("What is their email?");
        String email = optionScanner.nextLine();

        System.out.println("What type of service do they offer?");
        String typeOfService = optionScanner.nextLine();

        System.out.println("Would you like to record some notes on them?");
        String notes = optionScanner.nextLine();

        ServiceContact service = new ServiceContact(serviceName, phoneNumber, email, typeOfService, notes);
        servicers.addMember(service);

        System.out.println("Would you like to save this contact? (\"Yes\" or \"No\")");
        String choice = optionScanner.nextLine();
        if ((choice).equalsIgnoreCase("yes")) {
            saveService(service);
        } else {
            System.out.println("Contact Created but not saved");
        }
    }

    // EFFECT: Creates jsonObject to store service
    public void saveService(ServiceContact sc) {
        jsonWriter = new JsonWriter(SERVICE_STORE);
        try {
            jsonReader = new JsonReader(BUYING_STORE);
            //jsonWriter.prevDataLoad(jsonReader.prevData());
            jsonWriter.open();
            // jsonWriter.serviceWrite(sc);
            // jsonWriter.close();
            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println("Unable to write to file: " + SERVICE_STORE);
        }
    }

    // MODIFIES: this
    // EFFECT: User selects what group they would like to view
    public void listContact() {
        int listSelection;
        System.out.println("What group would you like view?");
        viewMenu();
        listSelection = optionScanner.nextInt();
        viewProcess(listSelection);
    }

    // EFFECT: Prints a menu for the user
    public void viewMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> buying client");
        System.out.println("\t2 -> selling client");
        System.out.println("\t3 -> friends");
        System.out.println("\t4 -> services");
    }

    // EFFECT: process input from the menu
    public void viewProcess(int listSelection) {
        switch (listSelection) {
            case 1:
                viewBuyers();
                contactViewingBuying();
                break;
            case 2:
                viewSellers();
                contactViewingSelling();
                break;
            case 3:
                viewFriends();
                contactViewingFriends();
                break;
            case 4:
                viewServices();
                contactViewingServices();
                break;
            default:
                System.out.println("That was not one of the options.");
                break;
        }
    }

    // EFFECT: Displays all the buyer contacts that the user has created
    public void viewBuyers() {
        optionScanner.nextLine();
        int savedSize = 0;
        try {
            System.out.println("Would you like to view buyers stored as well? (enter \"yes\" or \"no\")");
            String choice = optionScanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                try {
                    jsonReader = new JsonReader(BUYING_STORE);
                    savedSize = (jsonReader.keys()).size();
                    System.out.println(jsonReader.keys());
                } catch (IOException | JSONException io) {
                    System.out.println("You have not saved any contacts");
                }
            }

            System.out.println("There are currently " + (savedSize + buyers.getNumMembers()) + " people in this group");
            System.out.println("The people under this group who: ");
            System.out.println(buyers.getBuyerNames());
        } catch (NullPointerException e) {
            System.out.println("You have not created any contacts yet");
        }
    }

    // EFFECT: Displays all the seller contacts that the user has created
    public void viewSellers() {
        optionScanner.nextLine();
        int savedSize = 0;
        try {
            System.out.println("Would you like to view buyers stored as well? (enter \"yes\" or \"no\")");
            String choice = optionScanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                try {
                    jsonReader = new JsonReader(SELLING_STORE);
                    savedSize = (jsonReader.keys()).size();
                    System.out.println(jsonReader.keys());
                } catch (IOException | JSONException io) {
                    System.out.println("You have not saved any contacts");
                }
            }
            System.out.println("There are currently " + (savedSize + sellers.getNumMembers()) + " people in this "
                    + "group");
            System.out.println("The people under this group are: ");
            System.out.println(sellers.getSellersNames());
        } catch (NullPointerException e) {
            System.out.println("You have not created any contacts yet");
        }
    }

    // EFFECT: Displays all the friend contacts that the user has created
    public void viewFriends() {
        optionScanner.nextLine();
        int savedSize = 0;
        try {
            System.out.println("Would you like to view buyers stored as well? (enter \"yes\" or \"no\")");
            String choice = optionScanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                try {
                    jsonReader = new JsonReader(FRIEND_STORE);
                    savedSize = (jsonReader.keys()).size();
                    System.out.println(jsonReader.keys());
                    System.out.println(jsonReader.stored().toString());
                } catch (IOException | JSONException io) {
                    System.out.println("You have not saved any contacts");
                }
            }
            System.out.println("There are currently " + (savedSize + friends.getNumMembers()) + " people in this "
                    + "group");
            System.out.println("The people under this group are: ");
            System.out.println(friends.getFriendNames());
        } catch (NullPointerException e) {
            System.out.println("You have not created any contacts yet");
        }
    }

    // EFFECT: Displays all the service contacts that the user has created
    public void viewServices() {
        optionScanner.nextLine();
        int savedSize = 0;
        try {
            System.out.println("Would you like to view buyers stored as well? (enter \"yes\" or \"no\")");
            String choice = optionScanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                try {
                    jsonReader = new JsonReader(SERVICE_STORE);
                    savedSize = (jsonReader.keys()).size();
                    System.out.println(jsonReader.keys());
                } catch (IOException | JSONException io) {
                    System.out.println("You have not saved any contacts");
                }
            }

            System.out.println("There are currently " + (savedSize + servicers.getNumMembers()) + " people in this "
                    + "group");
            System.out.println("The people under this group are: ");
            System.out.println(servicers.getServiceNames());
        } catch (NullPointerException e) {
            System.out.println("You have not created any contacts yet");
        }
    }

    // EFFECT: Displays the information of a particular contact under the buying group
    public void contactViewingBuying() {
        System.out.println("\nWould you like to view one of the contacts above? (Enter \"yes\" or \"no\")");
        String choice = optionScanner.next();
        if (choice.equals("yes")) {
            optionScanner.nextLine();
            System.out.println("What is the name of the contact you would like to view?");
            viewContact = optionScanner.nextLine();
            for (int i = 0; i < (buyers.getBuyers()).size(); i++) {
                if ((((buyers.getBuyers()).get(i)).getName()).equals(viewContact)) {
                    System.out.println("Below is their information: ");
                    System.out.println("\t" + ((buyers.getBuyers()).get(i)).getName());
                    System.out.println("\t" + ((buyers.getBuyers()).get(i)).getNumber());
                    System.out.println("\t" + ((buyers.getBuyers()).get(i)).getEmail());
                    System.out.println("\t" + ((buyers.getBuyers()).get(i)).getCurrentAddress());
                    System.out.println("\t" + ((buyers.getBuyers()).get(i)).getInterestedListing());
                    System.out.println("\t" + ((buyers.getBuyers()).get(i)).getNotes());
                    editBOptions((buyers.getBuyers()).get(i));
                } else {
                    System.out.println("Information cannot be traced");
                }
            }
        } else {
            System.out.println("No contacts have been viewed");
        }
    }

    // EFFECT: Displays the information of a particular contact under the selling group
    public void contactViewingSelling() {
        System.out.println("\nWould you like to view one of the contacts above? (Enter \"yes\" or \"no\")");
        String choice = optionScanner.next();
        if (choice.equals("yes")) {
            optionScanner.nextLine();
            System.out.println("What is the name of the contact you would like to view?");
            viewContact = optionScanner.nextLine();
            for (int i = 0; i < (sellers.getSellers()).size(); i++) {
                if ((((sellers.getSellers()).get(i)).getName()).equals(viewContact)) {
                    System.out.println("Below is their information: ");
                    System.out.println("\t" + ((sellers.getSellers()).get(i)).getName());
                    System.out.println("\t" + ((sellers.getSellers()).get(i)).getNumber());
                    System.out.println("\t" + ((sellers.getSellers()).get(i)).getEmail());
                    System.out.println("\t" + ((sellers.getSellers()).get(i)).getCurrentAddress());
                    System.out.println("\t" + ((sellers.getSellers()).get(i)).getNotes());
                    editSOptions((sellers.getSellers()).get(i));
                } else {
                    System.out.println("Information cannot be traced");
                }
            }
        } else {
            System.out.println("No contacts have been viewed");
        }
    }

    // EFFECT: Displays the information of a particular contact under the friend group
    public void contactViewingFriends() {
        System.out.println("\nWould you like to view one of the contacts above? (Enter \"yes\" or \"no\")");
        String choice = optionScanner.next();
        if (choice.equals("yes")) {
            optionScanner.nextLine();
            System.out.println("What is the name of the contact you would like to view?");
            viewContact = optionScanner.nextLine();
            for (int i = 0; i < (friends.getFriends()).size(); i++) {
                if ((((friends.getFriends()).get(i)).getName()).equals(viewContact)) {
                    System.out.println("Below is their information: ");
                    System.out.println("\t" + ((friends.getFriends()).get(i)).getName());
                    System.out.println("\t" + ((friends.getFriends()).get(i)).getBirthday());
                    System.out.println("\t" + ((friends.getFriends()).get(i)).getNumber());
                    System.out.println("\t" + ((friends.getFriends()).get(i)).getHomeAddress());
                    System.out.println("\t" + ((friends.getFriends()).get(i)).getNotes());
                    editFOptions((friends.getFriends()).get(i));
                } else {
                    System.out.println("Information cannot be traced");
                }
            }
        } else {
            System.out.println("No contacts have been viewed");
        }
    }

    // EFFECT: Displays the information of a particular contact under the service group
    public void contactViewingServices() {
        System.out.println("\nWould you like to view one of the contacts above? (Enter \"yes\" or \"no\")");
        String choice = optionScanner.next();
        if (choice.equals("yes")) {
            optionScanner.nextLine();
            System.out.println("What is the name of the contact you would like to view?");
            viewContact = optionScanner.nextLine();
            for (int i = 0; i < (servicers.getServices()).size(); i++) {
                if ((((servicers.getServices()).get(i)).getName()).equals(viewContact)) {
                    System.out.println("Below is their information: ");
                    System.out.println("\t" + ((servicers.getServices()).get(i)).getName());
                    System.out.println("\t" + ((servicers.getServices()).get(i)).getNumber());
                    System.out.println("\t" + ((servicers.getServices()).get(i)).getEmail());
                    System.out.println("\t" + ((servicers.getServices()).get(i)).getTypeOfService());
                    System.out.println("\t" + ((servicers.getServices()).get(i)).getNotes());
                    editSEOptions((servicers.getServices()).get(i));
                } else {
                    System.out.println("Information cannot be traced");
                }
            }
        } else {
            System.out.println("No contacts have been viewed");
        }
    }

    // EFFECT: Prompts the user if they would like to edit the information of the contact
    public void editBOptions(BuyingClient buyer) {
        System.out.println("Are you satisfied with their information? (Enter \"yes\" or \"no\")");
        satisfaction = optionScanner.nextLine();
        if (satisfaction.equals("yes")) {
            System.out.println("No editing was done");
        } else {
            System.out.println("What about their information would you like to edit?");
            System.out.println("Please type in one of the following fields: ");
            System.out.println("\tFirst Name");
            System.out.println("\tLast Name");
            System.out.println("\tPhone Number");
            System.out.println("\tEmail");
            System.out.println("\tCurrent Address");
            System.out.println("\tInterested Listings");
            System.out.println("\tNotes");
            issue = optionScanner.nextLine();
            editBuyers(issue, buyer);
        }
    }

    // EFFECT: processes user selection from editBOptions()
    public void editBuyers(String editArea, BuyingClient buyer) {
        switch (editArea) {
            case "First Name":
                editBuyerFirst(buyer);
                break;
            case "Last Name":
                editBuyerLast(buyer);
                break;
            case "Phone Number":
                editBuyerNumber(buyer);
                break;
            case "Email":
                editBuyerEmail(buyer);
                break;
            case "Current Address":
                editBuyerCurrent(buyer);
                break;
            case "Interested Listings":
                editInterested(buyer);
                break;
            case "Notes":
                editNotes(buyer);
                break;
        }
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated first name should be
    public void editBuyerFirst(BuyingClient buyer) {
        System.out.println("What is the edited first name?");
        String editedFirst = optionScanner.nextLine();
        buyer.editFirstName(editedFirst);
        System.out.println("Update name to: " + buyer.getName());
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated last name should be
    public void editBuyerLast(BuyingClient buyer) {
        System.out.println("What is the edited last name?");
        String editedLast = optionScanner.nextLine();
        buyer.editLastName(editedLast);
        System.out.println("Update name to: " + buyer.getName());
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated buyer number should be
    public void editBuyerNumber(BuyingClient buyer) {
        System.out.println("What is the edited phone number?");
        String editedNumber = optionScanner.nextLine();
        buyer.editPhone(editedNumber);
        System.out.println("Update name to: " + buyer.getNumber());
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated email should be
    public void editBuyerEmail(BuyingClient buyer) {
        System.out.println("What is the edited email?");
        String editedEmail = optionScanner.nextLine();
        buyer.editEmail(editedEmail);
        System.out.println("Update name to: " + buyer.getEmail());
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated current address should be
    public void editBuyerCurrent(BuyingClient buyer) {
        System.out.println("What is the edited current address?");
        String editedAddress = optionScanner.nextLine();
        buyer.editCurrentAddress(editedAddress);
        System.out.println("Update name to: " + buyer.getCurrentAddress());
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated interested listings should be
    public void editInterested(BuyingClient buyer) {
        System.out.println("What is the edited interested listings?");
        String editedInterested = optionScanner.nextLine();
        buyer.editInterestedListing(editedInterested);
        System.out.println("Update name to: " + buyer.getInterestedListing());
    }

    // MODIFIES: this, buyer
    // EFFECTS: user input for what updated notes for the buyer should be
    public void editNotes(BuyingClient buyer) {
        System.out.println("What is the edited notes?");
        String editedNotes = optionScanner.nextLine();
        buyer.editNotes(editedNotes);
        System.out.println("Update name to: " + buyer.getNotes());
    }

    // EFFECT: Prompts the user if they would like to edit the information of the contact
    public void editSOptions(SellingClient seller) {
        System.out.println("Are you satisfied with their information? (Enter \"yes\" or \"no\")");
        satisfaction = optionScanner.nextLine();
        if (satisfaction.equals("yes")) {
            System.out.println("No editing was done");
        } else {
            System.out.println("What about their information would you like to edit?");
            System.out.println("Please type in one of the following fields: ");
            System.out.println("\tFirst Name");
            System.out.println("\tLast Name");
            System.out.println("\tPhone Number");
            System.out.println("\tEmail");
            System.out.println("\tCurrent Address");
            System.out.println("\tNotes");
            issue = optionScanner.nextLine();
            editSellers(issue, seller);
        }
    }

    // EFFECT: processes user selection from editSOptions()
    public void editSellers(String editArea, SellingClient sellers) {
        switch (editArea) {
            case "First Name":
                editSellerFirst(sellers);
                break;
            case "Last Name":
                editSellerLast(sellers);
                break;
            case "Phone Number":
                editSellerNumber(sellers);
                break;
            case "Email":
                editSellerEmail(sellers);
                break;
            case "Current Address":
                editSellerCurrent(sellers);
                break;
            case "Notes":
                editSellerNotes(sellers);
                break;
        }
    }

    // MODIFIES: this, seller
    // EFFECTS: user input for what updated first name should be
    public void editSellerFirst(SellingClient seller) {
        System.out.println("What is the edited first name?");
        String editedFirst = optionScanner.nextLine();
        seller.editFirstName(editedFirst);
        System.out.println("Update name to: " + seller.getName());
    }

    // MODIFIES: this, seller
    // EFFECTS: user input for what updated last name should be
    public void editSellerLast(SellingClient seller) {
        System.out.println("What is the edited last name?");
        String editedLast = optionScanner.nextLine();
        seller.editLastName(editedLast);
        System.out.println("Update name to: " + seller.getName());
    }

    // MODIFIES: this, seller
    // EFFECTS: user input for what updated seller phone number should be
    public void editSellerNumber(SellingClient seller) {
        System.out.println("What is the edited phone number?");
        String editedNumber = optionScanner.nextLine();
        seller.editPhone(editedNumber);
        System.out.println("Update name to: " + seller.getNumber());
    }

    // MODIFIES: this, seller
    // EFFECTS: user input for what updated email should be
    public void editSellerEmail(SellingClient seller) {
        System.out.println("What is the edited email?");
        String editedEmail = optionScanner.nextLine();
        seller.editEmail(editedEmail);
        System.out.println("Update name to: " + seller.getEmail());
    }

    // MODIFIES: this, seller
    // EFFECTS: user input for what updated current address should be
    public void editSellerCurrent(SellingClient seller) {
        System.out.println("What is the edited current address?");
        String editedAddress = optionScanner.nextLine();
        seller.editCurrentAddress(editedAddress);
        System.out.println("Update name to: " + seller.getCurrentAddress());
    }

    // MODIFIES: this, seller
    // EFFECTS: user input for what updated notes should be
    public void editSellerNotes(SellingClient seller) {
        System.out.println("What is the edited notes?");
        String editedNotes = optionScanner.nextLine();
        seller.editNotes(editedNotes);
        System.out.println("Update name to: " + seller.getNotes());
    }

    // EFFECT: Prompts the user if they would like to edit the information of the contact
    public void editFOptions(FriendContact friend) {
        System.out.println("Are you satisfied with their information? (Enter \"yes\" or \"no\")");
        satisfaction = optionScanner.nextLine();
        if (satisfaction.equals("yes")) {
            System.out.println("No editing was done");
        } else {
            System.out.println("What about their information would you like to edit?");
            System.out.println("Please type in one of the following fields: ");
            System.out.println("\tFirst Name");
            System.out.println("\tLast Name");
            System.out.println("\tPhone Number");
            System.out.println("\tBirthday");
            System.out.println("\tHome Address");
            System.out.println("\tNotes");
            issue = optionScanner.nextLine();
            editFriend(issue, friend);
        }
    }

    // EFFECT: processes user selection from editFOptions()
    public void editFriend(String editArea, FriendContact friend) {
        switch (editArea) {
            case "First Name":
                editFriendFirst(friend);
                break;
            case "Last Name":
                editFriendLast(friend);
                break;
            case "Phone Number":
                editFriendNumber(friend);
                break;
            case "Birthday":
                editFriendBirthday(friend);
                break;
            case "Home Address":
                editFriendHome(friend);
                break;
            case "Notes":
                editFriendNotes(friend);
                break;
        }
    }

    // MODIFIES: this, friend
    // EFFECTS: user input for what updated first name should be
    public void editFriendFirst(FriendContact friend) {
        System.out.println("What is the edited first name?");
        String editedFirst = optionScanner.nextLine();
        friend.editFirstName(editedFirst);
        System.out.println("Update name to: " + friend.getName());
    }

    // MODIFIES: this, friend
    // EFFECTS: user input for what updated last name should be
    public void editFriendLast(FriendContact friend) {
        System.out.println("What is the edited last name?");
        String editedLast = optionScanner.nextLine();
        friend.editLastName(editedLast);
        System.out.println("Update name to: " + friend.getName());
    }

    // MODIFIES: this, friend
    // EFFECTS: user input for what updated phone number should be
    public void editFriendNumber(FriendContact friend) {
        System.out.println("What is the edited phone number?");
        String editedNumber = optionScanner.nextLine();
        friend.editPhone(editedNumber);
        System.out.println("Update name to: " + friend.getNumber());
    }

    // MODIFIES: this, friend
    // EFFECTS: user input for what updated birthday should be
    public void editFriendBirthday(FriendContact friend) {
        System.out.println("What is the edited birthday?");
        String editedBirthday = optionScanner.nextLine();
        friend.editBirthday(editedBirthday);
        System.out.println("Update name to: " + friend.getBirthday());
    }

    // MODIFIES: this, friend
    // EFFECTS: user input for what updated home address should be
    public void editFriendHome(FriendContact friend) {
        System.out.println("What is the edited home address?");
        String editedAddress = optionScanner.nextLine();
        friend.editHome(editedAddress);
        System.out.println("Update name to: " + friend.getHomeAddress());
    }

    // MODIFIES: this, friend
    // EFFECTS: user input for what updated notes should be
    public void editFriendNotes(FriendContact friend) {
        System.out.println("What is the edited notes?");
        String editedNotes = optionScanner.nextLine();
        friend.editNotes(editedNotes);
        System.out.println("Update name to: " + friend.getNotes());
    }


    // EFFECT: Prompts the user if they would like to edit the information of the contact
    public void editSEOptions(ServiceContact service) {
        System.out.println("Are you satisfied with their information? (Enter \"yes\" or \"no\")");
        satisfaction = optionScanner.nextLine();
        if (satisfaction.equals("yes")) {
            System.out.println("No editing was done");
        } else {
            System.out.println("What about their information would you like to edit?");
            System.out.println("Please type in one of the following fields: ");
            System.out.println("\tService Name");
            System.out.println("\tPhone Number");
            System.out.println("\tEmail");
            System.out.println("\tType of Service");
            System.out.println("\tNotes");
            issue = optionScanner.nextLine();
            editService(issue, service);
        }
    }

    // EFFECT: processes user selection from editSEOptions()
    public void editService(String editArea, ServiceContact service) {
        switch (editArea) {
            case "Service Name":
                editServiceName(service);
                break;
            case "Phone Number":
                editServiceNumber(service);
                break;
            case "Email":
                editServiceEmail(service);
                break;
            case "Type of Service":
                editServiceType(service);
                break;
            case "Notes":
                editServiceNote(service);
                break;
        }
    }

    // MODIFIES: this, service
    // EFFECTS: user input for what updated service name should be
    public void editServiceName(ServiceContact service) {
        System.out.println("What is the edited service name?");
        String editedServiceName = optionScanner.nextLine();
        service.editServiceName(editedServiceName);
        System.out.println("Update name to: " + service.getName());
    }

    // MODIFIES: this, service
    // EFFECTS: user input for what updated phone number should be
    public void editServiceNumber(ServiceContact service) {
        System.out.println("What is the edited phone name?");
        String editedNumber = optionScanner.nextLine();
        service.editNumber(editedNumber);
        System.out.println("Update name to: " + service.getNumber());
    }

    // MODIFIES: this, service
    // EFFECTS: user input for what updated email should be
    public void editServiceEmail(ServiceContact service) {
        System.out.println("What is the edited email?");
        String editedEmail = optionScanner.nextLine();
        service.editEmail(editedEmail);
        System.out.println("Update name to: " + service.getEmail());
    }

    // MODIFIES: this, service
    // EFFECTS: user input for what updated service type should be
    public void editServiceType(ServiceContact service) {
        System.out.println("What is the edited type of service?");
        String editedType = optionScanner.nextLine();
        service.editType(editedType);
        System.out.println("Update name to: " + service.getTypeOfService());
    }

    // MODIFIES: this, service
    // EFFECTS: user input for what updated note should be
    public void editServiceNote(ServiceContact service) {
        System.out.println("What is the edited phone number?");
        String editedNotes = optionScanner.nextLine();
        service.editNotes(editedNotes);
        System.out.println("Update name to: " + service.getNotes());
    }
}