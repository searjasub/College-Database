package edu.neumont.lopez.database.controller;

import edu.neumont.lopez.database.controller.helper.FacultyMemberList;
import edu.neumont.lopez.database.controller.helper.StaffMemberList;
import edu.neumont.lopez.database.controller.helper.StudentList;
import edu.neumont.lopez.database.model.*;
import edu.neumont.lopez.database.view.UserInteraction;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    //private List<CollegePerson> database = new ArrayList<>();
    private CollegeDatabase database = new CollegeDatabase();
    private UserInteraction userInteraction = new UserInteraction();
    private int counter = 0;

    public void start() throws IOException {

        //preFillDatabase();

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
                case 4:

                    break;
                case 5:
                    StudentList students = loadStudents("students.txt");
                    StaffMemberList staff = loadStaff("staff.txt");
                    FacultyMemberList faculty = loadFaculty("faculty.txt");


                    break;
                default:
                    break;
            }
        }
    }

    private void saveStaff(StaffMemberList staff, String filePath) {
        String serializedStaff = staff.serializeStaffMembers();
        saveToFile(filePath, serializedStaff);
    }

    private void saveFaculty(FacultyMemberList faculty, String filePath) {
        String serializedFaculty = faculty.serializeFacultyMembers();
        saveToFile(filePath, serializedFaculty);
    }

    private void saveStudents(StudentList students, String filePath) {
        String serializedStudents = students.serializeStudents();
        saveToFile(filePath, serializedStudents);
    }

    private void saveToFile(String filePath, String contents) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(filePath);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        if (out != null) {
            PrintStream outFile = new PrintStream(out);
            outFile.print(contents);
            outFile.close();
        } else {
            System.out.println("error with the file");
        }
    }

    private FacultyMemberList loadFaculty(String filePath) throws IOException {
        List<String> lines = loadLinesFromFile(filePath);
        FacultyMemberList list = new FacultyMemberList();
        list.deserializeFaculty(lines);
        return list;
    }

    private StaffMemberList loadStaff(String filePath) throws IOException {
        List<String> lines = loadLinesFromFile(filePath);
        StaffMemberList list = new StaffMemberList();
        list.deserializeStaff(lines);
        return list;
    }

    private StudentList loadStudents(String filePath) throws IOException {
        List<String> lines = loadLinesFromFile(filePath);
        StudentList list = new StudentList();
        list.deserializeStudents(lines);
        return list;
    }

    private List<String> loadLinesFromFile(String filePath) throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<>();
        if (in != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (reader.ready()) {
                String line = reader.readLine().trim();
                lines.add(line);
            }
            reader.close();
        } else {
            System.out.println("Couldn't find file");
        }
        return lines;
    }

    private void viewDatabase() throws IOException {
        int selection = userInteraction.viewMenu();
        switch (selection) {
            case 0:
                sort();
                userInteraction.printDatabase(database.getBigList());
                break;
            case 1:
                sort();
                for (CollegePerson s : database.getBigList()) {
                    if (s instanceof Student) {
                        userInteraction.print(s.toString());
                    }
                }
                userInteraction.println("\n");
                break;
            case 2:
                sort();
                for (CollegePerson s : database.getBigList()) {
                    if (s instanceof FacultyMember) {
                        userInteraction.print(s.toString());
                    }
                }
                userInteraction.println("\n");
                break;
            case 3:
                sort();
                for (CollegePerson s : database.getBigList()) {
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
        Collections.sort(database.getBigList());
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
        Student student = new Student(p.getName(), p.getLastName(), p.getId(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getGpa());
        database.add(student);
        counter++;
    }

    private void addFaculty() throws IOException {
        CollegePerson p = basicInfo();
        FacultyMember faculty = new FacultyMember(p.getName(), p.getLastName(), p.getId(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getDegree());
        database.add(faculty);
        counter++;
    }

    private void addStaff() throws IOException {
        CollegePerson p = basicInfo();
        StaffMember staff = new StaffMember(p.getName(), p.getLastName(), p.getId(), p.getDay(), p.getMonth(), p.getYear(), userInteraction.getSchoolDepartment());
        database.add(staff);
        counter++;
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
        int selection = userInteraction.keepGoing();
        switch (selection) {
            case 0:
                int id = userInteraction.removeCollegePerson(database.getBigList().size());
                database.getBigList().remove(id);
                for (int i = id; i < database.getBigList().size(); i++) {
                    database.getBigList().get(i).setId(i);
                }
                counter--;
                break;
            case 1:
                break;
            default:
                break;
        }
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
    }
}
