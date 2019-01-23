package edu.neumont.lopez.database.controller.helper;

import edu.neumont.lopez.database.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends ArrayList<Student> {

    public String serializeStudents() {
        String serializedStudents = "";
        for (Student s : this) {
            serializedStudents += s.toSaveFormat() + "\r\n";
        }
        return serializedStudents;
    }

    public void deserializeStudents(List<String> rawData) {
        for (String line : rawData) {
            Student student = new Student();
            student.fromLoadFormat(line);
            this.add(student);
        }
    }
}

