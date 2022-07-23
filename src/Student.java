import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student extends Person implements IExportable {
    public static ArrayList<Student> students = new ArrayList<>();

    private String studentID;
    private double gpa;

    public static void addFromConsole(){
        System.out.println("Please enter student's information!");
        String name = (String) Utilities.input("Enter student's name: ", "String");
        String gender = (String) Utilities.input("Enter student's gender: ", "String");
        Date dob = (Date) Utilities.input("Enter student's date of birth (yyyy/MM/dd): ", "Date");
        String address = (String) Utilities.input("Enter student's address: ", "String");
        String studentID = (String) Utilities.input("Enter student ID: ", "String");
        double gpa = (double) Utilities.input("Enter student's GPA: ", "Double");

        Student newStudent = new Student(name, gender, dob, address, studentID, gpa);
        students.add(newStudent);

        Utilities.exportToFile(newStudent);

        System.out.println("New student was added successfully");
    }

    public static ArrayList<Student> filterScholarshipStudents() {
        return (ArrayList<Student>) students
                .stream()
                .filter(student -> student.gpa >= 8.0)
                .collect(Collectors.toList());
    }

    public static Student findById(String id) {
        try {
            return students
                .stream()
                .filter(student -> student.studentID.equals(id))
                .findFirst()
                .get();
        } catch (Exception e) {
            return null;
        }
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
    public String toRawString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                this.name, this.gender, Utilities.dateFormatter.format(this.dob),
                this.address, this.studentID, this.gpa
        );
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + name + '\'' +
                ", Gender='" + gender + '\'' +
                ", Date Of Birth=" + Utilities.dateFormatter.format(dob) +
                ", Address='" + address + '\'' +
                ", Student ID='" + studentID + '\'' +
                ", GPA=" + gpa +
                '}';
    }
}
