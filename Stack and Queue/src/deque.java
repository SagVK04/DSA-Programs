import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class deque {
    public static void main(String[] args) {
        //Deque Implementation
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89); System.out.println(deque);
        deque.add(97); System.out.println(deque);
        deque.addLast(76); System.out.println(deque);
        deque.addFirst(47); System.out.println(deque);
        System.out.println("Removed item: "+deque.removeFirst());
        System.out.println(deque);
        System.out.println("Removed item: "+deque.removeLast());
        System.out.println(deque);
        System.out.println("Removed item: "+deque.remove());
        System.out.println(deque);
    }
}
