import java.util.ArrayList;
import java.util.Date;

public class Student extends Person {
    public static ArrayList<Student> students = new ArrayList<>();

    private String studentID;
    private double gpa;

    public static void addFromConsole(){
        System.out.println("Please enter student's information!");
        String name = (String) Program.input("Enter student's name: ", "String");
        String gender = (String) Program.input("Enter student's gender: ", "String");
        Date dob = (Date) Program.input("Enter student's date of birth: ", "Date");
        String address = (String) Program.input("Enter student's address: ", "String");
        String studentID = (String) Program.input("Enter student ID: ", "String");
        double gpa = (double) Program.input("Enter student's GPA: ", "Double");

        Student newStudent = new Student(name, gender, dob, address, studentID, gpa);
        students.add(newStudent);
        System.out.println("New student is added successfully");
    }

    //constructor khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng
    public Student(
            String name, String gender,
            Date dob, String address,
            String studentID, double gpa
    ) {
        super(name, gender, dob, address);
        this.studentID = studentID;
        this.gpa = gpa;
    }

    // Getters
    public String getStudentID() { return this.studentID; }
    public double getGpa() { return this.gpa; }

    // Setters
    public String setStudentID(String name) { return this.studentID = studentID; }
    public double setGpa(String gender) { return this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", gpa=" + gpa +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}';
    }
}
