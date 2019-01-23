package edu.neumont.lopez.database;

import edu.neumont.lopez.database.controller.Driver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Driver driver = new Driver();
        driver.start();

    }
}
