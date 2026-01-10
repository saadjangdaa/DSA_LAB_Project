public class Node {
    int id;
    String name;
    String dept;
    Node next;

    public Node(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        next = null;
    }
}
