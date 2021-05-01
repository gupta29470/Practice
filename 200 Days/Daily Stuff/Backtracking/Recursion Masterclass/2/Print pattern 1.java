// Using recursion and loop.
// recursion is used for changing row and loop is used to print columns
public class Practice {

    public static void main(String[] args) {
        int n = 5;

        pattern(n);
    }
    
    public static void pattern(int n){
		// base class
        if (n == 0){
            return;
        }
        
		// self work
		// print column
        for (int index = 0; index < n; index++){
            System.out.print("*");
        }
        System.out.println("");
        
		// recursive assumption
        pattern(n - 1);
    }
}



// using multi recursion
// one recursion is used to change row and recursion is used to print columns
public class Practice {

    public static void main(String[] args) {
        int n = 5;

        pattern(n, 0);
    }
    
    public static void pattern(int n, int index){
		// base class
        if (n == 0){
            return;
        }
        
		// self work
		// print column
        if (index < n){
            System.out.print("*");
            pattern(n, index + 1);
        }
		// recursive assumption
        else{
			// change row
            System.out.println("");
            pattern(n - 1, 0);
        }
    }
}
// Time --> O(n ^ 2)    Space --> O(n ^ 2)