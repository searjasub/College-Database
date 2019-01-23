package edu.neumont.lopez.database.model;

public class FacultyMember extends CollegePerson {

    private DegreeProgram degreeProgram;

    public FacultyMember() {
    }

    public FacultyMember(String name, String lastName, int id, int day, int month, int year, DegreeProgram program) {
        super(name, lastName, id, day, month, year);
        this.setDegreeProgram(program);
    }

    public DegreeProgram getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(DegreeProgram degreeProgram) {
        if (degreeProgram == null) {
            throw new IllegalArgumentException("degreeProgram can't be null");
        }
        this.degreeProgram = degreeProgram;
    }

    @Override
    public String speak() {
        return "I have another lab for you";
    }

    @Override
    public String toString() {
        return super.toString() + "\nDegree Program: " + getDegreeProgram();
    }

    @Override
    public String toSaveFormat() {
        return super.toSaveFormat() + "," + this.getDegreeProgram().getName();
    }

    @Override
    public void fromLoadFormat(String raw) {
        String[] parts = raw.split(",");
        super.fromLoadFormat(raw);
        this.setDegreeProgram(DegreeProgram.valueOf(parts[6].trim()));
    }

}
