import java.util.Stack;

public class DailyTemparature {
    public int[] dailyTemp(int[] temp) {
        int[] res = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temp.length;i++){
            while(!st.isEmpty() && temp[st.peek()]<temp[i])
                res[st.peek()] = i - st.pop();
            st.push(i);
        }
        return res;
    }
}
