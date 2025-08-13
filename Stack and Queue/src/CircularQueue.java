import java.util.ArrayList;

public class CircularQueue {
    protected int[] queue;
    private static final int DEFAULT_SIZE=Integer.MAX_VALUE;
    int end=0; int front=0; int size=0;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size){
        queue = new int[size];
    }
    boolean isFull(){
        return size==queue.length;
    }
    boolean isEmpty(){
        return size==0;
    }
    public boolean insert(int item){
        if(isFull()) {
            System.out.println("Queue is full! "+item+" can't be inserted");
            return false;
        }
        queue[end]=item; //Increment end and size
        end=(end+1)%queue.length; size++;
        return true;
    }
    public int remove() throws CustomQueueException{
        if(isEmpty())
            throw new CustomQueueException("Queue is empty!");
        int removed = queue[front];
        //Increment front and size
        front=(front+1)%queue.length; size--;
        return removed;
    }
    public int peek() throws CustomQueueException{
        if(isEmpty())
            throw new CustomQueueException("Queue is empty!!");
        return queue[front];
    }
    public void printQueue() throws CustomQueueException{
        if(isEmpty())
            throw new CustomQueueException("Queue is empty! Nothing to display");
        ArrayList<Integer> res= new ArrayList<>();
        int ptr=front; int count=0;
        do{
            res.add(queue[ptr]);
            ptr=(ptr+1)%queue.length;
        }while (ptr!=end);
        System.out.println("Queue is: "+res);
    }
}
