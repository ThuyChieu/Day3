import java.util.Date;

public class Student extends Person {
    String studentID;
    double gpa;

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
