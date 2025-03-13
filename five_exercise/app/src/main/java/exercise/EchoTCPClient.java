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
        Socket clientSideSocket = new Socket("192.168.1.1", 3400);
        PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);
        BufferedReader fromNetwork = new BufferedReader(new
                InputStreamReader(clientSideSocket.getInputStream()));
        toNetwork.println("Conexion encontrada, enviando mensaje desde el servidor");
        String fromServer = fromNetwork.readLine();
        System.out.println("[Client] From server: " + fromServer);
        clientSideSocket.close();
    }
}
