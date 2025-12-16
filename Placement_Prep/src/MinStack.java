import java.util.Stack;

class MinStack {
    private Stack<Integer> st;
    private int mini;
    public MinStack() {
        st = new Stack<>();
        mini = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            mini = val;
        }
        else if(val >= mini) st.push(val);
        else{
            st.push((2*val) - mini);
            mini = val;
        }
    }

    public void pop() {
        if(st.isEmpty()) return;
        int n = top(); st.pop();
        if(n < mini) mini = 2*mini - (n);
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
