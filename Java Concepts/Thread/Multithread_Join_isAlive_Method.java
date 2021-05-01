import java.util.*;

public class Multithread_Join_isAlive_Method {

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }

        });

        t1.start();

        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        t2.start();
        
        t1.join(); t2.join();
        System.out.println("Bye");
        
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
    }

}
