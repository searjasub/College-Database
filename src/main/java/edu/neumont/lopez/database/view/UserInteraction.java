package edu.neumont.lopez.database.view;

import edu.neumont.lopez.database.model.DegreeProgram;
import interfaces.ConsoleUI;

import java.io.IOException;

public class UserInteraction {

    public int firstMenu() {
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

    public int secondMenu() {
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

    public String getName() {
        try {
            return ConsoleUI.promptForInput("What is the name?", false);
        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
        return "You should not see me";
    }

    public String getLastName() {
        try {
            return ConsoleUI.promptForInput("Enter the last name.", false);
        } catch (IOException e) {
            System.out.println("Incorrect Input");
        }
        return "You should not see me";
    }

    public int getMonth() throws IOException {
        return ConsoleUI.promptForInt("Enter the number of the month", 1, 12);
    }

    public int getDay() throws IOException {
        int day = -1;
        boolean isValid = false;
        while (!isValid) {
            day = ConsoleUI.promptForInt("Enter day", 1, 31);
            if (getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11) {
                if (day > 30) {
                    System.out.println("That month does not have " + day + " days. Please try again");
                    break;
                } else {
                    isValid = true;
                }
            } else if (getMonth() == 2) {
                if (day > 28) {
                    System.out.println("February does not have " + day + " days. Please try again.");
                } else {
                    isValid = true;
                }
            }
        }
        return day;
    }

    public int getYear(){
        try {
            return ConsoleUI.promptForInt("Enter the year", 0,2018);
        } catch (IOException e) {
            System.out.println("Invalid input");
        }

        return -1;
    }

    public double getGpa(){
        try {
            return ConsoleUI.promptForDouble("Enter GPA", 0,4);
        } catch (IOException e) {
            System.out.println("Invalid input");
        }

        return -1;
    }

    public int getDegree(){
        String[] menuOptions = degreesMenu();
        try {
            return ConsoleUI.promptForMenuSelection(menuOptions);
        } catch (IOException e) {
            System.out.println("Invalid Input");
        }
        return  -1;
    }

    private String[] degreesMenu(){
        String[] menuOptions = new String[5];
        menuOptions[0] = DegreeProgram.CS.getName();
        menuOptions[1] = DegreeProgram.GD.getName();
        menuOptions[2] = DegreeProgram.IS.getName();
        menuOptions[3] = DegreeProgram.TM.getName();
        menuOptions[4] = DegreeProgram.WD.getName();

        return menuOptions;
    }
}
