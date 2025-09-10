import java.util.Arrays;

public class EditDistance {
    public int minDistance(String s1, String s2) {
        int n = s1.length(); int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        return f_count1(s1,s2,n-1,m-1,dp);
    }
    public int f_count1(String s1, String s2, int i, int j, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1)
            return dp[i][j];

        //if characters are matched
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = f_count1(s1,s2,i-1,j-1,dp);

        //if not matched
        int delete = f_count1(s1,s2,i-1,j,dp);
        int insert = f_count1(s1,s2,i,j-1,dp);
        int replace = f_count1(s1,s2,i-1,j-1,dp);

        return dp[i][j] = 1 + Math.min(delete,Math.min(insert,replace));
    }
    public int f_count2(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int j=0; j<=m; j++)
            dp[0][j] = j;
        for(int i=0; i<=n; i++)
            dp[i][0] = i;
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=m; j++){
                //if characters are matched
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    //if not matched
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(delete,Math.min(insert,replace));
                }
            }
        }
        return dp[n][m];
    }
    public int f_count3(String s1, String s2, int n, int m){
        int[] prev = new int[m+1];
        for(int j=0; j<=m; j++)
            prev[j] = j;

        for(int i = 1; i<=n; i++){
            int[] cur = new int[m+1];
            cur[0] = i;
            for(int j=1; j<=m; j++){
                //if characters are matched
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    cur[j] = prev[j-1];
                else{
                    //if not matched
                    int delete = prev[j];
                    int insert = cur[j-1];
                    int replace = prev[j-1];
                    cur[j] = 1 + Math.min(delete,Math.min(insert,replace));
                }
            }
            prev = cur;
        }
        return prev[m];
    }
    //Can't be space optimised into 1-D Array Space Optimisation as cur has to read its own previous state
    //i.e. for any j -> cur[j] has to access insert = cur[j-1], hence both prev and cur are required
}
