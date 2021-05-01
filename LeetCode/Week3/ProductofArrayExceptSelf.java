import java.util.*;

public class ProductofArrayExceptSelf {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
       int num[]={1,2,3,4};
       int n=num.length;
       int arr[]=new int[n];
       int product=1;
       for(int i=0;i<n;i++)
       {
           product*=num[i];
           arr[i]=product; //[1 2 6 24]
       product=1;
       for(int i=n-1;i>0;i--)
       {
           arr[i]=arr[i-1]*product; //1.[6*1=6]  2.[2*4=8]  3.[12*1=12] 4.end of loop
           product*=num[i];// 1.[4]   2.[4*3=12]   3.[12*2=24]  4.end of loop
       }
       arr[0]=product;  // 1st pos a[0]=24
        
       for(int i:arr)
       {
           System.out.println(i);
       }
       
    }
}
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n)