package edu.neumont.lopez.database.controller.helper;

import edu.neumont.lopez.database.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends ArrayList<Student> {

    public String serializeStudents() {
        StringBuilder serializedStudents = new StringBuilder();
        for (Student s : this) {
            serializedStudents.append(s.toSaveFormat()).append("\r\n");
        }
        return serializedStudents.toString();
    }

    public void deserializeStudents(List<String> rawData) {
        for (String line : rawData) {
            Student student = new Student();
            student.fromLoadFormat(line);
            this.add(student);
        }
    }
}

