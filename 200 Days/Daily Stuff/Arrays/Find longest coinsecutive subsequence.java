/*
******************** IF ARRAY DOES NOT HAVE DUPLICATE *******************
longestConsecutiveSubsequencey function: 
	-> create max variable to store final longest subsequene and 
	currentMax update max variable
	
	-> Sort the array
	
	-> for loop from 0 to n - 1
		-> if next element is "1" greater than current element than 
		increment currentMax 
		
		-> else update currentMax = 1 as initial point
		
		-> update maxCount
*/

class LongestConsecutiveSubsequencey {

    public static void main(String[] args) {

        int array[] = {1, 9, 3, 10, 4, 20, 2};

        System.out.println(longestConsecutiveSubsequencey(array));
    }

    public static int longestConsecutiveSubsequencey(int array[]) {
        int max = 1, currentMax = 1;

        Arrays.sort(array);

        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] + 1 == array[index + 1]) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
// Time --> O(nlogn)  Space --> O(1)




/*
******************** IF ARRAY CONTAINS DUPLICATE *******************

longestConsecutiveSubsequencey function: 
	-> Sort the array

	-> traverse array from 0 to n - 1 and store in Set(contains unique)
	
	-> Put Set data in ArrayList
	
	-> Sort ArrayList
	
	-> create max variable to store final longest subsequene and 
	currentMax update max variable
	
	-> for loop from 0 to n - 1
		-> if next element is "1" greater than current element than 
		increment currentMax 
		
		-> else update currentMax = 1 as initial point
		
		-> update maxCount
*/

class Subseq
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    // return the length of the longest subsequene of consecutive integers
	static int findLongestConseqSubseq(int arr[], int N)
	{
	  
	   Arrays.sort(arr);
	  
	   Set<Integer> set = new HashSet<>();
	   for (int data: arr){
	       set.add(data);
	   }
	   
	   ArrayList<Integer> list = new ArrayList<>(set);
	   Collections.sort(list);
	   
	   int maxCount = 1, count = 1;
	   
	   for (int index = 0; index < list.size() - 1; index++){
	       if (list.get(index) + 1 == list.get(index + 1)){
	           count++;
	       }
	       else{
	           count = 1;
	       }
	       
	       maxCount= Math.max(maxCount, count);
	   }
	   
	   return maxCount;
	}
}
// Time --> O(nlogn)   Space --> O(n)




/*
************************* OPTIMAL APPROACH *************************
We have to reach 1st element(minimum number) where subsequene starts
longestConsecutiveSubsequencey function:
	-> create a hash map and store array element and its frequency in map
	
	-> create max variable to store final longest subsequene and 
	currentMax update max variable initialize with 0
	
	-> for loop from 0 to n - 1
		-> if map contains current element - 1 then continue
		
		-> else We have to reach 1st element(minimum number) where 
		subsequene startscreate currentData = data and update currentMax = 0
		and while loop till we get consecutive subsequene, update
		currentMax and currentData = currentData + 1
		If we don't reach to minimum number we eventually get in to 
		O(n^2) complexity because of second time traversing
		
		-> update maxCount
*/
class LongestConsecutiveSubsequencey {

    public static void main(String[] args) {

        int array[] = {1, 9, 3, 10, 4, 20, 2};

        System.out.println(consecutiveSubsequence(array));
    }

    public static int consecutiveSubsequence(int array[]) {

    // create a hash map and store array element and its frequency in map
		Map<Integer, Integer> map = new HashMap<>();

        for (int data : array) {
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }
		
	// create max variable to store final longest subsequene and 
	// currentMax update max variable initialize with 0
        int currentMax = 0, max = 0;
		
        for (int data : array) {
			// if map contains current element - 1 then continue
            if (map.containsKey(data - 1)) {
                continue;
            } 
	//  else We have to reach 1st element(minimum number) where 
	//	subsequenecreate currentData = data and update currentMax = 0
	//	and while loop till we get consecutive subsequene, update
	//	currentMax and currentData = currentData + 1
			else {
                int currentData = data;
                currentMax = 0;
                while (map.get(currentData) != null) {
                    currentMax++;
                    currentData = currentData + 1;
                }
            }
			
			// update maxCount
            max = Math.max(currentMax, max);
        }
        return max;
    }
}

// Time --> O(3n) ~ O(n)   Space --> O(n)