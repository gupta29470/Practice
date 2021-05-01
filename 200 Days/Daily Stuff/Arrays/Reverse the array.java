
/*
Create a result array of same size and traverse input array from end to start
and put input array elements in result array from start to end.
*/
class ArrayReverse {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 4, 5};
        int result[] = reverseArray(array);

        for (int data : result) {
            System.out.print(data + " ");
        }

    }

    public static int[] reverseArray(int array[]) {
        int result[] = new int[array.length];
        int index1 = 0;
        for (int index2 = array.length - 1; index2 >= 0; index2--) {
            result[index1++] = array[index2];
        }
        return result;
    }

}
// Time --> O(n)   Space --> O(n)

class ArrayReverse {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 4, 5};
        int result[] = reverseArray(array);

        for (int data : result) {
            System.out.print(data + " ");
        }

    }

    public static int[] reverseArray(int array[]) {

        int start = 0, end = array.length - 1;
        while (start <= end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }

}

/*
Using 2 pointer one start from start of array(0) and one start from end
of array(array.length - 1)
while start is less than or equal to end swap array[start] and array[end]
increment start and decrement end
*/
