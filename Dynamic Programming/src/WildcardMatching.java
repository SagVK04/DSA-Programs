import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        String s1 = "ab*cd"; String s2 = "abdefcd";
        System.out.println(isMatch1(s2,s1));
    }
    public static boolean isMatch(String s, String p) {
        int n = p.length(); int m = s.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        if (f_res(p,s,n,m,dp) == 1)
            return true;
        else
            return false;
    }
    public static boolean isMatch1(String s, String p) {
        int n = p.length(); int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];
        return f_res2(p,s,n,m);
    }
    public static int f_res(String s1, String s2, int i, int j, int[][] dp){
        if(i == 0 && j == 0) //both strings are matched
            return 1;
        if(i == 0 && j > 0) //s2 is still remaining
            return 0;
        //s1 is remaining
        if(j == 0 && i > 0){
            for(int t=1;t<=i;t++){
                if(s1.charAt(t-1) != '*')
                    return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
            return dp[i][j] = f_res(s1,s2,i-1,j-1,dp);
        if(s1.charAt(i-1) == '*')
            return dp[i][j] = (f_res(s1,s2,i-1,j,dp)==1
                    ||
                    f_res(s1,s2,i,j-1,dp)==1)? 1:0;
        return 0;
    }
    public static boolean f_res1(String s1, String s2, int n, int m, boolean[][] dp){
        //both strings are matched
        dp[0][0] = true;
        //s2 is still remaining
        for(int j=1;j<=m;j++)
            dp[0][j] = false;
        //s1 is still remaining
        for(int i=1;i<=n;i++){
            boolean flag = true;
            for(int t=1;t<=i;t++){
                if(s1.charAt(t-1) != '*')
                    flag = false;
            }
            dp[i][0] = flag;
        }
        for(int i=1; i<=n; i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                if(s1.charAt(i-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[n][m];
    }
    public static boolean f_res2(String s1, String s2, int n, int m){
        boolean[] prev = new boolean[m+1];
        //both strings are matched
        prev[0] = true;
        //s2 is still remaining
        for(int j=1;j<=m;j++)
            prev[j] = false;
        //s1 is still remaining
        for(int i=1; i<=n; i++){
            boolean[] cur = new boolean[m+1];
            boolean flag = true;
            for(int t=1;t<=i;t++){
                if(s1.charAt(t-1) != '*')
                    flag = false;
            }
            //for every row assigning 0-th column value
            cur[0] = flag;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
                    cur[j] = prev[j-1];
                if(s1.charAt(i-1) == '*')
                    cur[j] = prev[j] || cur[j-1];
            }
            prev = cur;
        }
        return prev[m];
    }
}
