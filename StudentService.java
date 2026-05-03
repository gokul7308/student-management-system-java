import java.util.*;

class StudentService {
    List<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    Student searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    void deleteStudent(int id) {
        students.removeIf(s -> s.id == id);
    }

    void updateStudent(int id, Scanner sc) {
        Student s = searchStudent(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("New Name: ");
        s.name = sc.nextLine();

        System.out.print("New Age: ");
        s.age = sc.nextInt();

        sc.nextLine();
        System.out.print("New Course: ");
        s.course = sc.nextLine();

        System.out.print("New Marks: ");
        s.marks = sc.nextDouble();
    }
}
