import java.util.*;

public class Multithreading_Runnable_Interface {

    public static void main(String[] args) throws IOException {
        Runnable odd = new Odd();
        Runnable even = new Even();
        
        Thread t1 =new Thread(odd);
        Thread t2=new Thread(even);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        t2.start();

    }

}

class Odd implements Runnable {

    public void run() { //// method name changed show to run because when ever we call start java internally calls run method
        for (int i = 1; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {

                }
            }
        }
    }

}

class Even implements Runnable {

    public void run() { // method name changed show to run because when ever we call start java internally calls run method
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {

                }
            }
        }
    }
}
