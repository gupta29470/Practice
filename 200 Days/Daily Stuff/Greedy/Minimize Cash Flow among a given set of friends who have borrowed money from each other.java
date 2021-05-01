/*
1) Compute the net amount for every person. The net amount for person ‘i’ can be 
computed be subtracting sum of all debts from sum of all credits.
{ {0, 1000, 2000},
  {0, 0, 5000},
  {0, 0, 0},}
  
Index column is credited amount. Index '0' has all columns 0 so no amount is 
credited. Similarly Index '1' has 1000 so 1000 rupees credit... Similarly for 
Index '2'

net amount = sum of all credit - sum of all debit amounts

2) Find the two persons that are maximum creditor and maximum debtor. 
Let the maximum amount to be credited maximum creditor be maxCredit and 
maximum amount to be debited from maximum debtor be maxDebit. 
Let the maximum debtor be Pd and maximum creditor be Pc.

maximum creditor will me max of amount array and minimum creditor will be min of
amount array.

3) Find the minimum of maxDebit and maxCredit. Let minimum of two be x. 
Debit ‘x’ from Pd and credit this amount to Pc

4) If x is equal to maxCredit, then remove Pc from set of persons and recur 
for remaining (n-1) persons.

5) If x is equal to maxDebit, then remove Pd from set of persons and recur for
remaining (n-1) persons.
*/


class MinimizeCashFlow{
    public static void main(String[] args) {
        int graph[][] = { {0, 1000, 2000},
                            {0, 0, 5000},
                            {0, 0, 0},};
        
        minCashFlow(graph);
    }
    
    // Given a set of persons as graph[] 
    // where graph[i][j] indicates
    // the amount that person i needs to 
    // pay person j, this function
    // finds and prints the minimum 
    // cash flow to settle all debts.
    public static void minCashFlow(int graph[][]){
        
         // Create an array amount[], 
        // initialize all value in it as 0.
        int amount[] = new int[graph.length];
        
        
        // Calculate the net amount to 
        // be paid to person 'p', and
        // stores it in amount[p]. The 
        // value of amount[p] can be
        // calculated by subtracting 
        // debts of 'p' from credits of 'p'
        for (int index1 = 0; index1 < graph.length; index1++){
            for (int index2 = 0; index2 < graph[0].length; index2++){
                amount[index1] += (graph[index2][index1] - graph[index1][index2]); 
            }
        }
       
        minCashFlowUtil(amount);
    }
    
    // amount[p] indicates the net amount 
    // to be credited/debited to/from person 'p'
    // If amount[p] is positive, then 
    // i'th person will amount[i]
    // If amount[p] is negative, then 
    // i'th person will give -amount[i]
    public static void minCashFlowUtil(int amount[]){
        int maxCredit = findMax(amount), maxDebit = findMin(amount);
        
        // If both amounts are 0, then 
        // all amounts are settled
        if (amount[maxCredit] == 0 && amount[maxDebit] == 0){
            return;
        }
        
        // Find the minimum of two amounts
        int minimum = Math.min(-amount[maxDebit], amount[maxCredit]);
        amount[maxDebit] += minimum;
        amount[maxCredit] -= minimum;
        
        // If minimum is the maximum amount to be
        System.out.println("Person " + maxDebit + " pays " + minimum + " to Person " + maxCredit);
        
        
        // Recur for the amount array. 
        // Note that it is guaranteed that
        // the recursion would terminate 
        // as either amount[mxCredit]  or 
        // amount[mxDebit] becomes 0
        minCashFlowUtil(amount);
    }
    
    // A utility function that returns 
    // index of minimum value in arr[]
    public static int findMin(int amount[]){
        int minIndex = 0;
        
        for (int index = 1; index < amount.length; index++){
            if (amount[index] < amount[minIndex]){
                minIndex = index;
            }
        }
        return minIndex;
    }
    
    // A utility function that returns 
    // index of maximum value in arr[]
    public static int findMax(int amount[]){
        int maxIndex = 0;
        
        for (int index = 1; index < amount.length; index++){
            if (amount[index] > amount[maxIndex]){
                maxIndex = index;
            }
        }
        return maxIndex;
    }
}
// Time --> O(n ^ 2)