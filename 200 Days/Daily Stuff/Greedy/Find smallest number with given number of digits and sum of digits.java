/*
There is a Greedy approach to solve the problem. The idea is to one by one fill all digits from rightmost to leftmost (or from least significant digit to most significant). 
We initially deduct 1 from sum s so that we have smallest digit at the end. 
After deducting 1, we apply greedy approach. We compare remaining sum with 9, 
if remaining sum is more than 9, we put 9 at the current position, else we put the 
remaining sum. Since we fill digits from right to left, we put the highest digits on the 
right side. Below is implementation of the idea.
*/


public class prat {

    public static void main(String[] args) {
        int sum = 20, digits = 3;
        
        smallestNumber(sum, digits);
    }
    
    public static void smallestNumber(int sum, int digits){
        
        // If sum of digits is 0, then a number is possible
        // only if number of digits is 1
        if (sum == 0){
            if (digits == 1){
                System.out.println("Smallest number is : 0");
            }
            else{
                System.out.println("Not possible");
            }
            return;
        }
        
        // Sum greater than the maximum possible sum
        if (sum > 9 * digits){
            System.out.println("Not possible");
            return;
        }
        
        // Create an array to store digits of result
        int array[] = new int[digits];
        
        // deduct sum by one to account for cases later
        // (There must be 1 left for the most significant
        //  digit)
        sum = sum - 1;
        
        // Fill last m-1 digits (from right to left)
        for (int index = digits - 1; index > 0; index--){
            
            // If sum is still greater than 9,
            // digit must be 9
            if (sum > 9){
                array[index] = 9;
                sum = sum - 9;
            }
            else{
                array[index] = sum;
                sum = 0;
            }
        }
        
        // Whatever is left should be the most significant
        // digit
        
        // The initially subtracted 1 is
        // incorporated here
        array[0] = sum + 1;
        
        System.out.println(sum);
        
        for (int data : array){
            System.out.print(data + " ");
        }
    }

}



