/*
1: If size of array is zero or one, return true.
2: Check last two elements of array, if they are
   sorted, perform a recursive call with n-1
   else, return false.
If all the elements will be found sorted, n will
eventually fall to one, satisfying Step 1.
*/

class CkeckSorted {
    // Function that returns 0 if a pair
    // is found unsorted
    static int arraySortedOrNot(int arr[], int n)
    {
        // Array has one or no element or the
        // rest are already checked and approved.
        if (n == 1 || n == 0)
            return 1;
 
        // Unsorted pair found (Equal values allowed)
        if (arr[n - 1] < arr[n - 2])
            return 0;
 
        // Last pair was sorted
        // Keep on checking
        return arraySortedOrNot(arr, n - 1);
    }
 
    // main function
    public static void main(String[] args)
    {
        int arr[] = { 20, 23, 23, 45, 78, 88 };
        int n = arr.length;
        if (arraySortedOrNot(arr, n) != 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}