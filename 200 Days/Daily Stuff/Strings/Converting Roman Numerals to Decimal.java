/*

"A number in Roman Numerals is a string of these symbols written 
in descending order"

Approach: "A number in Roman Numerals is a string of these symbols written 
in descending order"(e.g. M’s first, followed by D’s, etc.). However, 
in a few specific cases, to avoid four characters being repeated in 
succession(such as IIII or XXXX), subtractive notation is often used 
as follows: 

I placed before V or X indicates one less, so four is IV (one less than 5) 
and 9 is IX (one less than 10).
X placed before L or C indicates ten less, so forty is XL (10 less than 50)
and 90 is XC (ten less than a hundred).
C placed before D or M indicates a hundred less, so four hundred is CD 
(a hundred less than five hundred) and nine hundred is CM 
(a hundred less than a thousand).
Algorithm to convert Roman Numerals to Integer Number:  

Split the Roman Numeral string into Roman Symbols (character).
Convert each symbol of Roman Numerals into the value it represents.
Take symbol one by one from starting from index 0: 
If current value of symbol is greater than or equal to the value of next symbol, then add this value to the running total.
else subtract this value by adding the value of next symbol to the running total.
*/



import java.util.*;
 
public class RomanToNumber 
{
    // This function returns
    // value of a Roman symbol
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
 
    // Finds decimal value of a
    // given romal numeral
    int romanToDecimal(String str)
    {
        // Initialize result
        int res = 0;
 
        for (int i = 0; i < str.length(); i++) 
        {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));
 
            // Getting value of symbol s[i+1] becuase 
//"A number in Roman Numerals is a string of these symbols written 
// in descending order"
            if (i + 1 < str.length()) 
            {
                int s2 = value(str.charAt(i + 1));
 
                // Comparing both values
                if (s1 >= s2) 
                {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res = res + s1;
                }
                else
                {
                    // Value of current symbol is
                    // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }
 
        return res;
    }
 
    // Driver Code
    public static void main(String args[])
    {
        RomanToNumber ob = new RomanToNumber();
 
        // Considering inputs given are valid
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral"
                           + " is "
                           + ob.romanToDecimal(str));
    }
}

// Time O(n)