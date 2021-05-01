public class Practice {

    public static void main(String[] args) {
        int n = 5;

        pattern(n);
    }
    
    public static void pattern(int n){
        if (n == 0){
            return;
        }
        
        pattern(n - 1);
        
        for (int index = 0; index < n; index++){
            System.out.print("*");
        }
        System.out.println("");
    }
}


public class Practice {

    public static void main(String[] args) {
        int n = 5;

        pattern(n, 1);
    }
    
    public static void pattern(int n, int index){
        if (n == 0){
            return;
        }
        
        printPattern(index);
        System.out.println("");
        
        pattern(n - 1, index + 1);
    }
    
    public static void printPattern(int limit){
        if (limit == 0){
            return;
        }
        
        System.out.print("*");
        
        printPattern(limit - 1);
    }
}
