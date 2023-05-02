public class ThreadDemo implements Runnable {
    private Thread t;

    public ThreadDemo() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Created Thread: " + t);
    }

    public void run() {
        try {
            System.out.println("Thread " + t.getName() + " started");

            // Using yield() method
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + t.getName() + ": " + i);
                Thread.yield();
            }

            // Using sleep() method
            System.out.println("Thread " + t.getName() + " sleeping...");
            Thread.sleep(5000);

            // Using stop() method
            System.out.println("Thread " + t.getName() + " stopping...");
            t.stop();
            System.out.println("Thread " + t.getName() + " stopped.");

            System.out.println("Thread " + t.getName() + " awake.");

        } catch (InterruptedException e) {
            System.out.println("Thread " + t.getName() + " interrupted.");
        }

        System.out.println("Thread " + t.getName() + " exiting.");
    }

    public void start() {
        System.out.println("Starting Thread: " + t);
        t.start();
    }

    public static void main(String args[]) {
        ThreadDemo demo = new ThreadDemo();
        demo.start();

        // Record start time
        long startTime = System.currentTimeMillis();

        // Wait for thread to finish
        try {
            demo.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Record end time and calculate elapsed time
        long endTime = System.currentTimeMillis();
        double elapsedTime = (double) (endTime - startTime) / 1000;

        System.out.println("Elapsed time: " + elapsedTime + " seconds");
    }
}
