class MergeSort {

    public static void main(String[] args) {

        int array[] = {5, 3, 2, 4, 1};

        divideArray(array, 0, array.length - 1);

        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public static void divideArray(int array[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            divideArray(array, left, middle);
            divideArray(array, middle + 1, right);

            // middle will be in right sub array
            mergeArray(array, left, middle + 1, right);
        }
    }

    public static void mergeArray(int array[], int left, int middle,
            int right) {

        int index1 = left, index2 = middle, index3 = left;
        int tempArray[] = new int[array.length];

        // middle will be in right sub array
        while (index1 <= middle - 1 && index2 <= right) {
            if (array[index1] <= array[index2]) {
                tempArray[index3++] = array[index1++];
            } 
            else {
                tempArray[index3++] = array[index2++];
            }
        }

        while (index1 <= middle - 1) {
            tempArray[index3++] = array[index1++];
        }

        while (index2 <= right) {
            tempArray[index3++] = array[index2++];
        }

        for (int index = left; index <= right; index++) {
            array[index] = tempArray[index];
        }
    }
}
