import java.util.*;
import java.lang.*;
import java.io.*;

class Median_In_a_Row_Wise_sorted_Matrix_2 {
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String s[]=br.readLine().trim().split(" ");
		    int r=Integer.parseInt(s[0]);
		    int c=Integer.parseInt(s[1]);
		    String str[]=br.readLine().trim().split(" ");
		    int p=0;
		    int a[][]=new int[r][c];
		    for(int i=0;i<r;i++){
		        for(int j=0;j<c;j++){
		            a[i][j]=Integer.parseInt(str[p++]);
		        }
		    }
		    int b[]=new int[r*c];
		    int b_fill=0;
		    for(int i=0;i<r;i++){
		        for(int j=0;j<c;j++){
		            b[b_fill++]=a[i][j];
		        }
		    }
		    Arrays.sort(b);
		    System.out.println(b[(r*c)/2]);
			//or
			System.out.println(b[(r*c-1)/2]);
		}
	}
}