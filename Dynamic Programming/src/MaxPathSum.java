import java.util.Arrays;

public class MaxPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,10,4},
                {100,3,2,1},
                {1,1,2000,2},
                {1,2,2,1}
        };
        System.out.println("Grid is: ");
        for (int[] a: grid)
            System.out.println(Arrays.toString(a));
        System.out.println("Max path cost in grid: "+maxanyPathSum(grid));
    }

    private static int maxanyPathSum(int[][] grid) {
        int rows = grid.length; int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        int max = 0;
        for(int j=0;j<cols;j++){
            int res = findmaxsum(grid,dp,rows-1,j);
            max = Math.max(max,res);
        }
        //return findmaxsum1(grid,dp);
        return findmaxsum2(grid);

    }

    private static int findmaxsum2(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        int[] prev = new int[m];
        for(int j=0;j<m;j++)
            prev[j] = grid[0][j];
        for(int i=1;i<n;i++){
            int[] cur = new int[m];
            for(int j=0;j<m;j++){
                int left = 0; int right = 0; int up = 0;
                if(j>0)
                    left = grid[i][j] + prev[j-1];
                if(j<m-1)
                    right = grid[i][j] + prev[j+1];
                up = grid[i][j] + prev[j];
                cur[j] = Math.max(up,Math.max(left,right));
            }
            prev = cur;
        }
        int maxi=0;
        for(int j=0;j<m;j++){
            maxi = Math.max(maxi,prev[j]);
        }
        return maxi;
    }

    private static int findmaxsum1(int[][] grid, int[][] dp) {
        int m = grid.length; int n = grid[0].length;
        for(int j=0;j<m;j++)
            dp[0][j] = grid[0][j];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int left = 0; int right = 0; int up = 0;
                if(j>0)
                    left = grid[i][j] + dp[i-1][j-1];
                if(j<m-1)
                    right = grid[i][j] + dp[i-1][j+1];
                up = grid[i][j] + dp[i-1][j];
                dp[i][j] = Math.max(up,Math.max(left,right));
            }
        }
        int maxi = 0;
        for(int j=0;j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }
        return maxi;
    }

    private static int findmaxsum(int[][] grid, int[][] dp, int rows, int cols) {
        if(cols<0 || cols>grid[0].length-1)
            return (int) -1e9;
        if(rows==0)
            return grid[rows][cols];
        if(dp[rows][cols] != -1)
            return dp[rows][cols];
        int left = grid[rows][cols] + findmaxsum(grid,dp,rows-1,cols-1);
        int up = grid[rows][cols] + findmaxsum(grid,dp,rows-1,cols);
        int right = grid[rows][cols] + findmaxsum(grid,dp,rows-1,cols+1);
        dp[rows][cols] = Math.max(up,Math.max(left,right));
        return dp[rows][cols];
    }

}
