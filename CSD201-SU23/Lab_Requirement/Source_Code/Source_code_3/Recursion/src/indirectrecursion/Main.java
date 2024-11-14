/*
 * Indirect recursion.
 * If f() calls g(), and g() calls f(). It is indirect recursion. 
 * The chain of intermediate calls can be of an arbitrary length, as in: 
 * f() -> f1() -> f2() -> ... -> fn() -> f()
 */

package indirectrecursion;
 
public class Main {
    static void funA(int n) {
        if(n>0) {System.out.print(" " + n); funB(n-1);}
    }
    
    static void funB(int n) {
        if(n>1) {System.out.print(" " + n); funA(n/2);}
    }
    
    public static void main (String[] args) {
        funA(20);
        System.out.println();
    }
}
