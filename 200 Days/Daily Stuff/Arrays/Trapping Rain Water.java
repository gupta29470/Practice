/*
************************** BRUTE APPROACH ******************************

The idea is to traverse every array element and find highest bars on 
left sides and right sides. Take the smaller between left bar and right bar
and subtract from current element. After subtract the value is left is the
amount of water stored in current element.

amountOfWater function:
	-> initialize amountOfWaters = 0
	
	-> start from index 1 (because we cannot store water on index 0 
	because it does not have left bar) to array.length - 2(including)
	(because we cannot store water on last element because it does not 
	have right bar)
	
	-> outer loop from index1 to array.length - 2
		-> initialize left = current element(to store left maximum)
		
		-> inner loop from 0 to less than outer loop index 
		
			-> update leftMax by checking each element encounter by
			inner loop : left = Math.max(left, array[index2]) after this 
			we found left max for current element
			
		-> initialize right = current element (to store right maximum)
		
			-> inner loop from outer loop index + 1 to less than n
				
				-> update rightMax by checking each element encounter by
			inner loop : right = Math.max(right, array[index2]) 
			after this we found right max for current element
			
		-> amount Of Water can store by current element is :
		min(leftMax , rightMax) - current element
		amountOfWaters+= Math.min(left, right) - array[index1];
*/

class TrappingRainWater {

    public static void main(String[] args) {
        int array[] = {3, 0, 2, 0, 4};

        System.out.println(amountOfWater(array));
    }
    
    public static int amountOfWater(int array[]){
        int amountOfWaters = 0;
        
     /*
	 start from index 1 (because we cannot store water on index 0 
	because it does not have left bar) to array.length - 2(including)
	(because we cannot store water on last element because it does not 
	have right bar)
	 */
		
		for (int index1 = 1; index1 < array.length - 1; index1++){
		
            // initialize left = current element(to store left maximum)
			int left = array[index1];
       
			// inner loop from 0 to less than outer loop index 
			for (int index2 = 0; index2 < index1; index2++){
		/*
		update leftMax by checking each element encounter by
			inner loop : left = Math.max(left, array[index2]) after this 
			we found left max for current element
		*/
                left = Math.max(left, array[index2]);
            }
            
       // initialize right = current element (to store right maximum)
		
			int right = array[index1];
            
      // inner loop from outer loop index + 1 to less than n
			for (int index2 = index1 + 1; index2 < array.length; index2++){
		/*
		update rightMax by checking each element encounter by
			inner loop : right = Math.max(right, array[index2]) 
			after this we found right max for current element
		*/
                right = Math.max(right, array[index2]);
            }
    /*
	amount Of Water can store by current element is :
		min(leftMax , rightMax) - current element
	*/
            amountOfWaters+= Math.min(left, right) - array[index1];
        }
        return amountOfWaters;
    }

}
// Time --> O(n^2)  Space --> O(1)




/*
************************** OPTIMAL APPROACH ******************************

In brute force we calculating dynamically left max bar and right max bar.
In this approach we already calculate left max bar and right max bar for 
every element before counting amount of Water
Left Max Bar and Right Max Bar for every element will be store in 
leftMax and rightMax arrays

amountOfWater function:
	-> initialize amountOfWaters = 0
	
	-> create leftMax and rightMax arrays of length inout array
	
	-> leftMax array first element will be first element of input
	array 
	
	-> rightMax array last element will be last element of input
	array
	
	-> 1st loop to store leftMax for each element from 0 to n - 1:
		-> as we encounter every element and leftMax of current element
		will be max of previous element's max or current element
		leftMax[index] = Math.max(leftMax[index - 1], array[index]);
		
	-> 2nd loop to store rightMax for each element from n - 2 to 0:
		-> as we encounter every element and rightMax of current element
		will be max of next element's max or current element
		rightMax[index] = Math.max(rightMax[index + 1], array[index]);
		
	-> 3rd loop to calculate amountOfWater from 0 to n - 1
		-> amountOfWater = min (leftMax of current element and 
		right max of current element) - current element
		amountOfWaters += Math.min(leftMax[index],rightMax[index]) - 
                    array[index];
*/

class TrappingRainWater {

    public static void main(String[] args) {
        int array[] = {3, 0, 2, 0, 4};

        System.out.println(amountOfWater(array));
    }

    public static int amountOfWater(int array[]) {
		
        // initialize amountOfWaters = 0
		int amountOfWaters = 0;

        // create leftMax and rightMax arrays of length input array
		int leftMax[] = new int[array.length];
        int rightMax[] = new int[array.length];

   // leftMax array first element will be first element of input array 
		leftMax[0] = array[0];
        
	// rightMax array last element will be last element of input array
		rightMax[array.length - 1] = array[array.length - 1];

    
	/*
	1st loop to store leftMax for each element from 0 to n - 1:
		-> as we encounter every element and leftMax of current element
		will be max of previous element's max or current element
	*/
		for (int index = 1; index < array.length; index++) {
            leftMax[index] = Math.max(leftMax[index - 1], array[index]);
        }
        
        
	/*
	2nd loop to store rightMax for each element from n - 2 to 0:
		-> as we encounter every element and rightMax of current element
		will be max of next element's max or current element*/	
		for (int index = array.length - 2; index >= 0; index--){
            rightMax[index] = Math.max(rightMax[index + 1], array[index]);
        }
        
        
	/*
	3rd loop to calculate amountOfWater from 0 to n - 1
		-> amountOfWater = min (leftMax of current element and 
		right max of current element) - current element
	*/
		for (int index = 0; index < array.length; index++){
            amountOfWaters += Math.min(leftMax[index],rightMax[index]) - 
                    array[index];
        }
        return amountOfWaters;
    }

}
// Time --> O(n) + O(n) + O(n) =~ O(n)
// Space --> O(2n)




/*
************************** BETTER APPROACH ******************************
In above two approach we are first calculating leftMax bar and rightMax
bar and then select min between them and subtract from current element

In this approach we have 2 pointers , one at first element(left) and 
second at last element(right) and we choose min initially.

-> If left side element is smaller and left side element is greater than
left max then update left max, else subtract leftMax - current and 
store remaining in amountOfWater and increment left

-> If right side element is smaller and right side element is greater than
right max then update right max, else subtract rightMax - current and 
store remaining in amountOfWater and decrement right

Instead of choosing min (leftMax and rightMax) after calculating 
we choosing minimum initially by given height

It guarantes that there will be maximum height for current minimum.


amountOfWater function:
	-> initialize left = 0, right = n - 1, leftMax = 0, rightMax = 0
	
	-> while left is less than or equals to right
		-> if left element(array[left]) is less than or equals to
		right element(array[right]) then check if left element is greater
		then leftMax if yes then update leftMax else subtract leftMax - 
		current and store remaining in amountOfWater and increment left
		
		-> else (if right element(array[right]) is less than
		left element(array[left])) then check if right element is greater
		then rightMax if yes then update rightMax else subtract rightMax - 
		current and store remaining in amountOfWater and decrement right

*/
class TrappingRainWater {

    public static void main(String[] args) {
        int array[] = {3, 0, 2, 0, 4};

        System.out.println(amountOfWater(array));
    }

    public static int amountOfWater(int array[]) {
        int amountOfWaters = 0;

        int left = 0, right = array.length - 1, leftMax = 0, rightMax = 0;
        
        while (left <= right){
            
	/*
	if left element(array[left]) is less than or equals to
		right element(array[right]) then check if left element is greater
		then leftMax if yes then update leftMax else subtract leftMax - 
		current and store remaining in amountOfWater and increment left
	*/
			if (array[left] <= array[right]){
                if (array[left] > leftMax){
                    leftMax = array[left];
                }
                else{
                    amountOfWaters+= leftMax - array[left];
                }
                left++;
            }
            
	/*
	else (if right element(array[right]) is less than
		left element(array[left])) then check if right element is greater
		then rightMax if yes then update rightMax else subtract rightMax - 
		current and store remaining in amountOfWater and decrement right
	*/
			else{
                if (array[right] > rightMax){
                    rightMax = array[right];
                }
                else{
                    amountOfWaters+= rightMax - array[right];
                }
                right--;
            }
        }
        return amountOfWaters;
    }

}
// Time --> O(n)  Space --> O(1)