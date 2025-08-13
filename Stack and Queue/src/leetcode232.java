import java.util.Stack;
public class leetcode232 {
    public static void main(String[] args) throws CustomQueueException{
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(5);queue.push(2);queue.push(7);queue.push(4);queue.push(6);
        queue.printQueue();
        System.out.println("Removed: "+queue.pop());
        queue.printQueue();
        System.out.println("Removed: "+queue.pop());
        queue.printQueue();
        System.out.println("Removed: "+queue.pop());
        queue.printQueue();
        System.out.println("Removed: "+queue.pop());
        queue.printQueue();
        System.out.println("Removed: "+queue.pop());
        queue.printQueue();
        System.out.println("Front: "+queue.peek());
    }
}
class QueueUsingStack{
    private Stack<Integer> first;
    private Stack<Integer> second;
    public QueueUsingStack(){
        first = new Stack<>();
        second = new Stack<>();
    }
    public void push(int item){
        if(first.isEmpty())
            first.add(item);
        else{
            while(!first.isEmpty())
                second.push(first.pop());
            first.add(item);
            while (!second.isEmpty())
                first.push(second.pop());
        }
    }
    public int pop() throws CustomQueueException{
        if(first.isEmpty())
            throw new CustomQueueException("Queue is empty!!");
        return first.pop();
    }
    public int peek(){
        if(first.isEmpty())
            return -1;
        return first.peek();
    }
    public void printQueue(){
        System.out.println(first.reversed());
    }
}
