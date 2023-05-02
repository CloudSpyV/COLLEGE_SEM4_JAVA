import java.util.LinkedList;
import java.util.Queue;

class Process {
    private String name;
    private int priority;
    private int timeRemaining;

    public Process(String name, int priority, int timeRemaining) {
        this.name = name;
        this.priority = priority;
        this.timeRemaining = timeRemaining;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
}

class RoundRobinDispatcher {
    private Queue<Process> processQueue;
    private int timeSlice;

    public RoundRobinDispatcher(int timeSlice) {
        this.timeSlice = timeSlice;
        processQueue = new LinkedList<>();
    }

    public void addProcess(String name, int priority, int timeRemaining) {
        processQueue.add(new Process(name, priority, timeRemaining));
    }

    public void run() {
        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.poll();
            if (currentProcess.getTimeRemaining() <= timeSlice) {
                System.out.println(
                        currentProcess.getName() + " executed for " + currentProcess.getTimeRemaining() + " ms.");
            } else {
                System.out.println(currentProcess.getName() + " executed for " + timeSlice + " ms.");
                currentProcess.setTimeRemaining(currentProcess.getTimeRemaining() - timeSlice);
                processQueue.add(currentProcess);
            }
        }
    }
}

public class RRDispatcher {
    public static void main(String[] args) {
        RoundRobinDispatcher dispatcher = new RoundRobinDispatcher(100);
        dispatcher.addProcess("Process 1", 1, 500);
        dispatcher.addProcess("Process 2", 2, 250);
        dispatcher.addProcess("Process 3", 3, 1000);
        dispatcher.run();
    }
}
