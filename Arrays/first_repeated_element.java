import java.util.*;
public class first_repeated_element {
    public static void main(String[] args) {
        int a[]={1 ,5 ,3 ,4 ,3 ,5 ,6};
        int temp=-1;
        for(int i=0;i<a.length;i++)
        {
            int flag=0;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]==a[j])
                {
                    
                    flag=1;
                    temp=i+1;
                    //System.out.println(temp);
                    break;
                }
                
            }
            if(flag==1)break;
           
        } System.out.println(temp);

        
        
        
    }
              
     
} 

