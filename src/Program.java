import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        inputFromFile();
    }

    public static <T> T input(String question, String type) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);

        T result = null;
        while (result == null) {
            try {
                String in = sc.nextLine();
                result = convert(in, type);
            } catch (Exception e) {
                System.out.println("Input is invalid, try again: ");
            }
        }

        sc.close();
        return result;
    }

    public static Object inputFromFile() {
        try {
            Scanner sc = new Scanner(new File("src/input.txt"));

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] items = line.split(",");
                ArrayList<String> listItems = new ArrayList<>(Arrays.asList(items));

                int type = (int) convert(listItems.get(0), "Integer");

                switch (type) {
                    case 1:
                        String name = (String) Program.input("Enter student's name: ", "String");
                        String gender = (String) Program.input("Enter student's gender: ", "String");
                        Date dob = (Date) Program.input("Enter student's date of birth: ", "Date");
                        String address = (String) Program.input("Enter student's address: ", "String");
                        String studentID = (String) Program.input("Enter student ID: ", "String");
                        double gpa = (double) Program.input("Enter student's GPA: ", "Double");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid file");
        }

        return null;
    }

    public static <T> T convert(String value, String type) throws Exception {
        Object convertedValue = null;
        switch (type) {
            case "String":
                convertedValue = (Object) value;
                break;

            case "Integer":
                convertedValue = (Object) Integer.parseInt(value);
                break;

            case "Double":
                convertedValue = (Object) Double.parseDouble(value);
                break;

            case "Date":
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
                dateFormatter.setLenient(false);
                convertedValue = (Object) dateFormatter.parse(value);
                break;

            default:
                throw new Exception("Invalid type");
        }

        return (T) convertedValue;
    }
}
