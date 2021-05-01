/*
Initialization:
startIndex and endIndex with - 1 to store first and last occurences of 
given key

Loop Array if current element is same as key :
	-> if startIndex is - 1 then current index is startIndex
	-> else for every matching element store its index in endIndex
*/

class Occurences {

    public static void main(String[] args) {

        int array[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};

        firstLastIndex(array, 5);
    }

    public static void firstLastIndex(int array[], int key) {

        int startIndex = -1, endIndex = -1;
        
        for (int index = 0; index < array.length; index++){
            if (array[index] == key){
                if (startIndex == -1){
                    startIndex = index;
                }
                else{
                    endIndex = index;
                }
            }
        }

        System.out.println("Start at : " + startIndex);
        System.out.println("End at : " + endIndex);
    }
}
// Time --> O(n)


/*
************************* BINARY SEARCH ******************************
Initialization:
low = 0 and high = array.length - 1 for binary search
startIndex and endIndex with - 1 to store first and last occurences of 
given key

1. First we will find start index
	-> while low is less than high
		-> find mid 
		-> if key == array[mid] update startIndex = mid and try to find 
		actual start index by bringing high = mid - 1
		-> else if key > array[mid] low = mid + 1
		-> else if key < array[mid] high = mid - 1

2. First we will find end index
	-> while low is less than high
		-> find mid 
		-> if key == array[mid] update endIndex = mid and try to find 
		actual end index by bringing low = mid + 1
		-> else if key > array[mid] low = mid + 1
		-> else if key < array[mid] high = mid - 1

*/
class Occurences{
    public static void main(String[] args) {
        
        int array[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        
        firstLastIndex(array, 5);
    }
    
    public static void firstLastIndex(int array[], int key){
        int low = 0, high = array.length - 1;
        
        int startIndex = -1, endIndex = -1;
        
        // start index
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (key == array[mid]){
                startIndex = mid;
                high = mid - 1;
            }
            else if (key > array[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        low = 0; high = array.length - 1;
        
        // end index
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (key == array[mid]){
                endIndex = mid;
                low = mid + 1;
            }
            else if (key > array[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        System.out.println("Start at : " + startIndex);
        System.out.println("End at : " + endIndex);
    }
}
// Time --> O(2 log n)