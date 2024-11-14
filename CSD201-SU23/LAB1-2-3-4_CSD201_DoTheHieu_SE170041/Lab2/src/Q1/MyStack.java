package Q1;

import java.util.EmptyStackException;

public class MyStack {

    private Node top;
    private int size;

    private class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    //1. return true if the stack is empty and false otherwise.
    public boolean isEmpty() {
        return top == null;
    }

    // 2. clear the stack
    public void clear() {
        top = null;
        size = 0;
    }

    //3. insert a node with value x at the top of the stack.
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    //4. remove the top element on the stack and return it's value
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // 5. return value of a node at the top of the stack
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    //6. display all values in the stack from the top to the bottom
    public void traverse() {
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    //7. decimal system to binary
    public static void decimalToBinary(int n) {
        MyStack stack = new MyStack();
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("Is stack empty? " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.top());
        System.out.println("Traversing stack:");
        stack.traverse();
        System.out.println("Clearing stack");
        stack.clear();
        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.print("Converting decimal 10 to binary: ");
        decimalToBinary(10);
    }

}
