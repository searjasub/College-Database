package edu.neumont.lopez.database.model;

public class StaffMember extends CollegePerson{

    private SchoolDepartment department;

    public StaffMember(String name, String lastName, int day, int month, int year, SchoolDepartment department) {
        super(name, lastName, day, month, year);
        this.setDepartment(department);
    }

    public SchoolDepartment getDepartment() {
        return department;
    }

    public void setDepartment(SchoolDepartment department) {
        if(department == null){
            throw new IllegalArgumentException("department cannot be null");
        }
        this.department = department;
    }

    @Override
    public String speak() {
        return "Is it Friday yet?";
    }

    @Override
    public String toString() {
        return super.toString() + "\nSchool Department: " + getDepartment();
    }
}
