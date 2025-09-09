import java.util.*;
public class DistinctSubSeq {
    public static void main(String[] args) {
        String s1 = "rabbbit"; String s2 = "rabbit";
        System.out.println("No. of distinct subseq of "
                +s2+" in "+s1+
                " is: "+
                findSubseqNumber(s1,s2));
    }

    private static int findSubseqNumber(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return findNumber2(s1,s2,s1.length(),s2.length());
    }

    private static int findNumber(String s1, String s2, int i, int j,int[][] dp) {
        //string matching  is done
        if(j<0) return 1;

        //string matching is still needed
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        //if character matched
        if(s1.charAt(i) == s2.charAt(j)){
            //i. Take that and move backwards in both strings "babgbag" & "bag"

            //ii. Ignore that and find same character
            //in the remaining string in  backwards direction from which distinct
            //subsequences are to be found, only move in "babgbag"

            return dp[i][j] = findNumber(s1,s2,i-1,j-1,dp) + findNumber(s1,s2,i-1,j,dp);
            //We have to add both possibilities
        }
        //if character is not matched then we have to move backwards in both strings
        return dp[i][j] = findNumber(s1,s2,i-1,j,dp);
    }
    private static int findNumber1(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];

        for(int j=0; j<=m; j++)
            dp[0][j] = 0;

        for(int i=0; i<=n; i++)
            dp[i][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }
    private static int findNumber2(String s1, String s2, int n, int m){
        int[] prev = new int[m+1];

        prev[0] = 1;

        for(int i=1;i<=n;i++){
            int[] cur = new int[m+1];
            cur[0] = 1;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    cur[j] = prev[j-1] + prev[j];
                else
                    cur[j] = prev[j];
            }
            prev = cur;
        }
        return prev[m];
    }
}
