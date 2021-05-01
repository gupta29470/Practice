import java.util.*;

public class Synchronous_Thread_ {

    public static void main(String[] args) throws Exception {
        Count c = new Count();
        Thread t1 = new Thread(() -> {

            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }

        }
        );
        
        Thread t2=new Thread(()->{
           for(int i=1;i<=1000;i++){
               c.increment();
           } 
        });
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        
        System.out.println("Expected output 2000: " + c.count);//2000

    }
}

class Count {

    int count;

    public synchronized void increment() { // making synchronized so only one thread can run this method at a time 
        count++;
    }
}
