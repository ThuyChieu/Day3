import java.util.Date;

public class Person {
    protected String name;
    protected String gender;
    protected Date dob;
    protected String address;

    //constructor khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng
    public Person(
            String name, String gender,
            Date dob, String address
    ) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    // Getters
    public String getName() { return this.name; }
    public String getGender() { return this.gender; }
    public Date getDob() { return this.dob; }
    public String getAddress() { return this.address; }

    // Setters
    public String setName(String name) { return this.name = name; }
    public String setGender(String gender) { return this.gender = gender; }
    public Date setDob(Date dob) { return this.dob = dob; }
    public String setAddress(String address) { return this.address = address; }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}';
    }
}
