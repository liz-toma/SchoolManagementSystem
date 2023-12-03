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

    /**
     * Gets student's full name as a concatenation of the first name and last name
     *
     * @return the full name
     */
    public String getName() {
        return fname + " " + lname;
    }

    /**
     * Adds a course to courses
     *
     * @param course the new course
     */
    public void addCourse(Course course) {
        courses[courseNum++] = course;
    }

    /**
     * Verifies if the new course can be added
     *
     * @param courseId the new course's id
     * @return true if the course can be added, false otherwise
     */
    public boolean canAddCourse(String courseId) {
        if (courseNum == MAX_COURSE_NUM) {
            System.out.printf("Student %s has already registered %d courses, register course %s for student %s failed.%n", id, MAX_COURSE_NUM, courseId, id);
            return false;
        }

        return true;
    }

    /**
     * Verifies if the course is already registered
     *
     * @param courseId the id of the course
     * @return true if it is already registered, false otherwise
     */
    public boolean isCourseRegistered(String courseId) {
        for (Course courseStudent : courses) {
            if (courseStudent != null && courseStudent.getId().equals(courseId)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String coursesStr = "[";
        for (Course course : courses) {
            if (course != null) {
                coursesStr += "'" + course.getCourseName() + "'" + ", ";
            }
        }
        coursesStr += "]";
        return "Student{id='" + id +
                "',fname='" + fname + "',lname='" + lname +
                "',department=" + department +
                ",courseNum=" + courseNum + ",courses=" + coursesStr + '}';
    }
}
