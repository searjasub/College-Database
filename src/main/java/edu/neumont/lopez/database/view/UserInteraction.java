package edu.neumont.lopez.database.view;

import interfaces.ConsoleUI;

import java.io.IOException;

public class UserInteraction {

    public int firstMenu(){
        String[] menuOptions = fillFirstMenu();
        try {
            return ConsoleUI.promptForMenuSelection(menuOptions);
        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
        return -1;
    }

    private String[] fillFirstMenu() {
        String[] menuOptions = new String[4];
        menuOptions[0] = "Add College Person to database";
        menuOptions[1] = "Remove College Person from database";
        menuOptions[2] = "View current database";
        menuOptions[3] = "Exit";
        return menuOptions;
    }

    public int secondMenu(){
        String[] menuOptions = fillSecondMenu();
        try {
            return ConsoleUI.promptForMenuSelection(menuOptions);
        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
        return -1;
    }

    private String[] fillSecondMenu() {
        String[] menuOptions = new String[4];
        menuOptions[0] = "Student";
        menuOptions[1] = "Faculty member";
        menuOptions[2] = "Staff Member";
        menuOptions[3] = "Exit";
        return menuOptions;
    }

    public String getName(){
        try {
            return ConsoleUI.promptForInput("What is the name?", false);
        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
        return "You should not see me";
    }
}
