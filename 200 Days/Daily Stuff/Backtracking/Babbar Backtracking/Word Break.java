/*
We will consider all prefix i.e micro, microsoft, microsofthi and so on... and check one by one if current prefix is present in
dictionary or not. If it is present then concat that prefix in result string and recur from remaining string. Else continue to 
generate prefix.

The base case will be if input string is empty or input string length = 0.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		String dict[] = { "micro", "soft", "microsoft", "hi", "ring", "hiring" };
		List<String> dictionary = Arrays.asList(dict);

		String inputString = "microsofthiring";
		int len = inputString.length();
		String result = "";
		wordBreak(inputString, len, result, dictionary);
	}

	public static void wordBreak(String inputString, int len, String result, List<String> dictionary) {

		if (len == 0) {
			System.out.println(result.trim());
			return;
		}

		for (int index = 0; index < len; index++) {
			String containsWord = inputString.substring(0, index + 1);
			if (dictionary.contains(containsWord)) {
				String remainingWord = inputString.substring(index + 1);
				wordBreak(remainingWord, len - index - 1, result + containsWord + " ", dictionary);
			}
		}
	}
}
/*
Complexities: 

Time Complexity: O(nn). Because there are nn combinations in The Worst Case.
Auxiliary Space: O(n2). Because of the Recursive Stack of wordBreakUtil(…) function in The Worst Case.

*/