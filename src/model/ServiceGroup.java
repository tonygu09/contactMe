package model;

import java.util.ArrayList;

// Represents a list of service people
public class ServiceGroup {
    private ArrayList<ServiceContact> serviceContacts;

    // EFFECT: Constructs a list of services
    public ServiceGroup() {
        this.serviceContacts = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECT: Adds services into the list of services
    public void addMember(ServiceContact servicers) {
        this.serviceContacts.add(servicers);
        EventLog.getInstance().logEvent(new Event("Added service to group: " + servicers.getName()));
    }

    // GET METHODS
    public int getNumMembers() {
        return this.serviceContacts.size();
    }

    public ArrayList<ServiceContact> getServices() {
        return serviceContacts;
    }

    // EFFECT: Gets the names of all service people who are under the list services
    public String getServiceNames() {
        String names = "";
        for (int i = 0; i < (getServices()).size(); i++) {
            names = names + ((getServices()).get(i)).getName() + "\n";
        }
        return names;
    }
}
