import java.util.Arrays;

public class GridPath1 {
    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        System.out.println("Grid is: ");
        for (int[] a: grid)
            System.out.println(Arrays.toString(a));
        System.out.println("Paths from (0,0) to reach (3,3): "+find_path(grid));
    }
    private static int find_path(int[][] grid){
        int row = grid.length; int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        //return unique_path(grid,dp,row-1,col-1);
        //return path_tab(grid,row,col);
        return path_opt(grid,row,col);
    }
    private static int unique_path(int[][] grid,int[][] dp,int row,int col){
        if(row==0 && col==0)
            return 1;
        if(row<0 || col<0)
            return 0;
        if(dp[row][col] != -1)
            return dp[row][col];
        int up = unique_path(grid,dp,row-1,col);
        int left = unique_path(grid,dp,row,col-1);
        dp[row][col] = up+left;
        return dp[row][col];
    }
    private static int path_tab(int[][] grid,int row,int col){
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0)
                    dp[0][0] = 1;
                else{
                    int up=0; int left=0;
                    if(i>0)
                        up = dp[i-1][j];
                    if(j>0)
                        left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[row-1][col-1];
    }
    private static int path_opt(int[][] grid,int row,int col){
        int[] prev = new int[col];
        for(int i=0;i<row;i++){
            int[] cur = new int[col];
            for(int j=0;j<col;j++){
                if(i==0 && j==0)
                    cur[j] = 1;
                else {
                    int up = prev[j];
                    int left = 0;
                    if(j > 0)
                        left = cur[j-1];
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[col-1];
    }
}
