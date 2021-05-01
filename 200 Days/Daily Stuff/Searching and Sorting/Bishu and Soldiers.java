/*
Given Array is sorted
For every bishu power find find bishu power in input array.
3 possible cases:
	1. If bishu's power is less than first element of array pass kills(array, 0)
	
	2. Else If bishu's power is greater than last element of array then bishu
	can kills all the soldier so pass kills(array, size - 1)
	
	3. Else do binary search and find that element in input array if it is there 
	than return its index,
	else we will keep track of previous mid, If bishu'
	current power is not in array than return that index whose value is just 
	smaller than bishu's current power.
	
*/


class BishuAndSoldiers{
    public static void main(String[] args) {
        
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        int powerLen = 3;
        int bishuPow[] = {3, 10, 2};
        
        bishuAndSold(array, array.length, powerLen, bishuPow);
    }
    
    public static void bishuAndSold(int array[], int size, int powerLen, 
            int bishuPow[]){
        int index = 0;
        
        while (index < powerLen){
            if (bishuPow[index] < array[0]){
                kills(array, 0);
            }
            else if( bishuPow[index] > array[size - 1]){
                kills(array, size - 1);
            }
            else{
                int end = binarySearch(array, size, bishuPow[index]);
                kills(array, end);
            }
            index++;
        }
    }
    
    public static int binarySearch(int array[], int size, int currentPower){
        int low = 0, high = size - 1;
        int edgeCase = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (array[mid] == currentPower){
                return mid;
            }
            else if (array[mid] < currentPower){
                edgeCase = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return edgeCase;
    }
    
    public static void kills(int array[], int end){
        System.out.print(end + 1 + " ");
        int sum = 0;
        for (int index = 0; index <= end; index++){
            sum += array[index];
        }
        
        System.out.print(sum + "");
        System.out.println("");
    }
}

// Time --> O(n logn)