import java.util.Date;

public class Teacher extends Person {
    private String teachingClass;
    private int hourlyWages;
    private int teachingHoursPerMonth;

    public Teacher(String name, String gender,
                   Date dob, String address,
                   String teachingClas, int hourlyWages,
                   int teachingHoursPerMonth
    ) {
        super(name, gender, dob, address);
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
