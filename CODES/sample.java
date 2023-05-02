import java.util.Scanner;

class Student {
    private int rollNumber;

    public void getNumber(int num) {
        rollNumber = num;
    }

    public void putNumber() {
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Test extends Student {
    float m1;
    float m2;

    public void getMarks(float mark1, float mark2) {
        m1 = mark1;
        m2 = mark2;
    }

    public void putMarks() {
        System.out.println("Marks: " + m1 + " " + m2);
    }
}

interface Sports {
    float sportsWt = 6.0f;

    void putWt();
}

class Result extends Test implements Sports {
    private float total;

    public void putWt() {
        System.out.println("Sports weightage: " + sportsWt);
    }

    public void calculateTotal() {
        total = m1 + m2 + sportsWt;
    }

    public void display() {
        putNumber();
        putMarks();
        putWt();
        calculateTotal();
        System.out.println("Total: " + total);
    }
}

class sample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Marks in Subject 1: ");
        float m1 = scanner.nextFloat();

        System.out.print("Enter Marks in Subject 2: ");
        float m2 = scanner.nextFloat();

        Result result = new Result();
        result.getNumber(rollNumber);
        result.getMarks(m1, m2);
        result.display();

        scanner.close();
    }
}
