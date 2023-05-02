public class invertedpattern {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");// pyramid of blank spaces followed by the pyramid of asteriks
            }
            for (int k = 5; k >= i; --k) {
                System.out.print("* ");// remove the space to remove the symmetry of the pyramid
            }

            System.out.println();
        }
    }

}
