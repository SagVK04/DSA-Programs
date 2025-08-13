import java.util.Stack;

public class leetcode20 {
    public static void main(String[] args) {
        String s = "[][";
        System.out.println(s+" is valid?: "+isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.equals(" "))
            return false;
        for(char ch: s.toCharArray()){
            if(stack.isEmpty())
                stack.push(ch);
            else {
                if (ch == '(' || ch == '{' || ch == '[')
                    stack.push(ch);
                if (ch == ')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }
                if (ch == '}') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                }
                if (ch == ']') {
                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return stack.empty();
    }
}
