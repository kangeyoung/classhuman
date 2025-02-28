package feb28.Calculator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {
    String a;

    public Postfix(String input) {
        this.a = input;
        StringTokenizer st = new StringTokenizer(a, "+-*/()", true);
        int cnt = st.countTokens();
        String[] infix = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            infix[i] = st.nextToken();
        }
        Stack stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            if (infix[i].equals("(")) {
                stack.push(infix[i]);
            } else if (infix[i].equals("*") || infix[i].equals("/")) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals("*") || stack.peek().equals("/")) {
                        while (!stack.isEmpty() && !(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("("))) {
                            postfix.append(stack.pop());
                        }
                    }
                }
                stack.push(infix[i]);
            } else if (infix[i].equals("+") || infix[i].equals("-")) {
                if (!stack.isEmpty()) {
                    if (!stack.peek().equals("(")) {
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            postfix.append(stack.pop());
                        }
                    }
                }
                stack.push(infix[i]);
            } else if (infix[i].equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfix.append(stack.pop());
                }
                stack.pop();

            } else {
                postfix.append("'");
                postfix.append(infix[i]);
                postfix.append("'");
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        System.out.println("postfix: " + postfix);
        String postfixS = String.valueOf(postfix);
        new Calculator(postfixS);
    }

}
