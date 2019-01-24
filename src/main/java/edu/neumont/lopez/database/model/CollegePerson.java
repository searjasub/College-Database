package edu.neumont.lopez.database.model;

public class CollegePerson implements Comparable<CollegePerson>, Savable {

    private String name;
    private String lastName;
    private int day, month, year;

    public CollegePerson() {
    }

    public CollegePerson(String name, String lastName, int day, int month, int year) {
        this.setName(name);
        this.setLastName(lastName);

        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 0) {
            throw new IndexOutOfBoundsException("Day can't be a negative number");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 0) {
            throw new IndexOutOfBoundsException("Month can't be a negative number");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IndexOutOfBoundsException("Year can't be a negative number");
        }
        this.year = year;
    }

    public String speak() {
        return "Speaking from CollegePerson";
    }

    public String toString() {
        return "\nName: " + getName() +
                "\nLast name: " + getLastName() +
                "\nDOB: " + getDay() +
                "/" + getMonth() +
                "/" + getYear() ;
    }

    public boolean equals(Object obj) {
        CollegePerson other = (CollegePerson) obj;
        return this.getName().equalsIgnoreCase(other.getName());
    }

    @Override
    public int compareTo(CollegePerson o) {
        return this.getLastName().compareTo(o.getLastName());
    }

    @Override
    public String toSaveFormat() {
        return (this.getName() + "," + this.getLastName() + "," + this.getMonth() + "," + this.getDay() + "," + this.getYear());
    }

    @Override
    public void fromLoadFormat(String raw) {
        String[] parts = raw.split(",");
        this.setName(parts[0].trim());
        this.setLastName(parts[1].trim());
        this.setMonth(Integer.parseInt(parts[2].trim()));
        this.setDay(Integer.parseInt(parts[3].trim()));
        this.setYear(Integer.parseInt(parts[4].trim()));
    }
}
