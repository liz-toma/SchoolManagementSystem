package org.liz.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eliza Toma
 * <p>
 * Student
 */
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private static final int MAX_COURSE_NUM = 5;
    private static int nextId = 1;

    private String fname;
    private String lname;
    private Course[] courses;
    private String id;
    private int courseNum;
    private Department department;

    public Student(String fname, String lname, Department department) {
        this.fname = fname;
        this.lname = lname;
        courseNum = 0;
        courses = new Course[MAX_COURSE_NUM];
        this.department = department;
        id = String.format("S%03d", nextId++);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
