class MinMax {

    public static void main(String[] args) {

        int array[] = { 5, 7, 2, 4, 9, 6};
        
        minMax(array);
    }

    public static void minMax(int array[]) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (array[index] < min) {
                min = array[index];
            }
            if (array[index] > max) {
                max = array[index];
            }
        }
        System.out.println(min + " " + max);

    }
}

/*
Little better than above solution:
*/

class Main
{
    // Optimized solution to find the minimum and maximum number in an array
    public static void findMinAndMax(int[] A, int n)
    {
        // initialize minimum element by `INFINITY` and the maximum
        // element by `-INFINITY`
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
 
        // if the array has an odd number of elements, ignore the last
        // element and consider it later
        boolean odd = (n & 1) == 1;
        if (odd) n--;
 
        // compare elements in pairs, i.e., `A[i]` and `A[i+1]`
        for (int i = 0; i < n; i = i + 2)
        {
            int maximum, minimum;
 
            // find the maximum and minimum among `A[i]`, `A[i+1]`
 
            if (A[i] > A[i + 1])    // 1st comparison
            {
                minimum = A[i + 1];
                maximum = A[i];
            }
            else {
                minimum = A[i];
                maximum = A[i + 1];
            }
 
            // update max
            if (maximum > max) {        // 2nd comparison
                max = maximum;
            }
 
            // update min
            if (minimum < min) {        // 3rd comparison
                min = minimum;
            }
        }
 
        // handle the last element if the array has an odd number of elements
        if (odd)
        {
            if (A[n] > max) {
                max = A[n];
            }
 
            if (A[n] < min) {
                min = A[n];
            }
        }
 
        System.out.println("The minimum array element is " + min);
        System.out.println("The maximum array element is " + max);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 4, 7, 5, 1, 3 };
 
        findMinAndMax(A, A.length);
    }
}


