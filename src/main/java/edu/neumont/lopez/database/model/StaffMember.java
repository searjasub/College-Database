package edu.neumont.lopez.database.model;

public class StaffMember extends CollegePerson {

    private SchoolDepartment department;

    public StaffMember(){}

    public StaffMember(String name, String lastName, int id, int day, int month, int year, SchoolDepartment department) {
        super(name, lastName, id, day, month, year);
        this.setDepartment(department);
    }

    public SchoolDepartment getDepartment() {
        return department;
    }

    public void setDepartment(SchoolDepartment department) {
        if (department == null) {
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

    @Override
    public String toSaveFormat() {
        return super.toSaveFormat() + "," + this.getDepartment().getName();
    }

    @Override
    public void fromLoadFormat(String raw) {
        String[] parts = raw.split(",");
        super.fromLoadFormat(raw);
        this.setDepartment(SchoolDepartment.valueOf(parts[6].trim()));
    }
}
