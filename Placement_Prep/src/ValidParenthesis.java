import java.util.*;

public class ValidParenthesis {
    public boolean isValid(String s) {
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
