package edu.neumont.lopez.database.model;

public enum SchoolDepartment {
    AFFAIRS("Student Affairs"),
    ADMISSIONS("Admissions"),
    FINANCE("Finance"),
    EXECUTIVE("Executive");

    private String name;

    SchoolDepartment(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
