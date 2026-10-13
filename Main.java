/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labproject4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        // 1. COURSE SETUP
        int numberOfCourses;

        do {
            System.out.print(
                    "How many courses do you want to create? (At least 3): ");
            numberOfCourses = input.nextInt();
            input.nextLine();

            if (numberOfCourses < 3) {
                System.out.println("You must create at least 3 courses.");
            }

        } while (numberOfCourses < 3);

        for (int i = 0; i < numberOfCourses; i++) {

            System.out.println("\nEnter information for Course " + (i + 1));

            System.out.print("Course name: ");
            String courseName = input.nextLine();

            while (courseName.isEmpty()) {
                System.out.print("Course name cannot be empty. Enter again: ");
                courseName = input.nextLine();
            }

            // Prevent duplicate course names
            boolean duplicateCourse;

            do {
                duplicateCourse = false;

                for (Course course : courses) {
                    if (course.courseName.equals(courseName)) {
                        duplicateCourse = true;
                        break;
                    }
                }

                if (duplicateCourse) {
                    System.out.print(
                            "This course already exists. Enter another name: ");
                    courseName = input.nextLine();
                }

            } while (duplicateCourse);

            System.out.print("Classroom capacity: ");
            int capacity = input.nextInt();
            input.nextLine();

            while (capacity <= 0) {
                System.out.print("Capacity must be positive. Enter again: ");
                capacity = input.nextInt();
                input.nextLine();
            }

            Course course = new Course(courseName, capacity);
            courses.add(course);
        }

        // Display available courses
        System.out.println("\n=== AVAILABLE COURSES ===");

        for (Course course : courses) {
            System.out.println("- " + course.courseName
                    + " (Capacity: " + course.capacity + ")");
        }

        // 2. REGISTER STUDENTS
        while (true) {

            System.out.print(
                    "\nDo you want to register a student? (yes/no): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Please enter yes or no.");
                continue;
            }

            System.out.print("Enter student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter student name: ");
            String name = input.nextLine();

            if (studentID.isEmpty() || name.isEmpty()) {
                System.out.println("Student ID and name cannot be empty.");
                continue;
            }

            System.out.print("Enter course name: ");
            String requestedCourse = input.nextLine();

            // Find the course
            Course selectedCourse = null;

            for (Course course : courses) {
                if (course.courseName.equals(requestedCourse)) {
                    selectedCourse = course;
                    break;
                }
            }

            if (selectedCourse == null) {
                System.out.println(
                        "No course found with that name: " + requestedCourse);
                continue;
            }

            // Check duplicate registration
            boolean alreadyRegistered = false;

            for (Student student : selectedCourse.enrolledStudents) {
                if (student.studentID.equals(studentID)) {
                    alreadyRegistered = true;
                    break;
                }
            }

            if (alreadyRegistered) {
                System.out.println(
                        "This student is already registered for this course.");
                continue;
            }

            // Check classroom capacity
            if (selectedCourse.enrolledStudents.size()
                    >= selectedCourse.capacity) {
                System.out.println(
                        "This course is full. Registration failed.");
                continue;
            }

            // Register the student
            Student newStudent = new Student(studentID, name);
            selectedCourse.enrolledStudents.add(newStudent);

            System.out.println("Registration successful!");
        }

        // 3. VIEW ALL COURSES
        System.out.println("\n=== ALL COURSES ===");

        for (Course course : courses) {
            course.display();
        }

        input.close();
    }
}

