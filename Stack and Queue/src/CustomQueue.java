import java.util.ArrayList;

public class CustomQueue {
    protected int[] queue;
    private static final int DEFAULT_SIZE=Integer.MAX_VALUE;
    int end=0;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        queue = new int[size];
    }
    boolean isFull(){
        return end==queue.length;
    }
    boolean isEmpty(){
        return end==0;
    }
    public boolean insert(int item){
        if(isFull())
            return false;
        queue[end++]=item;
        return true;
    }
    public int remove() throws CustomQueueException{
        if(isEmpty())
            throw new CustomQueueException("Queue is empty!");
        int removed = queue[0];
        //Shift the elements to left
        for(int i=1;i<queue.length;i++)
            queue[i-1]=queue[i];
        end--;
        return removed;
    }
    public void printQueue(){
        int top=0;
        ArrayList<Integer> res= new ArrayList<>();
        while(top!=end){
            res.add(queue[top]);
            top++;
        }
        System.out.println("Queue is: "+res);
    }
    public int peek() throws CustomQueueException{
        if(isEmpty())
            throw new CustomQueueException("Queue is empty!!");
        return queue[0];
    }
}
