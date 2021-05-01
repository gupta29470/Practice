/*
permutaions function:
	-> initialize left = 0 and right = array.length - 1
	pass array, left and right in permutationsUtil function
	-> permutationsUtil function: 
		-> if left is equal to right print current state of element
		-> else for loop for every element will be left to right:
			-> swap left and current index element
			-> call permutationsUtil function with (array, left + 1, right)
			recursively
			-> get original structure of array by swapping again 
			left and current index element
*/

class AllPermutations {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 4, 5};

        permutaions(array);
    }

    public static void permutaions(int array[]) {
		
		// initialize left = 0 and right = array.length - 1
        int left = 0, right = array.length - 1;

        permutationsUtil(array, left, right);
    }

    public static void permutationsUtil(int array[], int left, int right) {
		// if left is equal to right print current state of element
        if (left == right) {
            printArray(array);
        }

        else{
			// for loop for every element will be left to right:
			for (int index = left; index <= right; index++) {
				// swap left and current index element
				swap(array, left, index);
				// call permutationsUtil function with (array, left + 1, 
				// right) recursively
				permutations(array, left + 1, right);
				// get original structure of array by swapping again 
				// left and current index element
				swap(array, left, index);
			}
        }
    }

    public static void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int array[]) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println("");
    }
}
