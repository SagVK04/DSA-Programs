public class CircularQueueMain {
    public static void main(String[] args) throws CustomQueueException{
        CircularQueue queue = new CircularQueue(5);
        //Adding elements
        queue.insert(56);
        queue.insert(26);
        queue.insert(76);
        queue.insert(46);
        queue.insert(66);
        queue.printQueue();
        System.out.println("Removed item is: "+queue.remove()); queue.printQueue();
        queue.insert(16); queue.printQueue();
        queue.insert(79);
        queue.remove();
        queue.printQueue();
        queue.insert(79);
        queue.printQueue();
    }
}
