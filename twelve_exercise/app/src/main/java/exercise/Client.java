package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

import javax.swing.JOptionPane;

public class Client {

  public static void main(String[] args) throws IOException {

    Socket clientSideSocket = new Socket("localhost", 3400);

    PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);

    BufferedReader fromNetwork = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

    toNetwork.println(generateStringBits() + ":" + inputNumber());

    String fromServer = fromNetwork.readLine();

    System.out.println("[Client] From server: " + fromServer);

    clientSideSocket.close();

  }

  public static String inputNumber() {
    String auxiliarity = JOptionPane.showInputDialog("Ingrese un número entre 2 y 30");
    while (verificationNumber(Integer.parseInt(auxiliarity)) != true) {
      auxiliarity = "";
      auxiliarity = JOptionPane.showInputDialog("Ingrese un número entre 2 y 30");
    }
    return auxiliarity;
  }

  public static boolean verificationNumber(int number) {
    if (number >= 2 && number <= 30) {
      return true;
    } else {
      return false;
    }
  }

  public static String generateStringBits() {
    String auxiliary = "";
    Random random = new Random();
    for (int i = 1; i <= 32; i += 1) {
      auxiliary = auxiliary + random.nextInt(0, 2);
    }
    return auxiliary;
  }
}
