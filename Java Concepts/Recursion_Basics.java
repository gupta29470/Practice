import java.util.*;

public class Recursion_Basics {

    static int fact = 1;

    public static void main(String[] args) {
        int n = 6, res, f = 1;
        res = fact(n);
        while (n > 0) {
            f *= n;
            n--;
        }
        System.out.println(f);
        System.out.println(sum(100));
        System.out.println(fib(5));
        print_n_to_1(5);
        System.out.println("");
        print_1_to_n(5);
        System.out.println("");
        print_1_to_n_tail_recursion(5, 1);
        System.out.println("");
        System.out.println(fact_tail_recursion(5, 1));
        System.out.println("");
        String s = "MOM";
        System.out.println(isPalindrome(s, 0, s.length() - 1));

    }

    static int fact(int n) {
        if (n == 0) {
            return n;
        }
        return fact(n - 1) * n;
    }

    static int sum(int n) {
        if (n <= 1) {
            return n;
        }
        return sum(n - 1) + n;
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);

    }

    static void print_n_to_1(int n) { // Tail Recursive because after calling function nohing operation is formed.
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        print_n_to_1(n - 1);
    }

    static void print_1_to_n(int n) {
        if (n < 1) {
            return;
        }
        print_1_to_n(n - 1);
        System.out.print(n + " ");
    }

    static void print_1_to_n_tail_recursion(int n, int k) {
        if (n < 1) {
            return;
        }
        System.out.print(k + " ");
        print_1_to_n_tail_recursion(n-1,k+1);
    }

    static int fact_tail_recursion(int n, int k) {
        if (n == 0) {
            return k;
        }
        return fact_tail_recursion(n - 1, n * k);

    }

    static boolean isPalindrome(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        if (left == right) {
            return true;
        }
        if (left > right) {
            return true;
        }
        return isPalindrome(s, left + 1, right - 1);

    }
}
