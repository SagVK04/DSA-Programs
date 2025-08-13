import java.util.Arrays;
public class CustomStackMain {
    public static void main(String[] args) throws CustomStackException{
        CustomStack stack = new DynamicStack(15);
        //Adding elements
        stack.push(56);
        stack.push(26);
        stack.push(76);
        stack.push(46);
        stack.push(66);
        stack.printStack();
        //Removing elements
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
        System.out.println("Removed item: "+stack.pop());
    }
}
