package edu.neumont.lopez.database.controller;

import edu.neumont.lopez.database.model.*;
import edu.neumont.lopez.database.view.UserInteraction;

import java.io.IOException;
import java.util.ArrayList;

public class CollegeDatabase {

    private ArrayList<CollegePerson> database = new ArrayList<>();
    private UserInteraction userInteraction = new UserInteraction();

    public void start() throws IOException {
        preFillDatabase();
        boolean keepAdding = true;
        while (keepAdding) {
            int selection = userInteraction.firstMenu();
            switch (selection) {
                case 0:
                    addCollegePerson();
                    break;
                case 1:
                    removeCollagePerson();
                    break;
                case 2:
                    userInteraction.print(database);
                    break;
                case 3:
                    keepAdding = false;
                    break;
                default:
                    break;
            }
        }

    }

    private void addCollegePerson() throws IOException {
        CollegePerson p;
        int selection = userInteraction.secondMenu();
        switch (selection) {
            case 0:
                p = basicInfo();
                Student student = new Student(p.getName(), p.getLastName(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getGpa());
                database.add(student);
                break;
            case 1:
                p = basicInfo();
                FacultyMember faculty = new FacultyMember(p.getName(),p.getLastName(),p.getDay(),p.getMonth(),p.getYear(), userInteraction.getDegree());
                database.add(faculty);
                break;
            case 2:
                p = basicInfo();
                StaffMember staff = new StaffMember(p.getName(),p.getLastName(),p.getDay(),p.getMonth(),p.getYear(), userInteraction.getSchoolDepartment());
                database.add(staff);
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    private CollegePerson basicInfo() throws IOException {
        String name = userInteraction.getName();
        String lastName = userInteraction.getLastName();
        int day = userInteraction.getDay();
        int month = userInteraction.getMonth();
        int year = userInteraction.getYear();

        return new CollegePerson(name, lastName, day, month, year);
    }


    private void removeCollagePerson() {
        //TODO How to remove people
    }

    private void preFillDatabase() {
        Student student1 = new Student("Sear", "Lopez", 4, 10, 1994, 4.0);
        Student student2 = new Student("Kellee", "Lopez", 26, 10, 1993, 3.9);

        StaffMember staffMember1 = new StaffMember("John", "P", 16, 2, 92, SchoolDepartment.AFFAIRS);
        StaffMember staffMember2 = new StaffMember("Lorem", "Ipsum", 1, 12, 67, SchoolDepartment.EXECUTIVE);

        FacultyMember facultyMember1 = new FacultyMember("Ryan", "Cox", 5, 3, 87, DegreeProgram.CS);
        FacultyMember facultyMember2 = new FacultyMember("Tom", "Beatty", 17, 9, 80, DegreeProgram.WD);

        database.add(student1);
        database.add(staffMember1);
        database.add(facultyMember1);
        database.add(student2);
        database.add(staffMember2);
        database.add(facultyMember2);

//        userInteraction.println(facultyMember1.speak());
//        userInteraction.println(student1.speak());
//        userInteraction.println(staffMember1.speak());
    }

}
