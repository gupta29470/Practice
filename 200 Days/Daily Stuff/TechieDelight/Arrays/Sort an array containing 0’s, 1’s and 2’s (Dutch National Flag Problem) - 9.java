/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            
            int count0 = 0, count1 = 0, count2 = 0;
            for (int index = 0; index < n; index++){
                if (a[index] == 0){
                    count0++;
                }
                else if (a[index] == 1){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            int ind = 0;
            for (int index = 0; index < count0; index++){
                a[ind] = 0;
                ind++;
            }
            for (int index = 0; index < count1; index++){
                a[ind] = 1;
                ind++;
            }
            for (int index = 0; index < count2; index++){
                a[ind] = 2;
                ind++;
            }
            for (int index = 0; index < n; index++){
                System.out.print(a[index]+" ");
            }
            System.out.println();
            
        }
	}
}
Time --> O(n) but many for loop



/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < s.length; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            int low = 0, high = n - 1, mid = 0;

            while (mid <= high) {
                switch (a[mid]) {
                    case 0: {
                        swap(a, low, mid);
                        low++;
                        mid++;
                        break;
                    }
                    case 1: {
                        mid++;
                        break;
                    }
                    case 2: {
                        swap(a, mid, high);
                        high--;
                        break;

                    }
                }
            }
            for (int value : a) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int a[], int number1, int number2) {
        int temp = a[number1];
        a[number1] = a[number2];
        a[number2] = temp;
    }
}

Time --> O(n) single for loop