package feb28.Calculator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    String postfix;
    public Calculator(String postfix) {
        this.postfix = postfix;
        ArrayList<String> postfixList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(postfix, "'+-*/", true);
        int cnt = st.countTokens();
        for (int i = 0; i < cnt; i++) {
            String token = st.nextToken();
            if (!token.equals("'"))
                postfixList.add(token);
        }
        Stack stack = new Stack();
        for (int i = 0; i < postfixList.size(); i++) {
            String token = postfixList.get(i);
            if (token.equals("*")) {
                int num1 = Integer.parseInt((String) stack.pop());
                int num2 = Integer.parseInt((String) stack.pop());
                int sum = num2 * num1;
                stack.push(Integer.toString(sum));
//                System.out.println(num2+"*"+num1+"="+sum);
            } else if (token.equals("/")) {
                int num1 = Integer.parseInt((String) stack.pop());
                int num2 = Integer.parseInt((String) stack.pop());
                int sum = num2 / num1;
                stack.push(Integer.toString(sum));
//                System.out.println(num2+"/"+num1+"="+sum);
            } else if (token.equals("+")) {
                int num1 = Integer.parseInt((String) stack.pop());
                int num2 = Integer.parseInt((String) stack.pop());
                int sum = num2 + num1;
                stack.push(Integer.toString(sum));
//                System.out.println(num2+"+"+num1+"="+sum);
            } else if (token.equals("-")) {
                int num1 = Integer.parseInt((String) stack.pop());
                int num2 = Integer.parseInt((String) stack.pop());
                int sum = num2 - num1;
                stack.push(Integer.toString(sum));
//                System.out.println(num2+"-"+num1+"="+sum);
            } else{
                stack.push(token);
            }
        }
        System.out.println("계산결과= "+stack.pop());
    }
}
