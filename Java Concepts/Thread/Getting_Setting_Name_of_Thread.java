import java.util.*;

public class Getting_Setting_Name_of_Thread {

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
        },"Odd Thread"); // passing thread name
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

        },"Even Thread");// passing thread name
        
        
        System.out.println("Thread 1 name: " + t1.getName());//Thread 1 name: Odd Thread
        System.out.println("Thread 2 name: " + t2.getName());//Thread 2 name: Even Thread

        t1.setName("One");
        t2.setName("Two");
        System.out.println("Thread 1 name: " + t1.getName());//Thread 1 name: One
        System.out.println("Thread 2 name: " + t2.getName());//Thread 2 name: Two

        t1.start();

        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Bye");

        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
    }

}
