import java.io.*;
import java.util.*;

public class SearchSystem {

    static Student[] arr = new Student[100];
    static int size = 0;
    static StudentLinkedList list = new StudentLinkedList();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");
            int id = Integer.parseInt(p[0]);
            String name = p[1];
            String dept = p[2];

            arr[size++] = new Student(id, name, dept);
            list.insert(id, name, dept);
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Search (Array)");
            System.out.println("2. Search (LinkedList)");
            System.out.println("3. Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 3) break;

            System.out.print("Enter Keyword: ");
            String key = sc.nextLine();

            if (ch == 1) arraySearch(key);
            else if (ch == 2) list.search(key);
        }
    }

    static void arraySearch(String key) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i].name.toLowerCase().contains(key.toLowerCase()) ||
                arr[i].dept.toLowerCase().contains(key.toLowerCase())) {
                System.out.println(arr[i].id + "  " + arr[i].name + "  " + arr[i].dept);
                found = true;
            }
        }
        if (!found) System.out.println("No Record Found");
    }
}
