package edu.neumont.lopez.database.view;

import edu.neumont.lopez.database.model.CollegePerson;
import edu.neumont.lopez.database.model.DegreeProgram;
import edu.neumont.lopez.database.model.SchoolDepartment;
import interfaces.ConsoleUI;

import java.io.IOException;
import java.util.List;

public class UserInteraction {

    public int firstMenu() {
        String[] menuOptions = fillFirstMenu();
        try {
            return ConsoleUI.promptForMenuSelection(menuOptions, "\nWhat would you like to do?");
        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
        return -1;
    }

    private String[] fillFirstMenu() {
        String[] menuOptions = new String[6];
        menuOptions[0] = "Add College Person to database";
        menuOptions[1] = "Remove College Person from database";
        menuOptions[2] = "View current database";
        menuOptions[3] = "Save";
        menuOptions[4] = "Load";
        menuOptions[5] = "Exit";
        return menuOptions;
    }

    public int secondMenu() {
        String[] menuOptions = fillSecondMenu();
        try {
            return ConsoleUI.promptForMenuSelection(menuOptions, "\nSelect the number for the type of College Person you want to add");
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
            return ConsoleUI.promptForInput("\nEnter name.", false);
        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
        return "You should not see me";
    }

    public String getLastName() {
        try {
            return ConsoleUI.promptForInput("\nEnter last name.", false);
        } catch (IOException e) {
            System.out.println("Incorrect Input");
        }
        return "You should not see me";
    }

    public int getMonth() throws IOException {
        return ConsoleUI.promptForInt("\nEnter the number of the month", 1, 12);
    }

    public int getDay() throws IOException {
        return ConsoleUI.promptForInt("\nEnter day", 1, 31);
    }

    public int getYear() {
        try {
            return ConsoleUI.promptForInt("\nEnter the year", 0, 2018);
        } catch (IOException e) {
            System.out.println("Invalid input");
        }

        return -1;
    }

    public double getGpa() {
        try {
            return ConsoleUI.promptForDouble("\nEnter GPA", 0, 4);
        } catch (IOException e) {
            System.out.println("Invalid input");
        }

        return -1;
    }

    public DegreeProgram getDegree() {
        String[] menuOptions = degreesMenu();
        try {
            int selection = ConsoleUI.promptForMenuSelection(menuOptions, "\nWhat Degree?");
            if (selection == 0) {
                return DegreeProgram.CS;
            } else if (selection == 1) {
                return DegreeProgram.GD;
            } else if (selection == 2) {
                return DegreeProgram.IS;
            } else if (selection == 3) {
                return DegreeProgram.TM;
            } else {
                return DegreeProgram.WD;
            }
        } catch (IOException e) {
            System.out.println("Invalid Input");
        }
        return DegreeProgram.DEFAULT;
    }

    private String[] degreesMenu() {
        String[] menuOptions = new String[5];
        menuOptions[0] = DegreeProgram.CS.getName();
        menuOptions[1] = DegreeProgram.GD.getName();
        menuOptions[2] = DegreeProgram.IS.getName();
        menuOptions[3] = DegreeProgram.TM.getName();
        menuOptions[4] = DegreeProgram.WD.getName();

        return menuOptions;
    }

    public SchoolDepartment getSchoolDepartment() {
        String[] menuOptions = departmentsMenu();
        try {
            int selection = ConsoleUI.promptForMenuSelection(menuOptions, "\nWhat is the School Department");
            if (selection == 0) {
                return SchoolDepartment.ADMISSIONS;
            } else if (selection == 1) {
                return SchoolDepartment.AFFAIRS;
            } else if (selection == 2) {
                return SchoolDepartment.EXECUTIVE;
            } else {
                return SchoolDepartment.FINANCE;
            }
        } catch (IOException e) {
            System.out.println("Error in getSchoolDepartment");
        }
        return SchoolDepartment.DEFAULT;
    }

    private String[] departmentsMenu() {
        String[] menuOptions = new String[4];
        menuOptions[0] = SchoolDepartment.ADMISSIONS.getName();
        menuOptions[1] = SchoolDepartment.AFFAIRS.getName();
        menuOptions[2] = SchoolDepartment.EXECUTIVE.getName();
        menuOptions[3] = SchoolDepartment.FINANCE.getName();

        return menuOptions;
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public int viewMenu() throws IOException {
        String[] menuOptions = new String[4];
        menuOptions[0] = "View All";
        menuOptions[1] = "View Students";
        menuOptions[2] = "View Faculty Members";
        menuOptions[3] = "View Staff Members";

        return ConsoleUI.promptForMenuSelection(menuOptions, "\nChoose your desire view");
    }

    public CollegePerson selectPerson(List<CollegePerson> persons) throws IOException {
        Object[] list = persons.toArray();
        String[] options = new String[list.length];
        for (int i = 0; i < options.length; i++) {
            options[i] = persons.get(i).getName();
        }
        return (CollegePerson)list[ConsoleUI.promptForMenuSelection(options,"Who you want to delete?")];

    }

}
