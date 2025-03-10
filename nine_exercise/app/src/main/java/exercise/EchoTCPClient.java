package exercise;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoTCPClient {
    public static void main(String[] args)  {
        try
        {
            Socket clientSideSocket = new Socket("localhost", 3400);
            Scanner scanerBacano=new Scanner(System.in);
            PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);
            BufferedReader fromNetwork = new BufferedReader(new
                    InputStreamReader(clientSideSocket.getInputStream()));
            System.out.print("Ingrese cualquier cosa");
            String cualquierCosa=scanerBacano.nextLine();
            boolean centinela=true;
            while(centinela)
            {
                String mensajeApoyo=scanerBacano.nextLine();
                if(mensajeApoyo.isEmpty())
                {
                    centinela=false;
                }
                cualquierCosa+="\n"+mensajeApoyo;
            }
            toNetwork.println(cualquierCosa);
            String fromServer = fromNetwork.readLine();
            System.out.println("[Client] From server: " + fromServer);
            scanerBacano.close();
            clientSideSocket.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
