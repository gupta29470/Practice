import java.io.*;
import java.util.*;

public class wordbreak {
    static Set<String> st=new HashSet<String>(Arrays.asList("i", "like", "sam", "sung",
           "samsung", "mobile", "ice","cream", "icecream", "man", "go", "mango"));
   
   static boolean isvalid(String word)
   {
       if(word==null && word.length()==0)
       {
           return true;
       }
     
       int n=word.length();
       boolean table[]=new boolean[n];
       for(int i=0;i<n;i++)
       {
           if(st.contains(word.substring(0,i+1)))
           {
               table[i]=true;
           }
           if(table[i]==true && i==n-1)
           {
               return true;
           }
           if(table[i]==true)
           {
               for(int j=i+1;j<n;j++)
               {
                   if(st.contains(word.substring(i+1,j+1)))
                   {
                       table[j]=true;
                   }
                   if(table[j]==true && j==n-1)
                   {
                       return true;
                   }
               }
           }
       }
       return false;
   }
    public static void main(String[] args) {
        String word ="ilikesamsung" ;
        if(isvalid(word))
            System.out.println("Yes or True");
        else
            System.out.println("NO or false");
    }
   
}

   //https://zoom.us/w/96056383335?tk=2j8u2Hzm9aVmR_84iRCPMSiTqciOYuUVoWsppiRWY1c.DQEAAAAWXWgXZxYxOG5lX19FTlF2aVBwQXZDM1FQLTJnAA
//Input string:
//IDeservelearningplatform
//
//Temporary array validWords[] initialized to false (represented by F in the image).
//
//
//i = 0:
//Is input substring from 0...i (= I) present in the dictionary? ✖
//  
//i = 1:
//Is input substring from 0...i (= ID) present in the dictionary? ✖
//
//i = 2:
//Is input substring from 0...i (= IDe) present in the dictionary? ✖
//
//Proceeding till i = 6:
//Is input substring from 0...i (= IDeserv) present in the dictionary? ✖
//
//i = 7:
//Is input substring from 0...i (= IDeserve) present in the dictionary? ✔
//Set validWords[i] = true (represented by T in the image)
//
//
//Next, starting from j = i+1 to n-1, on checking for all substrings from i+1 to j, we see that 'learn' (ending at j=12) and 'learning' (ending at 15) form valid dictionary words.
//So we set, validWords[12] = true and validWords[15] = true.
//
//Since, we have not reached the end of the input string, we proceed with next steps.
//
//i = 8:
//Is input substring from 0...i (= IDeservel) present in the dictionary? ✖
//
//Proceeding till i = 11:
//Is input substring from 0...i (= IDeservelear) present in the dictionary? ✖
//
//i = 12: input substring = IDeservelearn
//validWords[i] is already true.
//Next, starting from j = i+1 to n-1, on checking for all substrings from i+1 to j, we see that there is no valid dictionary word found.
//
//Proceeding like before for i = 13 and 14:
//Is input substring from 0...i (= IDeservelearni) present in the dictionary? ✖
//Is input substring from 0...i (= IDeservelearnin) present in the dictionary? ✖
//
//i = 15: input substring = IDeservelearning
//validWords[i] is already true.
//Next, starting from j = i+1 to n-1, on checking for all substrings from i+1 to j, we see that 'platform' (ending at 23) is a valid dictionary word.
//So, we set validWords[23] = true.
//
//Since, we have reached end of string and validWords[n-1] = validWords[23] = true, hence we return true.