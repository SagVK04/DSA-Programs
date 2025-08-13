import java.util.Arrays;

public class Jumpfrog {
    public static void main(String[] args) {
        int n=4; int[] heights = {10,20,30,10};
        //Max Stairs = n-1
        System.out.println("Min energy required: "+jumpFrog(n-1,heights)+" Unit(s)");
    }
    private static int jumpFrog(int n, int[] heights){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        //return min_energy(n,heights,dp);
        return min_energy_1(n,heights);
    }
    private static int min_energy(int n, int[] heights, int[] dp){
        if(n == 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        int left = min_energy(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]); //Skipping one step
        int right = Integer.MAX_VALUE;
        if(n>=2)
            right = min_energy(n-2,heights,dp) + Math.abs(heights[n]-heights[n-2]); //Skipping 2 steps
        dp[n] = Math.min(left,right);
        return dp[n];
    }
    private static int min_energy_1(int n, int[] heights){
        int prev = 0;
        int prev_prev = 0;
        int first = 0; int second = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            first = prev + Math.abs(heights[i] - heights[i-1]);
            if (i>1)
                second = prev_prev + Math.abs(heights[i] - heights[i-2]);
            prev_prev = prev; prev = Math.min(first,second);
        }
        return prev;
    }
}
