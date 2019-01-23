package edu.neumont.lopez.database.model;

public interface Savable {

    String toSaveFormat();
    void  fromLoadFormat(String raw);

}
