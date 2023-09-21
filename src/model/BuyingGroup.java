package model;

import java.util.List;
import java.util.ArrayList;

// Represents a list of clients who are looking to buy
public class BuyingGroup {
    private ArrayList<BuyingClient> buyingClients;

    // EFFECT: Constructs a list of clients who are looking to buy
    public BuyingGroup() {
        this.buyingClients = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECT: Adds buyer into the list of buyers
    public void addMember(BuyingClient buyers) {
        this.buyingClients.add(buyers);
        EventLog.getInstance().logEvent(new Event("Added buyer to group: " + buyers.getName()));
    }

    // Get methods
    public int getNumMembers() {
        return this.buyingClients.size();
    }

    public ArrayList<BuyingClient> getBuyers() {
        return buyingClients;
    }

    // EFFECT: Gets the names of all clients who are under the list buyer
    public String getBuyerNames() {
        String names = "";
        for (int i = 0; i < (getBuyers()).size(); i++) {
            names = names + ((getBuyers()).get(i)).getName() + "\n";
        }
        return names;
    }
}
