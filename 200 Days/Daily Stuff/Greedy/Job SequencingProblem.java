/*
 The idea is simple – consider each task decreasing order of their profits and 
 schedule it in the latest possible free slot that meets its deadline. 
 If no such slot is there, don’t schedule the task.
 
 Note: We can only assign task before the  given id's deadline.
*/


import java.util.*;

class JobSequencing {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(new Job(1, 9, 15), new Job(2, 2, 2),
                new Job(3, 5, 18), new Job(4, 7, 1),
                new Job(5, 4, 25), new Job(6, 2, 20),
                new Job(7, 5, 8), new Job(8, 7, 10),
                new Job(9, 4, 12), new Job(10, 3, 5));
        
        maxProfit(jobs, 15);
    }

    public static void maxProfit(List<Job> jobs, int maxDeadline) {
        //// arrange the jobs in decreasing order of their profits
        Collections.sort(jobs, (job1, job2) -> job2.profit - job1.profit);
        
        // array to store used and unused slots info
        int slot[] = new int[maxDeadline];
        Arrays.fill(slot, -1);
        
        // stores the maximum profit that can be earned by scheduling jobs
        int profit = 0;

        // consider each job in decreasing order of their profits
        for (Job job : jobs) {
            
            // search for the next free slot and map the task to that slot
            for (int deadline = job.deadline - 1; deadline >= 0; deadline--) {
                if (deadline < maxDeadline && slot[deadline] == -1) {
                    slot[deadline] = job.id;
                    profit += job.profit;
                    break;
                }
            }
        }

        // print the scheduled jobs
        for (int index = 0; index < slot.length; index++) {
            if (slot[index] != -1) {
                System.out.print((index + 1) + " ");
            }
        }
        System.out.println("");
        
         // print total profit that can be earned
        System.out.println(profit);
    }

}

class Job {

    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
// Time --> O(n ^ 2)
