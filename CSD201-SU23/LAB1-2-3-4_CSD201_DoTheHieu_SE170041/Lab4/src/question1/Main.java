/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question1;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Preorder traversal:");
        tree.preorder(tree.root);
        System.out.println();

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal:");
        tree.postorder(tree.root);
        System.out.println();

        System.out.println("Breadth-first traversal:");
        tree.breadth();
        System.out.println();

        System.out.println("Tree height: " + tree.height());
        System.out.println("Max path cost: " + tree.maxPath());

        System.out.println("Is AVL tree? " + tree.isAVL());
        System.out.println("Is heap? " + tree.isHeap());

        tree.delete(20);
        System.out.println("Inorder traversal after deleting 20:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Min value in the tree: " + tree.min().key);
        System.out.println("Max value in the tree: " + tree.max().key);
        System.out.println("Sum of all values: " + tree.sum());
        System.out.println("Average of all values: " + tree.avg());

        tree.clear();
        System.out.println("Tree cleared. Is empty? " + tree.isEmpty());
    }
}




