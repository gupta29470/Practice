import java.util.*;

public class Thread_Sleep {

    public static void main(String[] args) throws IOException {
        Odd odd = new Odd();
        Even even = new Even();
        odd.show();
        even.show();

    }

}

class Odd {

    public void show() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.print(i+" ");
                try{
                    Thread.sleep(500);
                }
                catch(Exception e){
                    
                }
            }
        }
    }

}

class Even {

    public void show() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i+" ");
                try{
                    Thread.sleep(500);
                }
                catch(Exception e){
                    
                }
            }
        }
    }
}
