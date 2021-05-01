/*
The idea is to put the highest frequency character first (a greedy approach). 
We use a priority queue (Or Binary Max Heap) and put all characters and ordered by their 
frequencies (highest frequency character at root). We one by one take the highest frequency 
character from the heap and add it to result. After we add, we decrease the frequency of 
the character and we temporarily move this character out of priority queue so that it is 
not picked next time.

We have to follow the step to solve this problem, they are:
1. Build a Priority_queue or max_heap, pq that stores characters and their frequencies.
…… Priority_queue or max_heap is built on the bases of the frequency of character.
2. Create a temporary Key that will be used as the previously visited element 
(the previous element in the resultant string. Initialize it { char = ‘#’ , freq = ‘-1’ }
3. While pq is not empty.
….. Pop an element and add it to the result.
….. Decrease frequency of the popped element by ‘1’
….. Push the previous element back into the priority_queue if it’s frequency > ‘0’
….. Make the current element as the previous element for the next iteration.
4. If the length of the resultant string and original string is not equal, print 
“not possible”. Else print result.
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        String string = "aaabc";

        rearrange(string, string.length());
    }

    // Function to rearrange character of a string
      // so that no char repeat twice
    public static void rearrange(String string, int len) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>
        (((Pair pair1, Pair pair2) -> (pair2.frequency - pair1.frequency)));
        
        // Store frequencies of all characters in string
        int countFrequency[] = new int[26];
        
        for (int index = 0; index < len; index++){
            char currentCharacter = string.charAt(index);
            countFrequency[currentCharacter - 'a']++;
        }
        
        // Insert all characters with their frequencies
        // into a priority_queue 
        for (char currentCharacter = 'a'; currentCharacter <= 'z'; currentCharacter++){
            int currentFrequency = countFrequency[currentCharacter - 'a'];
            if (currentFrequency > 0){
                priorityQueue.add(new Pair(currentCharacter, currentFrequency));
            }
        }
        
        // work as the previous visited element
        // initial previous element be. ( '#' and
        // it's frequency '-1' )
        Pair previous = new Pair('#', -1);
        
        // 'result' that will store resultant value
        String result = "";
        
        // traverse queue
        while (!priorityQueue.isEmpty()){
            
            // pop top element from queue and add it
            // to string.
            Pair current = priorityQueue.poll();
            char currentCharacter = current.character;
            int currentFrequency = current.frequency;
            
            result += currentCharacter;
            
            
            // If frequency of previous character is less
            // than zero that means it is useless, we
            // need not to push it 
            if (previous.frequency > 0){
                priorityQueue.add(previous);
            }
            
            // make current character as the previous 'char'
            // decrease frequency by 'one'
            currentFrequency--;
            current.frequency = currentFrequency;
            previous = current;
        }
        
        // If length of the resultant string and original
        // string is not same then string is not valid
        if (result.length() == len){
            System.out.println(result);
        }
        else{
            System.out.println("Not possible");
        }
    }
}

class Pair{
    char character;
    int frequency;
    
    Pair(char character, int frequency){
        this.character = character;
        this.frequency = frequency;
    }
}
// Time --> O(n logn)