import java.util.Stack;

public class leetcode84 {
    public static void main(String[] args) {
        int[] heights={3,2,10,11,5,10,6,3};
        System.out.println("Maximum area in the histogram is: "+largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int element=stack.pop();
                int nse=i; int pse= stack.isEmpty()? -1:stack.peek();
                maxArea = max(maxArea,heights[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.empty()){
            int element=stack.pop();
            int nse=heights.length; int pse=stack.isEmpty()? -1:stack.peek();
            maxArea=max(maxArea,heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
    public static int max(int a,int b){
        if(a > b)
            return a;
        else
            return b;
    }
}
