package model;

// Represents a contact who is a friend
public class FriendContact {
    private String firstName;
    private String lastName;
    private String birthday;
    private String phoneNumber;
    private String homeAddress;
    private String notes;

    // REQUIRES: firstName, lastName, birthday, phoneNumber, home address and notes must all be of non-zero length
    // EFFECTS: the fields of firstName, lastName, phoneNumber, email, currentAddress, notes
    //          are set to the parameters taken in by the constructor
    public FriendContact(String firstName, String lastName, String birthday, String phoneNumber, String homeAddress,
                         String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.notes = notes;
        EventLog.getInstance().logEvent(new Event("Created/edited friend: " + firstName + " " + lastName));
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
    // EFFECT: updates birthday
    public void editBirthday(String editedBirthday) {
        birthday = editedBirthday;
    }

    // MODIFIES: this
    // EFFECT: updates phone number
    public void editPhone(String editNumber) {
        phoneNumber = editNumber;
    }

    // MODIFIES: this
    // EFFECT: updates home address
    public void editHome(String editHomeAddress) {
        homeAddress = editHomeAddress;
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

    public String getBirthday() {
        return birthday;
    }

    public String getNumber() {
        return phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getNotes() {
        return notes;
    }
}
