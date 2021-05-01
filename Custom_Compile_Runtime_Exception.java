import java.util.*;

public class Custom_Compile_Runtime_Exception {
    public static void main(String[] args)throws OldAgeException {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age < 18) {
            throw new YoungAgeException("You are too young to vote");
        }  
        else if(age>80){
            throw new OldAgeException("You are too old to vote");
        }
            else {
            System.out.println("Vote successful");
        }
    }

}

class YoungAgeException extends RuntimeException { // unchecked

    YoungAgeException(String msg) {
        super(msg); // beacuse it is accessible for default exception handler
    }
}

class OldAgeException extends Exception { //checked

    OldAgeException(String msg) {
        super(msg); // beacuse it is accessible for default exception handler
    }
}
