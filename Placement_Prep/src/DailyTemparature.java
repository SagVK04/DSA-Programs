import java.util.*;

public class DailyTemparature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        String buf_input = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] buf_arr = buf_input.split(",");
        int[] temp = new int[buf_arr.length];
        for(int i=0;i< buf_arr.length;i++)
            temp[i] = Integer.parseInt(buf_arr[i]);
        System.out.println("Output: ");
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
    public static int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        Stack<Integer> store = new Stack<>();
        for(int i=0;i<temp.length;i++){
            while(!store.empty() && temp[store.peek()] < temp[i]){
                int index = store.pop();
                res[index] = i - index;
            }
            store.push(i);
        }
        return res;
    }
}
