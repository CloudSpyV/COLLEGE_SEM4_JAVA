public class MultipleThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("Thread 1"));
        Thread t2 = new Thread(new MyThread("Thread 2"));
        Thread t3 = new Thread(new MyThread("Thread 3"));

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread implements Runnable {
    String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
