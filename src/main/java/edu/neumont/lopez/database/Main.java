package edu.neumont.lopez.database;

import edu.neumont.lopez.database.controller.CollegeDatabase;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CollegeDatabase collegeDatabase = new CollegeDatabase();
        collegeDatabase.start();
    }
}
