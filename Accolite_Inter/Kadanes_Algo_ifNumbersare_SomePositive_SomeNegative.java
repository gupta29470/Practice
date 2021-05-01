import java.util.*;
import java.lang.*;
import java.io.*;

class Kadanes_Algo_ifNumbersare_SomePositive_SomeNegative{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    int msf=0,meh=0;
		    for(int i=0;i<n;i++){
		        meh=meh+a[i];
		        if(meh<0){
		            meh=0;
		        }
		        else if(msf<meh){
		            msf=meh;
		        }
		    }
		    System.out.println(msf);
		}
	}
}