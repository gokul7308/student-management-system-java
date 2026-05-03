import java.io.*;
import java.util.*;

class FileHandler {
    private static final String FILE_NAME = "students.txt";

    static void saveToFile(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.id + "," + s.name + "," + s.age + "," + s.course + "," + s.marks);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static List<Student> loadFromFile() {
        List<Student> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        Double.parseDouble(data[4])
                );
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }

        return list;
    }
}