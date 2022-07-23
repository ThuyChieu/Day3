public class Program {
    public static void main(String[] args) {
        Utilities.inputFromFile();

        boolean isContinue = true;
        while (isContinue) {
            isContinue = execute();
        }
    }

    public static boolean execute() {
        System.out.println("--------ACTIONS--------");
        System.out.println("1. Show all data");
        System.out.println("2. Add new Student");
        System.out.println("3. Add new Teacher");
        System.out.println("4. Filter students that have scholarship");
        System.out.println("5. Find student by id");
        System.out.println("6. Find teacher by name");
        System.out.println("7. Get teacher that has the highest salary");
        System.out.println("8. Sort student by score");
        System.out.println("9. Sort teacher by salary");
        System.out.println("0. Exit");

        int index = (int) Utilities.input("Your choice -> ", "Integer");
        switch (index) {
            case 1:
                System.out.println("----Student List----");
                System.out.println(Student.students);
                System.out.println("----Teacher List----");
                System.out.println(Teacher.teachers);
                break;

            case 2:
                Student.addFromConsole();
                break;

            case 3:
                Teacher.addFromConsole();
                break;

            case 4:
                System.out.println(Student.filterScholarshipStudents());
                break;

            case 5:
                String id = (String) Utilities.input("Enter student ID: ", "String");
                Student foundStudent = Student.findById(id);

                if (foundStudent == null) System.out.println("Not Found");
                else System.out.println(foundStudent);
                break;

            case 6:
                String name = (String) Utilities.input("Enter teacher name: ", "String");
                System.out.println(Teacher.findByName(name));
                break;

            case 0:
                System.out.println("Bye 🙂");
                return false;

            default:
                System.out.println("Invalid choice");
                break;
        }

        Utilities.input("Press enter to continue...", "String");
        return true;
    }
}
