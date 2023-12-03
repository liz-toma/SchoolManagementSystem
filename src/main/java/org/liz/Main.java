package org.liz;

import org.liz.dto.SchoolManagementSystem;

/**
 * @author Eliza Toma
 */
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem School = new SchoolManagementSystem("Vanier College");

        School.addDepartment("Computer Science");
        School.addDepartment("Social Science");
        School.addDepartment("Computer Technology");
        School.addDepartment("Math");
        School.addDepartment("Music");
        System.out.println();

        School.addTeacher("Yi", "Wang", "D001");
        School.addTeacher("Damiano", "David", "D002");
        School.addTeacher("Corio", "Snow", "D009");
        System.out.println();

        School.addStudent("Mike", "Conan", "D001");
        School.addStudent("Tom", "Riddle", "D001");
        School.addStudent("Mattheo", "Riddle", "D002");
        School.addStudent("Draco", "Malfoy", "D005");
        School.addStudent("Hermione", "Granger", "D004");
        School.addStudent("Ron", "Weasley", "D004");
        School.addStudent("Harry", "Potter", "D009");
        System.out.println();

        School.addCourse("Intro to programming", 3.0, "D001");
        School.addCourse("Business", 3.0, "D002");
        School.addCourse("Calculus 1", 3.0, "D004");
        School.addCourse("Calculus 2", 3.0, "D004");
        School.addCourse("Linear Algebra 1", 3.0, "D004");
        School.addCourse("Linear Algebra 2", 3.0, "D004");
        School.addCourse("How to talk to people", 1.5, "D009");
        System.out.println();

        School.printCourses();
        School.printDepartments();
        School.printStudents();
        School.printTeachers();
        System.out.println();

        School.modifyCourseTeacher("T001", "C001");
        School.modifyCourseTeacher("T009", "C001");
        School.modifyCourseTeacher("T001", "C008");
        System.out.println();

        School.registerCourse("S001", "C001");
        School.registerCourse("S001", "C002");
        School.registerCourse("S001", "C003");
        School.registerCourse("S001", "C004");
        School.registerCourse("S001", "C005");
        School.registerCourse("S001", "C006");
        System.out.println();

        School.registerCourse("S002", "C001");
        School.registerCourse("S003", "C001");
        School.registerCourse("S004", "C001");
        School.registerCourse("S005", "C001");
        School.registerCourse("S006", "C001");
        System.out.println();

        School.registerCourse("S009", "C001");
        School.registerCourse("S001", "C008");
        School.registerCourse("S001", "C001");
    }
}
