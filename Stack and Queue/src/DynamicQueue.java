public class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super();
    }
    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(isFull()){
            //Increase queue size
            int[] temp = new int[queue.length*2];
            for(int i=0;i<queue.length;i++)
                temp[i]=queue[(front+i)%queue.length];
            front=0; end=queue.length;
            queue=temp;
        }
        return super.insert(item);
    }
}
