package labproject4;


public class Student {
    String studentID;
    String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
    }
}
