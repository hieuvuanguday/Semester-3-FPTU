/*
 * Tail recursion
 * There is only one recursive call at the very end of a method implementation.
 */

package tailrecursion;

public class Main {
    public static void tail(int i) {
        if(i>0) {   
            System.out.print(i + "  ");
            tail(i-1);
        }
    }  
    
    public static void main(String [] args) {
        tail(10);
        System.out.println();
    }  
}
