package model;

import java.util.ArrayList;

// Represents a list of clients who are looking to sell their home
public class SellingGroup {
    private ArrayList<SellingClient> sellingClients;

    // EFFECT: Constructs a list of clients who are looking to sell
    public SellingGroup() {
        this.sellingClients = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECT: Adds sellers into the list of sellers
    public void addMember(SellingClient sellers) {
        this.sellingClients.add(sellers);
        EventLog.getInstance().logEvent(new Event("Added seller to group: " + sellers.getName()));
    }

    // GET METHODS
    public int getNumMembers() {
        return this.sellingClients.size();
    }

    public ArrayList<SellingClient> getSellers() {
        return sellingClients;
    }

    // EFFECT: Gets the names of all friends who are under the list friends
    public String getSellersNames() {
        String names = "";
        for (int i = 0; i < (getSellers()).size(); i++) {
            names = names + ((getSellers()).get(i)).getName() + "\n";
        }
        return names;
    }
}
