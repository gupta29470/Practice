/*

The idea is to traverse the given expression and maintain a count of 
open braces in the expression seen so far. 

1. If the current character is an opening brace ‘{‘ , then we increment the 
count of opened braces by  1.

2.  If the current character is a closing brace ‘}’ , then we check if it has 
any unclosed brace to its left (look for non-zero opened brace count). 

If any unclosed brace is found, we close it by using current brace and 
decrement the count of opened braces by one; 
else we convert the current closing brace ‘}’  to  and increment the total 
inversions needed and opening brace count by  1.

 After we are done processing each character in the expression, if there are 
 n  opened braces, we will need exactly n/2  inversion to close them.
*/


class Main
{
    // Function to find the minimum number of inversions needed
    // to make the given expression balanced
    public static int findMinInversions(String exp)
    {
        // if the expression has odd length, it cannot be balanced
        if (exp.length() % 2 == 1) {
            return Integer.MAX_VALUE;
        }
 
        int inversions = 0;// stores total inversions needed
        int open = 0; // stores total number of opening braces
 
        // traverse the expression
        for (char c: exp.toCharArray())
        {
            // if current character is an opening brace
            if (c == '{') {
                open++;
            }
 
            // if current character is a closing brace
            else
            {
                // if an opening brace is found before, close it
                if (open != 0) {
                    open = open - 1;    // decrement opening brace count
                }
                else
                // invert the closing brace i.e. change '}' to '{'
                {
                    inversions++; // increment total inversions needed by 1
                    open = 1;    // increment opening brace count
                }
            }
        }
 
        // for N opened brace, we need exactly N/2 inversions
        return inversions + open / 2;
    }
 
    public static void main(String[] args)
    {
        String exp = "{{}{{}{{";
 
        int inversions = findMinInversions(exp);
 
        if (inversions != Integer.MAX_VALUE) {
            System.out.print("Minimum number of inversions needed is " + inversions);
        }
        else {
            System.out.print("Invalid input");
        }
    }
}