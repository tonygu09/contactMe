package model;

// Represents a contact who is a client looking to buy a home
public class BuyingClient {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String currentAddress;
    private String interestedListing;
    private String notes;

    // REQUIRES: firstName, lastName, phoneNumber, email, currentAddress, interestedListing and notes must all be of
    //           non-zero length
    // EFFECTS: the fields of firstName, lastName, phoneNumber, email, currentAddress, interestedListing, notes
    //          are set to the parameters taken in by the constructor
    public BuyingClient(String firstName, String lastName, String phoneNumber, String email, String currentAddress,
                        String interestedListing, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.currentAddress = currentAddress;
        this.interestedListing = interestedListing;
        this.notes = notes;
        EventLog.getInstance().logEvent(new Event("Created/edited buyer: " + firstName + " " + lastName));
    }

    // MODIFIES: this
    // EFFECT: updates first name
    public void editFirstName(String editFirstName) {
        firstName = editFirstName;
    }

    // MODIFIES: this
    // EFFECT: updates last name
    public void editLastName(String editLastName) {
        lastName = editLastName;
    }

    // MODIFIES: this
    // EFFECT: updates phone number
    public void editPhone(String editNumber) {
        phoneNumber = editNumber;
    }

    // MODIFIES: this
    // EFFECT: updates email
    public void editEmail(String editEmail) {
        email = editEmail;
    }

    // MODIFIES: this
    // EFFECT: updates current address
    public void editCurrentAddress(String editCurrent) {
        currentAddress = editCurrent;
    }

    // MODIFIES: this
    // EFFECT: updates the interested listings
    public void editInterestedListing(String editInterest) {
        interestedListing = editInterest;
    }

    // MODIFIES: this
    // EFFECT: updates notes
    public void editNotes(String editNote) {
        notes = editNote;
    }

    // Get methods
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getInterestedListing() {
        return interestedListing;
    }

    public String getNotes() {
        return notes;
    }
}
