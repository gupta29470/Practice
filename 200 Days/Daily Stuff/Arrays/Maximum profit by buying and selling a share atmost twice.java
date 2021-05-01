/*

Here we’re allowed to stock shares at most twice. The idea is to use 
extra space to solve this problem. We create an auxiliary array 
(say profit[] ) and fill it while performing two scans of the input 
array which contains the stock price information for each day.

1. In the first scan, we update profit[i]  to the maximum profit earned 
by a single stock transaction from day i  to day n-1 . This can be done 
by traversing the array from right to left and keeping track of maximum 
stock price seen so far.

2. In the second scan, we update profit[i]  by taking the maximum of 
profit[i-1]  (i.e. maximum profit calculated so far) and the total 
profit obtained by closing the first transaction on day and performing 
another transaction from day i  to day n-1. . We can find the maximum 
profit earned on a stock transaction closing on day  by traversing the 
array from left to right and keeping track of minimum stock price seen
so far.

3. 
Finally, the last element of profit[]  has the result.

findMaxProfit function:
	-> create profit array of size input array to store max profit so far
	for each day
	
	-> first initialize max_so_far as last element of array
	
	-> for loop from second last element to 0 :
		-> update current profit index by checking max(previous profit,
		max_so_far - current price)
		
		update max_so_far by max(current max_so_far, current price)
		
	-> After this loop we have found 1st max profit of single transaction, 
	means max profit till now. Now we have to find 2nd max profit
	
	
	-> initialize min_so_far with first element of price
	
	-> for loop from 1 to n - 1:
		profit[index] = max(previous profit, current price - min_so_far
		+ profit associated with index i.e profit[index])
		
		update min_so_far by min(min_so_far , current price)
		
	return last element of profit array
*/
class Main {

    // Function to find maximum profit earned from at most two stock transactions
    public static int findMaxProfit(int[] price) {
        int n = price.length;

        // create an auxiliary array of size n
        int[] profit = new int[n];

        // initialize last element of the auxiliary array to 0
        profit[n - 1] = 0;

        // to keep track of maximum stock price on the right of current stock price
        int max_so_far = price[n - 1];

        // traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // update profit[i] to the maximum profit earned by a single stock
            // transaction from day i to day n-1
            profit[i] = Math.max(profit[i + 1], max_so_far - price[i]);

            // update maximum stock price seen so far
            max_so_far = Math.max(max_so_far, price[i]);
        }
        
        for (int data : profit){
            //System.out.println(data);
        }

        // to keep track of minimum stock price to the left of current stock price
        int min_so_far = price[0];

        // traverse the array from left to right
        for (int i = 1; i < n; i++) {
            // update profit[i] by taking the maximum of:
            // 1. profit[i-1] which represents the maximum profit calculated so far
            // 2. total profit obtained by closing the first transaction on day i
            // and performing another transaction from day i to day n-1.

            profit[i] = Math.max(profit[i - 1], (price[i] - min_so_far) + profit[i]);

            // update minimum stock price seen so far
            min_so_far = Math.min(min_so_far, price[i]);
        }
        
        for (int data : profit){
            System.out.println(data);
        }

        // the last element of profit[] stores the result
        return profit[n - 1];
    }

    public static void main(String[] args) {
        int[] price = {2, 4, 7, 5, 4, 3, 5};

        System.out.println("The maximum profit is " + findMaxProfit(price));
    }
}
// 1920DTR1000030264   Aakash@1998
