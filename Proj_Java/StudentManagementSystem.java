package Proj_Java;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Student {
    int rollNo;
    String name;
    int mark1, mark2, mark3;
    int total;
    double average;

    Student(int rollNo, String name, int m1, int m2, int m3) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark1 = m1;
        this.mark2 = m2;
        this.mark3 = m3;
        this.total = m1 + m2 + m3;
        this.average = total / 3.0;
    }
}

public class StudentManagementSystem extends JFrame {

    JTextField txtRoll, txtName, txtM1, txtM2, txtM3;
    JButton btnAdd, btnDelete, btnClear;
    JTable table;
    DefaultTableModel model;

    Student[] students = new Student[100];   // ARRAY
    int count = 0;

    StudentManagementSystem() {

        setTitle("Student Management System");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- FORM PANEL ----------
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createTitledBorder("Student Details"));

        panelForm.add(new JLabel("Roll No"));
        txtRoll = new JTextField();
        panelForm.add(txtRoll);

        panelForm.add(new JLabel("Name"));
        txtName = new JTextField();
        panelForm.add(txtName);

        panelForm.add(new JLabel("Mark 1"));
        txtM1 = new JTextField();
        panelForm.add(txtM1);

        panelForm.add(new JLabel("Mark 2"));
        txtM2 = new JTextField();
        panelForm.add(txtM2);

        panelForm.add(new JLabel("Mark 3"));
        txtM3 = new JTextField();
        panelForm.add(txtM3);

        btnAdd = new JButton("Add Student");
        btnDelete = new JButton("Delete Student");
        panelForm.add(btnAdd);
        panelForm.add(btnDelete);

        add(panelForm, BorderLayout.WEST);

        // ---------- TABLE ----------
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
                "Roll No", "Name", "Mark1", "Mark2", "Mark3", "Total", "Average"
        });

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ---------- CLEAR BUTTON ----------
        btnClear = new JButton("Clear");
        add(btnClear, BorderLayout.SOUTH);

        // ---------- EVENTS ----------
        btnAdd.addActionListener(e -> addStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnClear.addActionListener(e -> clearFields());

        setVisible(true);
    }

    // ---------- ADD STUDENT ----------
    void addStudent() {
        try {
            int roll = Integer.parseInt(txtRoll.getText());
            String name = txtName.getText();
            int m1 = Integer.parseInt(txtM1.getText());
            int m2 = Integer.parseInt(txtM2.getText());
            int m3 = Integer.parseInt(txtM3.getText());

            Student s = new Student(roll, name, m1, m2, m3);
            students[count++] = s;

            model.addRow(new Object[]{
                    s.rollNo, s.name, s.mark1, s.mark2, s.mark3, s.total, s.average
            });

            clearFields();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input!");
        }
    }

    // ---------- DELETE STUDENT ----------
    void deleteStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            model.removeRow(row);

            // Shift array values using LOOP
            for (int i = row; i < count - 1; i++) {
                students[i] = students[i + 1];
            }
            count--;

        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete");
        }
    }

    // ---------- CLEAR ----------
    void clearFields() {
        txtRoll.setText("");
        txtName.setText("");
        txtM1.setText("");
        txtM2.setText("");
        txtM3.setText("");
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
