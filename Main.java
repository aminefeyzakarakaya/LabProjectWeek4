
package labproject4;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyb = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        // CREATE COURSES
        int numberOfCourses;

        do {
            System.out.print("How many courses? (at least 3): ");
            numberOfCourses = keyb.nextInt();
            keyb.nextLine();

        } while (numberOfCourses < 3);

        for (int i = 0; i < numberOfCourses; i++) {

            System.out.print("Course name: ");
            String courseName = keyb.nextLine();

            System.out.print("Capacity: ");
            int capacity = keyb.nextInt();
            keyb.nextLine();

            while (capacity <= 0) {
                System.out.print("Enter a positive capacity: ");
                capacity = keyb.nextInt();
                keyb.nextLine();
            }

            Course course = new Course(courseName, capacity);
            courses.add(course);
        }
        
            System.out.println("\n===== AVAILABLE COURSES =====");

            for (Course course : courses) {
                System.out.println("Course Name: " + course.courseName
                        + " | Capacity: " + course.capacity);
            }

        

        // MENU
        int choice = 0;

        while (choice != 3) {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = keyb.nextInt();
            keyb.nextLine();

            if (choice == 1) {

                // REGISTER STUDENT
                System.out.print("Student ID: ");
                String studentID = keyb.nextLine();

                System.out.print("Student name: ");
                String name = keyb.nextLine();

                System.out.print("Course name: ");
                String courseName = keyb.nextLine();

                Course selectedCourse = null;

                for (Course course : courses) {
                    if (course.courseName.equals(courseName)) {
                        selectedCourse = course;
                        break;
                    }
                }

                if (selectedCourse == null) {
                    System.out.println("Course not found.");
                } else {

                    boolean alreadyRegistered = false;

                    for (Student student : selectedCourse.enrolledStudents) {
                        if (student.studentID.equals(studentID)) {
                            alreadyRegistered = true;
                            break;
                        }
                    }

                    if (alreadyRegistered) {
                        System.out.println("Student already registered.");

                    } else if (selectedCourse.enrolledStudents.size()
                            >= selectedCourse.capacity) {
                        System.out.println("Course is full.");

                    } else {
                        Student student = new Student(studentID, name);
                        selectedCourse.enrolledStudents.add(student);
                        System.out.println("Registration successful!");
                    }
                }

            } else if (choice == 2) {

                // VIEW ALL COURSES
                System.out.println("\n===== ALL COURSES =====");

                for (Course course : courses) {
                    course.display();
                }

            } else if (choice == 3) {

                System.out.println("Exiting program...");

            } else {

                System.out.println("Invalid choice!");
            }
        }

        keyb.close();
    }
}

