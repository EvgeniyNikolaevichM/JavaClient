import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Proxy {
    public static double Multiplication(double num1, double num2) throws Exception {
        try (Socket socket = new Socket("localhost", 5000)) {
            try (PrintStream outputSocketStream = new PrintStream(socket.getOutputStream())) {
                try (BufferedReader inputSocketStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                    outputSocketStream.println(num1);
                    outputSocketStream.println(num2);
                    outputSocketStream.println();

                    String line = inputSocketStream.readLine();
                    if (line != null) {
                        return Double.parseDouble(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new Exception("Error!");
    }
}
