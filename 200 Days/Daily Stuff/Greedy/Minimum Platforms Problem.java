/*
We required new platform when one station is occupied and another train has come.

So number of platform needed can be decided in two conditions by comparing
two trains at a time:
	1. if train1 arrivalTime >= train2 arrivalTime and 
	train1 arrivalTime <= train2 departureTime, 
	or 
	
	2. if train2 arrivalTime >= train1 arrivalTime and 
	train2 arrivalTime <= train1 departureTime,
	
	means new train has came after already present train and will depart 
	earlier than already present train.
	
*/



class MinimumPlatforms{
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        
        System.out.println(minimumPlatforms(arr, dep, n));
    }
    
    public static int minimumPlatforms(int arrival[], int departure[], int len){
        int requiredPlatform = 1;
        
        for (int index1 = 0; index1 < len; index1++){
            int platformNeeded = 1;
            
            for (int index2 = index1 + 1; index2 < len; index2++){
                int arrival1 = arrival[index1], arrival2 = arrival[index2];
                int departure1 = departure[index1], departure2 = departure[index2];
                
                if ((arrival1 >= arrival2 && arrival1 <= departure2) ||
                        arrival1 <= arrival2 && arrival2 <= departure1){
                    platformNeeded++;
                }
               requiredPlatform = Math.max(platformNeeded, requiredPlatform);
            }
        }
        return requiredPlatform;
    }
}
// Time --> O(n ^ 2)


/*
As we needed to know how many platforms required, so we sort the time for both
arrival and departure and using two pointers we check if any clashes happen.

1. We traverse arrival array from index1, because 1st train has already
occupied platform.

2. We travese departure array from index0, if beacuse train1 departure is less than
train2 arrival then clash happens else not. That's why arrival index is ahead
of departure index.
*/
import java.util.*;

class MinimumPlatforms{
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        
        System.out.println(minimumPlatforms(arr, dep, n));
    }
    
    public static int minimumPlatforms(int arrival[], int departure[], int len){
        int requiredPlatform = 1, platformNeeded = 1;
        
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int index1 = 1, index2 = 0;
        
        while (index1 < len && index2 < len){
            if (departure[index2] < arrival[index1]){
                platformNeeded--;
                index2++;
            }
            else if (departure[index2] >= arrival[index1]){
                platformNeeded++;
                index1++;
                
                requiredPlatform = Math.max(requiredPlatform, platformNeeded);
            }
        }
        return requiredPlatform;
    }
}

// Time --> O(n logn + 2n) for sorting and two pointers.