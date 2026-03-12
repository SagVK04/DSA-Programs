package TCS_NQT;

import java.util.HashMap;
import java.util.Scanner;

public class P23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nums = ");
        String input = sc.nextLine().trim();
        input = input.replaceAll("\\[|\\]","");
        String[] input_str = input.split(",");
        int[] nums = new int[input_str.length];
        for(int i=0;i<input_str.length;i++)
            nums[i] = Integer.parseInt(input_str[i]);

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        System.out.println("Output = ");
        System.out.println(subarraySum2(nums));
    }
    public static int subarraySum2(int[] nums) {
        int preSum=0;
        HashMap<Integer,Integer> map = new HashMap<>(); map.put(0,-1); int maxlen=0;
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            if(map.containsKey(preSum)) {
                int len = i - map.get(preSum);
                maxlen = Math.max(maxlen,len);
            }
            else map.put(preSum,i);
        }
        return maxlen;
    }
}
