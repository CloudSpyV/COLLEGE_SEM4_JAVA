import java.lang.Exception;

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class TestMyException {
    public static void main(String[] args) {
        int x = 5;
        int bangdu = 1000;
        try {
            {
                float z = (float) x / (float) bangdu;
                if (z < 0.01) {
                    throw new MyException("Number is too small");
                }
            }
        } catch (MyException e) {
            // TODO: handle exception
            System.out.println("Caught MyException" + e);
        } finally {
            System.out.println("I am always here");
        }
    }

}
