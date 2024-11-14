package Q2;

/**
 *
 * @author Hp
 */
public class MyList {

    private Node head;

    public void addToHead(String x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void addToTail(String x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String deleteFromHead() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    void delete(Node p) {
        if (head == null || p == null) {
            return;
        }
        if (head == p) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void deleteNode2(int i) {
        if (i < 0 || i >= count()) {
            throw new RuntimeException("Index out of bounds");
        }
        if (i == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int j = 0; j < i - 1; j++) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    String deleteAfter(Node p) {
        if (p == null || p.next == null) {
            throw new RuntimeException("Cannot delete");
        }
        String data = p.next.data;
        p.next = p.next.next;
        return data;
    }

    public void deleteNode(String x) {
        if (head == null) {
            return;
        }
        if (head.data.equals(x)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.equals(x)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    Node search(String x) {
        Node current = head;
        while (current != null && !current.data.equals(x)) {
            current = current.next;
        }
        return current;
    }

    public String deleteFromTail() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head.next == null) {
            String data = head.data;
            head = null;
            return data;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        String data = current.next.data;
        current.next = null;
        return data;
    }

    public void addAfter(Node p, String x) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

}
