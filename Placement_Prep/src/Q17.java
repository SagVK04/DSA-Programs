import java.util.*;
public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine().trim();
        input1 = input1.replaceAll("\\[|\\]","");
        String[] input_array = input1.split(",");
        int[] nums = new int[input_array.length];
        for(int i=0;i<input_array.length;i++)
            nums[i] = Integer.parseInt(input_array[i].trim());

        String input2 = sc.nextLine().trim();
        int k=Integer.parseInt(input2);

        int[] res = new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++) {
            res[i] = findMax(nums,i,i+k-1);
        }
        System.out.println(Arrays.toString(res));
    }
    public static int findMax(int[] nums,int lb,int ub){
        int max=nums[lb];
        for(int i=lb;i<=ub;i++)
            max = Math.max(max,nums[i]);
        return max;
    }
}
