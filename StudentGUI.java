import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }
}

public class StudentGUI extends JFrame {

    private java.util.List<Student> students = new ArrayList<>();
    private DefaultTableModel tableModel;

    JTextField idField, nameField, ageField, courseField, marksField;

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        courseField = new JTextField();
        marksField = new JTextField();

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseField);
        inputPanel.add(new JLabel("Marks:"));
        inputPanel.add(marksField);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"ID", "Name", "Age", "Course", "Marks"}, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");
        JButton avgBtn = new JButton("Average");

        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(avgBtn);

        add(buttonPanel, BorderLayout.SOUTH);


        addBtn.addActionListener(e -> addStudent());


        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                students.remove(row);
                tableModel.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row first!");
            }
        });


        avgBtn.addActionListener(e -> calculateAverage());

        setVisible(true);
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText());

            for (Student s : students) {
                if (s.id == id) {
                    JOptionPane.showMessageDialog(this, "ID already exists!");
                    return;
                }
            }

            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String course = courseField.getText();
            double marks = Double.parseDouble(marksField.getText());

            Student s = new Student(id, name, age, course, marks);
            students.add(s);

            tableModel.addRow(new Object[]{id, name, age, course, marks});

            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void calculateAverage() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data!");
            return;
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.marks;
        }

        double avg = sum / students.size();
        JOptionPane.showMessageDialog(this, "Average Marks: " + avg);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
        marksField.setText("");
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}