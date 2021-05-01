/*
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. 
The stalls are located along a straight line at positions x1,...,xN 
(0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive 
towards each other once put into a stall. To prevent the cows from hurting 
each other, FJ wants to assign the cows to the stalls, such that the minimum 
distance between any two of them is as large as possible. What is the largest 
minimum distance?

Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Example
Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.
*/


/*
Lets first define a function chk(x) that checks if a distance x is possible 
between each of the cows. We can use a greedy approach here by placing cows at 
the leftmost possible stalls such that they are at least x distance away from 
 last-placed cow.
*/


import java.util.*;

class AgressiveCows{
    public static void main(String[] args) {
        
        int array[] = {1, 2, 8, 4, 9};
        int cows = 3;
        
        System.out.println(minDistance(array, cows));
    }
    
    public static int minDistance(int array[], int cows){
        Arrays.sort(array);
        int low = 0, high = array.length - 1, minDistance = 0;
        
        while (low <= high){
            int middle = (low + high) / 2;
            int count = 1, left = 0;
            
            for (int index = 1; index < array.length && count < cows; index++){
                if (array[index] - array[left] >= middle){
                    count++;
                    left = index;
                }
            }
            // maximize the gap
            if (count >= cows){
                minDistance = middle;
                low = middle + 1;
            }
			// minimize the gap
            else{
                high = middle - 1;
            }
        }
        return minDistance;
    }
}

// Time Complexity: O(NlogN)