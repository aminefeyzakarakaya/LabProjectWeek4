/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labproject4;


import java.util.ArrayList;

public class Course {
    String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public void display() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("Classroom Capacity: " + capacity);
        System.out.println("Enrolled Students: "
                + enrolledStudents.size());

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("Students:");

            for (Student student : enrolledStudents) {
                System.out.println("- " + student.name
                        + " (ID: " + student.studentID + ")");
            }
        }
    }
}

