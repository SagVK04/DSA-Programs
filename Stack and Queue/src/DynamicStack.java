public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
        //Checks whether stack is empty or not
        if(isFull()) {
            int[] temp = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i]; stack=temp;
            }
        }
        //pushes the item normally
        return super.push(item);
    }
}
