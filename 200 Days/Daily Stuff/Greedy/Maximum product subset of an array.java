import java.util.*;

class MaxSubset {

    public static void main(String[] args) {
        int array[] = {-6, 4, -5, 8, -10, 0, 8};
        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println(powerSet(array, deque, array.length, Integer.MIN_VALUE));
    }

    public static int powerSet(int array[], Deque<Integer> deque, int len,
            int maximum) {

        if (len == 0) {
            // if we have considered all elements
             // compute its product of elements and update the maximum
            // product found so far
            return findMaximum(deque, maximum);
        }

         // consider the n'th element
        deque.add(array[len - 1]);
        maximum = powerSet(array, deque, len - 1, maximum);

        // backtrack
        deque.removeLast();

        // or don't consider the n'th element
        return powerSet(array, deque, len - 1, maximum);
    }

    public static int findMaximum(Deque<Integer> deque, int maximum) {
        int product = 1;

        for (int data : deque) {
            product *= data;
        }

        // if the deque is not empty, then update the product
        if (!deque.isEmpty()){
            maximum = Math.max(maximum, product);
        }

        return maximum;
    }
}
// Time --> O(n ^ 2)  Space --> O(n) recursion stack




/*
We can solve this problem in linear time by finding a negative element with a 
minimum absolute value in the set. We also count the total number of negative 
elements present in the set. If the count of negative elements is odd, 
exclude that negative element (having minimum absolute value) from the subset; 
otherwise, consider it (since the multiplication of two negative numbers will 
give a positive number as output). We need to handle one more special case 
because 0 will never be part of the subset if at least one positive element 
or two negative elements are present in the subset. Rest all elements will 
form part of the subset.
*/

class Main
{
    // Function to return the maximum product of a subset of a given array
    public static int findMaxProduct(int[] A, int n)
    {
        // base case
        if (n == 0) {
            return 0;
        }
 
        // if the array contains only one element
        if (n == 1) {
            return A[0];
        }
 
        int product = 1;    // to store the maximum product subset
 
        // stores the negative element having a minimum absolute value
        // in the set
        int abs_min_so_far = Integer.MAX_VALUE;
 
        // maintain the count of negative elements in the set
        int negative = 0;
 
        // maintain the count of positive elements in the set
        int positive = 0;
 
        boolean contains_zero = false;
 
        // traverse the given array
        for (int i = 0; i < n; i++)
        {
            // if the current element is negative
            if (A[i] < 0)
            {
                negative++;
                abs_min_so_far = Integer.min(abs_min_so_far, Math.abs(A[i]));
            }
            // if the current element is positive
            else if (A[i] > 0) {
                positive++;
            }
 
            // if the current element is zero
            if (A[i] == 0) {
                contains_zero = true;
            }
            else {
                product = product * A[i];
            }
        }
        
        System.out.println(product);
 
        // if an odd number of negative elements are present, exclude the
        // negative element having a minimum absolute value from the subset
        if ((negative & 1) != 0) {
            product = product / -abs_min_so_far;
        }
 
        // special case – set contains one negative element and
        // one or more zeroes
        if (negative == 1 && positive == 0 && contains_zero) {
            product = 0;
        }
 
        // return maximum product
        return product;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -6, 4, -5, 8, -10, 0, 8 };
 
        System.out.print("The maximum product of a subset is "
                        + findMaxProduct(A, A.length));
    }
}
// Time --> O(n)