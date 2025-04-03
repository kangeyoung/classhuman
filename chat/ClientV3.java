package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;


public class ClientV3 extends JFrame {


    public ClientV3(String id, int num) {
        Runnable ClientG = new ClientG(id, num);
        Thread t = new Thread(ClientG);
        t.start();
    }
}

class ClientG extends JFrame implements Runnable, ActionListener {
    private JTextArea output = new JTextArea();
    private JTextField input = new JTextField();
    private JButton send = new JButton("Send");
    private Socket socket;
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    private String id;
    private int num;


    public ClientG(String id, int num) {
        this.id = id;
        this.num = num;
        this.setTitle("Chatting- " + id);
        this.setBounds(100, 100, 300, 500);
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new BorderLayout());
        tfPanel.add("Center", input);
        tfPanel.add("East", send);

        this.add("Center", scroll);
        this.add("South", tfPanel);

        send.addActionListener(this);

        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing");
                if (socket != null) {
                    writer.println("quit");
                    writer.flush();
                    System.out.println("종료- 창닫기");
                    try {
                        writer.close();
                        reader.close();
                        socket.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == send) {
            if(!input.getText().isEmpty()) {
                writer.println(id + ":" + input.getText());
                writer.flush();
            }
            System.out.println("Send");
            input.setText("");
        }
    }


    @Override
    public void run() {
        try {
            socket = new Socket("localhost", 9000);
            System.out.println("연결성공");
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.println(num);
            writer.flush();
            System.out.println("Send");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println("Received: " + line);
            output.append(".... \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            while (!socket.isClosed()) {
                String line2 = reader.readLine();
                if (line2 != null) {
                    if (line2.equals("quit")) {
                        dispose();
                        break;
                    }
                    output.append(line2 + "\n");
                }
            }
        } catch (Exception e) {
            output.append("소켓 종료로 인한 종료");
        } finally {
            System.out.println("종료");
            try {
                writer.close();
                reader.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("자원 닫기 오류");
            }
        }
    }
}

