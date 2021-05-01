/*
Algorithm: Let input string be “geeksforgeeks” 
1: Construct character count array from the input string.
count[‘e’] = 4 
count[‘g’] = 2 
count[‘k’] = 2 
……
2: Print all the indexes from the constructed array which have value greater 
than 1.
*/

class PrintDuplicates{

    public static void main(String[] args) {
        String string = "geeksforgeeks";

        printduplicates(string);
    }
    
    public static void printduplicates(String string){
        
        int count[] = new int[256];
        
        for (int index = 0; index < string.length(); index++){
            count[string.charAt(index)]++;
        }
        
        for (int index = 0; index < count.length; index++){
            if (count[index] > 1){
                System.out.println((char) (index) + " : " + count[index]);
            }
        }
    }
}
// Time --> O(n)
