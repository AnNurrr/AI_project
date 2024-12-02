import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Ainur Emilbekova
// 12/2/2024
public class StudentManagementPortal {




        private ArrayList<String> students = new ArrayList<>();


        public static void main(String[] args) {
            SwingUtilities.invokeLater(StudentManagementPortal::new);
        }

        // Constructor to set up the GUI
        public StudentManagementPortal() {
            JFrame frame = new JFrame("Student Management Portal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Main Panel
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            frame.add(panel);

            // Label
            JLabel titleLabel = new JLabel("Student Management Portal", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(titleLabel);

            // TextField for student name
            JTextField studentNameField = new JTextField();
            studentNameField.setMaximumSize(new Dimension(300, 30));
            panel.add(studentNameField);


            JButton addButton = new JButton("Add Student");
            panel.add(addButton);

            // Display Students Button
            JButton displayButton = new JButton("Display Students");
            panel.add(displayButton);

            // TextArea to display student list
            JTextArea displayArea = new JTextArea(10, 30);
            displayArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(displayArea);
            panel.add(scrollPane);

            // Add Button Action
            addButton.addActionListener(e -> {
                String name = studentNameField.getText().trim();
                if (!name.isEmpty()) {
                    students.add(name);
                    studentNameField.setText("");
                    JOptionPane.showMessageDialog(frame, "Student Added: " + name);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a student name!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Display Button Action
            displayButton.addActionListener(e -> {
                if (students.isEmpty()) {
                    displayArea.setText("No students to display.");
                } else {
                    StringBuilder studentList = new StringBuilder("Students:\n");
                    for (int i = 0; i < students.size(); i++) {
                        studentList.append(i + 1).append(". ").append(students.get(i)).append("\n");
                    }
                    displayArea.setText(studentList.toString());
                }
            });

            // Set visible
            frame.setVisible(true);
        }
    }


