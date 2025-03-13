package exercise;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class EchoTCPClient {
    public static void main(String[] args)  {
        try
        {
            Socket clientSideSocket = new Socket("localhost", 3400);
            Scanner scanerBacano=new Scanner(new File("ten_exercise/app/src/main/java/exercise/ArchivoBacano"));
            PrintWriter toNetwork = new PrintWriter(clientSideSocket.getOutputStream(), true);
            BufferedReader fromNetwork = new BufferedReader(new
                    InputStreamReader(clientSideSocket.getInputStream()));
            ArrayList<String> cualquierCosa=new ArrayList<>();
            while(scanerBacano.hasNextLine())
            {
                cualquierCosa.add(scanerBacano.nextLine());
            }
            toNetwork.println(cualquierCosa.toString());
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
