/*
*********************** USING 3 Loops *************************
*/

class GenerateSubstring{
    public static void main(String[] args) {
        
        String string = "abc";
        
        generateSubstring(string);
    }
    
    public static void generateSubstring(String string){
        for (int index1 = 0; index1 < string.length(); index1++){
            for (int index2 = index1 + 1; index2 <= string.length(); index2++){
                for (int index3 = index1; index3 < index2; index3++){
                    System.out.print(string.charAt(index3));
                }
                System.out.println("");
            }
        }
    }
}


/*
*********************** USING SUBSTRING METHOD ********************
*/
class GenerateSubstring{
    public static void main(String[] args) {
        
        String string = "abc";
        
        generateSubstring(string);
    }
    
    public static void generateSubstring(String string){
        for (int index1 = 0; index1 < string.length(); index1++){
            for (int index2 = index1 + 1; index2 <= string.length(); index2++){
                System.out.println(string.substring(index1, index2));
            }
        }
    }
}