/*
Algorithm: 
 
1. Create a min-heap and insert all lengths into the min-heap.
2. Do following while the number of elements in min-heap is not one. 
	-> Extract the minimum and second minimum from min-heap
	->	Add the above two extracted values and insert the added value to the min-heap.
	-> Maintain a variable for total cost and keep incrementing it by the sum of extracted 
	values.
	-> Return the value of this total cost.
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };
        
        System.out.println(minimizeCost(ropes));
    }
    
    public static int minimizeCost(int ropes[]){
        if (ropes.length == 0){
            return 0;
        }
        if (ropes.length == 1){
            return ropes[0];
        }
        
        if (ropes.length == 2){
            return ropes[0] + ropes[1];
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int minimumCost = 0;
        
        for (int rope : ropes){
            priorityQueue.add(rope);
        }
        
        while (priorityQueue.size() >= 2){
            int one = priorityQueue.poll();
            int two = priorityQueue.poll();
            
            int sum = one + two;
            minimumCost+= sum;
            
            priorityQueue.add(sum);
        }
        return minimumCost;
    }

}
// Time --> O(n logn)  Space --> O(n)