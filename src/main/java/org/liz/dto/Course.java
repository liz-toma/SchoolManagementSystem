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

    /**
     * Adds a student to students
     *
     * @param student the new student
     * @return true if the student is added successfully, false otherwise
     */
    public void addStudent(Student student) {
        students[studentNum++] = student;
    }

    /**
     * Verifies if the new student can be added
     *
     * @param studentId the new student's id
     * @return true if the student can be added, false otherwise
     */
    public boolean canAddStudent(String studentId) {
        if (studentNum == MAX_STUDENT_NUM) {
            System.out.printf("Course %s has been fully registered, register course %s for student %s failed.%n", id, id, studentId);
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String studentsStr = "[";
        for (Student student : students) {
            if (student != null) {
                studentsStr += student.getName() + ", ";
            }
        }
        studentsStr += "]";
        return "Course{id='" + id +
                "',courseName='" + courseName +
                "',credit='" + credit +
                (teacher != null
                        ? "',teacher='" + teacher.getName()
                        : "") +
                (department != null
                        ? "',department='" + department.getDepartmentName()
                        : "") +
                "',students=" + studentsStr + '}';
    }
}
