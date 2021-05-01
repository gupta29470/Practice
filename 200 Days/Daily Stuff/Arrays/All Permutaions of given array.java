/*
permutaions function:
	-> create a upper bound and lower bound of an array(left, right)
	-> pass array, left, right to permutationsUtil function
	-> permutationsUtil function:
		-> every time if upper bound and lower bound is equal print current 
		state of an array
		-> for loop from lower bound to upper bound
			-> swap current element array[index] with lower bound index
			(array[left])
			-> recursively call permutationsUtil for next element 
			permutationsUtil(array, left +1, right)
			-> swap again swap current element array[index] with lower 
			bound index (array[left]) to retain previous state of an array
	
*/

class AllPermutations {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 4, 5};

        permutaions(array);
    }

    public static void permutaions(int array[]) {

        // create a upper bound and lower bound of an array
		int left = 0, right = array.length - 1;

        permutationsUtil(array, left, right);
    }

    public static void permutationsUtil(int array[], int left, int right) {
		// every time if upper bound and lower bound is equal print current 
		// state of an array
        if (left == right) {
            printArray(array);
        }

        // for loop from lower bound to upper bound 
		for (int index = left; index <= right; index++) {
			// swap current element array[index] with lower bound index
			// (array[left])
            swap(array, left, index);
			// recursively call permutationsUtil for next element 
            permutationsUtil(array, left + 1, right);
			// swap again swap current element array[index] with lower 
			// bound index (array[left]) to retain previous state of an array
            swap(array, left, index);
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
