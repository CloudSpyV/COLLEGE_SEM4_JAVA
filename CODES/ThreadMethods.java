

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            // Use of yield()
            Thread.yield();
            try {
                // Use of sleep()
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Use of stop()
        System.out.println("Thread stopped: " + Thread.currentThread().getName());
        Thread.currentThread().stop();
    }
}

public class ThreadMethods {
    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        // Start both threads
        t1.start();
        t2.start();

    }
}
