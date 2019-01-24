package edu.neumont.lopez.database.controller;

import edu.neumont.lopez.database.model.*;
import edu.neumont.lopez.database.view.UserInteraction;

import java.io.IOException;
import java.util.Collections;

public class Driver {

    private CollegeDatabase database = new CollegeDatabase();
    private UserInteraction userInteraction = new UserInteraction();

    public void start() throws IOException {

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
                    database.save();
                    userInteraction.println("\n\nThe file has been saved\n");
                    break;
                case 4:

                    database.load();

                    userInteraction.println("\n\nThe file has been loaded\n");
                    break;
                case 5:
                    keepAdding = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void viewDatabase() throws IOException {
        //TODO if nothing to show, says something
        int selection = userInteraction.viewMenu();
        switch (selection) {
            case 0:
                sort();
                userInteraction.println(database.toString());
                break;
            case 1:
                sort();
                userInteraction.println(database.getStudentsList());
                break;
            case 2:
                sort();
                userInteraction.println(database.getFacultyList());
                break;
            case 3:
                sort();
                userInteraction.println(database.getStaffList());
                break;
            default:
                break;
        }
    }

    private void sort() {
        Collections.sort(database.getStudents());
        Collections.sort(database.getFaculty());
        Collections.sort(database.getStaff());
    }

    private void addCollegePerson() throws IOException {
        int selection = userInteraction.secondMenu();

        switch (selection) {
            case 0:
                addStudent();
                break;
            case 1:
                addFaculty();
                break;
            case 2:
                addStaff();
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    private void addStudent() throws IOException {
        CollegePerson p = basicInfo();
        Student student = new Student(p.getName(), p.getLastName(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getGpa());
        database.addStudent(student);
    }

    private void addFaculty() throws IOException {
        CollegePerson p = basicInfo();
        FacultyMember faculty = new FacultyMember(p.getName(), p.getLastName(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getDegree());
        database.addFaculty(faculty);
    }

    private void addStaff() throws IOException {
        CollegePerson p = basicInfo();
        StaffMember staff = new StaffMember(p.getName(), p.getLastName(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getSchoolDepartment());
        database.addStaff(staff);
    }

    private CollegePerson basicInfo() throws IOException {

        String name = userInteraction.getName();
        String lastName = userInteraction.getLastName();
        int day = userInteraction.getDay();
        int month = userInteraction.getMonth();
        int year = userInteraction.getYear();

        return new CollegePerson(name, lastName, day, month, year);
    }

    private void removeCollegePerson() throws IOException {
        CollegePerson selected = userInteraction.selectPerson(database.getBigList());
        if (selected instanceof Student){
            database.getStudents().remove(selected);
            database.getBigList().remove(selected);
        } else if(selected instanceof FacultyMember){
            database.getFaculty().remove(selected);
            database.getBigList().remove(selected);
        } else if(selected instanceof StaffMember){
            database.getStaff().remove(selected);
            database.getBigList().remove(selected);
        }
    }
}
