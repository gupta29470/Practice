/*
minimumOperations function:
	-> check if both given string is of same length, if yes then continue
	else return invalid
	
	-> create count array to check if all characters are same in both
	strings or not
	
	-> for loop : first increment int value of character in count array 
	and at same time decrement int value of character in count array 
	to check if all characters are same or not
	
	-> check in count array if all values are 0 or not, if not 0 return 
	invalid
	
	-> create 2 index index1 and index2 and both initialize from end 
	of string1 and string2
	
	-> while loop till 0:
		-> if char at index1 and char at index2 is not matched that means
		operation required so increment minOperations.
		
		-> else decrement index2
		
		-> decrement index1. 
		Note: index1 will decrement every time to search char at index2 
		in string 1
*/

class Transform {

    public static void main(String[] args) {

        String string1 = "EACBD", string2 = "EABCD";

        System.out.println(minimumOperations(string1, string2));
    }

    public static int minimumOperations(String string1, String string2) {

        int index1 = string1.length() - 1, index2 = string2.length() - 1;
        int minOperations = 0;

        // This parts checks whether conversion is 
        // possible or not 
        if (string1.length() != string2.length()) {
            return -1;
        }

        int count[] = new int[256];

        // count characters in string1 
        // subtract count for every character in string2 
        for (int index = 0; index < string1.length(); index++) {
            count[string1.charAt(index)]++;
            count[string2.charAt(index)]--;
        }

        // Check if all counts become 0 
        for (int index = 0; index < 256; index++) {
            if (count[index] != 0) {
                return -1;
            }
        }

        while (index1 >= 0 && index2 >= 0) {

            // If there is a mismatch, then  
            // keep incrementing result 'minOperations' 
            // until string2[j] is not found in string1[0..i] 
            if (string1.charAt(index1) != string2.charAt(index2)) {
                minOperations++;
            } else {
                index2--;
            }
            index1--;
        }

        return minOperations;
    }
}
// Time --> O(n)   Space --> O(256)