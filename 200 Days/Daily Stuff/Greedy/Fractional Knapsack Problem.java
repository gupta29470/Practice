/*
Sort array in descending according to cost(value / weight) because max the cost 
means maximum value and less weight and we want maximum value.

Loop to array

	1. if given weight - current weight is greater than or equals to 0:
		-> update total = total + current value
		-> update given weight = weight - current weight
	
	2. if given weight - current weight is less than 0:
		-> find how much percent you want from current weight to make equals to
		given weight. by fraction = weight / current weight
		-> update total with total + (current value * fraction)(taking that much
		percent from current value)
		
		-> given weight will becomes 0 and break loop

return total weight
		
*/



// Java program to solve fractional Knapsack Problem
import java.util.Arrays;
import java.util.Comparator;
 
// Greedy approach
public class FractionalKnapSack {
    // function to get maximum value
    private static double getMaxValue(int[] wt, int[] val,
                                      int capacity)
    {
        ItemValue[] iVal = new ItemValue[wt.length];
 
        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }
 
        // sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }
        });
 
        double totalValue = 0d;
 
        for (ItemValue i : iVal) {
 
            int curWt = (int)i.wt;
            int curVal = (int)i.val;
 
            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
                // item cant be picked whole
                double fraction
                    = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity
                    = (int)(capacity - (curWt * fraction));
                break;
            }
        }
 
        return totalValue;
    }
 
    // item value class
    static class ItemValue {
        Double cost;
        double wt, val, ind;
 
        // item value function
        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double((double)val / (double)wt);
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;
 
        double maxValue = getMaxValue(wt, val, capacity);
 
        // Function call
        System.out.println("Maximum value we can obtain = "
                           + maxValue);
    }
}
// Time --> O(n logn)