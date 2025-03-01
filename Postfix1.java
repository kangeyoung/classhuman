package feb27;

import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix1 {
    String a;
    Stack<String> stack = new Stack<>();
    StringBuilder postfix = new StringBuilder();

    public Postfix1(String input) {
        this.a = input;
        StringTokenizer st = new StringTokenizer(a, "+-*/()", true);
        int cnt = st.countTokens();
        String[] infix = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            infix[i] = st.nextToken();
        }
        for (int i = 0; i < cnt; i++) {
            String token = infix[i];
            postStack(token);
        }
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if(!pop.equals("(")) {
                postfix.append(pop);
            }
        }
        System.out.println("postfix: " + postfix);
        String postfixS = String.valueOf(postfix);
        new Calculator(postfixS);
    }

    public void postStack(String infix) {
        int in = prior(infix);
        if (in != -1) {
            switch (in) {
                case 1:
                case 2:
                case 3:
                    while (!stack.isEmpty() && (prior(stack.peek()) <= in)) {
                        String pop = stack.pop();
                        if (!pop.equals("(")) {
                            postfix.append(pop);
                        }
                    }
                case 4:
                    if (in != 3) {
                        stack.push(infix);
                    }
                default:
                    break;
            }
        } else {
            postfix.append(infix);
            postfix.append("'");
        }
    }

    public int prior(String infix) {
        switch (infix) {
            case "*":
            case "/":
                return 1;
            case "+":
            case "-":
                return 2;
            case ")":
                return 3;
            case "(":
                return 4;
            default:
                return -1;
        }
    }
}
