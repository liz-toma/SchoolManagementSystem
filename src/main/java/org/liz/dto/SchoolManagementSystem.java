package org.liz.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eliza Toma
 * <p>
 * SchoolManagementSystem
 */
@Getter
@Setter
@EqualsAndHashCode
public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENT_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;
    private static final int MAX_COURSE_NUM = 30;
    private static final int MAX_TEACHER_NUM = 20;

    private int teacherNum;
    private int departmentNum;
    private int studentNum;
    private int courseNum;
    private Department[] departments;
    private Student[] students;
    private Course[] courses;
    private Teacher[] teachers;
    private String schoolName;

    public SchoolManagementSystem(String schoolName) {
        this.schoolName = schoolName;
        departments = new Department[MAX_DEPARTMENT_NUM];
        students = new Student[MAX_STUDENT_NUM];
        courses = new Course[MAX_COURSE_NUM];
        teachers = new Teacher[MAX_TEACHER_NUM];
        teacherNum = 0;
        departmentNum = 0;
        courseNum = 0;
        studentNum = 0;
    }

    /**
     * Add a new department to departments
     *
     * @param departmentName the name of the department
     */
    public void addDepartment(String departmentName) {
        departments[departmentNum++] = new Department(departmentName);
    }

    /**
     * Add a new student to students
     *
     * @param fname        student's first name
     * @param lname        student's last name
     * @param departmentId the id of the student's department
     */
    public void addStudent(String fname, String lname, String departmentId) {
        students[studentNum++] = new Student(fname, lname, findDepartment(departmentId));
    }

    /**
     * Add a new teacher to teachers
     *
     * @param fname        teacher's first name
     * @param lname        teacher's last name
     * @param departmentId the id of the teacher's department
     */
    public void addTeacher(String fname, String lname, String departmentId) {
        teachers[teacherNum++] = new Teacher(fname, lname, findDepartment(departmentId));
    }

    /**
     * Add a new course to courses
     *
     * @param courseName   the course's name
     * @param credit       the course's credit
     * @param departmentId the id of the course's department
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        courses[courseNum++] = new Course(courseName, credit, findDepartment(departmentId));
    }

    /**
     * Display all departments in a school
     */
    public void printDepartments() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Display all teachers in a school
     */
    public void printTeachers() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Display all courses in a school
     */
    public void printCourses() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Display all students in a school
     */
    public void printStudents() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Search a department in departments based on its id
     *
     * @param departmentId the department's id
     * @return the department
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getId().equals(departmentId)) {
                return department;
            }
        }

        return null;
    }

    /**
     * Search a teacher in teachers based on its id
     *
     * @param teacherId the teacher's id
     * @return the teacher
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }

        return null;
    }

    /**
     * Search a course in courses based on its id
     *
     * @param courseId the course's id
     * @return the course
     */
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    /**
     * Search a student in students based on its id
     *
     * @param studentId the student's id
     * @return the student
     */
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null && student.getId().equals(studentId)) {
                return student;
            }
        }

        return null;
    }

    /**
     * Assign a teacher to a specific course
     *
     * @param teacherId the teacher's id
     * @param courseId  the course's id
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Register a course for a student
     *
     * @param studentId the student's id
     * @param courseId  the course's id
     */
    public void registerCourse(String studentId, String courseId) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
