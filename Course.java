
package labproject4;


import java.util.ArrayList;


public class Course {
    String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        enrolledStudents = new ArrayList<>();
    }

    public void display() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: " + enrolledStudents.size());

        for (Student student : enrolledStudents) {
            student.display();
        }
    }
}
