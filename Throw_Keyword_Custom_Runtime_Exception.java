import static java.lang.System.out;
import java.util.*;

public class Throw_Keyword_Custom_Runtime_Exception {

    // Static Block : It runs all static block then main method
//    static{
//        System.out.println("Hii");
//    }
//    public static void main(String[] args) {
//        System.out.println("Hello");
//    }
//    static{
//        System.out.println("By");
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age < 18) {
            throw new YoungAgeException("You are too young to vote");
        } else {
            System.out.println("Vote successful");
        }
    }

}

class YoungAgeException extends RuntimeException {

    YoungAgeException(String msg) {
        super(msg); // beacuse it is accessible for default exception handler
    }
}
