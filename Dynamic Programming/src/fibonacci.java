import java.util.Arrays;

public class fibonacci {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        //return findfib(n,dp);
        //return findfib1(n,dp);
        return findfib2(n);
    }
    private static int findfib(int n, int[] dp){
        if(n<=1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        dp[n] = findfib(n-1,dp)+findfib(n-2,dp);
        return dp[n];
        //Time Complexity: O(n), Space Complexity: O(n)+O(n) [dp array + recursion stack-space]
    }
    private static int findfib1(int n, int[] dp){
        dp[0] = 0; dp[1] = 1;
        for(int i=2;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
        //Time Complexity: O(n), Space Complexity: O(n) [only dp array, no recursion]
    }
    private static int findfib2(int n){
        int prev = 1; int prev_prev = 0; int ans = 0;
        for(int i=2;i<=n;i++){
            ans = prev + prev_prev;
            prev_prev = prev;
            prev = ans;
        }
        return ans;
        //Time Complexity: O(n), Space Complexity: Constant [no dp array, no recursion]
    }
}
