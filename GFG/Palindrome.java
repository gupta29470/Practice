/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Palindrome {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int rem=0,sum=0,temp=n;
		    while(n>0){
		        rem=n%10;
		        n=n/10;
		        sum=sum*10+rem;
		    }
		    if(temp==sum){
		        System.out.println("Yes");
		}
		else{
		    System.out.println("No");
		}
	}
}
}
/*Given an integer, check whether it is a palindrome or not.

Input:
The first line of input contains an integer T denoting the number of test cases. For each test case there will be single line containing single integer N.

Output:
Print "Yes" or "No" (without quotes) depending on whether the number is palindrome or not.

Constraints:
1 <= T <= 1000
1 <= N <= 10000

Example:
Input:
3
6
167
55555

Output:
Yes
No
Yes