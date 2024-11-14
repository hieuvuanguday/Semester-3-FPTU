
package Q3;

/**
 *
 * @author Hp
 */
public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("Stack: ");
        System.out.println("Is empty: " + stack.isEmpty());
        stack.push("one");
        stack.push("two");
        stack.push("three");
        System.out.println("Traverse: ");
        stack.traverse();
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());
        System.out.println("Traverse: ");
        stack.traverse();
        System.out.println("Clear: ");
        stack.clear();
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("\n-------------------------------------------");
        
        MyQueue queue = new MyQueue();
        System.out.println("\nQueue: ");
        System.out.println("Is empty: " + queue.isEmpty());
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        System.out.println("Traverse: ");
        queue.traverse();
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("First: " + queue.first());
        System.out.println("Traverse: ");
        queue.traverse();
        System.out.println("Clear: ");
        queue.clear();
        System.out.println("Is empty: " + queue.isEmpty());
    }
}

