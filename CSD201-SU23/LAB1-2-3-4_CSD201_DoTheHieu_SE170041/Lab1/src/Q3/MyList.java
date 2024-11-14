package Q3;

/**
 *
 * @author Hp
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
    }

    public void addToHead(int x) {
        Node node = new Node(x);
        if (isEmpty()) {
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
        }
        head = node;
        size++;
    }

    public void addToTail(int x) {
        Node node = new Node(x);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node node = new Node(x);
        if (p == tail) {
            addToTail(x);
        } else {
            node.next = p.next;
            p.next.prev = node;
            p.next = node;
            node.prev = p;
            size++;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int count() {
        return size;
    }

    public int deleteFromHead() {
        if (isEmpty()) {
            return -1;
            
        }
        int data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public int deleteFromTail() {
        if (isEmpty()) {
            return -1;
        }
        int data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    int deleteAfter(Node p) {
        if (p == null) {
            return -1;
        }
        if (p == tail) {
            return -1;
        }
        int data = p.next.data;
        if (p.next == tail) {
            deleteFromTail();
        } else {
            p.next.next.prev = p;
            p.next = p.next.next;
            size--;
        }
        return data;
    }

    public void deleteNode(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                if (current == head) {
                    deleteFromHead();
                } else if (current == tail) {
                    deleteFromTail();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                break;
            }
            current = current.next;
        }
    }

    public void sort() {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

 // 19. find and return the maximum value in the list.
    public int max() {
        if (head == null) {
            return -1;
        }
        int max = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    // 20. find and return the minimum value in the list
    public int min() {
        if (head == null) {
            return -1;
        }
        int min = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        return min;
    }

    public int sum() {
        int sum = 0;
        for (Node i = head; i != null; i = i.next) {
            sum += i.data;
        }
        return sum;
    }

    public double avg() {
        return (double) sum() / size;
    }

    public boolean sorted() {
        for (Node i = head; i != null && i.next != null; i = i.next) {
            if (i.data > i.next.data) {
                return false;
            }
        }
        return true;
    }

    public void insert(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            addToHead(x);
        } else {
            Node current = head;
            while (current != null && current.data < x) {
                current = current.next;
            }
            if (current == null) {
                addToTail(x);
            } else {
                addAfter(current.prev, x);
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    // Print all the nodes of doubly linked list  
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print(current.data + " ");  
            current = current.next;  
        } 
        System.out.println();
    }

}

//    
//    
//    // Add a new node at the beginning of a list
//    public void addFirst(int item) {
//        //Create a new node  
//        Node newNode = new Node(item);   
//        //if list is empty, head and tail points to newNode  
//        if(head == null) {  
//            head = tail = newNode;  
//            //head's previous will be null  
//            head.previous = null;  
//            //tail's next will be null  
//            tail.next = null;  
//        }  else {  
//            newNode.next = head; 
//            head = newNode;
//            head.previous = null;   
//        }  
//    }
//
//    // Add a new node at the end of the list  
//    public void addLast(int item) {  
//        //Create a new node  
//        Node newNode = new Node(item);   
//        //if list is empty, head and tail points to newNode  
//        if(head == null) {  
//            head = tail = newNode;  
//            //head's previous will be null  
//            head.previous = null;  
//            //tail's next will be null  
//            tail.next = null;  
//        }  
//        else {  
//            //add newNode to the end of list. tail->next set to newNode  
//            tail.next = newNode;  
//            //newNode->previous set to tail  
//            newNode.previous = tail;  
//            //newNode becomes new tail  
//            tail = newNode;  
//            //tail's next point to null  
//            tail.next = null;  
//        }  
//    } 
//    
//    // Deleting a node from the beginning of a list
//    public void deleFirst() {
//        Node p = head;
//        if(p==null) return;
//        //if head in not null and next of head is null, delete the head
//        if(p.next==null) {
//            p = null;
//        } else {
//            head = p.next;
//            head.previous = null;
//        }
//    }
//    
//    // Delete a node from the end of the list 
//    public void deleLast() {
//        if(this.head != null) {
//            //if head in not null and next of head is null, release the head
//            if(this.head.next == null) {
//                this.head = null;
//            } else {
//            //Else, traverse to the second last element of the list
//                Node temp = new Node();
//                temp = this.head;
//                while(temp.next.next != null)
//                    temp = temp.next;
//            //Change the next of the second last node to null and delete the last node
//                Node lastNode = temp.next;
//                temp.next = null; 
//                lastNode = null;
//            }
//        }
//    }
//
      
    
//}
//
