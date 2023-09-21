package model;

// Represents a contact who is a service provider
public class ServiceContact {
    private String serviceName;
    private String phoneNumber;
    private String email;
    private String typeOfService;
    private String notes;

    // REQUIRES: sericeName, phoneNumber, email, typeOfService and notes must all be of non-zero length
    // EFFECTS: the fields of sericeName, phoneNumber, email, typeOfService and notes are set to the parameters taken in
    //          by the constructor
    public ServiceContact(String serviceName, String phoneNumber, String email, String typeOfService, String notes) {
        this.serviceName = serviceName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfService = typeOfService;
        this.notes = notes;
        EventLog.getInstance().logEvent(new Event("Created/edited service: " + serviceName));
    }


    // MODIFIES: this
    // EFFECT: updates service name
    public void editServiceName(String editedName) {
        serviceName = editedName;
    }

    // MODIFIES: this
    // EFFECT: updates phone
    public void editNumber(String editedPhone) {
        phoneNumber = editedPhone;
    }

    // MODIFIES: this
    // EFFECT: updates email
    public void editEmail(String editedEmail) {
        email = editedEmail;
    }

    // MODIFIES: this
    // EFFECT: updates type of service
    public void editType(String editedTypeOfService) {
        typeOfService = editedTypeOfService;
    }

    // MODIFIES: this
    // EFFECT: updates notes
    public void editNotes(String editedNotes) {
        notes = editedNotes;
    }

    public String getName() {
        return serviceName;
    }

    public String getNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public String getNotes() {
        return notes;
    }
}
