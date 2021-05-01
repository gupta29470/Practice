import java.util.*;

public class Inter_Thread_Communication {

    public static void main(String[] args) throws Exception {
        Data d = new Data();
        new Producer(d);
        new Consumer(d);

    }

}

class Data {

    int data;
    boolean valueSet = false;

    public synchronized void put(int data) {
        while (valueSet) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        System.out.println("Put Data: " + data);
        this.data = data;
        notify();
    }

    public synchronized void get() {
        while (valueSet) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        System.out.println("Get Data: " + data);
        notify();
    }
}

class Producer implements Runnable {

    Data data;

    public Producer(Data data) {
        this.data = data;
        Thread t1 = new Thread(this, "Producer");
        t1.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            data.put(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

class Consumer implements Runnable {

    Data data;

    public Consumer(Data data) {
        this.data = data;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }

    public void run() {
        while (true) {
            data.get();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
