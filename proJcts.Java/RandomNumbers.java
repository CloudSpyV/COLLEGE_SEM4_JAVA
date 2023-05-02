import java.util.Random;

public class RandomNumbers {
    
    public static void main(String[] args) {
        
        int[] randomNumbers = generateRandomNumbers(5);
        
        Thread negThread = new Thread(() -> {
            for (int num : randomNumbers) {
                if (num < 0) {
                    System.out.println(num + " is negative.");
                }
            }
        });
        
        Thread posEvenThread = new Thread(() -> {
            for (int num : randomNumbers) {
                if (num > 0 && num % 2 == 0) {
                    System.out.println(num + " is a positive even number.");
                }
            }
        });
        
        Thread posOddThread = new Thread(() -> {
            for (int num : randomNumbers) {
                if (num > 0 && num % 2 != 0) {
                    System.out.println(num + " is a positive odd number.");
                }
            }
        });
        
        negThread.start();
        posEvenThread.start();
        posOddThread.start();
    }
    
    public static int[] generateRandomNumbers(int count) {
        Random rand = new Random();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = rand.nextInt(201) - 100; // generates a random number between -100 and 100
        }
        return nums;
    }
    
}
