import java.util.*;
public class CustomStack {
    protected int[] stack;
    private static final int DEFAULT_SIZE=Integer.MAX_VALUE;
    int ptr=-1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        stack = new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full!");
            return false;
        }
        else{
            ptr++;
            stack[ptr]=item;
        }
        return  true;
    }
    public void printStack(){
        int top=stack.length-1;
        ArrayList<Integer> res= new ArrayList<>();
        while(top!=-1){
            if(stack[top]!=0)
                res.add(stack[top]);
            top--;
        }
        System.out.println("Stack is: "+res);
    }
    public int pop() throws CustomStackException{
        if(isEmpty())
            throw  new CustomStackException("Stack is empty!");
        return stack[ptr--];
    }
    public int peek() throws CustomStackException{
        if(isEmpty())
                throw new CustomStackException("Stack is empty!!");
        return stack[ptr];
    }
    boolean isFull(){
        return ptr==stack.length-1;
    }
    boolean isEmpty(){
        return ptr==-1;
    }
}
