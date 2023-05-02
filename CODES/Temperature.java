import java.util.Scanner;

class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] temperature = new int[2][7];
        System.out.println(
                "Enter the temperature for each day of the week for each city (2 cities, 7 days):\nCity 1\nCity 2");

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 7; j++)
                temperature[i][j] = scanner.nextInt();

        int highest = temperature[0][0], hCity = 1, hDay = 1;
        int lowest = temperature[0][0], lCity = 1, lDay = 1;

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 7; j++) {
                if (temperature[i][j] > highest)
                    highest = temperature[i][j];
                if (temperature[i][j] < lowest)
                    lowest = temperature[i][j];
                if (temperature[i][j] == highest) {
                    hCity = i + 1;
                    hDay = j + 1;
                }
                if (temperature[i][j] == lowest) {
                    lCity = i + 1;
                    lDay = j + 1;
                }
            }

        System.out.println("The highest temperature (" + highest + " degrees) was recorded in city " + hCity
                + " on day " + hDay + ".");
        System.out.println("The lowest temperature (" + lowest + " degrees) was recorded in city " + lCity + " on day "
                + lDay + ".");
        scanner.close();
    }
}
