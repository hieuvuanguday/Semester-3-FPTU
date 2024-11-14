package Q2;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    private final LinkedList<Integer> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    //1. return true if the queue is empty and false otherwise
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    //2. clear the queue.
    public void clear() {
        queue.clear();
    }

    //3. insert a node with value x at the end of the queue.
    public void enqueue(int x) {
        queue.addLast(x);
    }

    //4. remove the first element on the queue and return it's value
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.removeFirst();
    }

    //5. return value of the first node of the queue
    public int first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.getFirst();
    }

    //6. display all values in the queue from the front to the rear
    public void traverse() {
        for (int value : queue) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void decimalToBinary(double num) {
        StringBuilder binary = new StringBuilder("0.");
        Queue<Integer> q = new LinkedList<>();

        while (num > 0) {
            num *= 2;
            if (num >= 1) {
                q.add(1);
                num -= 1;
            } else {
                q.add(0);
            }

            if (binary.length() >= 32) { // limit the length of the binary representation
                binary.append("...");
                break;
            }

            binary.append(q.remove());
        }

        System.out.println(binary.toString());
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        System.out.println("Is the queue empty? " + q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("Queue after enqueuing: ");
        q.traverse();
        System.out.println("First element: " + q.first());
        System.out.println("Dequeue element: " + q.dequeue());
        System.out.println("Queue after dequeue: ");
        q.traverse();
        q.clear();
        System.out.println("Queue after clearing: ");
        q.traverse();
    }

}
