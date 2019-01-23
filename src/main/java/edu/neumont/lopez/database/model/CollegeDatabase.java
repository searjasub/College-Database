package edu.neumont.lopez.database.model;

import edu.neumont.lopez.database.controller.helper.FacultyMemberList;
import edu.neumont.lopez.database.controller.helper.StaffMemberList;
import edu.neumont.lopez.database.controller.helper.StudentList;

public class CollegeDatabase {

    private StudentList students = new StudentList();
    private StaffMemberList staff = new StaffMemberList();
    private FacultyMemberList faculty = new FacultyMemberList();

    public CollegeDatabase(){

    }

    public StudentList getStudents() {
        return students;
    }

    public void setStudents(StudentList students) {
        this.students = students;
    }

    public StaffMemberList getStaff() {
        return staff;
    }

    public void setStaff(StaffMemberList staff) {
        this.staff = staff;
    }

    public FacultyMemberList getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyMemberList faculty) {
        this.faculty = faculty;
    }
}
