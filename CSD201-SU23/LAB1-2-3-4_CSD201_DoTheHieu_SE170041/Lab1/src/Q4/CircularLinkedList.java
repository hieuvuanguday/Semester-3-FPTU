package Q4;

/**
 *
 * @author Hp
 */
public class CircularLinkedList {

    public static void main(String[] args) {
        MyList list = new MyList();

        // 1. Add to head
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.traverse();
        // 2. Add to tail
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);
        list.traverse();
        // 3. Add after
        Node node = list.search(4);
        if (node != null) {
            list.addAfter(node, 7);
        }
        list.traverse();

        // 5. Count
        System.out.println("Count: " + list.count());

        // 6. Delete from head
        System.out.println("Deleted from head: " + list.deleteFromHead());

        // 7. Delete from tail
        System.out.println("Deleted from tail: " + list.deleteFromTail());

        // 8. Delete after
        node = list.search(1);
        if (node != null) {
            System.out.println("Deleted after: " + list.deleteAfter(node));
        }

        // 9. Delete node
        list.deleteNode(2);
        list.traverse();
        // 10. Search
        node = list.search(5);

        // 11. Delete
        list.delete(node);
        list.traverse();
        // 12. Delete node 2
        list.deleteNode2(1);
        list.traverse();
        // 13. Add before
        node = list.search(4);
        if (node != null) {
            list.addBefore(node, 8);
        }

        // 14. Sort
        list.sort();
        list.traverse();
        // 15. Reverse
        list.reverse();
        list.traverse();
        // 16. To array
        int[] array = list.toArray();
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 17. Merge
        MyList list11 = new MyList();
        list11.addToTail(1);
        list11.addToTail(3);
        list11.addToTail(5);

        MyList list22 = new MyList();
        list22.addToTail(2);
        list22.addToTail(4);
        list22.addToTail(6);

        MyList mergedList = MyList.merge(list11,list22);
        mergedList.traverse();
        System.out.println();

        // 18. Attach
        list.attach(list22);
    }

}

