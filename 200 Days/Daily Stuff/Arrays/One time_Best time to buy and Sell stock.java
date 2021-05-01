/*
******************** We have to buy and sell only one time ***************
If the given array of prices is sorted in decreasing order, then profit 
cannot be earned at all.
*/

/*
using two loops we can find maximum profit. 
-> outer loop will traverse for every element in array
	-> inner loop will traverse from outer element + 1 to n - 1.
		-> if inner loop element is greater than outloop loop element
		we find max between current profit(array[index2] - array[index1])
		and previous profit
		profit = Math.max(profit, array[index2] - array[index1]);
return profir
*/

class StockBuyAndSell {

    public static void main(String[] args) {

        int array[] = {100, 180, 260, 310, 40, 535, 695};

        System.out.println(stockBuyAndSell(array));
    }

    public static int stockBuyAndSell(int array[]) {
        int profit = 0;

        for (int index1 = 0; index1 < array.length; index1++) {
            for (int index2 = index1 + 1; index2 < array.length; index2++) {
                if (array[index1] < array[index2]) {
                    profit = Math.max(profit, array[index2] - array[index1]);
                }
            }
        }
        return profit;
    }
}
// Time --> O(n^2)   Space --> O(1)



/*
**************************** OPTIMAL ************************************
stockBuyAndSell function:
	-> create a minimumPrice variable to store minimum price of stock
	-> for every element we check if current element is less than 
	minimumPrice price, if yes we update minimumPrice and calculate profit
	between (current element - minimumPrice and previous profit)
	-> return profit
*/
class StockBuyAndSell {

    public static void main(String[] args) {

        int array[] = {100, 180, 260, 310, 40, 535, 695};

        System.out.println(stockBuyAndSell(array));
    }

    public static int stockBuyAndSell(int array[]) {
        int profit = 0, minimumPrice = Integer.MAX_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (array[index] < minimumPrice) {
                minimumPrice = array[index];
            }
            profit = Math.max(profit, array[index] - minimumPrice);
        }

        return profit;
    }
}
