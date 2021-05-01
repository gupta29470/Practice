import java.util.*;
import java.io.*;
import java.math.*;

public class foss {

//    /* Driver code */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[][] = {{1, 3, 5}, {2, 6,9},{3,6,9}};
        
        int b[] = new int[3 * 3];
        int i1 = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                b[i1++] = a[i][j]; 
            }

        }
//        for(int i=0;i<9;i++){
//            
//                System.out.print(b[i]+" ");
//            }
        
        Arrays.sort(b);
        for(int i=0;i<9;i++){
            
                System.out.print(b[i]+" ");
            }
        System.out.println("");
        System.out.println(b[(3 * 3 ) / 2]);
		//or
		System.out.println(b[(3 * 3 -1) / 2]);

    }
}
