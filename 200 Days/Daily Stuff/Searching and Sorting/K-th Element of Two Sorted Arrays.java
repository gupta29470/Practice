/*
Solution 1: merge both arrays in different array sort array and return k - 1 
element
// Time --> O(N logN)    Space --> O(n + m)



Solution 2: merge both arrays in different array and sort using two pointers
// Time --> O(n + m)    Space --> O(n + m)

*/

/*
Initialize trace variable and using two pointers traverse both arrays. 
Once trace is equal to k return element
*/

class KthSmallest {

    public static void main(String[] args) {

        int arr1[] = {72, 86, 113, 119, 265, 445, 892};
        int arr2[] = {100, 112, 256, 349, 770};
        int k = 7;

        System.out.println(kthSmallest(arr1, arr2, k));
    }

    public static int kthSmallest(int array1[], int array2[], int k) {
        int index1 = 0, index2 = 0, trace = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                trace++;
                if (trace == k) {
                    return array1[index1];
                }
                index1++;
            } 
            else{
                trace++;
                if (trace == k) {
                    return array2[index2];
                }
                index2++;
            } 
        }
        
        while (index1 < array1.length){
            trace++;
            if (trace == k){
                return array1[index1];
            }
            index1++;
        }
        
        while (index2 < array2.length){
            trace++;
            if (trace == k){
                return array2[index2];
            }
            index2++;
        }
        return -1;
    }
}
// Time --> O(k)



/*
Using Binary Search

First assumption that kth element will be find between k/2 size of array1 and array2

If array1[k / 2] < array2[k / 2] then we will check in right side of array1 and 
shifting left side of array2 

Similarly, 
If array2[k / 2] < array1[k / 2] then we will check in right side of array2 and 
shifting left side of array1 
*/

// Java Program to find kth element from two sorted arrays
class GFG 
{
 
    static int kth(int arr1[], int arr2[], int m,
                   int n, int k, int st1, int st2) 
    {
        // In case we have reached end of array 1
        if (st1 == m) 
        {
            return arr2[st2 + k - 1];
        }
 
        // In case we have reached end of array 2
        if (st2 == n) 
        {
            return arr1[st1 + k - 1];
        }
 
        // k should never reach 0 or exceed sizes
        // of arrays
        if (k == 0 || k > (m - st1) + (n - st2)) 
        {
            return -1;
        }
 
        // Compare first elements of arrays and return
        if (k == 1) 
        {
            return (arr1[st1] < arr2[st2])
                    ? arr1[st1] : arr2[st2];
        }
        int curr = k / 2;
 
        // Size of array 1 is less than k / 2
        if (curr - 1 >= m - st1)
        {
             
            // Last element of array 1 is not kth
            // We can directly return the (k - m)th
            // element in array 2
            if (arr1[m - 1] < arr2[st2 + curr - 1]) 
            {
                return arr2[st2 + (k - (m - st1) - 1)];
            } 
            else
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
        }
 
        // Size of array 2 is less than k / 2
        if (curr - 1 >= n - st2)
        {
            if (arr2[n - 1] < arr1[st1 + curr - 1]) 
            {
                return arr1[st1 + (k - (n - st2) - 1)];
            }
            else
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            }
        } 
        else
         
        // Normal comparison, move starting index
        // of one array k / 2 to the right
        if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1])
        {
            return kth(arr1, arr2, m, n, k - curr,
                    st1 + curr, st2);
        } 
        else
        {
            return kth(arr1, arr2, m, n, k - curr,
                    st1, st2 + curr);
        }
    }
 
    // Driver code
    public static void main(String[] args) 
    {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        int st1 = 0, st2 = 0;
        System.out.println(kth(arr1, arr2, 5, 4, k, st1, st2));
    }
} 