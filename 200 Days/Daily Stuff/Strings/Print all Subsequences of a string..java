/*
				Method 1 (Pick and Don’t Pick Concept)  
*/

class Subsequences {

    public static void main(String[] args) {
        String str = "abc";

        subsequences(str);
    }

    public static void subsequences(String string) {
        String answer = "";

        subsequencesUtil(string, answer);
    }

    public static void subsequencesUtil(String string, String answer) {

        if (string.length() == 0) {
            System.out.println(answer);
            return;
        }
		
		 // We add adding 1st character in string
        subsequencesUtil(string.substring(1), answer + string.charAt(0));
		
		// Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        subsequencesUtil(string.substring(1), answer);
    }
}

// Time --> O(2^n)