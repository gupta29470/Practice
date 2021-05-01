import java.util.*;

public class Synchronous_Thread_Need {

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
        
        System.out.println("Expected output 2000: " + c.count);//1831//1596//1538 Every time we run gives different value

    }
}

class Count {

    int count;

    public void increment() {
        count++;
    }
}
