package Q5;

import java.util.NoSuchElementException;

public class MyQueue {

    final Object[] queue;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int capacity) {
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Object x) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = x;
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Object value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        return value;
    }

    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return queue[front];
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }
}
