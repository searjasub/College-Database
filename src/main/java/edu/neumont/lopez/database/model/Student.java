package edu.neumont.lopez.database.model;

public class Student extends CollegePerson {

    private double gpa;

    public Student(String name, String lastName, int id, int day, int month, int year, double gpa) {
        super(name, lastName, id, day, month, year);
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
        return super.toString() + "\nGPA: " + getGpa();
    }

    @Override
    public int compareTo(CollegePerson o) {
        if (o instanceof Student) {
            return Double.compare( ((Student)o).getGpa(), this.getGpa());
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
}
