import java.io.*;
import java.util.*;

public class vita {
    
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        int digits[] = {1, 2, 2};
        int index = 0;
        String result = "";
        
        recur(digits, index, result);
    }
    public static void recur(int digits[], int index, String result){
        if (index == digits.length){
            System.out.println(result);
            return;
        }
        
        int sum = 0;
        
        for (int index2 = index; index2 <= Integer.min(index + 1, digits.length - 1); 
            index2++){
            
            sum = (sum * 10) + digits[index2];
            
            if (sum > 0 && sum <= 26){
                recur(digits, index2 + 1, result + alphabet.charAt(sum - 1));
            }
        }
    }
}





class Main
{
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// Function to find all possible combinations of words formed
	// by replacing given positive numbers with corresponding
	// character of English alphabet
	public static void recur(int[] digits, int i, String str)
	{
		// base case: all digits are processed in current configuration
		if (i == digits.length)
		{
			// print the String
			System.out.println(str);
			return;
		}

		int sum = 0;

		// process next two digits (ith and (i+1)th)
		for (int j = i; j <= Integer.min(i + 1, digits.length - 1); j++)
		{
			sum = (sum * 10) + digits[j];

			// if a valid char can be formed by taking one or both digits,
			// append it to the output and recur for remaining digits
			if (sum > 0 && sum <= 26) {
				recur(digits, j + 1, str + alphabet.charAt(sum - 1));
			}
		}
	}

	public static void main(String[] args)
	{
		int[] digits = { 1, 2, 2 };

		String str = "";
		recur(digits, 0, str);
	}
}