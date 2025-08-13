import java.util.Stack;

public class stack1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //Adding elements
        stack.push(56);
        stack.push(26);
        stack.push(76);
        stack.push(46);
        stack.push(66);
        System.out.println("Stack: "+stack);
        //Removing elements
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Stack: "+stack);
    }
}
