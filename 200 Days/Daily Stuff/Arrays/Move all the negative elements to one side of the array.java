/*
moveNegativeBack function:
	-> create two varible start = 0 and end = n - 1
	-> Consider 4 situations:
		1. if both start and end are negative(-, -)
		2. if start is negative and end is positive(-, +)
		3. if start is posivite and end is negative(+, -)
		4. if start and end both are positive(+, +)
		
		1. if both start and end are negative(-, -) then decrement end
		2. if start is negative and end is positive(-, +) swap start
        and end and increment start and decrement end
		3. if start is posivite and end is negative(+, -) then simply 
         increment start and decrement end
		4. if start and end both are positive(+, +) increment start
*/


class MoveNegativeLast {

    public static void main(String[] args) {

        int array[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        moveNegativeBack(array);
        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public static void moveNegativeBack(int array[]) {
        int start = 0, end = array.length - 1;

        while (start <= end) {
            
            // if both start and end are negative(-, -) decrement end
            if (array[start] < 0 && array[end] < 0){
                end--;
            }
            
            // if start is negative and end is positive(-, +) swap start
            // and end and increment start and decrement end
            else if (array[start] < 0 && array[end] >= 0){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            
            // if start is posivite and end is negative(+, -) then simply 
            // increment start and decrement end
            else if (array[start] >= 0 && array[end] < 0){
                start ++;
                end --;
            }
            
            // if start and end both are positive(+, +) then increment start
            else{
                start++;
            }
        }
    }

}
// Time --> O(n)


/*
moveNegativeFront function:
	-> create two varible start = 0 and end = n - 1
	-> Consider 4 situations:
		1. if both start and end are negative(-, -)
		2. if start is negative and end is positive(-, +)
		3. if start is posivite and end is negative(+, -)
		4. if start and end both are positive(+, +)
		
		1. if both start and end are negative(-, -) then increment start
		2. if start is negative and end is positive(-, +) then simply 
         increment start and decrement end
		3. if start is posivite and end is negative(+, -) 
		swap start and end and increment start and decrement end 
		4. if start and end both are positive(+, +) decrement end
*/

class MoveNegativeFront {

    public static void main(String[] args) {

        int array[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        moveNegativeFront(array);
        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public static void moveNegativeFront(int array[]) {
        int start = 0, end = array.length - 1;

        while (start <= end) {
            
            // if both start and end are negative(-, -) increment start
            if (array[start] < 0 && array[end] < 0){
                start++;
            }
            
            // if start is negative and end is positive(-, +)increment start
			// and decrement end
            else if (array[start] < 0 && array[end] >= 0){
                start ++;
                end --;
            }
            
            // if start is posivite and end is negative(+, -) then
			// swap start and end and simply increment start and decrement end
            else if (array[start] >= 0 && array[end] < 0){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
				start++;
                end--;
            }
            
            // if start and end both are positive(+, +) then 
			// decrement end
            else{
                end--;
            }
        }
    }

}
