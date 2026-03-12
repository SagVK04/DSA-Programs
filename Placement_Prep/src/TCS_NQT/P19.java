package TCS_NQT;

import java.util.Scanner;

public class P19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String bufferinput = sc.nextLine().trim();
        String[] buf_array = bufferinput.split(" ");
        int[] nums = new int[buf_array.length];
        for(int i=0;i<buf_array.length;i++)
            nums[i] = Integer.parseInt(buf_array[i]);
        System.out.println("Output: ");
        System.out.println(findEqualIndex(nums));
    }
    public static int findEqualIndex(int[] nums){
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int[] preSum = new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        for(int i=0;i<nums.length;i++){
            int left=0;
            if(i>0) left = preSum[i-1];
            int right = preSum[nums.length-1]-preSum[i];
            if(right == left) return i;
        }
        return -1;
    }
}
