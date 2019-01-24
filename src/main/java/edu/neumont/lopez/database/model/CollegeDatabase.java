package edu.neumont.lopez.database.model;

import edu.neumont.lopez.database.controller.helper.FacultyMemberList;
import edu.neumont.lopez.database.controller.helper.StaffMemberList;
import edu.neumont.lopez.database.controller.helper.StudentList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollegeDatabase {

    private List<CollegePerson> bigList = new ArrayList<>();
    private StudentList students = new StudentList();
    private StaffMemberList staff = new StaffMemberList();
    private FacultyMemberList faculty = new FacultyMemberList();

    public CollegeDatabase() {

    }

    public List<CollegePerson> getBigList() {
        return bigList;
    }

    public StudentList getStudents() {
        return students;
    }

    public StaffMemberList getStaff() {
        return staff;
    }

    public FacultyMemberList getFaculty() {
        return faculty;
    }

    public String getStudentsList() {
        String toString;
        toString = "" + this.getStudents();
        return removeCharacters(toString);
    }

    public String getStaffList() {
        String toString;
        toString = "" + this.getStaff();
        return removeCharacters(toString);
    }

    public String getFacultyList() {
        String toString;
        toString = "" + this.getFaculty();
        return removeCharacters(toString);
    }

    @Override
    public String toString() {
        String toString;

        toString = "\nSTUDENTS:" + this.getStudents() +
                "\n\nFACULTY:" + this.getFaculty() +
                "\n\nSTAFF:" + this.getStaff();

        return removeCharacters(toString);
    }

    private String removeCharacters(String content) {
        String clean;
        clean = content.replace("[", "");
        clean = clean.replace("]", "");
        clean = clean.replace(",", "");
        return clean;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        this.bigList.add(student);
    }

    public void addStaff(StaffMember staffMember) {
        this.staff.add(staffMember);
        this.bigList.add(staffMember);
    }

    public void addFaculty(FacultyMember facultyMember) {
        this.faculty.add(facultyMember);
        this.bigList.add(facultyMember);
    }

    private void saveStaff(StaffMemberList staff) throws FileNotFoundException {
        String serializedStaff = staff.serializeStaffMembers();
        saveToFile("staff.txt", serializedStaff);
    }

    private void saveFaculty(FacultyMemberList faculty) throws FileNotFoundException {
        String serializedFaculty = faculty.serializeFacultyMembers();
        saveToFile("faculty.txt", serializedFaculty);
    }

    private void saveStudents(StudentList students) throws FileNotFoundException {
        String serializedStudents = students.serializeStudents();
        saveToFile("students.txt", serializedStudents);
    }

    private void saveToFile(String filePath, String contents) throws FileNotFoundException {
        OutputStream out = new FileOutputStream(filePath);
        PrintStream outFile = new PrintStream(out);
        outFile.print(contents);
        outFile.close();

    }

    public void save() throws FileNotFoundException {
        saveStudents(getStudents());
        saveFaculty(getFaculty());
        saveStaff(getStaff());

    }

    private FacultyMemberList loadFaculty() throws IOException {
        List<String> lines = loadLinesFromFile("faculty.txt");
        FacultyMemberList list = new FacultyMemberList();
        list.deserializeFaculty(lines);
        return list;
    }

    private StaffMemberList loadStaff() throws IOException {
        List<String> lines = loadLinesFromFile("staff.txt");
        StaffMemberList list = new StaffMemberList();
        list.deserializeStaff(lines);
        return list;
    }

    private StudentList loadStudents() throws IOException {
        List<String> lines = loadLinesFromFile("students.txt");
        StudentList list = new StudentList();
        list.deserializeStudents(lines);
        return list;
    }

    private List<String> loadLinesFromFile(String filePath) throws IOException {
        InputStream in = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        List<String> lines = new ArrayList<>();
        while (reader.ready()) {
            String line = reader.readLine().trim();
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public void load() throws IOException {
        StudentList students = loadStudents();
        StaffMemberList staff = loadStaff();
        FacultyMemberList faculty = loadFaculty();
        for (Student s : students) {
            addStudent(s);
        }
        for (FacultyMember f : faculty) {
            addFaculty(f);
        }
        for (StaffMember s : staff) {
            addStaff(s);
        }
    }
}
