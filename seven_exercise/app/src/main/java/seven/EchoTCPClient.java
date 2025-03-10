package seven;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoTCPClient {
    public static void main(String[] args) throws IOException {
        Socket clientSideSocket = new Socket("localhost", 3400);
        PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);
        BufferedReader fromNetwork = new BufferedReader(new
                InputStreamReader(clientSideSocket.getInputStream()));
        Scanner scanerBacano=new Scanner(System.in);
        System.out.print("Ingrese cualquier cosa");
        String cualquierCosa=scanerBacano.nextLine();
        toNetwork.println(cualquierCosa);
        String fromServer = fromNetwork.readLine();
        System.out.println("[Client] From server: " + fromServer);
        clientSideSocket.close();
    }
}
