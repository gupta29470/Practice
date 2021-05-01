/*
	****************** Using linear Search *********************
To know how many times array is rotated simply find index of minimum element
in array
*/

class NumberOfTimes {

    public static void main(String[] args) {

        int array[] = {5, 1, 2, 3, 4};

        System.out.println("Number of times rotated : " + sortedArrayRotated(array));
    }

    public static int sortedArrayRotated(int arr[]) {

        int minimum = arr[0];
        int minIndex = -1;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] < minimum) {
                minimum = arr[index];
                minIndex = index;
            }
        }
        return minIndex;
    }
}
// Time --> O(n)


/*
	****************** Using Binary Search *********************
Given array: 
Original array : array = {1, 2, 3, 4, 5}
Left rotated array : {3, 4, 5, 1, 2} (front to back)
Right rotated array : {4, 5, 1, 2, 3} (back to front)

If we observe clearly number of times rotation is equal to index of minimum
element i.e index of 1, because all the elements before 1 and all the
elements after 1 is greater than 1.

If we calculate mid of {4, 5, 1, 2, 3} then we get mid = 2 i.e 
array[2] = 1.
So array is now divided in two parts :
	Part 1 : 4, 5, 1
	Part 2 : 1, 2, 3

Part 1 is unsorted so make sure that result will be found in Part 1 i.e
unsorted part.


Initialization:
1. low = 0, high = n - 1 for binary search, rotation stores result

2. If array size is 1 then return 0

3. while loop till low is less than or equals to high
	-> if low is less than high that means array is fully sorted then return 
	low
	
	-> calculate mid 
	 
	-> Check if mid is smallest element in array by comparing previous and 
	next element of mid, if yes then return mid
	
	-> if array[low] is less than or equals to array[mid] means Part 1 is 
	sorted, we will jump in to Part 2 for answer
	
	-> else if array[mid] is less than or equals to array[mid] means 
	Part 2 is sorted we will jump in to Part 1 for answer
	
	
	return:
	-> if array is left rotated then answer will be:
	(n - rotation) % n
	
	-> if array is right rotated then answer will be:
	rotation

*/


class NumberOfTimes {

    public static void main(String[] args) {

        int array[] = {5, 1, 2, 3, 4};

        System.out.println("Number of times rotated : " + sortedArrayRotated(array));
    }

    public static int sortedArrayRotated(int arr[]) {

        int size = arr.length;
        int low = 0, high = size - 1;
        int rotation = 0;
		
		if (size == 1){
			return 0;
		}

        while (low <= high) {
            if (arr[low] <= arr[high]) {
                rotation = low;
                break;
            }

            int mid = (low + high) / 2;
            int previous = (mid - 1 + size) % size;
            int next = (mid + 1) % size;

            if (arr[mid] <= arr[previous] && arr[mid] <= arr[next]) {
                rotation = mid;
                break;
            }

            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            }
        }
        return rotation;
    }
}


/*
Use modified binary search to find pivot element:
1. If array[0] <= array[length of array - 1], it means the array is not 
rotated, so return 0.
2. Initialize start = 0, end = length of array - 1.
3. Repeat following steps till start <= end
   a). Set mid = (start+end)/2.
   b). If mid+1 is pivot, then break.
   c). If array[start] <= array[mid], it means from start to mid, all elements 
   are in sorted order.
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
