import java.util.*;

public class Multithreading_Lamda {

    public static void main(String[] args) throws IOException {
        Runnable odd = () -> {
            for (int i = 1; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }
        };

        Runnable even = () -> {
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }

        };

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);

        t1.start();

        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        t2.start();

    }

}
