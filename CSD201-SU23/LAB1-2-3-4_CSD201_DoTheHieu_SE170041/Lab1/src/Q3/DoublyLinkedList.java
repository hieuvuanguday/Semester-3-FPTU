
package Q3;


public class DoublyLinkedList {
    public static void main(String[] args) {
        // Create a DoublyLinkedList object
        MyList dl_List = new MyList();  
        // Add nodes to the list  
        dl_List.addToHead(40);
        dl_List.addToHead(50);  
        dl_List.addToHead(60);
         // Print the nodes of DoublyLinkedList  
        dl_List.printNodes(); 
        dl_List.addToTail(30);  
        dl_List.addToTail(20);  
        dl_List.addToTail(10);    
        // Print the nodes of DoublyLinkedList  
        dl_List.printNodes();       
        // Delete the first node
        dl_List.deleteFromHead();
        dl_List.deleteFromHead();
        dl_List.printNodes();  
        // Delete the last node
        dl_List.deleteFromTail();
        dl_List.deleteFromTail();
        dl_List.printNodes();  
        //min-max
        
        System.out.println("Min value: " + dl_List.min());

        
        System.out.println("Max value: " + dl_List.max());

    } 
}
