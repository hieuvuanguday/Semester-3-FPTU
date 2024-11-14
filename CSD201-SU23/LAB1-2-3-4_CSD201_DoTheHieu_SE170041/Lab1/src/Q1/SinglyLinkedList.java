
package Q1;

public class SinglyLinkedList {

    
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addToHead(3);
        list.addToHead(2);
        list.addToHead(1);
        //list.traverse(); // 1 2 3
        list.printNodes();
        list.addToTail(4);
        //list.traverse(); // 1 2 3 4
        list.printNodes();
        System.out.println("Count: " + list.count()); // 4
        System.out.println("Min: " + list.min());
        System.out.println("Max: " + list.max());
        System.out.println("Sum: " + list.sum());
        System.out.println("Avg: " + list.avg());
        System.out.println("Delete From Head: " + list.deleteFromHead()); // 1
        //list.traverse(); // 2 3 4
        //list.printNodes();
        System.out.println("Delete From Tail:" + list.deleteFromTail()); // 4
        list.printNodes();
        //list.traverse(); // 2 3
        Node node = list.search(3);
        list.addAfter(node, 5);
       // list.traverse(); // 2 3 5
        list.printNodes();
        list.deleteNode(3);
        //list.traverse(); // 2 5
        list.printNodes();
        node = list.search(5);
        list.delete(node);
        //list.traverse(); // 2
        list.printNodes();
        MyList List = new MyList();
        List.addToHead(6);
        List.addToHead(5);
        MyList mergedList = MyList.merge(list, List);
        //mergedList.traverse(); // 2 5 6
        mergedList.printNodes();
        
        
    }
    
}
