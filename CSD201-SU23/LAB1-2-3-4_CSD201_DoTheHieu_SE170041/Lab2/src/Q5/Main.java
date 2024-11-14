
package Q5;


public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        MyQueue queue = new MyQueue(10);
        
        stack.push("Computer1");
        stack.push("Computer2");
        stack.push("Computer3");
        
        queue.enqueue("Computer1");
        queue.enqueue("Computer2");
        queue.enqueue("Computer3");
        
        System.out.println("Stack: ");
        stack.traverse();
        
        System.out.println("Queue: ");
        queue.traverse();
        
        System.out.println(stack.pop());
        System.out.println(queue.dequeue());
        
        System.out.println("Stack: ");
        stack.traverse();
        
        System.out.println("Queue: ");
        queue.traverse();
    }
}

