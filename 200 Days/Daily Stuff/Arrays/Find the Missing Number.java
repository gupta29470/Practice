/*
missingInteger function:
	-> create length variable = array.length + 1 because one number is 
	missing the original length of array is array.length + 1
	-> finding sum of natural numbers
	-> store sum of array in sum variable
	-> return difference of sumOfNaturalNumber - sum
*/
class MissingInteger {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 5, 6};

        System.out.println(missingInteger(array));
    }

    public static int missingInteger(int array[]) {

        // as one number is missing the original length of 
		// array is array.length + 1
		int length = array.length + 1;
		// finding sum of natural numbers
        int sumOfNaturalNumber = ((length) * (length + 1) / 2);

        int sum = 0;
		// sum of array
        for (int index = 0; index < length - 1; index++) {
            sum += array[index];
        }
		
		// missing number
        return sumOfNaturalNumber - sum;
    }

}
// Time -->O(n)  Space --> O(1)
// problem of above approach is that if array size is larger than 
// int can't hold such larger sum


/*
missingInteger function:
	-> create xor1 and xor2 variable to store xor and initialize xor1 = 
	first element of array and xor2 = 1
	-> for xor1 run a loop from 1 to n - 1 and xor every array element 
	with xor1(xor1 = xor1 ^ array[index])
	-> for xor2 run a loop from 2 to n + 1(including) and xor index
	with xor2(xor2 = xor2 ^ index)
	-> return xor1 ^ xor2
*/


class MissingInteger {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 5, 6};

        System.out.println(missingInteger(array));
    }

    public static int missingInteger(int array[]) {

        int xor1 = array[0], xor2 = 1;

        for (int index = 1; index < array.length; index++) {
            xor1 = xor1 ^ array[index];
        }
        System.out.println(array.length + 1);
        for (int index = 2; index <= array.length + 1; index++) {
            xor2 = xor2 ^ index;
        }
        return xor1 ^ xor2;
    }

}
// Time --> O(n)   Space --> O(1)