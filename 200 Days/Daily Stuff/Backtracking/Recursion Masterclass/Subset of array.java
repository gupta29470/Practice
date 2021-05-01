
// total number of subsets = 2 ^ n
public class Practice {

    public static void main(String[] args) {
        int array[] = {1, 2, 3};

        subsets(array, 0, array.length, "");
    }
    
    public static void subsets(int array[], int index, int len, String outputSubset){
        if (index == len){
            System.out.println("[" + outputSubset + "]");
            return;
        }
        // include current element
        subsets(array, index + 1, len, outputSubset + array[index] + " ");
        
        // exclude current element
        subsets(array, index + 1, len, outputSubset);
    }
}
// Time --> O(2 ^ n)   Space --> O(2 ^ n)