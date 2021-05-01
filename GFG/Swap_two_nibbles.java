

import java.util.*;
import java.lang.*;
import java.io.*;

class Swap_two_nibbles {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    System.out.println((n & 0x0F)<<4|(n & 0xF0)>>4);
		}
	}
}
/*package whatever //do not write package name here 
Given a byte, swap the two nibbles in it. For example 100 is be represented as 01100100 
in a byte (or 8 bits). The two nibbles are (0110) and (0100). 
If we swap the two nibbles, we get 01000110 which is 70 in decimal.

Input:

The first line contains 'T' denoting the number of testcases. 
Each testcase contains a single positive integer X.
Output:

In each separate line print the result after swapping the nibbles.


Constraints:

1 ≤ T ≤ 70
1 ≤ X ≤ 255


Example:

Input:

2
100
129

Output:

70
24

The first line contains 'T' denoting the number of testcases. 
Each testcase contains a single positive integer X.
*/