import java.util.*;

public class vita {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        printPermutations(arr, 0);
    }
    
    public static void printPermutations(int arr[], int currentIndex){
        if (currentIndex == arr.length - 1){
            printArray(arr);
            return;
        }
        
        for (int index = currentIndex; index < arr.length; index++){
            swap (arr, index, currentIndex);
            printPermutations(arr, currentIndex + 1);
            swap (arr, index, currentIndex);
        }
    }
    
    public static void printArray(int arr[]){
        for (int index = 0; index < arr.length; index++){
            System.out.print(arr[index]);
        }
        System.out.println("");
    }
    
    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
   
}