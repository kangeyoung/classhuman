package chat;

import lombok.Getter;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Handler extends Thread {
    private Handler handler = null;
    private Socket socket = null;
    private InetSocketAddress socketAddress = null;
    private BufferedReader input;
    private PrintWriter output;
    private int delNum = 0;
    @Getter
    private int num = 0;

    public Handler(Socket socket, InetSocketAddress isa, int num) {
        this.socket = socket;
        this.socketAddress = isa;
        this.num = num;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        prt("채팅시작");
        while (true) {
            try {
                String line = input.readLine();
                if (line.equals("quit")) {
                    if (handler != null) {
                        handler.prt("상대방의 채팅종료");
                        prt("채팅종료");
                    }
                    ServerV3.delete(delNum);
                    break;
                }
                handler.prt(line);
                prt(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            System.out.println("자원 닫기- Handler");
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void prt(String s) {
        output.println(s);
        output.flush();
    }

    public void set(Handler handler, int delNum) {
        this.handler = handler;
        this.delNum = delNum;
    }
}
