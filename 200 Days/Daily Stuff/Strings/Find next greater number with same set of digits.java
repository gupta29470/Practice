/*
Same logic as Next Permutation problem:
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
*/

class NextGreater {

    public static void main(String[] args) {

        String string = "1234";

        System.out.println(nextGreater(string));

    }

    public static String nextGreater(String string) {
        char charArray[] = string.toCharArray();
        int smaller = Integer.MIN_VALUE;
        int bigger = Integer.MIN_VALUE;
        int start = 0, end = charArray.length - 1;

        for (int index = charArray.length - 1; index > 0; index--) {
            if (Character.getNumericValue(charArray[index - 1])
                    < Character.getNumericValue(charArray[index])) {
                smaller = index - 1;
                break;
            }
        }

        if (smaller == Integer.MIN_VALUE) {
            return "Not possible";
        }

        for (int index = charArray.length - 1; index > 0; index--) {
            if (Character.getNumericValue(charArray[index]) > 
                    Character.getNumericValue(charArray[smaller])) {
                bigger = index;
                break;
            }
        }

        swap(charArray, smaller, bigger);

        start = smaller + 1;

        while (start <= end) {
            swap(charArray, start, end);
            start++;
            end--;
        }

        return String.valueOf(charArray);

    }

    public static void swap(char charArray[], int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }

}
