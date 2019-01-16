package edu.neumont.lopez.database.model;

public class Student extends CollegePerson {

    private double gpa;

    public Student(String name, String lastName, int day, int month, int year, double gpa) {
        super(name, lastName, day, month, year);
        this.setGpa(gpa);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa < 0){
            throw new IllegalArgumentException("The GPA can't be negative");
        }
        this.gpa = gpa;
    }

    public double compareTo(Student other) {
        return this.getGpa() - other.getGpa();
    }

    @Override
    public String speak() {
        return "I need to sleep";
    }

    @Override
    public String toString() {
        return super.toString() + "\nGPA: " + getGpa();
    }
}
