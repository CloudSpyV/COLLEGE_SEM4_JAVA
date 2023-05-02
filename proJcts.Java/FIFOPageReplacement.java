
//First in First Out Page Replacement Program
import java.util.*;

public class FIFOPageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of frames: ");
        int numFrames = sc.nextInt();

        int[] frames = new int[numFrames];
        int numPageFaults = 0;
        int currentFrameIndex = 0;

        System.out.print("Enter sequence of pages (separated by spaces): ");
        String[] pageString = sc.nextLine().split("");
        int[] pages = new int[pageString.length];
        for (int i = 0; i < pageString.length; i++) {
            pages[i] = Integer.parseInt(pageString[i]);
        }

        // Initialize frames to -1 to indicate empty frames
        Arrays.fill(frames, -1);

        // Iterate through page sequence
        for (int i = 0; i < pages.length; i++) {
            int currentPage = pages[i];
            boolean pageFault = true;

            // Check if current page is already in a frame
            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == currentPage) {
                    pageFault = false;
                    break;
                }
            }

            // If current page is not in a frame, replace the oldest page in the queue
            if (pageFault) {
                frames[currentFrameIndex] = currentPage;
                currentFrameIndex = (currentFrameIndex + 1) % numFrames;
                numPageFaults++;
            }

            // Print current state of frames
            System.out.print("Frames: ");
            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Number of page faults: " + numPageFaults);
        sc.close();
    }
}
