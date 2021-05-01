/*
1. create 3 variables count0, count1, count2 to keep count of number of 0's,
1's and 2's present in array
2. traverse array to count number of 0's, 1's and 2's present in array
3. create index variable = 0
4. 
	-> 1. first for loop from 0 to count0 - 1 and add 0 in array with
	increment index variable
	2. second for loop from 0 to count1 - 1 and add 1 in array with
	increment index variable
	3. third for loop from 0 to count2 - 1 and add 2 in array with
	increment index variable
*/

class Sort012 {

    public static void main(String[] args) {

        int array[] = {0, 1, 2, 0, 1, 2};

        sort012(array);

        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public static void sort012(int array[]) {
		// three variables
        int count0 = 0, count1 = 0, count2 = 0;
		
		// count number of 0's, 1's and 2's
        for (int index = 0; index < array.length; index++) {
            if (array[index] == 0) {
                count0++;
            } else if (array[index] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
		
		// index variable
        int index = 0;
		
		// first for loop from 0 to count0 - 1 and add 0 in array with
		// increment index variable
        for (int ind = 0; ind < count0; ind++) {
            array[index] = 0;
            index++;
        }
		
		// second for loop from 0 to count1 - 1 and add 1 in array with
		// increment index variable
        for (int ind = 0; ind < count1; ind++) {
            array[index] = 1;
            index++;
        }
		
		// third for loop from 0 to count2 - 1 and add 2 in array with
		// increment index variable
        for (int ind = 0; ind < count2; ind++) {
            array[index] = 2;
            index++;
        }
    }

}


// Time --> O(2n)


/*
******************************* EEFICIENT ******************************
We create start = 0, end = 0, index = 0 and element that stays in middle
i.e 1 is pivot

-> It states that if current element is less than pivot(1) it is 0 then 
swap(array[start] and array[index]) increment start and index

-> It states that if current element is greater than pivoit(1) it is 2 then
swap(array[index], array[end]) and decrement end. We are only decrementing index
because may be we swap 2 with 2

-> It states that if current element is equal to pivoit(1) then increment index
. We only incrementing index because we want all 1's in middle

To sort 0, 1 and 2 we have to keep all 1's in middle (i.e after 0's and
before 2's)

sort012 function:
	-> 1. create start = 0, index = 0, pivot = 1, end = array.length - 1
	-> 2. while index is less than or equals to end
		-> 1. if current element is less than 1 means current element is "0"
		then swap(array[start], array[end]) and increment start and index
		-> 2. if current element is greater than 1 means current element is "2"
		then swap(array[index], array[end]) and just decrement end
		-> 3. if current element is 1, as we said earlier we have to keep
		all 1's in index so just increment index.
*/


class Sort012 {

    public static void main(String[] args) {

        int array[] = {0, 1, 2, 0, 1, 2};

        sort012(array);

        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    // Linear time partition routine to sort an array containing 0, 1, and 2.
    // It is similar to 3–way partitioning for the Dutch national flag problem.
    public static void sort012(int array[]) {
        
        int start = 0, index = 0, end = array.length - 1, pivot = 1;
        
        while (index <= end){
            // current element is 0
            if (array[index] < pivot){
                swap(array, start, index);
                start++;
                index++;
            }
            // current element is 2
            else if (array[index] > pivot){
                swap(array, index, end);
                end--;
            }
            // current element is 1
            else{
                index++;
            }
        }

    }
    
    public static void swap(int array[], int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
