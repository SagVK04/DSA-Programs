import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {10,8,2,9},
                {10,5,100,5},
                {1,1,7,76,31},
                {76,1,3,10}
        };
        System.out.println("Grid is: ");
        for (int[] a: grid)
            System.out.println(Arrays.toString(a));
        System.out.println("Min cost from first cell to last cell: "+minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        //return findMinSum(grid,dp,grid.length-1,grid[0].length-1);
        //return findMinSum_tab(grid,dp);
        return findMinSum_opt(grid);
    }

    private static int findMinSum(int[][] grid, int[][] dp, int row, int col) {
        if(row==0 && col==0)
            return grid[0][0];
        if(row<0 || col<0)
            return 99999;
        if(dp[row][col] != -1)
            return dp[row][col];
        int up = grid[row][col] + findMinSum(grid,dp,row-1,col);
        int left = grid[row][col] + findMinSum(grid,dp,row,col-1);
        dp[row][col] = Math.min(up,left);
        return dp[row][col];
    }
    private static int findMinSum_tab(int[][] grid,int[][] dp){
        int row = grid.length; int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0)
                    dp[i][j] = grid[0][0];
                else {
                    int up = 0; int left = 0;
                    if(i>0)
                        up = grid[i][j] + dp[i-1][j];
                    if(j>0)
                        left = grid[i][j] + dp[i][j-1];
                    if(i==0 || j==0)
                        dp[i][j] = Math.max(up,left);
                    else
                        dp[i][j] = Math.min(up,left);
                }
            }
        }
        System.out.println();
        for(int[] a: dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[row-1][col-1];
    }
    private static int findMinSum_opt(int[][] grid){
        int[] prev = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int[] cur = new int[grid[0].length];
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0)
                    cur[j] = grid[0][0];
                else {
                    int up=0; int left=0;
                    if(i>0)
                        up = grid[i][j] + prev[j];
                    if(j>0)
                        left = grid[i][j] + cur[j-1];
                    if(i==0 || j==0)
                        cur[j] = Math.max(up,left);
                    else
                        cur[j] = Math.min(up,left);
                }
            }
            prev = cur;
        }
        return prev[grid[0].length-1];
    }
}
