class Main {

  // check if result string is valid shuffle of string first and second
  static boolean shuffleCheck(String first, String second, String result) {

    // check length of result is same as
    // sum of result of first and second
    if(first.length() + second.length() != result.length()) {
      return false;
    }
    // variables to track each character of 3 strings
    int i = 0, j = 0, k = 0;

    // iterate through all characters of result
    while (k != result.length()) {

      // check if first character of result matches with first character of first string
      if (i < first.length() && first.charAt(i) == result.charAt(k))
        i++;

      // check if first character of result matches the first character of second string
      else if (j < second.length() && second.charAt(j) == result.charAt(k))
        j++;

      // if the character doesn't match
      else {
        return false;
      }

      // access next character of result
      k++;
    }

    // after accessing all characters of result
    // if either first or second has some characters left
    if(i < first.length() || j < second.length()) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {

    String first = "XY";
    String second = "12";
    String[] results = {"1XY2", "Y12X"};

    // call the method to check if result string is
    // shuffle of the string first and second
    for (String result : results) {
      if (shuffleCheck(first, second, result) == true) {
        System.out.println(result + " is a valid shuffle of " + first + " and " + second);
      }
      else {
        System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
      }
    }
  }
}


/*
Output

1XY2 is a valid shuffle of XY and 12
Y12X is not a valid shuffle of XY and 12



In the above example, we have a string array named results. 
It contains two strings: 1XY2 and Y12X. We are checking if these 
two strings are valid shuffle of strings first(XY) and second(12).

Here, the program says 1XY2 is a valid shuffle of XY and 12. 
However, Y12X is not a valid shuffle.

This is because Y12X has altered the order of string XY. Here, 
Y is used before X. Hence, to be a valid shuffle, the order of 
string should be maintained.

Note: The program gets confused if the initial letters of two 
strings match. For example, if ab12 and abb34 are two strings, 
then abbab1234 is a valid shuffle.

However, the program will treat the first two letters ab as part of 
the first string. Due to this, the third letter b doesn't match with 
both the third letter of the first string (1) and the first letter of 
the second string (a).

*/