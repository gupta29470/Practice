*************** ELEMENT APPERARS MORE THAN (n / 2) times ***************
/*
There can be atmost one majority element which is more than n / 2 times
1. First tell using two loops with Time-> O(n^2) and Space -> O(1)
2. Second Using Hash Map
*/


/*
3.
In Moore's voting algorithm the majority element is equal to all
minority elements until we find that majority element continous 
in last subarray.

Assuming first element is majority element as count is 0 initially.
for index 1 to n - 1:
	-> if count is 0 then we reset majority element as current element
	
	-> if current element is equal to majority element then increment
	count
	
	-> else decrement count indicates

You will end up with the majority element once the iteration is done.

Intution:
from index1 to n - 1 whenever count becomes zero the majority element
is equal to all minority elements
Eg: arr = {7, 7, 5, 7, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5}
Dry run the algorithm:
	int majorityElement = -1;
        
    int count = 0;
	
index: 
	0-> 7 majorityElement = 7 and counter = 1
	1-> 7 current is equal to majorityElement then count = 2    
	2-> 5 current element is not equal to majorityElement then counter = 1
	3-> 7 current element is 7 then counter = 2
	4-> 1 current element is not equal to 7 then counter = 1
	5-> 5 current element is not equal to 7 then counter = 0
	
	As counter = 0 and we can clearly see majority element is equal
	to all minority elements i.e 7 occur 3 times = 5 occur 2 times + 
	1 occur 1 time
	
	6-> 7 counter = 0 so majorityElement = 7(current element)
	7-> current element = 5 so counter = 0
	
	Again counter = 0 and 7 occur 1 time is equal 5 occur 1 time
	
	8-> 5 as counter = 0 majorityElement = 5(current element) and counter = 1
	9-> 7 majorityElement isnot equal to current element then counter = 0
	
	Again counter = 0 and 7 occur 1 time is equal 5 occur 1 time
	
	10-> 7 as counter = 0 majorityElement = 7(current element) and counter = 1
	11-> 5 majorityElement isnot equal to current element then counter = 0
	
	Again counter = 0 and 7 occur 1 time is equal 5 occur 1 time
	
	12-> 5 as counter = 0 majorityElement = 5(current element) and counter = 1
	13-> 5 majorityElement is equal to current element(5) counter = 2
	14->  majorityElement is equal to current element(5) counter = 3
	
we return the majorityElement because in last there is no minority
element is present all is present is majority element so that will be 
majority element



*/

class MajorityElement {

    public static void main(String[] args) {

        int array[] = {7, 7, 5, 7, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};

        System.out.println(majorityElement(array, 4));
    }

    public static int majorityElement(int array[], int k) {

        int majorityElement = -1, count = 0;
        
        for (int data : array){
    // Assuming first element is majority element as count is 0 initially.
	// or
	// if count is 0 then we reset majority element as current element
			if (count == 0){
                majorityElement = data;
            }
// if current element is equal to majority element then increment count
            else if (data == majorityElement){
                count+= 1;
            }
// if current element is equal to majority element then decrement count
            else{
                count-= 1;
            }
        }
        return majorityElement;
    }
}

// Time --> O(n)  Space --> O(1)



*************** ELEMENT APPERARS MORE THAN (n / 3) times ***************

/*
There can be atmost two majority element which is more than n / 3 times
Eg if array length is 11 then 11 / 3 = 3 so element repeated greater 
than 3 is 2 i.e (4 + 4) = 8 and remaining 3.

In this we are performing Boyer Moore's for two elements.

majorityElement:
1. First time for loop  
for each element:
	-> create two majorityElement i.e majorityElement1 and majorityElement2
	and initialze with first element with array and initialze count 
	for two majorityElements count1 and count2 = 0
	
	-> if current element is majorityElement1 then increment count1
	
	-> else if current element is majorityElement2 then increment count2
	
	-> else if count1 = 0 then reset majorityElement1 with current element
	and increment count1
	
	-> else if count2 = 0 then reset majorityElement2 with current element
	and increment count2
	
	-> else if current element is not equal to majorityElement1 and 
	majorityElement2 and count1 and count2 is not equal to zero
	decrement count1 and count2
	
update count1 = 0 and count2 = 0
2. Second time for loop 
Checking the majority element we found in above loop i.e 
majorityElement1 and majorityElement2 is occuring greater than (n / 3) 
times or not using count1 and count2 variable
if occurs add in result list

Reason for again checking majority element because take example as
following array: 5, 5, 9, 2, 5, 2, 2, 9, 9, 1, 3

after first loop we get majorityElement1 = 3 and majorityElement2 = 5
but if we count 5 occurs 3 times and 3 occurs 1 times and both are 
not occuring (n / 3) times individually. So to confirm we have to cross
majority elements
*/


class MajorityElement {

    public static void main(String[] args) {

        int array[] = {1, 1, 1, 3, 3, 2, 2, 2};

        System.out.println(majorityElement(array, 4));
    }

    public static ArrayList<Integer> majorityElement(int array[], int k) {
        
        /*
	create two majorityElement i.e majorityElement1 and majorityElement2
	and initialze with first element with array and initialze count 
	for two majorityElements count1 and count2 = 0
		*/
		int majorityElement1 = array[0], majorityElement2 = array[0];
        int count1 = 0, count2 = 0;
		
		// result to store two majority elements
        ArrayList<Integer> result = new ArrayList<>();
        
        
		for (int data : array){
			
       //if current element is majorityElement1 then increment count1
			if (data == majorityElement1){
                count1++;
            }
			
	// else if current element is majorityElement2 then increment count2
            else if (data == majorityElement2){
                count2++;
            }
			
// else if count1 = 0 then reset majorityElement1 with current element
	// and increment count1
            else if (count1 == 0){
                majorityElement1 = data;
                count1 = 1;
            }
			
	// else if count2 = 0 then reset majorityElement2 with current element
	// and increment count2
            else if (count2 == 0){
                majorityElement1 = data;
                count2 = 1;
            }
	/*
	else if current element is not equal to majorityElement1 and 
	majorityElement2 and count1 and count2 is not equal to zero
	decrement count1 and count2
	*/
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        
 /*
 Reason for this loop:
 Reason for again checking majority element because take example as
following array: 5, 5, 9, 2, 5, 2, 2, 9, 9, 1, 3

after first loop we get majorityElement1 = 3 and majorityElement2 = 5
but if we count 5 occurs 3 times and 3 occurs 1 times and both are 
not occuring (n / 3) times individually. So to confirm we have to cross
majority elements
 */
		for (int data : array){
            if (data == majorityElement1){
                count1++;
            }
            else if (data == majorityElement2){
                count2++;
            }
        }
        
        if (count1 > (array.length / 3)){
            result.add(majorityElement1);
        }
        if (count2 > (array.length / 3)){
            result.add(majorityElement2);
        }
        return result;
    }

}















