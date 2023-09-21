package model;

// Represents a contact who is a client looking to sell a home
public class SellingClient {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String currentAddress;
    private String housingType;
    private String notes;

    // REQUIRES: firstName, lastName, phoneNumber, email, currentAddress and notes must all be of non-zero length
    // EFFECTS: the fields of firstName, lastName, phoneNumber, email, currentAddress, notes
    //          are set to the parameters taken in by the constructor
    public SellingClient(String firstName, String lastName, String phoneNumber, String email, String currentAddress,
                         String housingType, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.currentAddress = currentAddress;
        this.housingType = housingType;
        this.notes = notes;
        EventLog.getInstance().logEvent(new Event("Created/edited seller: " + firstName + " " + lastName));
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
    // EFFECT: updates number
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

    public void editHousingType(String editType) {
        housingType = editType;
    }

    // MODIFIES: this
    // EFFECT: updates notes
    public void editNotes(String editNote) {
        notes = editNote;
    }

    // GET METHODS
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

    public String getType() {
        return housingType;
    }

    public String getNotes() {
        return notes;
    }
}
