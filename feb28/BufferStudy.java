package feb28;

import java.io.*;


public class BufferStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("문자열입력");
        bw.flush();
        String s = br.readLine();
        bw.write("숫자입력");
        bw.flush();
        int i = Integer.parseInt(br.readLine());
        bw.write(s+"\n");
        bw.write(String.valueOf(i));
        bw.flush();
        bw.close();
    }
}
