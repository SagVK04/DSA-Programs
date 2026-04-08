import java.util.*;
public class FrogJump {
    public static void main(String[] args) {
        int[] nums = {30,10,60,10,60,50};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        System.out.println("Min cost to reach end: "
                +findMinEnergy3(nums,nums.length));
    }
    public static int findMinEnergy1(int[] nums,int lastInd,int[] dp){
        if(lastInd == 0) return dp[lastInd]=0;
        if(dp[lastInd] != -1) return dp[lastInd];
        int jump_one = findMinEnergy1(nums,lastInd-1,dp)
                +Math.abs(nums[lastInd]-nums[lastInd-1]);
        int jump_two = Integer.MAX_VALUE;
        if(lastInd > 1) {
            jump_two = findMinEnergy1(nums, lastInd - 2,dp) +
                    Math.abs(nums[lastInd] - nums[lastInd - 2]);
        }
        dp[lastInd] = Math.min(jump_one,jump_two);
        return dp[lastInd];
    }
    public static int findMinEnergy2(int[] nums,int lastInd,int[] dp){
        dp[0]=0;
        for(int i=1;i<lastInd;i++) {
            int jump_one = dp[i-1]
                    + Math.abs(nums[i] - nums[i-1]);
            int jump_two = Integer.MAX_VALUE;
            if (i > 1) {
                jump_two = dp[i-2]+
                        Math.abs(nums[i]-nums[i-2]);
            }
            dp[i] = Math.min(jump_one, jump_two);
        }
        return dp[lastInd-1];
    }
    public static int findMinEnergy3(int[] nums,int lastInd){
        int prev1=0; int prev2=0;
        for(int i=1;i<lastInd;i++) {
            int jump_one = prev1
                    + Math.abs(nums[i] - nums[i-1]);
            int jump_two = Integer.MAX_VALUE;
            if (i > 1) {
                jump_two = prev2+
                        Math.abs(nums[i]-nums[i-2]);
            }
            int cur_i = Math.min(jump_one, jump_two);
            prev2 = prev1; prev1 = cur_i;
        }
        return prev1;
    }
}
