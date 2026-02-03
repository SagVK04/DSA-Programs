import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> prev_nums = new Stack<>();
        Stack<StringBuilder> prev_string = new Stack<>();
        int num=0; StringBuilder curr = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)) num = (num*10) + (ch-'0');
            else if(ch == '['){
                prev_nums.push(num); prev_string.push(curr);
                curr = new StringBuilder(); num = 0;
            }
            else if(ch == ']'){
                StringBuilder prev = prev_string.pop();
                int repeat = prev_nums.pop();
                for(int i=0; i<repeat; i++)
                    prev.append(curr);
                curr = prev;
            }
            else
                curr.append(ch);
        }
        return curr.toString();
    }
}
