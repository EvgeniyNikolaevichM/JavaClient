import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        double num1 = 2;
        double num2 = 2;
        double multi = Proxy.Multiplication(num1, num2);

        System.out.printf("Произведение " + num1 + " и " + num2 + " равно " + multi);
    }
}
