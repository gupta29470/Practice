/*
1. Create a Pair class to sort stock price according to price and also attach
day, so we can only buy that amount of that stock.

2. Reason for sorting according to stock price because we have to find max stock, 
so more less price stock we purchase the more count increases.

3. maxStock will updated by = min(currentDay, (money / currentStockPrice)).
We have to purchase current stock but limit to given day and also take care that
we won't exceed given money.

4. Deduct money by how much money we spent on buying current stock
*/

import java.util.*;

class MaxStock{
    public static void main(String[] args) {
         int prices[] = { 7, 10, 4 };
         int money = 100;
         
         System.out.println(maxStock(prices, money));
    }
    
    public static int maxStock(int prices[], int money){
        ArrayList<Pair> list = new ArrayList<>(prices.length);
        int maxStock = 0;
        
        for (int index = 0; index < prices.length; index++){
            int stockPrice = prices[index];
            int day = index + 1;
            list.add(new Pair(stockPrice, day));
        }
        
/*
Reason for sorting according to stock price because we have to find max stock, 
so more less price stock we purchase the more count increases.
*/
        Collections.sort(list, (Pair pair1, Pair pair2) -> pair1.stockPrice - pair2.stockPrice);
        
        for(int index = 0; index < list.size(); index++){
            int currentStockPrice = list.get(index).stockPrice;
            int currentDay = list.get(index).day;
            
			/*
		maxStock will updated by = min(currentDay, (money / currentStockPrice)).
We have to purchase current stock but limit to given day and also take care that
we won't exceed given money.
			*/
            maxStock += Math.min(currentDay, (money / currentStockPrice));
			
			// Deduct money by how much money we spent on buying current stock
            money -= currentStockPrice * Math.min(currentDay, (money / currentStockPrice));
        }
        
        return maxStock;
    }
}

class Pair{
    int stockPrice, day;
    
    Pair(int stockPrice, int day){
        this.stockPrice = stockPrice;
        this.day = day;
    }
}

// Time --> O(n logn + n) Sorting and looping