package edu.neumont.lopez.database.model;

public class Student extends CollegePerson {

    private double gpa;

    public Student() {
    }

    public Student(String name, String lastName, int day, int month, int year, double gpa) {
        super(name, lastName, day, month, year);
        this.setGpa(gpa);
    }

    public double getGpa() {
        return gpa;
    }

    private void setGpa(double gpa) {
        if (gpa < 0) {
            throw new IllegalArgumentException("The GPA can't be negative");
        }
        this.gpa = gpa;
    }

    @Override
    public String speak() {
        return "I need to sleep";
    }

    @Override
    public String toString() {
        return super.toString() + "\nGPA: " + getGpa() + "\n";
    }

    @Override
    public int compareTo(CollegePerson o) {
        if (o instanceof Student) {
            return Double.compare(((Student) o).getGpa(), this.getGpa());
        } else {
            return 0;
        }
//            try {
//                Student other = (Student) o;
//                return Double.compare(this.getGpa(), other.getGpa());
//
//            } catch (ClassCastException ex) {
//                return super.compareTo(o);
//            }
    }

    @Override
    public String toSaveFormat() {
        return super.toSaveFormat() + "," + this.getGpa();
    }

    @Override
    public void fromLoadFormat(String raw) {
        super.fromLoadFormat(raw);
        String[] parts = raw.split(",");
        this.setGpa(Double.parseDouble(parts[5].trim()));
    }
}
