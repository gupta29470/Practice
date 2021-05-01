/*
runCustomerSimulation function:
	-> As input sequence is cpaital alphabets so create a seen array 
	of size 26
	
	-> // seen[i] = 0, indicates that customer 'i' is not in cafe  
        
        // seen[1] = 1, indicates that customer 'i' is in cafe but  
        //         computer is not assigned yet.  
        
        // seen[2] = 2, indicates that customer 'i' is in cafe and  
        //         has occupied a computer.  
		
	-> loop input string 
		-> generate seenIndex by int(char at index) - 'A'
		
		-> if this chacter occurs first time, so initialize 
		seen[seenIndex] = 1
			-> if occupied is less than total computer increment 
			occupied and initialize seen[seenIndex] = 2
			
			-> else increment notGet
		
		-> else if this character is already occupied computer or 
		already seen then decrement occupied and initialize 
		seen[seenIndex] = 0
*/


import java.util.*;

class Customers {

    public static void main(String[] args) {

        System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ"));
        System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE"));
        System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE"));
        System.out.println(runCustomerSimulation(1, "ABCBCA"));
        System.out.println(runCustomerSimulation(1, "ABCBCADEED"));
    }

    // total is number of computers in cafe.  
// visitors is given sequence of customer entry, exit events  
    public static int runCustomerSimulation(int total, String visitors) {

        // seen[i] = 0, indicates that customer 'i' is not in cafe  
        
        // seen[1] = 1, indicates that customer 'i' is in cafe but  
        //         computer is not assigned yet.  
        
        // seen[2] = 2, indicates that customer 'i' is in cafe and  
        //         has occupied a computer.  
        char[] seen = new char[26];
        
        // To keep track of occupied computers  
        int occupied = 0;
        
        // Initialize result which is number of customers who could  
    // not get any computer.  
        int notGet = 0;

        // Traverse the input sequence  
        for (int index = 0; index < visitors.length(); index++) {
            
            // Find index of current character in seen[0...25]  
            int seenIndex = visitors.charAt(index) - 'A';

            // If First occurrence of 'seq[i]'  
            if (seen[seenIndex] == 0) {
                // set the current character as seen  
                seen[seenIndex] = 1;

                // If number of occupied computers is less than  
            // n, then assign a computer to new customer  
                if (occupied < total) {
                    occupied++;
                     // Set the current character as occupying a computer  
                    seen[seenIndex] = 2;
                } 
                
                // Else this customer cannot get a computer,  
            // increment result  
                else {
                    notGet++;
                }
            } 
            
             // If this is second occurrence of 'seq[i]'  
            else {
                
                // Decrement occupied only if this customer  
        // was using a computer  
                if (seen[seenIndex] == 2) {
                    occupied--;
                }
                seen[seenIndex] = 0;
            }
        }
        return notGet;
    }
}

// Time complexity --> O(n)  Space -- > O(26)