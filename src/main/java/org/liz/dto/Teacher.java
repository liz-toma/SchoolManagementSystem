package org.liz.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eliza Toma
 * <p>
 * Teacher
 */
@Getter
@Setter
@EqualsAndHashCode
public class Teacher {
    private static int nextId = 1;

    private String fname;
    private String lname;
    private Department department;
    private String id;

    public Teacher(String fname, String lname, Department department) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        id = String.format("T%03d", nextId++);
    }

    /**
     * Gets teacher's full name as a concatenation of the first name and last name
     *
     * @return the full name
     */
    public String getName() {
        return fname + " " + lname;
    }

    @Override
    public String toString() {
        return "Teacher{id='" + id +
                "',fname='" + fname + "',lname='" + lname +
                (department != null
                        ? "',department='" + department.getDepartmentName() + "'}"
                        : "'}");
    }
}
