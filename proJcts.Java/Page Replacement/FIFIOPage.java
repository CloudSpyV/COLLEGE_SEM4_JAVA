import java.util.Scanner;

public class FIFIOPage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the incoming stream: ");
        int size = input.nextInt();

        int[] incomingStream = new int[size];

        System.out.println("Enter the incoming stream elements:");
        for (int i = 0; i < size; i++) {
            incomingStream[i] = input.nextInt();
        }

        int pageFaults = 0;
        int frames = 3;
        int m, n, s, pages;
        pages = incomingStream.length;
        System.out.println("Incoming \t Frame 1 \t Frame 2 \t Frame 3");
        int[] temp = new int[frames];
        for (m = 0; m < frames; m++) {
            temp[m] = -1;
        }
        for (m = 0; m < pages; m++) {
            s = 0;
            for (n = 0; n < frames; n++) {
                if (incomingStream[m] == temp[n]) {
                    s++;
                    pageFaults--;
                }
            }
            pageFaults++;
            if ((pageFaults <= frames) && (s == 0)) {
                temp[m] = incomingStream[m];
            } else if (s == 0) {
                temp[(pageFaults - 1) % frames] = incomingStream[m];
            }
            System.out.println();
            System.out.print(incomingStream[m] + "\t\t");
            for (n = 0; n < frames; n++) {
                if (temp[n] != -1) {
                    System.out.print(temp[n] + "\t\t");
                } else {
                    System.out.print("- \t\t");
                }
            }
        }
        System.out.println("\n\nTotal Page Faults:\t" + pageFaults);
        System.out.println("Total Hits :\t" + (pages - pageFaults));
        input.close();
    }
}
