import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int[] dim = {10,30,5,60};
        System.out.println("Min no. of multiplications: "+maxMultiply(dim,dim.length));
    }
    private static int maxMultiply(int[] dim, int n) {
        int[][] dp = new int[n+1][n];
        int[][] dp1 = new int[n+1][n+1];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        return f_1(dim,dp1);
    }
    private static int f(int[] dim, int i, int j, int[][] dp) {
        if(i == j)  return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        int min = 99999;
        for(int k=i;k<j;k++){
            int steps = dim[i-1]*dim[k]*dim[j] + f(dim,i,k,dp) + f(dim,k+1,j,dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }
    private static int f_1(int[] dim,int[][] dp) {
        int min = 99999;
        for(int i=dim.length; i>0; i--){
            for(int j=dim.length-1;j>=0; j--){
                for(int k=j-1;k>=i;k--){
                    int steps = dim[i-1]*dim[k]*dim[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                    dp[i][j] = min;
                }
            }
        }
        return dp[1][dim.length-1];
    }
}
