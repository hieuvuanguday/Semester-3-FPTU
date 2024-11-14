package Q1;

/**
 *
 * @author Hp
 */
public class MyList {

    private Node head;

    public void addToHead(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void addToTail(int x) {
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

    void addAfter(Node p, int x) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
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

    public int deleteFromHead() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public int deleteFromTail() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        return data;
    }

    int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            return -1;
        }
        // Unlink the node from linked list
        int info = p.next.data;
        p.next = p.next.next;
        return info;
    }

    public void deleteNode(int x) {
        if (head == null) {
            return;
        }
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != x) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    Node search(int x) {
        Node current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }
        return current;
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
        int count = 0;
        while (head != null && count < i) {
            count++;
            head = head.next;
        }
        delete(head);
    }

    void addBefore(Node p, int x) {
        if (p == null || head == null) {
            return;
        }
        if (head == p) {
            addToHead(x);
            return;
        }
        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }
        if (current.next != null) {
            Node newNode = new Node(x);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node nextNode = current.next;
            while (nextNode != null) {
                if (nextNode.data < minNode.data) {
                    minNode = nextNode;
                }
                nextNode = nextNode.next;
            }
            int temp = current.data;
            current.data = minNode.data;
            minNode.data = temp;
            current = current.next;
        }
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    public int[] toArray() {
        int[] array = new int[count()];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    public static MyList merge(MyList list1, MyList list2) {
        MyList mergedList = new MyList();
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.addToTail(current1.data);
                current1 = current1.next;
            } else {
                mergedList.addToTail(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            mergedList.addToTail(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            mergedList.addToTail(current2.data);
            current2 = current2.next;
        }
        return mergedList;
    }

    public void attach(MyList list) {
        if (head == null) {
            head = list.head;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }

    public int max() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public int min() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public int avg() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return sum() / count();
    }

    public boolean sorted() {
        if (head == null || head.next == null) {
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void insert(int x) {
        Node newNode = new Node(x);
        if (head == null || head.data >= x) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data < x) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static boolean sameContents(MyList list1, MyList list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

    public void printNodes() {
        //Node current will point to head  
        Node current = head;
        if (head == null) {
            System.out.println("Singly linked list is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Print each node and then go to next.  
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
