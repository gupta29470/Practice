/*
Remove all distinct elements from string using Hash Map, loop input string
and put all characters in HashMap. Loop again with entry interface 
and strore keys in allChars String

pass input string and all chars to  smallestWindowUtil function

smallestWindowUtil function: 
We are solving problems using acquire and collect answer and release 
strategy.

1. Acquire strategy refers that we acquire characters till we get all 
characters and number of times characters are given in another string.

2. Collect and release strategy refers to collect raw substring and release
character from start of substring and check after release we are 
satisfying smallest window in a string containing all characters of 
another string.

Initialization :
	1. Create two Hash Maps, one for input string i.e big string 
	and second map for another input string i.e small string
	2. index1 and index2 to find substring which contains all characters
	of another string, initially both initialize to -1.
	3. matchCount indicates that we have found raw string which contains
	all another string characters
	4. answer to store final answer and updating minimum window string
	5. potentialAnswer to update answer 
	6. flag1 and flag2 indicates that we have reached end of input string
	or we have found minimum window string

Operations:
	-> put all characters of another string in anotherMap with its character 
	frequency
	
	-> while flag 1 and flag2 = true:
		-> every time initialize flag1 = false and flag2 = false
		
		1. Acquire:
			-> while index1 < string lengths and matchCount is less
			than or equals to desiredCount 
				-> increment index1 (because it is -1)
				
				-> extract character from string with index1
				
				-> put character and its frequency in stringMap
				
				-> check if current character frequency in stringMap
				is less than or equals to current character frequency
				in anotherMap then increment matchCount. 
				
				-> There will be condition where current character frequency in stringMap
				is greater than current character frequency in anotherMap, 
				so this is redundant character so we do nothing. 
				
				" Note: we only increment matchCount if if current character 
				frequency in stringMap is less than or equals to current 
				character frequency in anotherMap"
				
				-> every time we enter this block we mark flag1 = true
			
		2. Collect and release answer:
			-> while index2 is less than index1 and matchCount is 
			equals to desiredCount
				-> extract substring which contains all characters of
				another in potentialAnswer 
				
				-> if answer length is 0 or answer length is greater 
				than potentialAnswer length update answer = potentialAnswer
				
				-> increment index2 (because it is -1)
				
				-> extract character from string with index2
				
				// releasing
				-> if current character frequency in stringMap is 1
				then simply remove that character 
				-> else decrement current character frequency by 1
				
				"There will be situation we have removed required character,
				so,"
				
				-> check if current character frequency in stringMap 
				is less than current character frequency in anotherMap 
				then decrement matchCount, as matchCount is decremented 
				and it is not equals to desiredCount we are moving 
				out of this while loop 
				
				-> if matchCount is still equals to desiredCount it means
				we have removed redundant character and while loop 
				continues
				
				-> every time we enter this block we mark flag2 = true
		
		if we don't enter in any one block we update flag1 and flag2 =
		false and while loop breaks
		
	
	-> printing answer
*/
import java.util.*;

class SmallestWindow {

    public static void main(String[] args) {

        smallestWindow("aabcbcdbca");
    }

    public static void smallestWindow(String string) {

        Map<Character, Integer> allCharsMap = new HashMap<>();
        String allChars = "";

        for (int index = 0; index < string.length(); index++) {
            char current = string.charAt(index);
            allCharsMap.put(current, allCharsMap.getOrDefault(current, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : allCharsMap.entrySet()) {
            allChars += entry.getKey();
        }
        
        String answer = smallestWindowUtil(string, allChars);
        
        System.out.println(answer);
    }
    
    public static String smallestWindowUtil(String string, String another){
        
        Map<Character, Integer> anotherMap = new HashMap<>();
        int index1 = -1, index2 = -1;
        int matchCount = 0, desiredCount = another.length();
        Map<Character, Integer> stringMap = new HashMap<>();
        String answer = "";
        
        for (int index = 0; index < another.length(); index++){
            char current = another.charAt(index);
            anotherMap.put(current, anotherMap.getOrDefault(current, 0) + 1);
        }
        
        while (true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            while (index1 < string.length() - 1 && matchCount < desiredCount){
                index1++;
                
                char current = string.charAt(index1);
                
                stringMap.put(current, stringMap.getOrDefault(current, 0) + 1);
                
                if (stringMap.getOrDefault(current, 0) <= anotherMap.getOrDefault(current, 0)){
                    matchCount++;
                }
                
                flag1 = true;
            }
            
            while (index2 < index1 && matchCount == desiredCount){
                String potentialAnswer = string.substring(index2 + 1, index1 + 1);
                
                if (answer.length() == 0 || potentialAnswer.length() < string.length()){
                    answer = potentialAnswer;
                }
                
                index2++;
                char current = string.charAt(index2);
                
                if (stringMap.get(current) == 1){
                    stringMap.remove(current);
                }
                else{
                    stringMap.put(current, stringMap.get(current) - 1);
                }
                
                if (stringMap.getOrDefault(current, 0) < anotherMap.getOrDefault(current, 0)){
                    matchCount--;
                }
                
                flag2 = true;
            }
            
            if (flag1 == false && flag2 == false){
                break;
            }
        }
        
        return answer;
    }

}
