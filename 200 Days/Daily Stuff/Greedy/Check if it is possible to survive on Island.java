/*
You are a poor person in an island. There is only one shop in this island, 
this shop is open on all days of the week except for Sunday. 
Consider following constraints: 

N – Maximum unit of food you can buy each day.
S – Number of days you are required to survive.
M – Unit of food required each day to survive.
Currently, it’s Monday, and you need to survive for the next S days. 
Find the minimum number of days on which you need to buy food from the shop so that you can survive the next S days, or determine that it isn’t possible to survive. 
Examples: 

Input : S = 10 N = 16 M = 2 
Output : Yes 2 
Explanation 1: One possible solution is to buy a box on the first day (Monday), it’s sufficient to eat from this box up to 8th day (Monday) inclusive. Now, on the 9th day (Tuesday), you buy another box and use the chocolates in it to survive the 9th and 10th day.
Input : 10 20 30 
Output : No 
Explanation 2: You can’t survive even if you buy food because 
the maximum number of units you can buy in one day is less the required food 
for one day.
*/


/*
In this problem, the greedy approach of buying the food for some consecutive 
early days is the right direction. 
If we can survive for the first 7 days then we can survive any number of days 
for that we need to check two things 
-> Check whether we can survive one day or not. 
-> (S >= 7) If we buy food in the first 6 days of the week and we can survive 
for the week i.e. total food we can buy in a week (6*N) is greater then or equal 
to total food we require to survive in a week (7*M) then we can survive. 

Note : We are buying the food in the first 6 days because we are counting 
from Monday and the shop will remain close on Sunday.
*/

class Survial{
    public static void main(String[] args) {
        int S = 10, N = 16, M = 2;
 
        survival(S, N, M);
    }
    
    public static void survival(int S, int N, int M){
        
        // If we can not buy at least a week
        // supply of food during the first
        // week OR We can not buy a day supply
        // of food on the first day then we
        // can't survive.
        if (((N * 6) < M * 7 && S > 6) || M > N){
            System.out.println("No");
        }
        
        // If we can survive then we can
            // buy ceil(A/N) times where A is
            // total units of food required
        else{
            int days = (S * M) / N;
            
            if (((M * S) / N) != 0){
                days++;
            }
            System.out.println("Yes " + days);
        }
    }
}