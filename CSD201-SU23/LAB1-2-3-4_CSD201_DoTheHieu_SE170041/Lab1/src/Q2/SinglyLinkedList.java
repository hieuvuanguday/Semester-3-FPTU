
package Q2;

/**
 *
 * @author Hp
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addToHead("C");
        list.addToHead("B");
        list.addToHead("A");
        list.traverse(); // A B C
        list.addToTail("D");
        list.traverse(); // A B C D
        System.out.println(list.count()); // 4
        System.out.println(list.deleteFromHead()); // A
        list.traverse(); // B C D
        System.out.println(list.deleteFromTail()); // D
        list.traverse(); // B C
        Node node = list.search("C");
        list.addAfter(node, "E");
        list.traverse(); // B C E
        list.deleteNode("C");
        list.traverse(); // B E
        node = list.search("E");
        list.delete(node);
        list.traverse(); // B
    }
}

