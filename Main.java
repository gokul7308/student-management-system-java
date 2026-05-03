import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        // Load data from file
        service.students = FileHandler.loadFromFile();

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    service.addStudent(new Student(id, name, age, course, marks));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student s = service.searchStudent(sc.nextInt());
                    System.out.println(s != null ? s : "Not found");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    service.updateStudent(sc.nextInt(), sc);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    service.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    FileHandler.saveToFile(service.students);
                    System.out.println("Data saved. Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
                    
            }
        }
    }
}