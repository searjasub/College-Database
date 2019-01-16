package edu.neumont.lopez.database;

import edu.neumont.lopez.database.controller.CollegeDatabase;

public class Main {

    public static void main(String[] args) {
        CollegeDatabase collegeDatabase = new CollegeDatabase();
        collegeDatabase.start();
    }
}
