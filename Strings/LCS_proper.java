import java.io.*;
import java.util.*;


public class LCS_proper {

      int lcs(char a[],char b[],int l1,int l2)
      {
          int table[][]=new int[l1+1][l2+1];
          for(int i=0;i<=l1;i++)
          {
              for(int j=0;j<=l2;j++)
              {
                  if(i==0||j==0)
                      table[i][j]=0;
                  
                  else if(a[i-1]==b[j-1])
                      table[i][j]=table[i-1][j-1]+1;
                  else
                      table[i][j]=max(table[i-1][j],table[i][j-1]);
                      
              }
          }
          return table[l1][l2];
      }
      int max(int a,int b)
      {
          return a>b?a:b;
      }
      public static void main(String[] args) {
          foss f=new foss();
      String s1="ABCDGH",s2="AEDFHR";
      char a[]=s1.toCharArray();
      char b[]=s2.toCharArray();
      int l1=a.length,l2=b.length;
          System.out.println(f.lcs(a, b, l1, l2));
    }
              
}
