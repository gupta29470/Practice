/*
1) First sort jobs according to finish time, because given question has condition
to find max profit without collision

2) Now apply following recursive process. 
   // Here arr[] is array of n jobs
   findMaximumProfit(arr[], n)
   {
     a) if (n == 1) return arr[0];
	 
     b) Return the maximum of following two profits.
         (i) Maximum profit by excluding current job, i.e., 
             findMaximumProfit(arr, n-1)
			 
         (ii) Maximum profit by including the current job            
   }
*/

import java.util.*;

class JobScheduling{
    public static void main(String[] args) {
        Jobs jobs[] = {new Jobs(1, 2, 50), new Jobs(3, 5, 20), 
                      new Jobs(6, 19, 100), new Jobs(2, 100, 200)};
        
        System.out.println(maxProfit(jobs));
    }
    
    public static int maxProfit(Jobs jobs[]){
        
        Arrays.sort(jobs, new JobsComparator());
        
        // Create an array to store solutions of subproblems. 
        // table[i] stores the profit for jobs till jobs[i] 
        // (including jobs[i]) 
        int profit[] = new int[jobs.length];
        profit[0] = jobs[0].profit;
        
        for (int index = 1; index < jobs.length; index++){
            // Find profit including the current job 
            int includeProfit = jobs[index].profit;
            
            int canInclude = binarySearch(jobs, index);
            
            if (canInclude != -1){
                includeProfit+= profit[canInclude];
            }
            
            // Store maximum of including and excluding includeProfit 
            profit[index] = Math.max(includeProfit, profit[index - 1]);
        }
        return profit[jobs.length - 1];
    }
    
    /* A Binary Search based function to find the latest job 
      (before current job) that doesn't conflict with current 
      job.  "index" is index of the current job.  This function 
      returns -1 if all jobs before index conflict with it. 
      The array jobs[] is sorted in increasing order of finish 
      time. */
    public static int binarySearch(Jobs jobs[], int index){
        int low = 0, high = index - 1;
        
        while (low <= high){
            int middle = (low + high) / 2;
            
            if (jobs[middle].finish <= jobs[index].start){
                if (jobs[middle + 1].finish <= jobs[index].start){
                    low = middle + 1;
                }
                else{
                    return middle;
                }
            }
            else{
                high = middle - 1;
            }
        }
        return -1;
    }
}

class Jobs{
    int start, finish, profit;
    
    Jobs(int start, int finish, int profit){
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}

// Used to sort job according to finish times 
class JobsComparator implements Comparator<Jobs>{
    @Override
    public int compare(Jobs one, Jobs two){
        if (one.finish < two.finish){
            return - 1;
        }
        else if (one.finish > two.finish){
            return 1;
        }
        return 0;
    }
}
