public class printallsubsequence {

    public  void printallsubseq(String input,String output)
    {
        if(input.length()==0)
        {
            System.out.print(output+" ");
            return;
        }
        char ch=input.charAt(0);
        String substring=input.substring(1);
        //not including first char
        printallsubseq(substring,output);
        //including first character
        printallsubseq(substring,output+ch);
    }
    public static void main(String[] args) {
        String a="aakash";
        foss f=new foss();
        f.printallsubseq(a, " ");
        
        
    }
}