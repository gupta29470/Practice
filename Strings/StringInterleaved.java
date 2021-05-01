import java.util.HashMap;
import java.util.Map;

class StringInterleaved
{
	// Function to check if String X and Y are interleaving of
	// String S or not
	public static boolean interleaved(String X, String Y, String S,
									 Map<String, Boolean> dp)
	{
		// return true if we have reached end of all Strings
		if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
			return true;
		}

		// return false if we have reached the end of String S
		// but String X or Y are not empty
		if (S.length() == 0) {
			return false;
		}

		// calculate unique map key by using delimiter "|"
		String key = (X + "|" + Y + "|" + S);

		// if sub-problem is seen for the first time
		if (!dp.containsKey(key))
		{
			// if String X is not empty and its first character matches with
			// first character of S, recur for remaining subString
			boolean x = (X.length() != 0 && S.charAt(0) == X.charAt(0)) &&
					interleaved(X.substring(1), Y, S.substring(1), dp);

			// if String Y is not empty and its first character matches with
			// first character of S, recur for remaining subString
			boolean y = (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) &&
					interleaved(X, Y.substring(1), S.substring(1), dp);

			dp.put(key, x || y);
		}

		return dp.get(key);
	}

	public static void main(String[] args)
	{
		String X = "ABC";
		String Y = "ACD";
		String S = "ACDABC";

		// map to store solution to already computed sub-problems
		Map<String, Boolean> dp = new HashMap<>();

		if (interleaved(X, Y, S, dp))
			System.out.print("Given String is interleaving of X and Y");
		else
			System.out.print("Given String is not an interleaving of X and Y");

	}
}