import java.util.ArrayList;
import java.util.Date;

public class Teacher extends Person {
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    private String teachingClass;
    private int hourlyWages;
    private int teachingHoursPerMonth;

    public static void addFromConsole(){
        System.out.println("Please enter teacher's information!");
        String name = (String) Program.input("Enter teacher's name: ", "String");
        String gender = (String) Program.input("Enter teacher's gender: ", "String");
        Date dob = (Date) Program.input("Enter teacher's date of birth: ", "Date");
        String address = (String) Program.input("Enter teacher's address: ", "String");
        String teachingClass = (String) Program.input("Enter teaching class: ", "String");
        int hourlyWages = (int) Program.input("Enter one hour wage: ", "Integer");
        int teachingHoursPerMonth = (int) Program.input("Enter teaching hours per month: ", "Integer");

        Teacher newTeacher = new Teacher(name, gender, dob, address, teachingClass, hourlyWages, teachingHoursPerMonth);
        Teacher.teachers.add(newTeacher);
        System.out.println("New teacher is added successfully");
    }

    //constructor khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng
    public Teacher(String name, String gender,
                   Date dob, String address,
                   String teachingClass, int hourlyWages,
                   int teachingHoursPerMonth
    ) {
        super(name, gender, dob, address); //gọi trực tiếp Constructor của lớp cha
        this.teachingHoursPerMonth = teachingHoursPerMonth;
        this.teachingClass = teachingClass;
        this.hourlyWages = hourlyWages;
    }
    // Getters
    public String getTeachingClass() { return this.teachingClass; }
    public int getHourlyWages() { return this.hourlyWages; }
    public int getTeachingHoursPerMonth() { return this.teachingHoursPerMonth; }

    // Setters
    public String setTeachingClass() { return this.teachingClass = teachingClass; }
    public int setHourlyWages() { return this.hourlyWages = hourlyWages; }
    public int setTeachingHoursPerMonth() { return this.teachingHoursPerMonth = teachingHoursPerMonth; }

    @Override
    public String toString() {
        return "Teacher{" +
                "teachingClass='" + teachingClass + '\'' +
                ", hourlyWages=" + hourlyWages +
                ", teachingHoursPerMonth=" + teachingHoursPerMonth +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}';
    }
}
