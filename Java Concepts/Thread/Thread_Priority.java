import java.util.*;

public class Thread_Priority {

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i + " priority is: " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }
        }, "Odd Thread"); // passing thread name
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " priority is: " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }

        }, "Even Thread");// passing thread name

        System.out.println("Thread 1 priority: " + t1.getPriority());//5
        System.out.println("Thread 2 priority: " + t2.getPriority());//5

        t1.setPriority(1);
        t2.setPriority(10);

        //or
        t1.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Thread 1 priority: " + t1.getPriority());//1
        System.out.println("Thread 2 priority: " + t2.getPriority());//10

        t1.start();
        t2.start();

        /*
         Thread 1 priority: 5
         Thread 2 priority: 5
         Thread 1 priority: 1
         Thread 2 priority: 10
         2 priority is: 10
         1 priority is: 1
         4 priority is: 10
         3 priority is: 1
         5 priority is: 1
         6 priority is: 10
         7 priority is: 1
         8 priority is: 10
         9 priority is: 1
         */
    }

}
