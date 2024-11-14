package Recursion;

import java.util.Arrays;

/**
 *
 * @author Hp
 */
public class Recursion {

    static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    static int findmin(int a[], int n) {
        if (n == 1) {
            return a[0];
        } else {
            return Math.min(a[n - 1], findmin(a, n - 1));
        }
    }

    static int findsum(int a[], int n) {
        if (n == 0) {
            return 0;
        } else {
            return a[n - 1] + findsum(a, n - 1);
        }
    }

    static int ispalindrome(char a[], int n) {
        if (n <= 1) {
            return 1;
        } else if (a[0] != a[n - 1]) {
            return 0;
        } else {
            return ispalindrome(Arrays.copyOfRange(a, 1, n - 1), n - 2);
        }
    }

    static int binarySearch(int a[], int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return binarySearch(a, low, mid - 1, target);
        } else {
            return binarySearch(a, mid + 1, high, target);
        }
    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / power(x, -n);
        } else if (n % 2 == 0) {
            double y = power(x, n / 2);
            return y * y;
        } else {
            return x * power(x, n - 1);
        }
    }

    static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    static int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static double addReciprocals(int n) {
        if (n == 1) {
            return 1.0;
        } else {
            return 1.0 / n + addReciprocals(n - 1);
        }
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
        }
    }

    static int treeSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + treeSize(root.left) + treeSize(root.right);
        }
    }

    public static void main(String[] args) {
        // Example usage of the sum function
        int n = 5;
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum(n));

        // Example usage of the findmin function
        int[] a = {3, 1, 4, 2};
        System.out.println("Minimum element in array = " + findmin(a, a.length));

        // Example usage of the findsum function
        System.out.println("Sum of elements in array = " + findsum(a, a.length));

        // Example usage of the ispalindrome function
        char[] b = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        System.out.println("Is array a palindrome? " + (ispalindrome(b, b.length) == 1 ? "Yes" : "No"));

        // Example usage of the binarySearch function
        int[] c = {1, 2, 3, 4, 5};
        int target = 3;
        System.out.println("Index of target in array = " + binarySearch(c, 0, c.length - 1, target));

        // Example usage of the GCD function
        int x = 12;
        int y = 18;
        System.out.println("GCD of " + x + " and " + y + " = " + GCD(x, y));

        // Example usage of the power function
        double base = 2.0;
        int exponent = 3;
        System.out.println(base + " raised to the power of " + exponent + " = " + power(base, exponent));

        // Example usage of the fact function
        int m = 5;
        System.out.println(m + "! = " + fact(m));

        // Example usage of the fib function
        int k = 6;
        System.out.println("Fibonacci number at index " + k + " = " + fib(k));

        // Example usage of the addReciprocals function
        int p = 4;
        System.out.println("Sum of first " + p + " reciprocals = " + addReciprocals(p));
    }

}
