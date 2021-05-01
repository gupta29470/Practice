/*
1. Using Linear Search
*/

/*
2. Using Binary Search:
search function:
	-> find minimum element in rotated sorted array ans store in partition
	
	-> if key is greater than or equals to array[low] && key is less than
	equals to array[mid] then do binary search between low to partition
	(included)
	
	-> else if key is less than or equals to array[mid + 1] && key is greater 
	than equals to array[high] then do binary search between partition + 1 to
	high(included)
*/

class Search {

    public static void main(String[] args) {

        int array[] = {11, 12, 15, 18, 2, 5, 6, 8};

        System.out.println("Number of times rotated : " + search(array, 8));
    }

    public static int search(int array[], int key){
        
        if (key == array[0]){
            return 0;
        }
        
        if (key == array[array.length - 1]){
            return array.length - 1;
        }
        
        int low = 0, high = array.length - 1; 
        int partition = pivot(array);
        
        if (array[low] <= key && key <= array[partition - 1]){
            return binarySearch(array, low, partition - 1, key);
        }
        else{
            return binarySearch(array, partition, high, key);
        }
        
        
    }
    public static int pivot(int arr[]) {

        int size = arr.length;
        int low = 0, high = size - 1;
        int rotation = 0;

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
        return (size - rotation) % size;
    }
    
    public static int binarySearch(int array[], int low, int high, int key){
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (array[mid] == key){
                return mid;
            }
            else if (key < array[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
// Time --> O(2 logn)


/*
3. Using Binary Search requires one traversal: 
1) Find middle point mid = (l + h)/2

2) If key is present at middle point, return mid.

3) Else If arr[l..mid] is sorted
    a) If key to be searched lies in range from arr[l]
       to arr[mid], recur for arr[l..mid].
    b) Else recur for arr[mid+1..h]
	
4) Else (arr[mid+1..h] must be sorted)
    a) If key to be searched lies in range from arr[mid+1]
       to arr[h], recur for arr[mid+1..h].
    b) Else recur for arr[l..mid] 
*/


class Search {

    public static void main(String[] args) {

        int array[] = {4, 5, 6, 7, 8, 1, 2, 3};

        System.out.println("Number of times rotated : " + search(array, 8));
    }

    public static int search(int array[], int key) {

        if (key == array[0]) {
            return 0;
        }

        if (key == array[array.length - 1]) {
            return array.length - 1;
        }

        int low = 0, high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if (array[low] <= array[mid]){
                if (array[low] <= key && key <= array[mid]){
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if (array[mid + 1] <= array[high]){
                 if (array[mid + 1] <= key && key <= array[high]){
                    low = mid + 1;
                }
                else{
                    high = mid;
                }
            }
        }
        return -1;
    }

}
// Time --> O(logn)
