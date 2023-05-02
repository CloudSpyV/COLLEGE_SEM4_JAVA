public class MainThreadControl {
    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.currentThread();
        System.out.println("Main thread: " + t);

        // Put the main thread to sleep for 3 seconds
        Thread.sleep(3000);

        // Change the name of the main thread
        t.setName("MainThread");

        System.out.println("New thread name: " + t.getName());
    }
}
