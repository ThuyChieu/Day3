import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Utilities {
    private static Scanner consoleScanner = new Scanner(System.in);
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");

    public static Object input(String question, String type) {
        System.out.println(question);

        Object result = null;
        while (result == null) {
            try {
                String in = consoleScanner.nextLine();
                result = convert(in, type);
            } catch (Exception e) {
                System.out.println("Input is invalid, try again: ");
            }
        }

        return result;
    }

    public static void inputFromFile() {
        System.out.println("Adding data from input.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/input.txt"));

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] items = line.split(",");
                ArrayList<String> listItems = new ArrayList<>(Arrays.asList(items));

                int type = (int) convert(listItems.get(0), "Integer");

                switch (type) {
                    case 1: {
                        String name = (String) convert(listItems.get(1), "String");
                        String gender = (String) convert(listItems.get(2), "String");
                        Date dob = (Date) convert(listItems.get(3), "Date");
                        String address = (String) convert(listItems.get(4), "String");
                        String studentID = (String) convert(listItems.get(5), "String");
                        double gpa = (double) convert(listItems.get(6), "Double");

                        Student newStudent = new Student(name, gender, dob, address, studentID, gpa);
                        Student.students.add(newStudent);
                        break;
                    }

                    case 2: {
                        String name = (String) convert(listItems.get(1), "String");
                        String gender = (String) convert(listItems.get(2), "String");
                        Date dob = (Date) convert(listItems.get(3), "Date");
                        String address = (String) convert(listItems.get(4), "String");
                        String teachingClass = (String) convert(listItems.get(5), "String");
                        int hourlyWages = (int) convert(listItems.get(6), "Integer");
                        int teachingHoursPerMonth = (int) convert(listItems.get(7), "Integer");

                        Teacher newTeacher = new Teacher(name, gender, dob, address, teachingClass, hourlyWages, teachingHoursPerMonth);
                        Teacher.teachers.add(newTeacher);
                        break;
                    }

                    default:
                        throw new Exception("Invalid type");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (sc != null) sc.close();
        }

        System.out.println("Successfully added data from input.txt");
    }

    public static <T extends IExportable> void exportToFile(T data) {
        try {
            String dataToSave = "\n";

            if (data instanceof Student) dataToSave += 1;
            if (data instanceof Teacher) dataToSave += 2;

            dataToSave += "," + data.toRawString();

            Files.write(Paths.get("src/input.txt"), dataToSave.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("Fail when export " + data + " to input.txt");
        }
    }

    public static Object convert(String value, String type) throws Exception {
        switch (type) {
            case "String":
                return (Object) value;

            case "Integer":
                return (Object) Integer.parseInt(value);

            case "Double":
                return (Object) Double.parseDouble(value);

            case "Date":
                dateFormatter.setLenient(false);
                return (Object) dateFormatter.parse(value);

            default:
                throw new Exception("Invalid type");
        }
    }
}
