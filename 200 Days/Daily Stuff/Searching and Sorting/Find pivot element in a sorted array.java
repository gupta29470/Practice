/*
Use modified binary search to find pivot element:
1. If array[0] <= array[length of array - 1], it means the array is not rotated, so return 0.
2. Initialize start = 0, end = length of array - 1.
3. Repeat following steps till start <= end
   a). Set mid = (start+end)/2.
   b). If mid+1 is pivot, then break.
   c). If array[start] <= array[mid], it means from start to mid, all elements are in sorted order.
       Set start = mid+1, so that we look for pivot in second half of the array.
   d). Else set end = mid-1, to look for pivot in first half.
*/

class Pivot{
    public static void main(String[] args) {
        
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(smallestPivot(arr));
    }
    
    public static int smallestPivot(int array[]){
        if (array.length == 0){
            return - 1;
        }
        if (array.length == 1){
            return array[0];
        }
        
        int low = 0, high = array.length - 1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (mid <= high && array[mid] > array[mid + 1]){
                return array[mid + 1];
            }
            else if (array[low] <= array[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}


class Pivot{
    public static void main(String[] args) {
        
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(largestPivot(arr));
    }
    
    public static int largestPivot(int array[]){
        if (array.length == 0){
            return - 1;
        }
        if (array.length == 1){
            return array[0];
        }
        
        int low = 0, high = array.length - 1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (mid <= high && array[mid - 1] > array[mid]){
                return array[mid - 1];
            }
            else if (array[low] <= array[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}