import java.util.LinkedList;
import java.util.Queue;

public class queue1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //Adding elements
        queue.add(50);
        queue.add(20);
        queue.add(70);
        queue.add(40);
        queue.add(60);
        System.out.println("Queue is: "+queue);
        //Peeking & Removing elements
        System.out.println("Peek element: "+queue.peek());
        System.out.println("Removed item is: "+queue.remove());
        System.out.println("Peek element: "+queue.peek());
        System.out.println("Removed item is: "+queue.remove());
        System.out.println("Peek element: "+queue.peek());
        System.out.println("Removed item is: "+queue.remove());
        System.out.println("Peek element: "+queue.peek());
        System.out.println("Removed item is: "+queue.remove());
        System.out.println("Queue is: "+queue);
    }
}
