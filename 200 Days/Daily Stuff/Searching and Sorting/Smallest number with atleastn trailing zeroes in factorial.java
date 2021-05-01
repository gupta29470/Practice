/*
A trailing zero is always produced by prime factors 2 and 5. 
If we can count the number of 5s and 2s, our task is done. 
Consider the following examples:
n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). 
So a count of trailing 0s is 1.( one 2 and one 5 are common)
n = 11: There are two 5s and eight 2s in prime factors of 11! 
(2^8 * 3^4 * 5^2 * 7). So the count of trailing 0s is 2.

But if we carefully look every 2nd number is multiple by 2 and every 5th number is
multiple by 5. It means number of 2's is greater than number of 5's.
If we just find the power of 5, then we can pair then they can pair with that 
many of 2's to produce trailing zeroes.

Ex : number = 10;
Factorial: 1 * 2* 3* 4* 5* 6* 7* 8* 9* 10, so there will be two trailing zeroes
first is 2 and 5
second is 10


But what if number = 28  so trailing zeroes will be
5 -> 1(contains one 5)(n / 5)
10 -> 1(contains one 5)(n / 5)
15 -> 1(contains one 5)(n / 5)
20 -> 1(contains one 5)(n / 5)
25 -> 2(contains two 5)(n / 5)
 Total 6 trailing zeroes

But if we do 25 / 5 we will get only one 5. to getting another five we have 
to divide the number with next power of 5 i.e 25. 
So 25 / 25 will get one 5

Working:
25 / 5 = 5, but answer is 6
So we have to divide next power of 5 i.e 25 / 25 = 1

5 + 1 = 6.

Example 125:

125 / 5 = 25, but answer is 31.
So we have to divide next power of 5 i.e 125 / 25 = 5
and 125 / 125 = 1

25 + 5 + 1 = 31.



Find smallest number have alteast given trailing zeroes:

Let us take few examples to observe pattern 

5!  has 1 trailing zeroes 
[All numbers from 6 to 9
 have 1 trailing zero]

10! has 2 trailing zeroes
[All numbers from 11 to 14
 have 2 trailing zeroes]

15! to 19! have 3 trailing zeroes

20! to 24! have 4 trailing zeroes

25! to 29! have 6 trailing zeroes


We can notice that, the minimum value whose factorial contain n trailing 
zeroes is 5*n.
So, to find minimum value whose factorial contains n trailing zeroes, 
use binary search on range from 0 to 5*n. And, find the smallest number 
whose factorial contains n trailing zeroes. 
*/


class CountTrailingZeroes {

    public static void main(String[] args) {

        int number = 6;

        System.out.println(smallestNumber(number));
    }

    public static int smallestNumber(int number) {
        int low = 0, high = number * 5;

        while (low <= high) {
            int middle = (low + high) / 2;
			
			// if we found equals to or greater number of zeroes than 
			// input zeroes we will shift to left side
            if (trailingZeroes(middle, number)) {
                high = middle - 1;
            } 
			
			// if number of trailing Zeroes is less than given input zeroes
			// we will shift to right side
            else {
                low = middle + 1;
            }
        }
		
		// return low because we have to return first number which
		// contains alteast given input zeroes
        return low;
    }

    public static boolean trailingZeroes(int number, int inputZeroes) {
        int zeroes = 0;
        int divideWith = 5;

        while (number / divideWith > 0) {
            zeroes += number / divideWith;
            divideWith = divideWith * 5;
        }
        return zeroes >= inputZeroes;
    }
}
