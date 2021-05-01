/*
using two loops outer loop will traverse whole array and inner loop will
find maximum sum. 
before entering in to inner loop we define sum = 0 and inner loop 
start index(index2) will same as outer loop start index(index1). we add
every add to sum and check for maximum
*/

class LargestSumContiguousSubarray {

    public static void main(String[] args) {

        int array[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(largestSum(array));

    }

    public static int largestSum(int array[]) {
        int max = Integer.MIN_VALUE;

        for (int index1 = 0; index1 < array.length; index1++) {
            int sum = 0;
            for (int index2 = index1; index2 < array.length; index2++) {
                sum += array[index2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
// Time --> O(n^2)   Space --> O(1)


/*
************************** KADANE'S ALGORITHM ************************
create sum = 0 and maximum = 1st element of array.
Additional: create start index = 0, end index = 0 and temp index = 0;

traverse array
	-> do addition of current current with sum
	-> if sum is greater than maximum then update maximum and startIndex =
	tempIndex and endIndex = index
	-> if sum is less than zero than update sum = 0 and tempIndex = 
	index + 1
-> return maximum.
*/
class LargestSumContiguousSubarray {

    public static void main(String[] args) {

        int array[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(largestSum(array));

    }

    public static int largestSum(int array[]) {

        int sum = 0, maximum = array[0];
        int startIndex = 0, endIndex = 0, tempIndex = 0;

        for (int index = 0; index < array.length; index++) {
            sum += array[index];

            if (maximum < sum) {
                maximum = sum;
                startIndex = tempIndex;
                endIndex = index;
            }
            if (sum < 0) {
                sum = 0;
                tempIndex = index + 1;
            }
        }

        // Additional
        System.out.println(startIndex + " " + endIndex);
        for (int index = startIndex; index <= endIndex; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println("");
		return maximum;
    }

}
