package edu.neumont.lopez.database.controller;

import edu.neumont.lopez.database.model.*;
import edu.neumont.lopez.database.view.UserInteraction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollegeDatabase {

    private List<CollegePerson> database = new ArrayList<>();
    private UserInteraction userInteraction = new UserInteraction();
    private int counter = 0;

    public void start() throws IOException {

        preFillDatabase();

        boolean keepAdding = true;
        while (keepAdding) {
            int selection = userInteraction.firstMenu();
            switch (selection) {
                case 0:
                    addCollegePerson();
                    sort();
                    break;
                case 1:
                    removeCollegePerson();
                    break;
                case 2:
                    viewDatabase();
                    break;
                case 3:
                    keepAdding = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void viewDatabase() throws IOException {
        int selection = userInteraction.viewMenu();
        switch (selection) {
            case 0:
                sort();
                userInteraction.printDatabase(database);
                break;
            case 1:
                sort();
                for (CollegePerson s : database) {
                    if (s instanceof Student) {
                        userInteraction.print(s.toString());
                    }
                }
                userInteraction.println("\n");
                break;
            case 2:
                sort();
                for (CollegePerson s : database) {
                    if (s instanceof FacultyMember) {
                        userInteraction.print(s.toString());
                    }
                }
                userInteraction.println("\n");
                break;
            case 3:
                sort();
                for (CollegePerson s : database) {
                    if (s instanceof StaffMember) {
                        userInteraction.print(s.toString());
                    }
                }
                userInteraction.println("\n");
                break;
            default:
                break;
        }
    }

    private void sort() {
        Collections.sort(database);
    }

    private void addCollegePerson() throws IOException {
        CollegePerson p;
        int selection = userInteraction.secondMenu();

        switch (selection) {
            case 0:
                p = basicInfo();
                Student student = new Student(p.getName(), p.getLastName(), p.getId(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getGpa());
                database.add(student);
                counter++;
                break;
            case 1:
                p = basicInfo();
                FacultyMember faculty = new FacultyMember(p.getName(), p.getLastName(), p.getId(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getDegree());
                database.add(faculty);
                counter++;
                break;
            case 2:
                p = basicInfo();
                StaffMember staff = new StaffMember(p.getName(), p.getLastName(), p.getId(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getSchoolDepartment());
                database.add(staff);
                counter++;
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

        return new CollegePerson(name, lastName, counter, day, month, year);
    }


    private void removeCollegePerson() throws IOException {
        userInteraction.println("To remove someone from the database use the ID, you can check someone's ID by printing the database ");
        int id = userInteraction.removeCollegePerson(database.size());
        database.remove(id);
        for (int i = id; i < database.size(); i++) {
            database.get(i).setId(i);
        }
        counter--;
    }

    private void preFillDatabase() {
        Student student1 = new Student("Sear", "Apple", 0, 4, 10, 1994, 4);
        Student student2 = new Student("Kellee", "Lopez", 1, 26, 10, 1993, 3.9);
        StaffMember staffMember1 = new StaffMember("John", "Pin", 2, 16, 2, 92, SchoolDepartment.AFFAIRS);
        StaffMember staffMember2 = new StaffMember("Lorem", "Ipsum", 3, 1, 12, 67, SchoolDepartment.EXECUTIVE);
        FacultyMember facultyMember1 = new FacultyMember("Ryan", "Cox", 4, 5, 3, 87, DegreeProgram.CS);
        FacultyMember facultyMember2 = new FacultyMember("Tom", "Beatty", 5, 17, 9, 80, DegreeProgram.WD);
        Student student3 = new Student("Pedro", "California", 6, 7, 12, 1998, 2.0);

        counter = 7;

        database.add(student1);
        database.add(student2);
        database.add(staffMember1);
        database.add(staffMember2);
        database.add(facultyMember1);
        database.add(facultyMember2);
        database.add(student3);

//        userInteraction.println(facultyMember1.speak());
//        userInteraction.println(student1.speak());
//        userInteraction.println(staffMember1.speak());


//        if (staffMember1.compareTo(facultyMember1) < 0) {
//            System.out.println("staff is bigger");
//        } else if (staffMember1.compareTo(facultyMember1) > 0) {
//            System.out.println("faculty is bigger");
//        } else {
//            System.out.println("equals");
//        }

    }

}
