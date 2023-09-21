package ui;

import java.io.FileNotFoundException;

// Main window for everything to start
public class Main {
    public static void main(String[] args) {
        Menu.mainWindow();

        try {
            new ContactMe();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}