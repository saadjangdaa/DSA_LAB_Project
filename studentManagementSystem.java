import java.util.Scanner;

public class studentManagementSystem {
    student studentArr[];
    int size;
    int count = 0;

    studentManagementSystem(int s) {
        studentArr = new student[s];
        this.size = s;
    }

    public void menu(int choice) {
        switch (choice) {
            case 1:
                // login();
                break;
            case 2:
                this.addStudent();
                break;
            case 3:
                this.displayStudents();
                break;
            case 4:
                System.out.println("Exiting Program!");
                System.exit(0);
        }
    }

    boolean isFull() {
        return (count == size);
    }

    boolean isEmpty() {
        return count == 0;
    }

    void addStudent() {
        if (isFull()) {
            System.out.println("The seats are full, Kindly wait for the next induction session");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter enrollment year: ");
        int enYear = sc.nextInt();
        if (enYear != 2024) {
            sc.close();
            System.out.println("Only students enrolled in 2024 are allowed");
            return;
        }
        sc.nextLine();
        System.out.println("Enter Student name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student ID: ");
        String ID = sc.nextLine();
        System.out.println("Enter Student age: ");
        int age = sc.nextInt();
        sc.nextLine();
        // sc.close();
        student s = new student(enYear, name, ID, age);
        studentArr[count++] = s;

        SortStudents();
    }

    void SortStudents() {
        for (int i = 1; i < count; i++) {
            student second_std = studentArr[i];

            int second_std_id = Integer.parseInt(second_std.ID.substring(second_std.ID.length() - 2));

            for (int j = i - 1; j >= 0; j--) {
                int first_std_id = Integer.parseInt(studentArr[j].ID.substring(studentArr[j].ID.length() - 2));

                if (first_std_id > second_std_id) {
                    studentArr[j + 1] = studentArr[j];
                    studentArr[j] = second_std;
                } else {
                    break;
                }
            }
        }
    }

    // public void menu() {
    // int choice;
    // Scanner newScan = new Scanner(System.in);
    // // choice = newScan.nextInt();
    // System.out.println("Enter your choice: ");
    // choice = newScan.nextInt();

    // switch (choice) {
    // case 1:
    // this.addStudent();
    // newScan.close();
    // break;
    // case 2:
    // // login();
    // }
    // }

    void deleteStudent(String id) {
        for (int i = 0; i < count; i++) {
            if (studentArr[i].ID.equals(id)) {
                while (i < count - 1) {
                    studentArr[i] = studentArr[i + 1];
                    i++;
                }
                studentArr[count - 1] = null;
                count--;
                System.out.println("The Student data was deleted");
                return;
            }
        }
        System.out.println("No such student was found to delete!");
    }

    void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students enrolled to be displayed!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Enrollment Year: " + studentArr[i].enYear);
            System.out.println("Student name: " + studentArr[i].name);
            System.out.println("Student ID: " + studentArr[i].ID);
            System.out.println("Student age: " + studentArr[i].age);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        studentManagementSystem sms = new studentManagementSystem(500);
        Scanner choiceScan = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome To Student Management System.\n-------------------------------------\n");
            System.out.println("What action do you want to perform? \n 1. Login \n 2. Add Students \n 3. Display Students \n 4. Exit \n");
            System.out.println("Enter your choice: ");
            int choice = choiceScan.nextInt();
            sms.menu(choice);
        }
    }
}

class student {
    int enYear;
    String name;
    String ID;
    int age;

    student(int year, String n, String id, int a) {
        this.enYear = year;
        this.name = n;
        this.ID = id;
        this.age = a;
    }

    void displayStudent() {
        System.out.println("Student name: " + this.name);
        System.out.println("Student ID: " + this.ID);
        System.out.println("Student age: " + this.age);
    }
}