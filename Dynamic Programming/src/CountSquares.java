public class CountSquares {
    public static void main(String[] args) {
        int[][] grid = {
                        {1,1,0},
                        {1,1,1},
                        {1,1,0}
                    };
        System.out.println("No. of square matrices: "+countMatrices(grid));
    }
    private static int countMatrices(int[][] grid){
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n][m];
        return f_mat(grid,dp,n,m);
    }

    private static int f_mat(int[][] grid, int[][] dp, int n, int m) {
        for(int j=0;j<m;j++)    dp[0][j] = grid[0][j];
        for(int i=0;i<n;i++)    dp[i][0] = grid[i][0];
        int sum = 0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j] == 0) dp[i][j] = 0;
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
