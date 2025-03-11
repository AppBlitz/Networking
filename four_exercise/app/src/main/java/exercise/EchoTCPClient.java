package exercise;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoTCPClient {
    public static void main(String[] args) throws IOException {
        Socket clientSideSocket = new Socket("192.168.56.1", 3400);
        PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);
        BufferedReader fromNetwork = new BufferedReader(new
                InputStreamReader(clientSideSocket.getInputStream()));
        System.out.println("La direccion Ip del cliente es"+clientSideSocket.getInetAddress().getHostAddress());
        System.out.print("El puerto local del cliente es "+clientSideSocket.getLocalPort());
        System.out.print("El puerto del cliente es "+clientSideSocket.getPort());
        toNetwork.println("Mensaje enviado desde el servidor");
        String fromServer = fromNetwork.readLine();
        System.out.println("[Client] From server: " + fromServer);
        clientSideSocket.close();
    }
}
