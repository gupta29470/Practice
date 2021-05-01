import java.util.*;

public class Run_Method {

    public static void main(String[] args) throws IOException {
        Odd odd = new Odd();
        Even even = new Even();
        odd.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        even.start();

    }

}

class Odd extends Thread {

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

class Even extends Thread {

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
