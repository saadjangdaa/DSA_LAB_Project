import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // MENU
    public void displayMainMenu() {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student (by ID)");
            System.out.println("5. Search Student (by Name)");
            System.out.println("6. Display All Students");
            System.out.println("8. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    displayAllStudents();
                    break;
                case 7:
                    sortStudents();
                    System.out.println("✓ Students sorted by ID successfully!");
                    break;
                case 8:
                    System.out.println("\nThank you for using SMS. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        System.out.print("Enter Student ID: ");
        int id = getIntInput();

        if (findStudentById(id) != null) {
            System.out.println("ERROR: Student with ID " + id + " already exists!");
            return;
        }

        scanner.nextLine(); 

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("ERROR: Name cannot be empty!");
            return;
        }

        System.out.print("Enter Student Marks: ");
        int marks = getIntInput();

        if (marks < 0 || marks > 100) {
            System.out.println("ERROR: Marks must be between 0 and 100!");
            return;
        }

        Student student = new Student(id, name, marks);
        students.add(student);
        sortStudents();
        System.out.println("✓ Student added successfully!");
    }

    public void updateStudent() {
        System.out.println("\n--- Update Student ---");

        System.out.print("Enter Student ID to Update: ");
        int id = getIntInput();

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("ERROR: Student with ID " + id + " not found!");
            return;
        }

        System.out.println("Current Details: " + student);

        scanner.nextLine(); 

        System.out.print("Enter new Name (or press Enter to skip): ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            student.setName(newName);
        }

        System.out.print("Enter new Marks (or enter -1 to skip): ");
        int newMarks = getIntInput();
        if (newMarks != -1) {
            if (newMarks < 0 || newMarks > 100) {
                System.out.println("ERROR: Marks must be between 0 and 100!");
                return;
            }
            student.setMarks(newMarks);
        }

        System.out.println("✓ Student updated successfully!");
        System.out.println("Updated Details: " + student);
    }

    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        System.out.print("Enter Student ID to Delete: ");
        int id = getIntInput();

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("ERROR: Student with ID " + id + " not found!");
            return;
        }

        System.out.println("Student to Delete: " + student);
        System.out.print("Are you sure? (yes/no): ");
        scanner.nextLine(); 
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            students.remove(student);
            System.out.println("✓ Student deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public void searchById() {
        System.out.println("\n--- Search Student by ID ---");

        System.out.print("Enter Student ID: ");
        int id = getIntInput();

        Student student = findStudentById(id);

        if (student != null) {
            displayTableHeader();
            System.out.println(student.getTableRow());
            displayTableFooter();
        } else {
            System.out.println("ERROR: Student with ID " + id + " not found!");
        }
    }

    public void searchByName() {
        System.out.println("\n--- Search Student by Name ---");

        scanner.nextLine(); 
        System.out.print("Enter Student Name (or part of name): ");
        String searchName = scanner.nextLine();

        ArrayList<Student> results = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No students found with name containing '" + searchName + "'");
        } else {
            System.out.println("\nSearch Results:");
            displayTableHeader();
            for (Student student : results) {
                System.out.println(student.getTableRow());
            }
            displayTableFooter();
        }
    }

    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students in the system!");
            return;
        }

        displayTableHeader();
        for (Student student : students) {
            System.out.println(student.getTableRow());
        }
        displayTableFooter();
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private void displayTableHeader() {
        System.out.println("\n|-------|-----------------------|-------|");
        System.out.println("| ID    | Name                | Marks |");
        System.out.println("|-------|-----------------------|-------|");
    }

    private void displayTableFooter() {
        System.out.println("|-------|-----------------------|-------|");
    }

    private int getIntInput() {
        int value = -1;
        try {
            value = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR: Please enter a valid number!");
            scanner.nextLine(); 
            return -1;
        }
        return value;
    }

    private void sortStudents() {
        for (int i = 1; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            int currentId = currentStudent.getId();

            int j = i - 1;
            while (j >= 0 && students.get(j).getId() > currentId) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, currentStudent);
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.displayMainMenu();
    }
}
