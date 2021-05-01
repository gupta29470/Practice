/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static ArrayList<String> res;
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0){
		    String input = br.readLine();
		    res = new ArrayList<>();
		    permuteString(input, 0, input.length() - 1);
		    Collections.sort(res);
		    System.out.println(res.toString().replace("[", "").replace("]", "").replace(",", ""));
		}
	}
	
	public static void permuteString(String input, int left, int right){
	    if (left == right){
	        res.add(input);
	    }
	    else{
	        for (int index = left; index <= right; index++){
	            input = swap (input, left, index);
	            permuteString (input, left + 1, right);
	            input = swap (input, left, index);
	        }
	        
	    }
	}
	
	public static String swap (String input, int index1, int index2){
	    char charArray[] = input.toCharArray();
	    char temp = charArray[index1];
	    charArray[index1] = charArray[index2];
	    charArray[index2] = temp;
	    return String.valueOf(charArray);
	}
}







class Permutation{
    public static void main(String[] args) {
        
        String string = "ABC";
        
        permutation(string);
    }
    
    
    public static void permutation(String string){
        
        char charArray[] = string.toCharArray();
        int start = 0;
        
        permutationUtil(charArray, start);
    }
    
    public static void permutationUtil(char charArray[], int start){
        if (start == charArray.length - 1){
            System.out.println(String.valueOf(charArray));
            return;
        }
        
        for (int index = start; index < charArray.length; index++){
            swap(charArray, start, index);
            permutationUtil(charArray, start + 1);
            swap(charArray, start, index);
        }
    }
    
    public static void swap(char charArray[], int index1, int index2){
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}
