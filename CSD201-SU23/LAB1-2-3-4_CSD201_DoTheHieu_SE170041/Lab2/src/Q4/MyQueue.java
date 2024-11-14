package Q4;

import java.util.NoSuchElementException;

/**
 *
 * @author Hp
 */
public class MyQueue {

    Node front;
    Node rear;
    int size;

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

    public void enqueue(char x) {
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

    public char dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        char value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public char first() {
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

}
