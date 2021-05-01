/*
A simple method is to first calculate factorial of n, then count trailing 0s in 
the result (We can count trailing 0s by repeatedly dividing the factorial by 10 
till the remainder is 0).

The method can cause overflow for slightly bigger numbers as the factorial of a 
number is a big number (See factorial of 20 given in above examples).

Input: n = 20
Output: 4
Factorial of 20 is 2432902008176640000 which has
4 trailing zeroes.
*/

class CountTrailingZeroes {

    public static void main(String[] args) {

        long factorial = factorial(10, 1);
        int count = 0;
        while (factorial > 1) {
            long remainder = factorial % 10;
            if (remainder == 0) {
                count++;
            } else {
                break;
            }
            factorial = factorial / 10;
        }

        System.out.println(count);
    }

    public static long factorial(int number, int factorial) {
        if (number == 1) {
            return factorial;
        }
        return factorial(number - 1, factorial * number);
    }
}



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

*/

class CountTrailingZeroes {

    public static void main(String[] args) {

        int number = 100;
        
        System.out.println(trailingZeroes(number));
    }
    
    public static int trailingZeroes(int number){
        int zeroes = 0;
        int divideWith = 5;
        
        while (number / divideWith > 0){
            zeroes += number / divideWith;
            divideWith = divideWith * 5;
        }
        return zeroes;
    }

}
