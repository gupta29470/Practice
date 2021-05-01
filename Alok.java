// Question 1
import java.io.*;
import java.util.*;

public class Question 1 {

    public static void main(String[] args) throws Exception {
        String str = "{{hello {world}}";
        boolean result = checkBrackets(str);
        System.out.println(result);
    }

	// main Function
    public static boolean checkBrackets(String str) {
		
		
		// copy from here 
        Stack<Character> st = new Stack<>();

        for (int index = 0; index < str.length(); index++) {
            char temp = str.charAt(index);
            if (temp == '{') {
                st.push(temp);
            } else if (temp == '}' && st.peek() == '{') {
                st.pop();
            }
        }

        if (st.size() == 0) {
            return true;
        }
        return false;
    }
}




// Duplicate Number

import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
       int arr[] = {1, 2, 6, 3};
       String res = findDuplicate(arr);
        System.out.println(res);
    }
	
	
	// Given Function
    public static String findDuplicate(int arr[]) {
		
		// Copy from here
        String res = "";

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        boolean flag = false;
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                temp = entry.getKey();
                flag = true;
            }
        }

        if (flag == true) {
            res = "Duplicate number is " + temp;
        } else {
            res = "No duplicate number";
        }

        return res;
    }
}




// Count Frequency
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
        int arr[] = {1, 2, 6, 3};
        int freq = 9;
        String res = findDuplicate(arr, freq);
        System.out.println(res);
    }
	
	
	// Given Function
    public static String findFrequency(int arr[], int freq) {
        String res = "";

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        boolean flag = false;
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == freq) {
                temp = entry.getValue();
                flag = true;
            }
        }

        if (flag == true) {
            res = freq + " comes " + temp + " time";
        } else {
            res = freq + " not present";
        }

        return res;
    }
}





// Number to words 
import java.util.*;

public class vit {

    static ArrayList<String> output = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int input = 9999999;
        String res = numberToWord(input);
        System.out.println(res);
    }


	// Given Function
    public static String numberToWord(int input) {
		
		// main logic
        String words = "";

        String unitsArray[] = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String tensArray[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};

        if (input == 0) {
            return "zero";
        }

        if (input < 0) {
            String numberStr = "" + input;
            numberStr = numberStr.substring(1);
            return "minus " + numberToWord(Integer.parseInt(numberStr));
        }

        if ((input / 1000000) > 0) {
            words += numberToWord(input / 1000000) + " million ";
            input = input % 1000000;
        }

        if ((input / 100000) > 0) {
            words += numberToWord(input / 100000) + " lac ";
            input = input % 100000;
        }

        if ((input / 1000) > 0) {
            words += numberToWord(input / 1000) + " thousand ";
            input = input % 1000;
        }

        if ((input / 100) > 0) {
            words += numberToWord(input / 100) + " hundred ";
            input = input % 100;
        }
        if (input > 0) {

            if (input < 20) {
                words += unitsArray[input];
            } else {
                words += tensArray[input / 10];
                if ((input % 10) > 0) {
                    words += " " + unitsArray[input % 10];
                }
            }
        }

        return words;
    }

}




// Find Intersection

import java.util.*;

public class vit {

    static ArrayList<String> output = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        String strArr[][] = {{"1,3,9,10,17,18"}, {"1,4,9,10"}};
        String res = findIntersection(strArr);
        for (int index = 0; index < res.length() - 1; index++) {
            System.out.print(res.charAt(index));
        }
        System.out.println("");

    }
	
	
	// Given Function
    public static String findIntersection(String strArr[][]) {
		
		// main logic
        String a = strArr[0][0];

        String b = strArr[1][0];

        String arr[] = a.trim().split(",");
        String brr[] = b.trim().split(",");
        String res = "";

        int index1 = 0, index2 = 0;
        while (index1 < arr.length && index2 < brr.length) {
            int i = Integer.parseInt(arr[index1]);
            int j = Integer.parseInt(brr[index2]);

            if (i == j) {
                res += i + ",";
                index1++;
                index2++;
            } else if (i < j) {
                index1++;
            } else {
                index2++;
            }
        }
        return res;
    }

}



