import java.util.ArrayList;

public class maze1 {
    public static void main(String[] args) {
        //System.out.println("No. of paths: "+count(3,3));
        //path("",3,3);
        //System.out.println("Possible paths are: "+pathReturn("",3,3));
        //System.out.println("Possible paths (including diagonals) are: "+diagonalpathReturn("",3,3));
        boolean[][] maze ={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        System.out.println("Possible paths (bypassing obstacles) are: "); pathWithObstacles("",maze,0,0);
        //System.out.println("Possible paths (bypassing obstacles) are: "+returnPathWithObstacles("",maze,0,0));
    }
    static int count(int r, int c){ //starting from (3,3), reverse from traditional convention
        if(r == 1 || c == 1)
            return 1;
        int left = count(r-1,c); //moving down -> row decrease by 1
        int right = count(r,c-1); //moving right -> column decrease by 1
        return left+right;
    }
    static void path(String pro, int r, int c){
        if(r==1 && c==1)
            System.out.println(pro);
        if(r > 1)
            path(pro+'D',r-1,c);
        if(c > 1)
            path(pro+'R',r,c-1);
    }
    static ArrayList pathReturn(String pro, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> res = new ArrayList<>();
            res.add(pro); return res;
        }
        ArrayList<String> fin = new ArrayList<>();
        if(r > 1)
            fin.addAll(pathReturn(pro+'D',r-1,c));
        if(c > 1)
            fin.addAll(pathReturn(pro+'R',r,c-1));
        return fin;
    }
    static ArrayList diagonalpathReturn(String pro, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> res = new ArrayList<>();
            res.add(pro); return res;
        }
        ArrayList<String> fin = new ArrayList<>();
        if(r>1 && c>1)
            fin.addAll(diagonalpathReturn(pro+'D',r-1,c-1));
        if(r > 1)
            fin.addAll(diagonalpathReturn(pro+'V',r-1,c));
        if(c > 1)
            fin.addAll(diagonalpathReturn(pro+'H',r,c-1));
        return fin;
    }
    static void pathWithObstacles(String pro,boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze.length-1) {
            System.out.println(pro);
            return;
        }
        if(maze[r][c] && r < maze.length-1 && c < maze.length-1)
            pathWithObstacles(pro+'D',maze,r+1,c+1);
        if(maze[r][c] && r < maze.length-1)
            pathWithObstacles(pro+'V',maze,r+1,c);
        if(maze[r][c] && c < maze.length-1)
            pathWithObstacles(pro+'H',maze,r,c+1);
    }
    static ArrayList returnPathWithObstacles(String pro, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze.length-1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(pro); return res;
        }
        ArrayList<String> fin = new ArrayList<>();
        if(maze[r][c] && r < maze.length-1 && c < maze.length-1)
            fin.addAll(returnPathWithObstacles(pro+'D',maze,r+1,c+1));
        if(maze[r][c] && r < maze.length-1)
            fin.addAll(returnPathWithObstacles(pro+'V',maze,r+1,c));
        if(maze[r][c] && c < maze.length-1)
            fin.addAll(returnPathWithObstacles(pro+'H',maze,r,c+1));
        return fin;
    }
}
