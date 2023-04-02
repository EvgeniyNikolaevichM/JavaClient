import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        double num1 = 2;
        double num2 = 2;
        double multi = Proxy.Multiplication(num1, num2);

        System.out.printf("Proizvedenie " + num1 + " i " + num2 + " ravno " + multi);
    }
}