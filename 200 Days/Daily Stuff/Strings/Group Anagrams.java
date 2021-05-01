/*
Group Anagrams means grouping all words whose characters frequency is same.

Initailization: 
1. Create a bigMap where key is hashmap of character and integer key value 
and value is array list of string 

2. loop to wordsArray
	-> create a hashmap currentMap to store frequency of characters of 
	current string
	
	-> if bigMap does not contains currentMap then create new array list
	add string to list and put currentMap and list to bigMap
	
	-> if bigMap contains currentMap then create array list and initialize
	with already stored list with respective to currentMap in bigMap
	add string in list 
*/


import java.util.*;

class GroupAnagrams{
    public static void main(String[] args) {
        
        String wordsArray[] = { "cat", "dog", "tac", "god", "act" };
        
        anagrams(wordsArray);
    }
    
    public static void anagrams(String []wordsArray){
        
        Map<Map<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        
        for (String current : wordsArray){
            Map<Character, Integer> currentMap = new HashMap<>();
            
            for (int index = 0; index < current.length(); index++){
                char currentChar = current.charAt(index);
                currentMap.put(currentChar, currentMap.getOrDefault(currentChar, 0) + 1);
            }
            
            if (!bigMap.containsKey(currentMap)){
                ArrayList<String> currentList = new ArrayList<>();
                currentList.add(current);
                bigMap.put(currentMap, currentList);
            }
            
            else{
                ArrayList<String> currentList = bigMap.get(currentMap);
                currentList.add(current);
            }
        }
        
        for (ArrayList<String> currentList : bigMap.values()){
            resultList.add(currentList);
        }
        
        System.out.println(resultList);
    }
}
/* Time --> O(N * M * log(M)), where N is size of array and M is size 
 of longest word in array
 
 Space --> O(N+M)
*/