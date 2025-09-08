import java.util.Arrays;

public class ShortestCommonSuperSeq {
    public static void main(String[] args) {
        String s1 = "brute"; String s2 = "groot";
        String res = findShortestSuperSeq(s1,s2,s1.length(),s2.length());
        System.out.println("Shortest Common Super sequence: "+res);
        System.out.println("Length is: "+res.length());
    }

    private static String findShortestSuperSeq(String s1, String s2, int n, int m) {
        StringBuilder ans = new StringBuilder(); int[][] dp = new int[n+1][n+1];
        for(int i2=0;i2<=m;i2++)    dp[0][i2] = 0;
        for(int i1=0;i1<=n;i1++)    dp[i1][0] = 0;
        for(int i1=1;i1<=n;i1++){
            for(int i2=1;i2<=m;i2++){
                if(s1.charAt(i1-1) == s2.charAt(i2-1)) //index element matched
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else //index element not matched
                    dp[i1][i2] = Math.max(dp[i1][i2-1] , dp[i1-1][i2]);

            }
        }
        for(int[] a: dp){
            System.out.println(Arrays.toString(a));
        }

        int i=n; int j=m;
        while(i>0 && j>0){
            //If index matches
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--; j--;
            }
            //moving upwards if indexes not matched
            else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(s1.charAt(i-1));
                i--;
            }
            //moving left if otherwise
            else if(dp[i][j-1] >= dp[i-1][j]){
                ans.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i>0) {
            ans.append(s1.charAt(i-1)); i--;
        }
        while(j>0){
            ans.append(s2.charAt(j-1)); j--;
        }
        return ans.reverse().toString();
    }
}
