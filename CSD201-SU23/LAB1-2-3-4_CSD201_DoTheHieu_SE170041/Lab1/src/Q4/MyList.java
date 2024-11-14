package Q4;

public class MyList {

    Node head = null;
    Node tail = null;
    int size = 0;

    public void addToHead(int x) {
        Node newNode = new Node(x);

        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addToTail(int x) {
        Node newNode = new Node(x);

        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addAfter(Node p, int x) {
        if (p == null) {
            return;
        }

        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;

        if (p == tail) {
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void traverse() {
        if (size == 0) {
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
 

    public int count() {
        return size;
    }

    public int deleteFromHead() {
        if (size == 0) {
            return -1;
        }

        int data = head.data;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return data;
    }

    public int deleteFromTail() {
        if (size == 0) {
            return -1;
        }

        int data = tail.data;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = head;
        }
        size--;
        return data;
    }

    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            return -1;
        }

        int data = p.next.data;

        if (p.next == tail) {
            tail = p;
            tail.next = head;
        } else {
            p.next = p.next.next;
        }
        size--;
        return data;
    }

    public void deleteNode(int x) {
        if (size == 0) {
            return;
        }

        Node current = head;
        Node prev = null;

        do {
            if (current.data == x) {
                break;
            }

            prev = current;
            current = current.next;
        } while (current != head);

        if (current.data != x) {
            return;
        }

        if (prev == null) {
            deleteFromHead();
        } else if (current == tail) {
            deleteFromTail();
        } else {
            prev.next = current.next;
            size--;
        }
    }

    public Node search(int x) {
        if (size == 0) {
            return null;
        }

        Node current = head;

        do {
            if (current.data == x) {
                return current;
            }

            current = current.next;
        } while (current != head);

        return null;
    }

    public void delete(Node p) {
        if (p == null || size == 0) {
            return;
        }

        Node current = head;
        Node prev = null;

        do {
            if (current == p) {
                break;
            }

            prev = current;
            current = current.next;
        } while (current != head);

        if (current != p) {
            return;
        }

        if (prev == null) {
            deleteFromHead();
        } else if (current == tail) {
            deleteFromTail();
        } else {
            prev.next = current.next;
            size--;
        }
    }

    public int max() {
        if (size == 0) {
            return -1;
        }

        int max = head.data;
        Node current = head.next;

        while (current != head) {
            if (current.data > max) {
                max = current.data;
            }

            current = current.next;
        }
        return max;
    }

    public int min() {
        if (size == 0) {
            return -1;
        }

        int min = head.data;
        Node current = head.next;

        while (current != head) {
            if (current.data < min) {
                min = current.data;
            }

            current = current.next;
        }
        return min;
    }

    public int sum() {
        if (size == 0) {
            return 0;
        }

        int sum = 0;
        Node current = head;

        do {
            sum += current.data;
            current = current.next;
        } while (current != head);

        return sum;
    }

    public int avg() {
        if (size == 0) {
            return 0;
        }

        return sum() / size;
    }

    public void deleteNode2(int i) {
        if (i < 0 || i >= size) {
            return;
        }

        if (i == 0) {
            deleteFromHead();
        } else if (i == size - 1) {
            deleteFromTail();
        } else {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public void addBefore(Node p, int x) {
        if (p == null) {
            return;
        }

        Node newNode = new Node(x);

        if (p == head) {
            addToHead(x);
        } else {
            Node current = head;
            while (current.next != p) {
                current = current.next;
            }
            newNode.next = p;
            current.next = newNode;
            size++;
        }
    }

    public void sort() {
        if (size <= 1) {
            return;
        }

        Node current = head;
        do {
            Node next = current.next;
            while (next != head) {
                if (current.data > next.data) {
                    int temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                next = next.next;
            }
            current = current.next;
        } while (current != head);
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        tail = head;
        head = prev;
        tail.next = head;
    }

    public int[] toArray() {
        int[] array = new int[size];

        Node current = head;
        int i = 0;

        do {
            array[i++] = current.data;
            current = current.next;
        } while (current != head);

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
        if (list.size == 0) return;

        if (size == 0) {
            head = list.head;
            tail = list.tail;
            size = list.size;
        } else {
            tail.next = list.head;
            tail = list.tail;
            size += list.size;
        }
    }
}
