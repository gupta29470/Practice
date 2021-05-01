/*
************************* BRUTE FORCE ****************************
1. Create a string array from input string.
2. Store first and second string in one and two variable
3. loop till minimum length between one and two and if common characters 
then concat in lcp variable.
4. loop from index 2 because we have store prefix of first and second string
of array in lcp variable.
	-> Store current string in current variable.
	-> determine min length between current string and lcp
	-> loop till min length and if characters matches then concat in 
	temp variable. 
	-> After inner loop stops check if temp length is less than lcp length, 
	if yes then lcp = temp
	
5. return lcp
*/

class LongestCommonPrefix {

    public static void main(String[] args) {

        String string = "flower flow flight";

        lcp(string);
    }

    public static void lcp(String string) {

        if (string.length() == 0) {
            return;
        }

        if (string.length() == 1) {
            System.out.println(string);
            return;
        }

        String lcp = "";
        // Create a string array from input string.
		String array[] = string.trim().split(" ");

        // Store first and second string in one and two variable
		String one = array[0];
        String two = array[1];

        int initialLoop = one.length() < two.length() ? one.length()
                : two.length();

        
// loop till minimum length between one and two and if common characters 
// then concat in lcp variable.		
		for (int index = 0; index < initialLoop; index++) {
            if (one.charAt(index) == two.charAt(index)) {
                lcp += one.charAt(index);
            } else {
                break;
            }
        }

        
// loop from index 2 because we have store prefix of first and second string
// of array in lcp variable.		
		for (int index = 2; index < array.length; index++) {
            
			// Store current string in current variable.
			String current = array[index];
            String temp = "";
            
			// determine min length between current string and lcp
			int innerLength = current.length() < lcp.length()
                    ? current.length() : lcp.length();
            
// loop till min length and if characters matches then concat in 
	// temp variable. 			
			for (int innerIndex = 0; innerIndex < innerLength; innerIndex++) {
                if (current.charAt(innerIndex) == lcp.charAt(innerIndex)) {
                    temp += current.charAt(innerIndex);
                } else {
                    break;
                }
            }

// After inner loop stops check if temp length is less than lcp length, 
	// if yes then lcp = temp            
			if (temp.length() < lcp.length()) {
                lcp = temp;
            }
        }
        
		//return lcp
		System.out.println(lcp);
    }
}
/*
Time : 
	Average --> O(n) * O(innerLength)
	Worst --> O(n^2)
	
Space : If string given then O(n)
		If string array given O(1)
*/
