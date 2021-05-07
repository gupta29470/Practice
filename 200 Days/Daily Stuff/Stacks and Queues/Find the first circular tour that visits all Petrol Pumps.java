/*
uSING TWO LOOPS

We have to find minimum index in array which can give us circular tour.

1. Outerlopp will traverse from 0 to n - 1

	calculate balance petrol of index1
	
	2. Innerloop will traverse from outer loop index + 1 to n - 1
	
		3. calculate balance petrol of all index2
		
		4. If balance < 0 that means we can't jump to next city then break inner loop
		
	5. After completing inner loop and balance is 0 or greater than 0 that means index1 can form circular tour, break outer loop.
	
6. If balance is less than 0 after outer looping then return - 1. Else return index1
*/

import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		PetrolPump petrolPump[] = {
				new PetrolPump(4, 6), 
				new PetrolPump(6, 5),
				new PetrolPump(7, 3),
				new PetrolPump(4, 5),
				};
		
		System.out.println(circularTour(petrolPump));
	}
	
	public static int circularTour(PetrolPump petrolPump[]) {
		int resultIndex = -1, balance = 0;
		
		for (int index1 = 0; index1 < petrolPump.length; index1++) {
			balance = petrolPump[index1].petrol - petrolPump[index1].distance;
			resultIndex = index1;
			
			if (balance >= 0) {
				
				for (int index2 = index1 + 1; index2 < petrolPump.length; index2++) {
					int isPossible = petrolPump[index2].petrol - petrolPump[index2].distance;
					balance += isPossible;
					
					if (balance < 0) {
						break;
					}
				}
			}
			if (balance > 0) {
				break;
			}
		}
		return balance < 0 ? - 1 : resultIndex;
	}
}

class PetrolPump{
	int petrol, distance;
	
	PetrolPump(int petrol, int distance){
		this.petrol = petrol;
		this.distance = distance;
	}
}
// Time --> O(n ^ 2)




/*
Using Two Pointers:

We will be creating two pointers start and end. start will be initialized with 0 and end will be 1.\

1. loop while start != end || balance < 0
	
	2. loop while start != end && balance < 0 , this loop will change starting point if balance petrol becomes less than 0
	If current amount of petrol in truck becomes less than 0, then remove the starting petrol pump from tour.
	increment start. If start becomes 0 that means we cant find result return 0
	
	3. add current petrol pump 
	
	4. increment end

6. If it has petrol pump that makes circular tour then start will become equals to end and outer while loop breaks, then 
we return start.

*/



import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		PetrolPump petrolPump[] = {
				new PetrolPump(4, 6), 
				new PetrolPump(6, 5),
				new PetrolPump(7, 3),
				new PetrolPump(4, 5),
				};
		
		System.out.println(circularTour(petrolPump, petrolPump.length));
	}
	
	public static int circularTour(PetrolPump petrolPump[], int len) {
		int start = 0, end = 1;
		int currentPetrolValue = petrolPump[0].petrol - petrolPump[0].distance;
		
		while (start != end || currentPetrolValue < 0) {
			
			// If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
			while (start != end && currentPetrolValue < 0) {
				
				// Remove starting petrol pump. Change start
				currentPetrolValue -= petrolPump[start].petrol - petrolPump[start].distance;
				
				start = (start + 1) % len;
				
				 
                // If 0 is being considered as start again, then there is no
                // possible solution
				if (start == 0) {
					return -1;
				}
			}
			
			// Add a petrol pump to current tour
			currentPetrolValue += petrolPump[end].petrol - petrolPump[end].distance;
			
			end = (end + 1) % len;
		}
		 // Return starting point
		return start;
	}
}

class PetrolPump{
	int petrol, distance;
	
	PetrolPump(int petrol, int distance){
		this.petrol = petrol;
		this.distance = distance;
	}
}
// Time --> O(n)
