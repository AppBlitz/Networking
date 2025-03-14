package exercise;

public class App {

    public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(3400);
            System.out.println("The Echo TCP server is running on port 3400 ...");
            System.out.println("The server is waiting for a client.");
            Socket serverSideSocket = listener.accept();
            System.out.println("A client has connected");
            BufferedReader fromNetwork = new BufferedReader(new InputStreamReader(serverSideSocket.getInputStream()));
            PrintWriter toNetwork = new PrintWriter(serverSideSocket.getOutputStream(), true);
            String message = fromNetwork.readLine();
            System.out.println("[Server] From client: " + message);
            String answer = message;
            toNetwork.println(answer);
            serverSideSocket.close();
            listener.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
