package Q3;

import java.util.NoSuchElementException;

public class MyQueue {

    private Node front;
    private Node rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(String x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public String first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.value;
    }

    public void traverse() {
        Node current = front;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void decimalToBinary(double n) {
        MyQueue queue = new MyQueue();

        while (n > 0) {
            n *= 2;
            if (n >= 1) {
                queue.enqueue("1");
                n -= 1;
            } else {
                queue.enqueue("0");
            }

            if (queue.size > 10) {
                break; // limit the number of digits
            }
        }

        System.out.print("0.");

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
        }

        System.out.println();
    }

}
