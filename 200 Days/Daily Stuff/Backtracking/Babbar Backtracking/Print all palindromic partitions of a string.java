/*
We will start attack from prefix of string. If prefix string is palindrome then we will consider as answer and pass rest of string
further.
*/


import java.util.*;
import java.sql.*;//1

public class practice_1 {
	public static void main(String args[]) {
		String input = "nitin";
		
		palindromicPartition(input);
		
	}

	public static void palindromicPartition(String input) {
		palindromicPartitionUtil(input, "");
	}

	public static void palindromicPartitionUtil(String input, String answer) {

		if (input.length() == 0) {
			System.out.println(answer);
			return;
		}
		
		for (int index = 0; index < input.length(); index++) {
			String prefixString = input.substring(0, index + 1);
			String restOfString = input.substring(index + 1);

			if (isPalindrome(prefixString)) {
				palindromicPartitionUtil(restOfString, answer + "(" + prefixString + ")");
			}
		}
	}
	
	public static boolean isPalindrome(String currentString) {
		int index1 = 0, index2 = currentString.length() - 1;
		
		while (index1 <= index2) {
			if (currentString.charAt(index1) != currentString.charAt(index2)) {
				return false;
			}
			index1++;
			index2--;
		}
		return true;
	}
}

/*
Time : O(n * 2 ^ n)
Should be O(n*2^n). You are basically trying out every possible partition out there. For a string with length n, you will have 
2^(n - 1) ways to partition it. This is because, a partition is equivalent of putting a "|" in b/t two chars. 
There are n - 1 such slots to place a "|". There are only two choice for each slot - placing a "|" or not placing a "|". 
Thus 2^(n - 1) ways to place "|"s.

Then for each unique partitioning, you have to traverse the entire string (in the worst case when you have repeating chars) 
to make sure every partition is a palindrome. so n * 2 ^ (n - 1) = O(n*2^n).


Space : number of partitions
*/
