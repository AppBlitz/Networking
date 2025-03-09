package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
  public static void main(String[] args) throws IOException {

    String number = "";
    String amountDigits = "";
    String question = "";
    System.out.println("ingrese el número a pasar a hexadecimal");
    number = JOptionPane.showInputDialog("Ingrese el número a pasar de hexadecimal");
    amountDigits = JOptionPane.showInputDialog(("Ingrese la cantidad de digitos que quiere que tenga"));
    question = number + ":" + amountDigits;
    Socket clientSideSocket = new Socket("localhost", 3400);

    PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);

    BufferedReader fromNetwork = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

    toNetwork.println(question);

    String fromServer = fromNetwork.readLine();

    System.out.println("[Client] From server: " + fromServer);

    clientSideSocket.close();

  }
}
