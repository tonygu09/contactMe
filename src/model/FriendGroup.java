package model;

import java.util.ArrayList;

// Represents a list of friends
public class FriendGroup {
    private ArrayList<FriendContact> friendGroups;

    // EFFECT: Constructs a list of friends
    public FriendGroup() {
        this.friendGroups = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECT: Adds friends into the list of friends
    public void addMember(FriendContact friends) {
        this.friendGroups.add(friends);
        EventLog.getInstance().logEvent(new Event("Added friend to group: " + friends.getName()));
    }

    // GET METHODS
    public int getNumMembers() {
        return this.friendGroups.size();
    }

    public ArrayList<FriendContact> getFriends() {
        return friendGroups;
    }

    // EFFECT: Gets the names of all friends who are under the list friends
    public String getFriendNames() {
        String names = "";
        for (int i = 0; i < (getFriends()).size(); i++) {
            names = names + ((getFriends()).get(i)).getName() + "\n";
        }
        return names;
    }
}
