package edu.neumont.lopez.database.controller.helper;

import edu.neumont.lopez.database.model.StaffMember;

import java.util.ArrayList;
import java.util.List;

public class StaffMemberList extends ArrayList<StaffMember> {

    public String serializeStaffMembers() {
        StringBuilder serializedStaffMembers = new StringBuilder();
        for (StaffMember staffMember : this) {
            serializedStaffMembers.append(staffMember.toSaveFormat()).append("\r\n");
        }
        return serializedStaffMembers.toString();
    }

    public void deserializeStaff(List<String> rawData) {
        for (String line : rawData) {
            StaffMember staffMember = new StaffMember();
            staffMember.fromLoadFormat(line);
            this.add(staffMember);
        }
    }
}
