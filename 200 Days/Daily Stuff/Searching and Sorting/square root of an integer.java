/*
A square root of any number will not be greater than number * number
(number starts from 1).
-> if number * number == x return number

-> else if number * number < x store that number because it may be 
possible that next number * number > x so we will consider previous square

-> else if number * number > x break
*/

class Solution {
    public int mySqrt(int x) {
        
        int potentialSqrt = 0;
        
        for (int number = 1; number * number <= x; number++){
            if (number * number == x){
                return number;
            }
            else if (number * number < x){
                potentialSqrt = number;
            }
            else if (number * number > x ){
                break;
            }
        }
        return potentialSqrt;
    }
}
// Time --> O(n)


/*
Using Binary Search :
1. Take care of some base cases, i.e when the given number is 0 or 1.

2. Create some variables, lowerbound l = 0, upperbound r = n, where n 
is the given number, mid and ans to store the answer.

3. Run a loop until l <= r , the search space vanishes
Check if the square of mid (mid = (l + r)/2 ) is less than or equal to n, 

4. If yes then search for a larger value in second half oF search space, i.e 
l = mid + 1, update ans = mid

5. Else if the square of mid is less than n then search for a smaller value 
in first half oF search space, i.e r = mid – 1
Print the value of answer ( ans)

*/

class SquareRoot {

    public static void main(String[] args) {

        int number = 26;
        
        System.out.println(sqrt(number));
    }

    public static int sqrt(int number) {
        int low = 0, high = number;
        int answer = 0;
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (mid <= number / mid){
                low = mid + 1;
                answer = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return answer;
    }

}