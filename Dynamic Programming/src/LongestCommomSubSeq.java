import java.util.Arrays;

public class LongestCommomSubSeq {
    public static void main(String[] args) {
        String s1 = "acd"; String s2 = "ced";
        String res = findLongestSubSeq(s1,s2);
        System.out.println("Longest common subsequence: "+res);
        System.out.println("Length is: "+res.length());
    }

    private static String findLongestSubSeq(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return findLength3(s1, s2, s1.length(), s2.length());
    }

    private static String findLength3(String s1, String s2, int i1, int i2){
        int[] prev = new int[s2.length()+1]; int[] cur = new int[s2.length()+1];
        StringBuilder ans = new StringBuilder();
        for(int j=0;j<=i2;j++)
            prev[j] = 0;
        for(int i=1;i<=i1;i++){
            cur[i] = 0;
            for(int j=1;j<=i2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    ans.append(s1.charAt(i-1));
                    cur[j] = 1 + prev[j - 1];
                }
                else
                    cur[j] = Math.max(cur[j-1],prev[j]);
            }
            prev = cur;
        }
        return ans.toString();
    }

    private static int findLength2(String s1, String s2, int i1, int i2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=i1;i++)
            dp[i][0] = 0;
        for(int j=0;j<=i2;j++)
            dp[0][j] = 0;
        for(int i=1;i<=i1;i++){
            for(int j=1;j<=i2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[i1][i2];
    }

    private static int findLength1(String s1, String s2, int i1, int i2, int[][] dp){
        if(i1==0 || i2==0)
            return 0;

        if(dp[i1][i2] != -1)
            return dp[i1][i2];

        if(s1.charAt(i1-1) == s2.charAt(i2-1)) //matches both index
            return dp[i1][i2] = 1+findLength1(s1,s2,i1-1,i2-1,dp); //then check for previous indices

        return dp[i1][i2] = Math.max(findLength1(s1,s2,i1,i2-1,dp),findLength1(s1,s2,i1-1,i2,dp));
    }
}
