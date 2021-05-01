/*
1. Use Linked Hash Map and put every word in map.
2. If word contains then increment its frequency by 1 else initialize 
frequency with 1.
3. Use Entry interface to loop map
	-> if value is greater than 1 return its key and return from there
	don't need to move forward
*/

import java.util.*;

class FirstRepeated{
    public static void main(String[] args) {
        String str = "he had had he";
        
        firstRepeated(str);
    }
    
    public static void firstRepeated(String string){
        String strArr[] = string.trim().split(" ");
        
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for (String data : strArr){
            if (!map.containsKey(data)){
                map.put(data, 1);
            }
            else{
                map.put(data, map.get(data) + 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1){
                System.out.println(entry.getKey());
                return;
            }
        }
    }
}

// Time --> O(n)   Space --> O(n)