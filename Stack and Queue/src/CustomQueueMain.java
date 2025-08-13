public class CustomQueueMain {
    public static void main(String[] args) throws CustomQueueException{
        CustomQueue queue = new CustomQueue(15);
        //Adding elements
        queue.insert(56);
        queue.insert(26);
        queue.insert(76);
        queue.insert(46);
        queue.insert(66);
        queue.printQueue();
        //Removing elements
        System.out.println("Front item: "+queue.peek());
        System.out.println("Removed item: "+queue.remove());
        queue.printQueue();
        System.out.println("Front item: "+queue.peek());
        System.out.println("Removed item: "+queue.remove());
        queue.printQueue();
        System.out.println("Front item: "+queue.peek());
        System.out.println("Removed item: "+queue.remove());
        queue.printQueue();
        System.out.println("Front item: "+queue.peek());
        System.out.println("Removed item: "+queue.remove());
        queue.printQueue();
        System.out.println("Front item: "+queue.peek());
        System.out.println("Removed item: "+queue.remove());
        queue.printQueue();
        System.out.println("Front item: "+queue.peek());
        System.out.println("Removed item: "+queue.remove());
        queue.printQueue();
    }
}
