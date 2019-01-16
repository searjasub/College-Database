package edu.neumont.lopez.database.model;

public enum DegreeProgram {
    CS("Computer Science"),
    WD("Web Development"),
    GD("Game Development"),
    TM("Technology Management"),
    IS("Information Systems"),
    DEFAULT("No degree assigned");

    private String name;

    DegreeProgram(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
