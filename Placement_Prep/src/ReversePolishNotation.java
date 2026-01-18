import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = st.pop(); int a = st.pop();
                st.push(findResult(a,b,token));
            }
            else
                st.push(Integer.parseInt(token));
        }
        return st.peek();
    }
    public int findResult(int a, int b, String op){
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
