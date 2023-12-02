package org.liz.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eliza Toma
 * <p>
 * Course
 */
@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private static final int MAX_STUDENT_NUM = 5;
    private static int nextId = 1;

    private String courseName;
    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    private int studentNum;
    private Teacher teacher;

    public Course(String courseName, double credit, Department department) {
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        students = new Student[MAX_STUDENT_NUM];
        studentNum = 0;
        id = String.format("C%03d", nextId++);
    }

    @Override
    public String toString() {
        String studentsStr = "[";
        for (Student student : students) {
            if (student != null) {
                studentsStr += student + ", ";
            }
        }
        studentsStr += "]";
        return "Course{id='" + id +
                "',courseName='" + courseName +
                "',credit='" + credit +
                "',teacher=" + teacher +
                "',department=" + department +
                ",students=" + studentsStr + '}';
    }
}
