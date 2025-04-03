package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerV3 {
    private List<Handler> adminList = new ArrayList<>(3);
    private List<Handler> memList = new ArrayList<>();
    private String chatLine;
    private int num;
    static Handler[][] chat = new Handler[3][2];
    static volatile boolean flag = true;
    static Match match;

    public static void main(String[] args) {
        ServerV3 server = new ServerV3();
    }

    public ServerV3() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            match = new Match();
            match.start();
            while (true) {
                System.out.println("연결대기");
                Socket socket = serverSocket.accept();
                InetSocketAddress address = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결완료-> " + address.getAddress());
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                chatLine = input.readLine();
                output.println(chatLine);
                output.flush();
                num = Integer.parseInt(chatLine);
                Handler handler = new Handler(socket, address, num);

                switch (num) {
                    case 0:
                    case 1:
                    case 2:
                        memList.add(handler);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        adminList.add(handler);
                        break;
                    default:
                        break;
                }
                flag = true;
                System.out.println("flag- "+flag);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void delete(int delNum) {
        System.out.println("채팅방 초기화");
        chat[delNum][0] = null;
        chat[delNum][1] = null;
        flag = true;

    }

    private class Match extends Thread {
        boolean flag2 = true;

        @Override
        public void run() {
            while (true) {

                while (flag) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    flag2 = true;
                    int index = isEmpty();
                    if (index > -1) {
                        if (!adminList.isEmpty() && !memList.isEmpty()) {
                            for (Handler h : adminList) {
                                for (Handler h2 : memList) {
                                    if (h.getNum() - 3 == h2.getNum()) {
                                        chat[index][0] = h;
                                        chat[index][1] = h2;
                                        adminList.remove(h);
                                        memList.remove(h2);
                                        chat[index][0].set(chat[index][1], index);
                                        chat[index][1].set(chat[index][0], index);
                                        chat[index][0].start();
                                        chat[index][1].start();
                                        flag = false;
                                        flag2 = false;
                                        break;
                                    }
                                }
                                if (!flag2) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        }

        private int isEmpty() {
            for (int i = 0; i < 3; i++) {
                if (chat[i][0] == null || chat[i][1] == null) {
//                    System.out.println("i- "+i);
                    return i;
                }
            }
            return -1;
        }
    }
}
