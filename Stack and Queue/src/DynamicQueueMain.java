public class DynamicQueueMain {
    public static void main(String[] args) throws CustomQueueException{
        DynamicQueue queue = new DynamicQueue(5);
        //Adding elements
        queue.insert(56);
        queue.insert(26);
        queue.insert(76);
        queue.insert(46);
        queue.insert(66);
        queue.printQueue();
        System.out.println("Removed: "+queue.remove());
        queue.printQueue();
        queue.insert(16);
        queue.insert(79); queue.printQueue();
        System.out.println("Removed: "+queue.remove());
        queue.printQueue();
        queue.insert(99); queue.printQueue();
    }
}
