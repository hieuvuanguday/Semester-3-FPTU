/*
 * Nested recursion.
 * A function is not only defined in terms of itself but also is used as 
 * one of the parameters.
 */

package nestedrecursion;
 
public class Main {
    static int fun(int n) {
        if (n>100) return n-10;
        return fun(fun(n+11));

    }
    
    public static void main(String args[]) {
        int r; r = fun(95);
        System.out.println("  " + r);
    }
}

