import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8089;
        ServerSocket serverSocket = new ServerSocket(port);
         try (Socket clientSocket = serverSocket.accept()){
             //Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

             System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

             final String name = in.readLine();
             out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

         } catch (IOException e) {
        System.err.println(e);
    }
    }
}
