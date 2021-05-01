/*
Next Permutation will always be next greater permutation except 1 case:
5, 4, 3, 2, 1 => 1, 2, 3, 4, 5
array = [1, 3, 5, 4, 2] : if we see array in this structure
						5
					  3   4
					1		2
-> so from last of an array i.e 2 we see order is increasing sequence
(2, 4, 5) so we have to choose the break condition i.e the first smaller 
element that breaks increasing sequence(3) store its index in prefixIndex
sp prefixIndex = 1 and break loop

-> next we have to find the first greater element which is greater than 
that element which breaks increasing sequence(3) in given array the first
greater is (4) and store its index in suffixIndex, so suffixIndex = 3
and break loop

than swap(array[prefixIndex] and array[suffixIndex])
than reverse from(prefixIndex + 1 to end of array)

************************************************************************

nextPermutation function:
	-> initialize prefixIndex = min value because in one case(5, 4, 3, 2, 1)
	there is no element smaller than its previous one that break condition
	
	-> for loop to find prefixIndex if find first smaller element that 
	breaks increasing sequence than store its index in prefixIndex and 
	break loop
	
	-> check if given array is (5, 4, 3, 2, 1) or compeletly descending 
	by adding condition :
		if (prefixIndex != min value) than do 3 things:
			1. initialize suffixIndex = min
			for loop to find first greater element than array[prefixIndex]
			and store its index in suffixIndex and break loop
			2. swap(array[prefixIndex], array[suffixIndex])
			3. reverse all elements after prefixIndex to n - 1
			reverse(array, prefixIndex + 1, array.length - 1)
			return from here
		
		if (prefixIndex == min value) than do only 1 thing:
			1. reverse all elements from start to end(array, 0, n - 1)
*/

class NextPermutation {

    public static void main(String[] args) {

        int array[] = {5, 4, 3, 2, 1};

        nextPermutation(array);

        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public static void nextPermutation(int array[]) {

        // if only 1 element in array
		if (array.length == 1) {
            System.out.println(array[0]);
        }
		
		// initialize prefixIndex = min value because in one case
		// (5, 4, 3, 2, 1)
        int prefixIndex = Integer.MIN_VALUE;

        // for loop to find prefixIndex
		// find first smaller element that breaks increasing sequence
		for (int index = array.length - 1; index > 0; index--) {
            if (array[index - 1] < array[index]) {
                prefixIndex = index - 1;
                break;
            }
        }

        // check if given array is (5, 4, 3, 2, 1) or compeletly descending
		// if (prefixIndex != min value) than do 3 things:
		if (prefixIndex != Integer.MIN_VALUE) {
			
			// initialize suffixIndex = min
		// for loop to find first greater element than array[prefixIndex]
            int suffixIndex = Integer.MIN_VALUE;
			for (int index = array.length; index >= 0; index++) {
                if (array[index] > array[prefixIndex]) {
                    suffixIndex = index;
                    break;
                }
            }

            // swap(array[prefixIndex], array[suffixIndex])
			swap(array, prefixIndex, suffixIndex);
            // reverse all elements after prefixIndex to n - 1
			// reverse(array, prefixIndex + 1, array.length - 1)
			reverse(array, prefixIndex + 1, array.length - 1);
            return;
        }
		
		// if given array is (5, 4, 3, 2, 1) or compeletly descending
		else {
			// reverse all elements from start to end(array, 0, n - 1)
            reverse(array, 0, array.length - 1);
        }

    }

    public static void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void reverse(int array[], int start, int end) {
        while (start <= end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}
