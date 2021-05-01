/*

We will use a priority queue for building Huffman Tree, where the node with the 
lowest frequency has the highest priority. Following are the complete steps:

1. Create a leaf node for each character and add them to the priority queue.

2. While there is more than one node in the queue:
	->Remove the two nodes of the highest priority (the lowest frequency) from 
	the queue.
	
	-> Create a new internal node with these two nodes as children and a frequency 
	equal to the sum of both nodes’ frequencies.
	
	-> Add the new node to the priority queue.
	
3. The remaining node is the root node and the tree is complete.
*/


import java.util.*;

class HuffmanCoding{
    public static void main(String[] args) {
        String message = "abcdef";
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        
        huffmanCoding(message, charfreq);
    }
    
    public static void huffmanCoding(String message, int freq[]){
        char charArray[] = message.toCharArray();
		
		// sort on basis of frequencies
        PriorityQueue<Huffman> priorityQueue = new PriorityQueue<>
        ((Huffman huff1, Huffman huff2) -> huff1.frequency - huff2.frequency);
        
        for (int index = 0; index < charArray.length; index++){
            Huffman huffman = new Huffman(charArray[index], freq[index]);
            huffman.left = null; huffman.right = null;
            
            priorityQueue.add(huffman);
        }
        
        Huffman root = null;
        
		// do till there is more than one node in the queue
        while (priorityQueue.size() > 1){
            Huffman one = priorityQueue.poll();
            Huffman two = priorityQueue.poll();
            
            Huffman sum = new Huffman();
            
            sum.frequency = one.frequency + two.frequency;
            sum.chars = '-';
            
            sum.left = one;
            sum.right = two;
            
            root = sum;
            
            priorityQueue.add(sum);
        }
        
        // printing
        ArrayList<String> codes = new ArrayList<>();
        codes = storeCodes(root, "", codes);
        System.out.println(codes);
        
        print(root, "");
    }
    
    public static ArrayList<String> storeCodes(Huffman root, String code, ArrayList<String> codes){
        if (root.left == null && root.right == null && 
                Character.isLetter(root.chars)){
            codes.add(code);
            return codes;
        }
        
        codes = storeCodes(root.left, code + "0", codes);
        codes = storeCodes(root.right, code + "1", codes);
        
        return codes;
    }
    
    public static void print(Huffman root, String code){
        if (root.left == null && root.right == null && 
                Character.isLetter(root.chars)){
            System.out.println(root.chars + " " + code);
            return;
        }
        
        print(root.left, code + "0");
        print(root.right, code + "1");
    }
}

class Huffman{
    char chars;
    int frequency;
    Huffman left, right;
    
    Huffman(){}
    
    Huffman(char chars, int frequency){
        this.chars = chars;
        this.frequency = frequency;
        
    }
}




/*
					HUFFMAN CODING : ENCODING AND DECODING 
*/

import java.util.*;

class HuffmanCoding {

    public static void main(String[] args) {
        String message = "abcde";
        
        huffmanCoding(message);
    }

    // Builds Huffman Tree and decodes the given input text
    public static void huffmanCoding(String message) {
       char charArray[] = message.toCharArray();
       
       // Count the frequency of appearance of each character
        // and store it in a map
       Map<Character, Integer> frequencyMap = new HashMap<>();
       
       for (char current : charArray){
           frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);
       }
       
       // create a priority queue to store live nodes of the Huffman tree.
        // Notice that the highest priority item has the lowest frequency
       PriorityQueue<Huffman> priorityQueue = new PriorityQueue<>(
               (huffman1, huffman2) -> (huffman1.frequency - huffman2.frequency)
       );
       
       // create a leaf node for each character and add it
        // to the priority queue.
       for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
           priorityQueue.add(new Huffman(entry.getKey(), entry.getValue()));
       }
       
       
        // do till there is more than one node in the queue
       while (priorityQueue.size() > 1){
           
           // Remove the two nodes of the highest priority
            // (the lowest frequency) from the queue
           Huffman one = priorityQueue.poll();
           Huffman two = priorityQueue.poll();
           
           
           // create a new internal node with these two nodes as children
            // and with a frequency equal to the sum of both nodes'
            // frequencies. Add the new node to the priority queue.
           Huffman sum = new Huffman();
           sum.frequency = one.frequency + two.frequency;
           sum.left = one;
           sum.right = two;
           
           priorityQueue.add(sum);
       }
       
       // `root` stores pointer to the root of Huffman Tree
       Huffman root = priorityQueue.peek();
       
       // Traverse the Huffman tree and store the Huffman codes in a map
       Map<Character, String> huffmanCodes = new HashMap<>();
       encode(root, "", huffmanCodes);
       
       // Print the Huffman codes
       System.out.println(huffmanCodes);
        
       StringBuilder sb = new StringBuilder();
       
       for (char current : charArray){
           sb.append(huffmanCodes.get(current));
       }
       
       // Print encoded string
        System.out.println(sb);
        
       if (root.left == null && root.right == null){
           
           // Special case: For input like a, aa, aaa, etc.
           while (root.frequency-- > 0){
               System.out.print(root.chars);
           }
       }
       else{
           int index = -1;
           
           // Traverse the Huffman Tree again and this time,
            // decode the encoded string
           while (index < sb.length() - 1){
               index = decode(root, index, sb);
           }
       }
    }
    
    public static void encode(Huffman root, String code, 
            Map<Character, String> huffmanCodes){
        
        // Found a leaf node
        if (root.left == null && root.right == null){
            huffmanCodes.put(root.chars, code.length() > 0 ? code : "1");
            return;
        }
        
        encode(root.left, code + "0", huffmanCodes);
        encode(root.right, code + "1", huffmanCodes);
    }
    
    public static int decode(Huffman root, int index, StringBuilder sb){
        
        // Found a leaf node
        if (root == null){
            return index;
        }
        
        if (root.left == null && root.right == null){
            System.out.print(root.chars);
            return index;
        }
        
        index++;
        root = sb.charAt(index) == '0'? root.left : root.right;
        
        index = decode(root, index, sb);
        
        return index;
    }
}

class Huffman {

    Character chars;
    Integer frequency;
    Huffman left, right;

    Huffman() {
    }

    Huffman(Character chars, Integer frequency) {
        this.chars = chars;
        this.frequency = frequency;

    }
}
