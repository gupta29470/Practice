import java.io.*;
import java.util.*;

public class vit {

    public static void main(String args[]) {
        int x = 10, n = 1;
        printDecreasing(x);
        printIncreasing(x, n);
    }

    public static void printIncreasing(int x, int n) {

        if (n > x) {
            return;
        }
        System.out.println(n);
        printIncreasing(x, n + 1);
    }

    public static void printDecreasing(int x) {
        if (x == 0) {
            return;
        }
        System.out.println(x);
        printDecreasing(x - 1);
    }

}

import java.io.*;
import java.util.*;

public class vit {

    public static void main(String args[]) {
        int x = 10, n = 1;

        System.out.println(factorial(5));

    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

}


import java.io.*;
import java.util.*;

public class vit {

    public static void main(String args[]) {
        int x = 10, n = 1;

        System.out.println(power(5, 5));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return power(x, n - 1) * x;
    }

}

import java.io.*;
import java.util.*;

public class vit {

    public static void main(String args[]) {
        int x = 10, n = 1;

        System.out.println(power(5, 5));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int pow = power(x, n / 2);
        int res = pow * pow;

        if (n % 2 == 1) {
            res = res * x;
        }
        return res;
    }

}



public class vita {

    public static void main(String[] args) {
        String input = "aabaa";

        System.out.println(printDecreasing(10));
        System.out.println(printIncreasing(1));
        printIncreasing_2(10);
        System.out.println("");
        System.out.println(printInRange(5, 15));
        System.out.println(printFactorial(6));
        printDecreasing_Increasing(3);
        System.out.println("");
        System.out.println(printNthfibonacci(5));

        // Tail Recursion
        printIncreasing_tailRecursive(10, 1);
        System.out.println("");
        System.out.println(printFactorial_tailRecursive(6, 1));
        System.out.println(isPalindrome(input, 0, input.length() - 1));
        System.out.println(addDigits(253));
        System.out.println(maxCutRopes(5, 2, 1, 5));
        stringSubset("ABC", "", 0);
    }

    public static int printDecreasing(int n) {
        if (n == 1) {
            return n;
        }
        System.out.print(n + " ");
        return printDecreasing(n - 1);
    }

    public static int printIncreasing(int n) {
        if (n == 10) {
            return n;
        }
        System.out.print(n + " ");
        return printIncreasing(n + 1);
    }

    public static void printIncreasing_2(int n) {
        if (n <= 0) {
            return;
        }
        printIncreasing_2(n - 1);
        System.out.print(n + " ");
    }

    public static int printInRange(int start, int end) {
        if (start == end) {
            return start;
        }
        System.out.print(start + " ");
        return printInRange(start + 1, end);
    }

    public static int printFactorial(int n) {
        if (n <= 1) {
            return n;
        }
//        if (n == 1) {
//            return n;
//        }
        return n * printFactorial(n - 1);
    }

    public static void printDecreasing_Increasing(int n) {
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        printDecreasing_Increasing(n - 1);
        System.out.print(n + " ");
    }

    public static int printNthfibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return printNthfibonacci(n - 1) + printNthfibonacci(n - 2);
    }

    public static void printIncreasing_tailRecursive(int n, int k) {
        if (n < 1) {
            return;
        }
        System.out.print(k + " ");
        printIncreasing_tailRecursive(n - 1, k + 1);
    }

    public static int printFactorial_tailRecursive(int n, int k) {
        if (n <= 1) {
            return k;
        }
        return k * printFactorial_tailRecursive(n - 1, k + 1);
    }

    public static boolean isPalindrome(String input, int start, int end) {
        if (start == end) { // only one character or odd lngth string
            return true;
        }
        if (start > end) { // even length string 
            return true;
        }
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }
        return isPalindrome(input, start + 1, end - 1);
    }

    public static int addDigits(int n) {
        if (n < 10) {
            return n;
        }
        return addDigits(n / 10) + (n % 10);
    }

    public static int maxCutRopes(int n, int a, int b, int c) {

        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }

        int res = Math.max(maxCutRopes(n - a, a, b, c),
                Math.max(maxCutRopes(n - b, a, b, c), maxCutRopes(n - c, a, b, c)));
        if (res < 0) {
            return -1;
        }
        return res + 1;
        // Time -- > O(3^n)
    }

    public static void stringSubset(String input, String currentString, int index) {
        if (index == input.length()) {
            System.out.print(currentString + " ");
            return;
        }
        stringSubset(input, currentString, index + 1);
        stringSubset(input, currentString + input.charAt(index), index + 1);
    }

}


// Power Logarithmic
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        System.out.println(power(x, n));
    }

    public static int power(int x, int n){
        if (n <= 0){
            return 1;
        }
        int xpb2 = power(x, n / 2);
        int res = xpb2 * xpb2;
        
        if (n % 2 == 1){
            res = res * x;
        }
        return res;
    }

}


// Print Zig Zag
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pzz(n);
    }

    public static void pzz(int n){
        if (n == 0){
            return;
        }
        System.out.print(n+" ");
        pzz(n - 1);
        System.out.print(n+" ");
        pzz(n - 1);
        System.out.print(n+" ");
    }

}



// Tower of Hanoi
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        
        toh(n, n1, n2, n3);
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
    if(n == 0){
      return;
    }
    
    toh(n - 1, t1id, t3id, t2id);
    System.out.println(n + "[" + t1id + " -> " + t2id + "]");
    toh(n - 1, t3id, t2id, t1id);
  }

}


//Max Of An Array 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int inputArray[] = new int[size];
        for (int index = 0; index < size; index++) {
            inputArray[index] = Integer.parseInt(br.readLine());
        }
        int idx = 1;
        int max = maxOfArray(inputArray, idx);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        
        
        if (idx == arr.length - 1){
            return arr[idx];
        }
        int misa = maxOfArray(arr, idx + 1);
        if (misa > arr[idx]){
            return misa;
        }
        else{
            return arr[idx];
        }
    }

}


// first Index
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int inputArray[] = new int[size];
        for (int index = 0; index < size; index++) {
            inputArray[index] = Integer.parseInt(br.readLine());
        }
        int find = Integer.parseInt(br.readLine());
        int idx = 0;
        System.out.println(firstIndex(inputArray, idx, find));
    }

    public static int firstIndex(int[] arr, int idx, int x){
       
       if (idx == arr.length){
           return -1;
       }
       if (arr[idx] == x){
           return idx;
       }
       else{
           int index = firstIndex(arr, idx + 1, x);
           return index;
       }
    }

}

//last index
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int inputArray[] = new int[size];
        for (int index = 0; index < size; index++) {
            inputArray[index] = Integer.parseInt(br.readLine());
        }
        int find = Integer.parseInt(br.readLine());
        int idx = size - 1;
        System.out.println(lastIndex(inputArray, idx, find));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        
        if (idx < 0){
            return -1;
        }
        if (arr[idx] == x){
            return idx;
        }
        else{
            int index = lastIndex(arr, idx - 1, x);
            return index;
        }
    }

}


// All indices
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length){
            return new int[fsf];
        }
        
        if (arr[idx] == x){
            int res[] = allIndices(arr, x, idx + 1, fsf + 1);
            res[fsf] = idx;
            return res;
        }
        else{
            int res[] = allIndices(arr, x, idx + 1, fsf);
            return res;
        }
    }

}