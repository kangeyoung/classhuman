package feb18;

import java.util.Arrays;
import java.util.Scanner;

public class Feb18 {
    Feb18() {
        // 생성자- 클래스를 객체로 생성할 때, 처음 호출하는 메서드. 리턴이 없다.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // new 객체를 만든다 Scanner 생성자
        int[] a = {1,2,3};
        int[] b = a;
//        int[] c = {1,2,3};
        b[0] = 4;
        System.out.println(a);
        System.out.println(b);
//        System.out.println(c);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.toString(c));


        String c = "apple";
        String d = c;
        boolean e = c==d;
        System.out.println(e);
        d.replace(".","banana");

        e = c==d;
        System.out.println(e);
        System.out.println(c);
        System.out.println(d);






    }
}