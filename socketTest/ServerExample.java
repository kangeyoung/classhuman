package socketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public static void main(String[] args) {
        int serverPort = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                OutputStream outputStream = clientSocket.getOutputStream();
                InputStream inputStream = clientSocket.getInputStream();
                byte[] buffer = new byte[1024];
                int byteRead = inputStream.read(buffer);
                String received = new String(buffer, 0, byteRead);
                String message = "Hello Client";

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
