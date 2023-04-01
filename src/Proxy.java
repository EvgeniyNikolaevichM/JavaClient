import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


//ЭТО КЛИЕНТ!!!
//Паттерн, который дает возможность подставлять вместо реальных объектов специальные объекты заменители
//Вместо клиента будем подставлять сервер:
//На клиенте мы только выводим результат, того метода, который у нас в  прокси записан
//Даем доступ к порту на сервере, потом клиент отправляет свой запрос, сервер дает ответ и клиент его считывает:

public class Proxy {
    public static double Multiplication(double num1, double num2) throws Exception {
        try (Socket socket = new Socket("localhost", 5000)) {
            try (PrintStream outputSocketStream = new PrintStream(socket.getOutputStream())) {
                try (BufferedReader inputSocketStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                    outputSocketStream.println(num1);//Отправляем первое число на сервер
                    outputSocketStream.println(num2);//Отправляем второе число на сервер
                    outputSocketStream.println();

                    String line = inputSocketStream.readLine(); //Сервер отвечает и тут мы считываем ответ
                    if (line != null) {
                        return Double.parseDouble(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new Exception("Ошибка!");
    }
}
