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
        if (departmentNum < MAX_DEPARTMENT_NUM) {
            departments[departmentNum] = new Department(departmentName);
            System.out.println(departments[departmentNum++] + " added successfully.");
        } else {
            System.out.println("Max department reached, add a new department failed.");
        }
    }

    /**
     * Add a new student to students
     *
     * @param fname        student's first name
     * @param lname        student's last name
     * @param departmentId the id of the student's department
     */
    public void addStudent(String fname, String lname, String departmentId) {
        if (studentNum < MAX_STUDENT_NUM) {
            students[studentNum] = new Student(fname, lname, findDepartment(departmentId));
            System.out.println(students[studentNum++] + " added successfully.");
        } else {
            System.out.println("Max student reached, add a new student failed.");
        }
    }

    /**
     * Add a new teacher to teachers
     *
     * @param fname        teacher's first name
     * @param lname        teacher's last name
     * @param departmentId the id of the teacher's department
     */
    public void addTeacher(String fname, String lname, String departmentId) {
        if (teacherNum < MAX_TEACHER_NUM) {
            teachers[teacherNum] = new Teacher(fname, lname, findDepartment(departmentId));
            System.out.println(teachers[teacherNum++] + " added successfully.");
        } else {
            System.out.println("Max teacher reached, add a new teacher failed.");
        }
    }

    /**
     * Add a new course to courses
     *
     * @param courseName   the course's name
     * @param credit       the course's credit
     * @param departmentId the id of the course's department
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        if (courseNum < MAX_COURSE_NUM) {
            courses[courseNum] = new Course(courseName, credit, findDepartment(departmentId));
            System.out.println(courses[courseNum++] + " added successfully.");
        } else {
            System.out.println("Max course reached, add a new course failed.");
        }
    }

    /**
     * Display all departments in a school
     */
    public void printDepartments() {
        System.out.println("Displaying all departments:");
        System.out.println("-------------------");

        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }

    /**
     * Display all teachers in a school
     */
    public void printTeachers() {
        System.out.println("Displaying all teachers:");
        System.out.println("-------------------");

        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    /**
     * Display all courses in a school
     */
    public void printCourses() {
        System.out.println("Displaying all courses:");
        System.out.println("-------------------");

        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }

    /**
     * Display all students in a school
     */
    public void printStudents() {
        System.out.println("Displaying all students:");
        System.out.println("-------------------");

        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
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
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);

        if (course == null) {
            System.out.printf("Cannot find any course match with courseId %s, modify teacher %s for course %s failed.%n", courseId, teacherId, courseId);
        } else if (teacher == null) {
            System.out.printf("Cannot find any teacher match with teacherId %s, modify teacher %s for course %s failed.%n", teacherId, teacherId, courseId);
        } else {
            course.setTeacher(teacher);
            System.out.println(course + " teacher info updated successfully.");
        }
    }

    /**
     * Register a course for a student
     *
     * @param studentId the student's id
     * @param courseId  the course's id
     */
    public void registerCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (course == null) {
            System.out.printf("Cannot find any course match with courseId %s, register course %s for student %s failed.%n", courseId, courseId, studentId);
        } else if (student == null) {
            System.out.printf("Cannot find any student match with studentId %s, register course %s for student %s failed.%n", studentId, courseId, studentId);
        } else if (student.isCourseRegistered(courseId)) {
            System.out.printf("Student %s has already registered course %s, register course %s for student %s failed.%n", studentId, courseId, courseId, studentId);
        } else if (course.canAddStudent(studentId) && student.canAddCourse(courseId)) {
            course.addStudent(student);
            student.addCourse(course);

            System.out.println("Student register course successfully.");
            System.out.println("Latest student info: " + student);
            System.out.println("Latest course info: " + course);
        }
    }
}
