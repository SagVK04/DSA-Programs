import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for(int num: nums) total += num;
        if(total%2 != 0) return false; total /= 2;
        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        for(int num: nums){
            for(int i=total; i>=num; i--){
                if(dp[i-num]) dp[i] = true;
            }
        }
        return dp[total];
    }
}
