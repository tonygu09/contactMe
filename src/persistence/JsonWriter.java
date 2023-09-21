package persistence;

import model.*;
import org.json.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// Represents a writer that writes JSON representation of contacts to file
// Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriter {
    private String source;
    private PrintWriter writer;
    private JsonReader reader;
    private String prevData;


    // REQUIRES: actual file in data
    // EFFECTS: constructs writer to write to source file
    public JsonWriter(String source) {
        this.source = source;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(source);
    }

    public void prevDataLoad(String prevData) {
        this.prevData = prevData;
    }

    public void multiplePrevData() {
        try {
            reader = new JsonReader(source);
            prevData = reader.prevData();
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

    public String time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of buying contacts to file
    public void buyingWrite(BuyingClient bc, int i) {
        if (i != 0) {
            multiplePrevData();
        }

        JSONObject buyer = new JSONObject();
        JSONObject buyerInfo = new JSONObject();
        String buyerName = (bc.getName()).replaceAll("\\s", "");
        String buyerFullName = bc.getName();
        String buyerNumber = bc.getNumber();
        String buyerEmail = bc.getEmail();
        String buyerAddress = bc.getCurrentAddress();
        String buyerInterested = bc.getInterestedListing();
        String buyerNotes = bc.getNotes();

        buyer.put("name", buyerFullName);
        buyer.put("number", buyerNumber);
        buyer.put("email", buyerEmail);
        buyer.put("address", buyerAddress);
        buyer.put("interested", buyerInterested);
        buyer.put("notes", buyerNotes);
        buyer.put("CreationTime", time());

        buyerInfo.put(buyerName, buyer);
        String written = buyerInfo.toString();
        multipleInstance(prevData, written);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of selling contacts to file
    public void sellingWrite(SellingClient sc, int i) {
        if (i != 0) {
            multiplePrevData();
        }

        JSONObject seller = new JSONObject();
        JSONObject sellerInfo = new JSONObject();
        String sellerName = (sc.getName()).replaceAll("\\s", "");
        String sellerFullName = sc.getName();
        String sellerNumber = sc.getNumber();
        String sellerEmail = sc.getEmail();
        String sellerAddress = sc.getCurrentAddress();
        String sellerType = sc.getType();
        String sellerNotes = sc.getNotes();

        seller.put("name", sellerFullName);
        seller.put("number", sellerNumber);
        seller.put("email", sellerEmail);
        seller.put("address", sellerAddress);
        seller.put("type", sellerType);
        seller.put("notes", sellerNotes);
        seller.put("CreationTime", time());

        sellerInfo.put(sellerName, seller);
        String written = sellerInfo.toString();

        multipleInstance(prevData, written);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of friend contacts to file
    public void friendWrite(FriendContact fc, int i) {
        if (i != 0) {
            multiplePrevData();
        }

        JSONObject friend = new JSONObject();
        JSONObject friendInfo = new JSONObject();
        String friendName = (fc.getName()).replaceAll("\\s", "");
        String friendFullName = fc.getName();
        String friendBirthday = fc.getBirthday();
        String friendNumber = fc.getNumber();
        String friendAddress = fc.getHomeAddress();
        String friendNotes = fc.getNotes();

        friend.put("name", friendFullName);
        friend.put("birthday", friendBirthday);
        friend.put("number", friendNumber);
        friend.put("address", friendAddress);
        friend.put("notes", friendNotes);
        friend.put("CreationTime", time());

        friendInfo.put(friendName, friend);
        String written = friendInfo.toString();

        multipleInstance(prevData, written);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of service contacts to file
    public void serviceWrite(ServiceContact sc, int i) {
        if (i != 0) {
            multiplePrevData();
        }

        JSONObject service = new JSONObject();
        JSONObject serviceInfo = new JSONObject();
        String serviceName = (sc.getName()).replaceAll("\\s", "");
        String serviceFullName = sc.getName();
        String serviceNumber = sc.getNumber();
        String serviceEmail = sc.getEmail();
        String serviceType = sc.getTypeOfService();
        String serviceNote = sc.getNotes();

        service.put("name", serviceFullName);
        service.put("number", serviceNumber);
        service.put("email", serviceEmail);
        service.put("type", serviceType);
        service.put("note", serviceNote);
        service.put("CreationTime", time());

        serviceInfo.put(serviceName, service);
        String written = serviceInfo.toString();
        multipleInstance(prevData, written);
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: if content's length > 1 then there is something saved in the file so we want to add onto it
    // Otherwise, write into the file without taking into account previous data.
    public void multipleInstance(String content, String written) {
        try (FileWriter file = new FileWriter(source)) {
            if (content.length() > 1) {
                content = content.substring(0, content.length() - 1);
                written = written.substring(1, written.length());
                file.write(content + "," + written);
                file.flush();
            } else {
                file.write(written);
                file.flush();
            }
        } catch (IOException i) {
            System.out.println("Something went wrong");
        }
    }
}
