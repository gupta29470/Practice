/*
Create a result array and store last element of input array in as first
element of result array and traverse to 0 to n - 2 for given array to fill
result array
*/

class RotateArrayByOne {

    public static void main(String[] args) {

        int array[] = {1, 3, 4, 5, 7};
        
        rotateByOne(array);
    }
    
    public static void rotateByOne(int array[]){
        int result[] = new int[array.length];
        
        result[0] = array[array.length - 1];
        
        for (int index = 1; index < array.length; index++){
            result[index] = array[index - 1];
        }
        
        for (int data : result){
            System.out.print(data+" ");
        }
    }

}
// Time --> O(n)  Space --> O(n)


/*
********************** EFFICIENT ***************************
Following are steps.
1) Store last element in a variable say last.
2) Shift all elements one position ahead.
3) Replace first element of array with last.
*/

class RotateArrayByOne {

    public static void main(String[] args) {

        int array[] = {1, 3, 4, 5, 7};

        rotateByOne(array);
    }

    public static void rotateByOne(int array[]) {

        int last = array[array.length - 1];

        for (int index = array.length - 1; index > 0; index--) {
            array[index] = array[index - 1];
        }

        array[0] = last;

        for (int data : array) {
            System.out.print(data + " ");
        }
    }

}

