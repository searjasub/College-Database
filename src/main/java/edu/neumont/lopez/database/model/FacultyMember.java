package edu.neumont.lopez.database.model;

import java.util.ArrayList;

public class FacultyMember extends CollegePerson{

    private DegreeProgram degreeProgram;

    public FacultyMember(String name, String lastName, int day, int month, int year, DegreeProgram program) {
        super(name, lastName, day, month, year);
        this.setDegreeProgram(program);
    }

    public DegreeProgram getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(DegreeProgram degreeProgram) {
        if (degreeProgram == null){
            throw new IllegalArgumentException("degreeProgram can't be null");
        }
        this.degreeProgram = degreeProgram;
    }

    public String compareTo(CollegePerson other) {
        //TODO COMPARE BY LAST NAME
        ArrayList<String> lastNames = new ArrayList<>();
        lastNames.add(this.getLastName());
        lastNames.add(other.getLastName());
        //lastNames.sort();
        return lastNames.get(0);
    }

    @Override
    public String speak() {
        return "I have another lab for you";
    }

    @Override
    public String toString() {
        return super.toString() + "\nDegree Program: " + getDegreeProgram();
    }

}
