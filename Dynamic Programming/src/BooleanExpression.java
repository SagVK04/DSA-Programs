import java.util.Arrays;

public class BooleanExpression {
    public static int mod = 1000000007;
    public static void main(String[] args) {
        String exp = "T|T&F";
        System.out.println("No. of ways it can be evaluated true: "+countWays(exp));
    }
    private static int countWays(String exp){
        int n = exp.length();
        int[][][] dp = new int[n][n][2];
        for(int[][] a: dp){
            for(int[] b: a)
                Arrays.fill(b,-1);
        }
        return bool_f(0,n-1,exp,1,dp);
    }
    private static int bool_f(int i,int j,String exp,int isTrue,int[][][] dp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1) return exp.charAt(i)=='T'? 1:0;
            else return exp.charAt(i)=='F'? 1:0;
        }
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ways = 0;
        for(int ind=i+1;ind<=j-1;ind=ind+2){
            int lt = bool_f(i,ind-1,exp,1,dp);
            int lf = bool_f(i,ind-1,exp,0,dp);
            int rt = bool_f(ind+1,j,exp,1,dp);
            int rf = bool_f(ind+1,j,exp,0,dp);

            if(exp.charAt(ind) == '&'){
                if(isTrue == 1)
                    ways = (ways + ((lt*rt)%mod)) % mod;
                else
                    ways = (ways + ((lf*rf)%mod) + ((lt*rf)%mod) + ((lf*rt)%mod)) % mod;
            }

            else if(exp.charAt(ind) == '|'){
                if(isTrue == 1)
                    ways = (ways + ((lt*rt)%mod) + ((lt*rf)%mod) + ((lf*rt)%mod)) % mod;
                else
                    ways = (ways + ((lf*rf)%mod)) % mod;
            }

            else if(exp.charAt(ind) == '^'){
                if(isTrue == 1)
                    ways = (ways + ((lt*rf)%mod) + ((lf*rt)%mod)) % mod;
                else
                    ways = (ways + ((lf*rf)%mod) + ((lt*rt)%mod)) % mod;
            }
        }

        return dp[i][j][isTrue] = ways;
    }
}
