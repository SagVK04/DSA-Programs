import java.util.Arrays;

public class MaxSumNonAdjacent {
    public static void main(String[] args) {
        int[] nums = {2,1,4,9};
        System.out.println("Max Sum with non adjacent elements: ");
        System.out.println(findMaxSum(nums));
    }
    public static int findMaxSum(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        //Arrays.fill(dp,-1);
        //Recursion
        //return f1(nums,n-1);
        //Memoization
        //return f2(nums,n-1,dp);
        //Tabulation
        //return f3(nums,dp);
        //Space Optimisation
        return f4(nums);
    }
    public static int f1(int[] nums,int ind){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        int pick = nums[ind]+f1(nums,ind-2);
        int notPick = f1(nums,ind-1);
        return Math.max(pick,notPick);
    }
    public static int f2(int[] nums,int ind,int[] dp){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = nums[ind]+f1(nums,ind-2);
        int notPick = f1(nums,ind-1);
        return dp[ind] = Math.max(pick,notPick);
    }
    public static int f3(int[] nums,int[] dp){
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            int pick = nums[i];
            if(i>1) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length-1];
    }
    public static int f4(int[] nums){
        int prev1 = nums[0]; int prev2 = 0;
        for(int i=1;i< nums.length;i++){
            int pick = nums[i];
            if(i>1) pick += prev2;
            int notPick = prev1;
            int cur_i = Math.max(pick,notPick);
            prev2 = prev1; prev1 = cur_i;
        }
        return prev1;
    }
}
