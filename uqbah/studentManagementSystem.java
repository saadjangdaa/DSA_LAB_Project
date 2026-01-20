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
    }

    // public void menu() {
    //     int choice;
    //     Scanner newScan = new Scanner(System.in);
    //     // choice = newScan.nextInt();
    //     System.out.println("Enter your choice: ");
    //     choice = newScan.nextInt();

    //     switch (choice) {
    //         case 1:
    //             this.addStudent();
    //             newScan.close();
    //             break;
    //         case 2:
    //             // login();
    //     }
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