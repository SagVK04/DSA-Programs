import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze ={
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] Path = new int[maze.length][maze[0].length];
        //System.out.println("Possible paths (R,L,D,U) are:"); returnPathWithObstacles("",maze,0,0);
        System.out.println("Possible paths (R,L,D,U) are:"); printpathWithMatrices("",maze,0,0,1,Path);
    }
    static void returnPathWithObstacles(String pro, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1) {
            System.out.println(pro); return;
        }
        if(!maze[r][c])
            return;
        maze[r][c] = false; //Considering the block as false
        if(r < maze.length-1)
            returnPathWithObstacles(pro + 'D', maze, r + 1, c);
        if(c < maze[0].length-1)
            returnPathWithObstacles(pro + 'R', maze, r, c + 1);
        if(r > 0)
            returnPathWithObstacles(pro + 'U', maze, r - 1, c);
        if(c > 0)
            returnPathWithObstacles(pro + 'L', maze, r, c - 1);
        maze[r][c]=true; //Reverting back true before return
    }

    static void printpathWithMatrices(String pro, boolean[][] maze, int r, int c,int step,int[][] Path){
        if(r==maze.length-1 && c==maze[0].length-1) {
            //Last cell : no need to set false and again making it true, just keep as it is
            Path[r][c] = step; //As the last cell is being checked, this is also included in the path, hence Path[r][c] = step
            //Printing the total path matrix as the path is already determined
            for(int a[] : Path)
                System.out.println(Arrays.toString(a));
            System.out.println(pro); //Print the path
            System.out.println(); return;
        }
        if(!maze[r][c])
            return;
        maze[r][c] = false; //Considering the block as false
        Path[r][c] = step; //Set the cell of Path Matrix with the step number
        if(r < maze.length-1)
            printpathWithMatrices(pro + 'D', maze, r + 1, c,step+1,Path);
        if(c < maze[0].length-1)
            printpathWithMatrices(pro + 'R', maze, r, c + 1,step+1,Path);
        if(r > 0)
            printpathWithMatrices(pro + 'U', maze, r - 1, c, step+1, Path);
        if(c > 0)
            printpathWithMatrices(pro + 'L', maze, r, c - 1,step+1, Path);
        //Reverting back true before return
        maze[r][c]=true;
        Path[r][c]=0;
    }
}