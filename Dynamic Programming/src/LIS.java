import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("Length of LIS is: "+lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] a : dp)
            Arrays.fill(a,-1);
        return findLength4(nums,n);
    }
    public static int findLength1(int[] nums,int n,int ind,int prev_ind,int[][] dp){
        if(ind == n) return 0;
        if(dp[ind][prev_ind+1] != -1)
            return dp[ind][prev_ind+1];
        int notTake = findLength1(nums,n,ind+1,prev_ind,dp);
        int Take = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
            Take = 1 + findLength1(nums,n,ind+1,ind,dp);
        return dp[ind][prev_ind+1] = Math.max(notTake,Take);
    }
    public static int findLength2(int[] nums,int n){
        int[][] dp = new int[n+1][n+1];
        for(int ind = n-1;ind>=0;ind--){
            for(int prev = ind-1;prev>=-1;prev--){
                int notTake = dp[ind+1][prev+1];
                int Take = 0;
                if(prev == -1 || nums[ind] > nums[prev])
                    Take = 1 + dp[ind+1][ind+1];
                dp[ind][prev+1] = Math.max(notTake,Take);
            }
        }
        return dp[0][-1+1];
    }
    public static int findLength3(int[] nums,int n){
        int[] ahead = new int[n+1];
        for(int ind = n-1;ind>=0;ind--){
            int[] cur = new int[n+1];
            for(int prev = ind-1;prev>=-1;prev--){
                int notTake = ahead[prev+1];
                int Take = 0;
                if(prev == -1 || nums[ind] > nums[prev])
                    Take = 1 + ahead[ind+1];
                cur[prev+1] = Math.max(notTake,Take);
            }
            ahead = cur;
        }
        return ahead[0];
    }
    public static int findLength4(int[] nums,int n){
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int ind = 0;ind<n;ind++){
            for(int prev = 0;prev<ind;prev++){
                if(nums[prev] < nums[ind])
                    dp[ind] = Math.max(1+dp[prev],dp[ind]);
            }
            max = Math.max(max,dp[ind]);
        }
        return max;
    }
}
