package thirteen;

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
    String auxiliary = JOptionPane.showInputDialog("Ingresa un número entre 2 y 30");
    while (verificationNUmber(Integer.parseInt(auxiliary)) != true) {
      auxiliary = "";
      auxiliary = JOptionPane.showInputDialog("Ingresa un número entre 2 y 30");
    }
    return auxiliary;

  }

  public static boolean verificationNUmber(int number) {
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
