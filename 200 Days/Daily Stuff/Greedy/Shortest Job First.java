						/**************NON - PREEMPTIVE******************/

public class prat {

    public static void main(String[] args) {
        int processes = 5;
        int arrivalTime[] = {2, 1, 4, 0, 2};
        int burstTime[] = {1, 5, 1, 6, 3};
        int done[] = {0, 0, 0, 0, 0};
        
        sjfNonPreemtive(processes, arrivalTime, burstTime, done);
    }

    public static void sjfNonPreemtive(int processes, int arrivalTime[], int burstTime[], int done[]) {
        int systemTime = 0, completed = 0;
        int completionTime[] = new int[processes];
        int turnAroundTime[] = new int[processes];
        int waitingTime[] = new int[processes];
        int averageWaitingTime = 0, averageTurnAroundTime = 0;

        while (true) {
            int temp = processes, limit = Integer.MAX_VALUE;

            if (completed == processes) {
                break;
            }

            for (int index = 0; index < processes; index++) {
                
                /*
		 * If i'th process arrival time <= system time and its flag=0 and burst<min 
		* That process will be executed first 
		*/ 
                if ((arrivalTime[index] <= systemTime) && (done[index] == 0)
                        && (burstTime[index] < limit)) {
                    limit = burstTime[index];
                    temp = index;   
                }
            }
/* If temp == processes means temp value can not updated because no process arrival time< system time 
            so we increase the system time */
            if (temp == processes) {
                systemTime++;
            } 
            else {
                completionTime[temp] = systemTime + burstTime[temp];
                systemTime = systemTime + burstTime[temp];
                turnAroundTime[temp] = completionTime[temp] - arrivalTime[temp];
                waitingTime[temp] = turnAroundTime[temp] - burstTime[temp];
                done[temp] = 1;
                completed++;
            }
        }
        
        for (int index = 0; index < processes; index++){
            averageTurnAroundTime += turnAroundTime[index];
            averageWaitingTime += waitingTime[index];
            
            System.out.println(arrivalTime[index] + "\t" + burstTime[index]
             + "\t" + completionTime[index] + "\t" + turnAroundTime[index]
             + "\t" + waitingTime[index]);
        }
        
        System.out.println("Average turn around time is : " + (float)averageTurnAroundTime / processes);
        System.out.println("Average waiting time is : " + (float)averageWaitingTime / processes);
    }
}
// Time --> O(n)



						/**************PREEMPTIVE******************/
public class prat {

    public static void main(String[] args) {
        int processes = 4;
        int arrivalTime[] = {2, 1, 3, 5};
        int burstTime[] = {3, 2, 4, 6};
        int done[] = {0, 0, 0, 0};
        
        sjfNonPreemtive(processes, arrivalTime, burstTime, done);
    }

    public static void sjfNonPreemtive(int processes, int arrivalTime[], int burstTime[], int done[]) {
        int systemTime = 0, completed = 0;
        int completionTime[] = new int[processes];
        int turnAroundTime[] = new int[processes];
        int waitingTime[] = new int[processes];
        int averageWaitingTime = 0, averageTurnAroundTime = 0;
        int burstTimeClone[] = burstTime.clone();

        while (true) {
            int temp = processes, limit = Integer.MAX_VALUE;
            
            if (completed == processes){
                break;
            }
            
            for (int index = 0; index < processes; index++){
                if ((arrivalTime[index] <= systemTime) && (done[index] == 0) && 
                        (burstTime[index] < limit)){
                    limit = burstTime[index];
                    temp = index;
                }
            }
            
            if (temp == processes){
                systemTime++;
            }
            // decrement burst time
            else{
                burstTime[temp]--;
                systemTime++;
                
                if (burstTime[temp] == 0){
                    completionTime[temp] = systemTime;
                    done[temp] = 1;
                    completed++;
                }
            }
        }
        
        for (int index = 0; index < processes; index++){
            turnAroundTime[index] = completionTime[index] - arrivalTime[index];
            waitingTime[index] = turnAroundTime[index] - burstTimeClone[index];
            averageTurnAroundTime += turnAroundTime[index];
            averageWaitingTime += waitingTime[index];
        }
        
        for (int index = 0; index < processes; index++){
            
            System.out.println(arrivalTime[index] + "\t" + burstTime[index]
             + "\t" + completionTime[index] + "\t" + turnAroundTime[index]
             + "\t" + waitingTime[index]);
        }
        
        System.out.println("Average turn around time is : " + (float)averageTurnAroundTime / processes);
        System.out.println("Average waiting time is : " + (float)averageWaitingTime / processes);
    }
}
// Time --> O(n)