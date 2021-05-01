/*
create a frequency array and mark number of visit of each element in 
frequency array.
If element has visit more than 1 time then that number is repeated and if 
element has 0 visit then it is missing element

repeatAndMissing function:
	-> create frequency array of size input array
	
	-> fill frequency array with 0
	
	-> for loop to input array from 1 to n + 1(excluded) becuase element 
	will be given in input array from 1 not from 0
		-> take current element as index in frequency array and 
		increment number of visits
		
	-> again foor loop from 1 to n + 1(excluded) if number of visit
	of current element is more than 1 then it is repeated and return 
	index or if current element has 0 visits then it is missing number
	return index.
*/

import java.util.*;

class RepeatAndMissing {

    public static void main(String[] args) {

        int[] array = {4, 3, 6, 2, 1, 1};

        repeatAndMissing(array);
    }
    
    public static void repeatAndMissing(int array[]){
        int frequency[] = new int[array.length + 1];
        
        Arrays.fill(frequency, 0);
        
        for (int index = 1; index < array.length + 1; index++){
            frequency[array[index - 1]]++;
        }
        
        int repeat = -1, missing = -1;
        for (int index = 1; index < frequency.length; index++){
            if (frequency[index] > 1){
                repeat = index;
            }
            else if (frequency[index] < 1){
                missing = index;
            }
        }
        System.out.println(repeat + " " + missing);
    }

}
// Time --> O(2n) ~ O(n)    Space --> O(n)


/*
*************************** EFFICIENT APPROACH ************************
repeatAndMissing function:
	-> sumOfLen: apply sum of all natural number till "n" formula -> 
	(n * (n + 1)) / 2
	
	-> sumOfLenSquare: apply sum of squares of all natural number till "n" 
	formula -> (n * (n + 1) * (2 * n + 1)) / 6
	
	-> for loop to input array:
		-> subtract current element from sumOfLen
		-> do square of current element and subtract from sumOfLenSquare
		
	-> sumNum : division of sumOfLenSquare and sumOfLen
	sumOfLenSquare / sumOfLen
	
	-> missing : addition of sumNum and sumOfLen and divide by 2
	(sumNum + sumOfLen) / 2
	
	-> repeat : subtract sumNum from missing. sumNum - missing
*/

class RepeatMissingNumber {

    public static void main(String[] args) {

        int array[] = {4, 3, 2, 6, 1, 1};

        repeatMissing(array);
    }

    public static void repeatMissing(int array[]) {

        int len = array.length;
        
        long sumOfLen = (long) (len * (len + 1)) / 2;
        
        long sumOfLenSquare = (long) (len * (len  + 1) * (2 * len + 1)) / 6;
        
        for (int index = 0; index < len; index++){
            sumOfLen = sumOfLen - array[index];
            sumOfLenSquare = sumOfLenSquare - (array[index] * array[index]); 
        }
        
        long sumNum = sumOfLenSquare / sumOfLen;
        
        int missing = (int) (sumNum + sumOfLen) / 2;
        
        int repeat = (int) (sumNum - missing);
        
        System.out.println(missing + " " + repeat);
    }
}
