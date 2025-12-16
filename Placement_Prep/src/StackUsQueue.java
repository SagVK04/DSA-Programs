import java.util.LinkedList;
import java.util.Queue;

public class StackUsQueue {
    private Queue<Integer> Q1;
    public StackUsQueue() {
        Q1 = new LinkedList<>();
    }

    public void push(int x) {
        Q1.offer(x);
        for(int i=0; i<Q1.size()-1; i++)
            Q1.offer(pop());
    }

    public int pop() {
        return Q1.poll();
    }

    public int top() {
        return Q1.peek();
    }

    public boolean empty() {
        return Q1.isEmpty();
    }
}
/**
 * Your StackUsQueue object will be instantiated and called as such:
 * StackUsQueue obj = new StackUsQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */