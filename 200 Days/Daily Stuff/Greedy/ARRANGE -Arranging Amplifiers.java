import java.util.*;

public class prat {

    public static void main(String[] args) {
        int amplifiers[] = {5, 6, 4};
        
        strongest(amplifiers, amplifiers.length);
    }

    public static void strongest(int amplifiers[], int len){
        Arrays.sort(amplifiers);
        int index1 = 0;
        
        while (amplifiers[index1] == 1){
            System.out.print("1 ");
        }
        
        if (index1 == len - 2 && amplifiers[index1] == 2 && amplifiers[index1 + 1] == 3){
            System.out.print("2 3");
        }
        else{
            for (int index2 = len - 1; index2 >= index1; index2--){
                System.out.print(amplifiers[index2] + " ");
            }
        }
    }
}
