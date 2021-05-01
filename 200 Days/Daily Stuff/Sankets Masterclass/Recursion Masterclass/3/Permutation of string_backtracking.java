/*
String : ABC 
Output: ABC
ACB
BAC
BCA
CAB
CBA

So we are giving chance to every character to start string.
First we make swap A with A and give A to start string and pass recursive function from 
index 1 to n - 1 to bring all permutations of remaining string we just add A to 
prefix of string.

Similarly we swap A with B and give B to start. As B is in first place of string, so 
we pass remaining string and pass recursive function from index 1 to n - 1 to bring all 
permutations of remaining string we just add B to prefix of string.

"After we get all permutations starts with B we reswap A with B to get original string 
so that all permutations can achieve"


Similarly we swap A with C and give C to start. As C is in first place of string, so 
we pass remaining string and pass recursive function from index 1 to n - 1 to bring all 
permutations of remaining string we just add C to prefix of string.

"After we get all permutations starts with C we reswap A with C to get original string 
so that all permutations can achieve"

After each stage of swapping we modified input string to regain its original form we have
re-swap again.
*/

public class Practice {

    public static void main(String[] args) {
        String input = "ABC";

        permutations(input.toCharArray(), 0, input.length() - 1);
    }
    
    public static void permutations(char input[], int left, int right){
        if (left == right){
            for (char character : input){
                System.out.print(character + " ");
            }
            System.out.println("");
            return;
        }
        
        for (int index = left; index <= right; index++){
            swap(input, index, left);
            permutations(input, left + 1, right);
            swap(input, index, left);
        }
    }
    
    public static void swap(char input[], int index1, int index2){
        char temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}
