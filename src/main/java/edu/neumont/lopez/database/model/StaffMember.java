package edu.neumont.lopez.database.model;

public class StaffMember extends CollegePerson {

    private SchoolDepartment department;

    public StaffMember(){}

    public StaffMember(String name, String lastName, int day, int month, int year, SchoolDepartment department) {
        super(name, lastName, day, month, year);
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
        return super.toString() + "\nSchool Department: " + getDepartment() + "\n";
    }

    @Override
    public String toSaveFormat() {
        return super.toSaveFormat() + "," + this.getDepartment().getName();
    }

    @Override
    public void fromLoadFormat(String raw) {
        super.fromLoadFormat(raw);
        String[] parts = raw.split(",");
        if(parts[5].trim().equals(SchoolDepartment.AFFAIRS.getName())){
            this.setDepartment(SchoolDepartment.AFFAIRS);
        } else if(parts[5].trim().equals(SchoolDepartment.EXECUTIVE.getName())){
            this.setDepartment(SchoolDepartment.EXECUTIVE);
        }else if(parts[5].trim().equals(SchoolDepartment.AFFAIRS.getName())){
            this.setDepartment(SchoolDepartment.AFFAIRS);
        }else if(parts[5].trim().equals(SchoolDepartment.ADMISSIONS.getName())){
            this.setDepartment(SchoolDepartment.ADMISSIONS);
        }
    }
}
