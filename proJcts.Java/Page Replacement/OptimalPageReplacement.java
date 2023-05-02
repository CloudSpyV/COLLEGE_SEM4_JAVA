import java.util.Scanner;

public class OptimalPageReplacement {
    public static boolean search(int key, int[] frame_items, int frame_occupied) {
        for (int i = 0; i < frame_occupied; i++)
            if (frame_items[i] == key) {
                return true;

            }
        return false;

    }

    public static void printOuterStructure(int max_frames) {
        System.out.print("Stream ");
        for (int i = 0; i < max_frames; i++)
            System.out.printf("Frame%d ", i + 1);
    }

    public static void printCurrFrames(int item, int[] frame_items, int frame_occupied, int max_frames) {
        System.out.print("\n" + item + "\t");
        for (int i = 0; i < max_frames; i++) {
            if (i < frame_occupied)
                System.out.print(frame_items[i] + "\t");
            else
                System.out.print("- \t");
        }
    }

    public static int predict(int[] ref_str, int[] frame_items, int refStrLen, int index, int frame_occupied) {
        int result = -1, farthest = index;
        for (int i = 0; i < frame_occupied; i++) {
            int j;
            for (j = index; j < refStrLen; j++) {
                if (frame_items[i] == ref_str[j]) {
                    if (j > farthest) {
                        farthest = j;
                        result = i;
                    }
                    break;
                }
            }
            if (j == refStrLen)
                return i;
        }
        return (result == -1) ? 0 : result;
    }

    public static void optimalPage(int[] ref_str, int refStrLen, int[] frame_items, int max_frames) {
        int frame_occupied = 0;
        printOuterStructure(max_frames);
        int hits = 0;
        for (int i = 0; i < refStrLen; i++) {
            if (search(ref_str[i], frame_items, frame_occupied)) {
                hits++;
                printCurrFrames(ref_str[i], frame_items, frame_occupied, max_frames);
                continue;
            }
            if (frame_occupied < max_frames) {
                frame_items[frame_occupied] = ref_str[i];
                frame_occupied++;
                printCurrFrames(ref_str[i], frame_items, frame_occupied, max_frames);
            } else {
                int pos = predict(ref_str, frame_items, refStrLen, i + 1, frame_occupied);
                frame_items[pos] = ref_str[i];
                printCurrFrames(ref_str[i], frame_items, frame_occupied, max_frames);
            }

        }
        System.out.println("\n\nHits: " + hits);
        System.out.println("Page faults: " + (refStrLen - hits));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pages in the reference string: ");
        int refStrLen = sc.nextInt();
        int[] ref_str = new int[refStrLen];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < refStrLen; i++) {
            ref_str[i] = sc.nextInt();
        }
        int max_frames = 3;
        int[] frame_items = new int[max_frames];

        optimalPage(ref_str, refStrLen, frame_items, max_frames);
        sc.close();
    }
}
