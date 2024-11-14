package Q5;

import java.util.EmptyStackException;

public class MyStack {

    private Object[] stack;
    private int top;

    public MyStack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void clear() {
        top = -1;
    }

    public void push(Object x) {
        if (top == stack.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = x;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    public Object top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public void traverse() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
