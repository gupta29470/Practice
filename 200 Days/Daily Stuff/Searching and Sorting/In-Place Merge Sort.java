/*
Maintain two pointers which point to start of the segments which have to be merged.
Compare the elements at which the pointers are present.
If element1 < element2 then element1 is at right position, simply increase pointer1.
Else shift all the elements between element1 and element2(including element1 but 
excluding element2) right by 1 and then place the element2 in the previous place
(i.e. before shifting right) of element1. Increment all the pointers by 1.
*/

class InPlaceMerge{
    public static void main(String[] args) {
        
        int array[] = {1, 2, 7, 3, 4, 5, 6, 8, 9};
        
        divideArray(array, 0, array.length - 1);
        
        for (int data : array){
            System.out.print(data + " ");
        }
    }
    
    public static void divideArray(int array[], int low, int high){
        
        if (low < high){
            int middle = (low + high) / 2;
            
            divideArray(array, low, middle);
            divideArray(array, middle + 1, high);
            
            mergeArray(array, low, middle + 1, high);
        }
    }
    
    public static void mergeArray(int array[], int low, int middle, int high){
        int index1 = low, index2 = middle, index;
        
        while (index1 < middle && index2 <= high){
            if (array[index1] <= array[index2]){
                index1++;
            }
            else if (array[index1] > array[index2]){
                int temp = array[index1];
                for (index = index1; index < index2; index++){
                    array[index] = array[index + 1];
                }
                array[index] = temp;
                
                index1++;
                index2++;
            }
        }
    }
}

// Time --> O(n ^ 2)