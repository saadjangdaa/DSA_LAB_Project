public class StudentLinkedList {
    Node head;

    public void insert(int id, String name, String dept) {
        Node n = new Node(id, name, dept);
        if (head == null) head = n;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = n;
        }
    }

    public void search(String key) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.toLowerCase().contains(key.toLowerCase()) ||
                temp.dept.toLowerCase().contains(key.toLowerCase())) {
                System.out.println(temp.id + "  " + temp.name + "  " + temp.dept);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No Record Found");
    }
}
