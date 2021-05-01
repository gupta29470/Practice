/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Aakash
 */
import java.io.*;

public class vit {

    // Function that returns true if 
    // str is a palindrome 
    static boolean isPalindrome(String str) {

        // Pointers pointing to the beginning 
        // and the end of the string 
        int i = 0, j = str.length() - 1;

        // While there are characters toc compare 
        while (i < j) {

            // If there is a mismatch 
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            // Increment first pointer and 
            // decrement the other 
            i++;
            j--;
        }

        // Given string is a palindrome 
        return true;
    }

    // Driver code 
    public static void main(String[] args) {
        String str = "nayannamantenet";

        if (isPalindrome(str)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
