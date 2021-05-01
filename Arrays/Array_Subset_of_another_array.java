import java.util.*;
import java.io.*;
import java.math.*;

public class import java.util.*;
import java.io.*;
import java.math.*;

public class Array_Subset_of_another_array {

//    /* Driver code */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[]={10, 5 ,2, 23 ,19};
        int b[]={19 ,5 ,3};
        int count=0;
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<a.length;i++){
            st.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            if(st.contains(b[i])){
                count++;
            }
        }
        if(count==b.length){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
       
    }
}

