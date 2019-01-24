package edu.neumont.lopez.database.model;

public class FacultyMember extends CollegePerson {

    private DegreeProgram degreeProgram;

    public FacultyMember() {
    }

    public FacultyMember(String name, String lastName, int day, int month, int year, DegreeProgram program) {
        super(name, lastName, day, month, year);
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
        return super.toString() + "\nDegree Program: " + getDegreeProgram() + "\n";
    }

    @Override
    public String toSaveFormat() {
        return super.toSaveFormat() + "," + this.getDegreeProgram().getName();
    }

    @Override
    public void fromLoadFormat(String raw) {
        super.fromLoadFormat(raw);
        String[] parts = raw.split(",");
        if (parts[5].equals(DegreeProgram.CS.getName())) {
            this.setDegreeProgram(DegreeProgram.CS);
        } else if (parts[5].equals(DegreeProgram.WD.getName())){
            this.setDegreeProgram(DegreeProgram.WD);
        } else if (parts[5].equals(DegreeProgram.TM.getName())){
            this.setDegreeProgram(DegreeProgram.TM);
        }else if (parts[5].equals(DegreeProgram.IS.getName())){
            this.setDegreeProgram(DegreeProgram.IS);
        } else if (parts[5].equals(DegreeProgram.GD.getName())){
            this.setDegreeProgram(DegreeProgram.GD);
        }

    }

}
