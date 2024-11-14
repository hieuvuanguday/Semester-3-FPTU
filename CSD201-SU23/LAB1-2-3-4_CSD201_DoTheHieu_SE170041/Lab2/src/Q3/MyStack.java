package Q3;

import java.util.EmptyStackException;

public class MyStack {

    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void push(String x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public String top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public void traverse() {
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
}
