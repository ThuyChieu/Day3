import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Teacher extends Person implements IExportable {
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    private String teachingClass;
    private int hourlyWages;
    private int teachingHoursPerMonth;

    public static void addFromConsole(){
        System.out.println("Please enter teacher's information!");
        String name = (String) Utilities.input("Enter teacher's name: ", "String");
        String gender = (String) Utilities.input("Enter teacher's gender: ", "String");
        Date dob = (Date) Utilities.input("Enter teacher's date of birth (yyyy/MM/dd): ", "Date");
        String address = (String) Utilities.input("Enter teacher's address: ", "String");
        String teachingClass = (String) Utilities.input("Enter teaching class: ", "String");
        int hourlyWages = (int) Utilities.input("Enter one hour wage: ", "Integer");
        int teachingHoursPerMonth = (int) Utilities.input("Enter teaching hours per month: ", "Integer");

        Teacher newTeacher = new Teacher(name, gender, dob, address, teachingClass, hourlyWages, teachingHoursPerMonth);
        Teacher.teachers.add(newTeacher);

        Utilities.exportToFile(newTeacher);

        System.out.println("New teacher was added successfully");
    }

    public static ArrayList<Teacher> findByName(String name) {
        return (ArrayList<Teacher>) teachers
                .stream()
                .filter(teacher -> teacher.name.contains(name))
                .collect(Collectors.toList());

    }

    public static Teacher findHighestSalaryTeacher() {
        try {
//            return teachers
//                    .stream()
//                    .sorted((teacher1, teacher2) -> teacher1.getSalary() - teacher2.getSalary())
//                    .findFirst()
//                    .get();
        } catch (Exception e) {
            return null;
        }
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

    public long getSalary() {
        return this.hourlyWages * this.teachingHoursPerMonth + 50000000;
    }

    @Override
    public String toRawString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                this.name, this.gender, Utilities.dateFormatter.format(this.dob),
                this.address, this.teachingClass, this.hourlyWages,
                this.teachingHoursPerMonth
        );
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Name='" + name + '\'' +
                ", Gender='" + gender + '\'' +
                ", Date Of Birth=" + Utilities.dateFormatter.format(dob) +
                ", Address='" + address + '\'' +
                ", Teaching Class='" + teachingClass + '\'' +
                ", Hourly Wages=" + hourlyWages +
                ", Teaching Hours Per Month=" + teachingHoursPerMonth +
                '}';
    }
}
