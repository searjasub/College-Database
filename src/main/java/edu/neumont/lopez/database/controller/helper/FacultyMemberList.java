package edu.neumont.lopez.database.controller.helper;

import edu.neumont.lopez.database.model.FacultyMember;

import java.util.ArrayList;
import java.util.List;

public class FacultyMemberList extends ArrayList<FacultyMember> {

    public String serializeFacultyMembers() {
        StringBuilder serializedFacultyMembers = new StringBuilder();
        for (FacultyMember facultyMember : this) {
            serializedFacultyMembers.append(facultyMember.toSaveFormat());
        }
        return serializedFacultyMembers.toString();
    }

    public void deserializeFaculty(List<String> rawData) {
        for (String line : rawData) {
            FacultyMember facultyMember = new FacultyMember();
            facultyMember.fromLoadFormat(line);
            this.add(facultyMember);
        }
    }
}
