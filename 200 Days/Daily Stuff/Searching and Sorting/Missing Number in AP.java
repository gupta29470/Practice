/*
A Simple Solution is to linearly traverse the array and find the missing number. 
Time complexity of this solution is O(n).
*/

class MissingAP{
    public static void main(String[] args) {
        
        int array[] = {1, 6, 11, 16, 21, 31};
        
        System.out.println(missingNumber(array, array.length));
    }
    
    public static int missingNumber(int array[], int size){
        // if second number is missing 
        int pattern = (array[1] - array[0]) < (array[size - 1] - array[size - 2]) ? 
                (array[1] - array[0]) : (array[size - 1] - array[size - 2]);
        
        for (int index = 1; index < size; index++){
            if (array[index] - array[index - 1] != pattern){
                return array[index - 1] + pattern;
            }
        }
        return -1;
    }
}
// Time complexity : O(n).



/*
Using Binary Search

The idea is to go to the middle element. 

Check if the difference between middle and next to middle is equal to diff or not, 
if not then the missing element lies between mid and mid+1. 

If the middle element is equal to n/2th term in Arithmetic Series 
(Let n be the number of elements in input array), then missing element lies in 
right half. Else element lies in left half.
*/
class GFG  
{ 
      
// A binary search based  
// recursive function that  
// returns the missing  
// element in arithmetic 
// progression 
static int findMissingUtil(int arr[], int low,  
                           int high, int diff) 
{ 
    // There must be two elements 
    // to find the missing 
    if (high <= low) 
        return Integer.MAX_VALUE; 
  
    // Find index of  
    // middle element 
    int mid = low + (high - low) / 2; 
  
    // The element just after the  
    // middle element is missing.  
    // The arr[mid+1] must exist,  
    // because we return when 
    // (low == high) and take 
    // floor of (high-low)/2 
    if (arr[mid + 1] - arr[mid] != diff) 
        return (arr[mid] + diff); 
  
    // The element just  
    // before mid is missing 
    if (mid > 0 && arr[mid] -  
                   arr[mid - 1] != diff) 
        return (arr[mid - 1] + diff); 
  
    // If the elements till mid follow  
    // AP, then recur for right half 
    if (arr[mid] == arr[0] + mid * diff) 
        return findMissingUtil(arr, mid + 1,  
                               high, diff); 
  
    // Else recur for left half 
    return findMissingUtil(arr, low, mid - 1, diff); 
} 
  
// The function uses findMissingUtil()  
// to find the missing element in AP.  
// It assumes that there is exactly  
// one missing element and may give  
// incorrect result when there is no  
// missing element or more than one 
// missing elements. This function also  
// assumes that the difference in AP is 
// an integer. 
static int findMissing(int arr[], int n) 
{ 
    // If exactly one element is missing,  
    // then we can find difference of 
    // arithmetic progression using  
    // following formula. Example, 2, 4,  
    // 6, 10, diff = (10-2)/4 = 2. 
    // The assumption in formula is that  
    // the difference is an integer. 
    int diff = (arr[n - 1] - arr[0]) / n; 
  
    // Binary search for the missing  
    // number using above calculated diff 
    return findMissingUtil(arr, 0, n - 1, diff); 
} 
  
// Driver Code 
public static void main (String[] args)  
{ 
    int arr[] = {2, 4, 8, 10, 12, 14}; 
    int n = arr.length; 
    System.out.println("The missing element is "+    
                            findMissing(arr, n)); 
} 
} 
  


class MissingNumberAP{
    public static void main(String[] args) {
        
        int array[] = {1, 6, 11, 16, 21, 31};
        
        System.out.println(missingAP(array));
    }
    
    public static int missingAP(int array[]){
		// if second number is missing 
        int pattern = (array[1] - array[0]) < (array[size - 1] - array[size - 2]) ? 
                (array[1] - array[0]) : (array[size - 1] - array[size - 2]);
        
        int low = 0, high = array.length - 1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (array[mid + 1] - array[mid] != pattern){
                return array[mid] + pattern;
            }
            
            if (mid > 0 && array[mid] - array[mid - 1] != pattern){
                return array[mid - 1] + pattern;
            }
            
            if (array[mid] == array[0] + mid * pattern){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}