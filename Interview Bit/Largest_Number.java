import java.util.*;
public class Solution {
    public String largestNumber(final List<Integer> A) {
        int count=0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)==0){
                count++;
            }
        }
        if(count==A.size()) return "0";
        Comparator<Integer> com=new Comparator<Integer>(){
          public int compare(Integer int1, Integer int2){
              String s1=""+int1+int2;
              String s2=""+int2+int1;
              Long l1=Long.parseLong(s1);
              Long l2=Long.parseLong(s2);
              return -Long.compare(l1,l2);
          }  
        };
        Collections.sort(A,com);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<A.size();i++){
            sb.append(A.get(i));
        }
        return sb.toString();
    }
}

