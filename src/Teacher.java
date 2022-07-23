import java.util.Date;

public class Teacher extends Person {
    private String teachingClass;
    private int hourlyWages;
    private int teachingHoursPerMonth;

    //constructor khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng
    public Teacher(String name, String gender,
                   Date dob, String address,
                   String teachingClas, int hourlyWages,
                   int teachingHoursPerMonth
    ) {
        super(name, gender, dob, address); //gọi trực tiếp Constructor của lớp cha
        this.teachingHoursPerMonth = teachingHoursPerMonth;
        this.teachingClass = teachingClas;
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
