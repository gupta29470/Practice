/*
EEE is having its AGM next week and the president wants to serve cheese prata 
after the meeting. The subcommittee members are asked to go to food connection 
and get P(P<=1000) pratas packed for the function. The stall has L cooks(L<=50) 
and each cook has a rank R(1<=R<=8). A cook with a rank R can cook 1 prata in the 
first R minutes 1 more prata in the next 2R minutes, 1 more prata in 3R minutes 
and so on(he can only cook a complete prata) ( For example if a cook is ranked 2.. 
he will cook one prata in 2 minutes one more prata in the next 4 mins an one more 
in the next 6 minutes hence in total 12 minutes he cooks 3 pratas in 13 minutes 
also he can cook only 3 pratas as he does not have enough time for the 4th prata). 
The webmaster wants to know the minimum time to get the order done. 
Please write a program to help him out.

 

Input
The first line tells the number of test cases. Each test case consist of 2 lines. In the first line of the test case we have P the number of prata ordered. In the next line the first integer denotes the number of cooks L and L integers follow in the same line each denoting the rank of a cook.

Output
Print an integer which tells the number of minutes needed to get the order done.

 

Example
Input:

3
10
4 1 2 3 4
8
1 1
8
8 1 1 1 1 1 1 1 1
Output:
12
36
1
*/



/*
minimumTime function:

We initialize low = 0 and high = max (where low and high denotes time, that
minimum time ranges between them)

while low is less than high:
	-> we are taking potential time i.e middle of low and high and assuming
	this can be time where we can make all pratas
	
	-> if is Possible function return true then we store potential time and 
	search for lower potential time by updating high = potentialTime - 1
	
	-> if return false then we search for greater potential time by updating
	low = potentialTime + 1
	

isPossible function:

Initialize time as 0 and currentPratas = 0

Loop to all chefs :
	-> initially time we itself chef rank
	-> multiply variable to multiply with rank of a chef i.e 2R 3R..., so 2, 3... 
	are stiore in multiply. So initialize multiply with 2
	
	-> while time is less than potentialTime i.e checking if any chef can made
	all pratas in lesser or equal to potentialTime 
		-> increment currentPratas
		-> update time with time + (current chef rank * multiply)
		-> increment multiply
	
	-> if currentPratas is greater or equals to totalPratas i.e if any chef 
	has made all pratas in lesser or equal to potentialTime return true

-> return false
*/

class RotiPrata{
    public static void main(String[] args) {
        
        int totalPratas = 10;
        int chefs[] = {1, 2, 3, 4};
        
        System.out.println(minimumTime(totalPratas, chefs));
    }
    
    public static int minimumTime(int totalPratas, int chefs[]){
        int low = 0, high = Integer.MAX_VALUE;
        int time = 0;
        
        while (low <= high){
            int potentialTime = (low + high) / 2;
            
            if (isPossible(totalPratas, chefs, potentialTime)){
                time = potentialTime;
                high = potentialTime - 1;
            }
            else{
                low = potentialTime + 1;
            }
        }
        return time;
    }
    
    public static boolean isPossible(int totalPratas, int chefs[], int potentialTime){
        int time = 0;
        int currentPratas = 0;
        
        for (int index = 0; index < chefs.length; index++){
            time = chefs[index];
            int multiply = 2;
            
            while (time <= potentialTime){
                currentPratas ++;
                time = time + (chefs[index] * multiply);
                multiply++;
            }
            if (currentPratas >= totalPratas){
                return true;
            }
        }
        return false;
    }
}

// Time --> O(logn * n(chef array length))