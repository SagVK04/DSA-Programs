import java.util.Scanner;

public class Q16 {
    static int m; static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String range = sc.nextLine().trim();
        String[] range_str = range.split(",");
        m = Integer.parseInt(range_str[0]);
        n = Integer.parseInt(range_str[1]);

        String input = sc.nextLine().trim();
        //[[0,0,0],[0,1,0],[0,0,0]] -> [0,0,0],[0,1,0],[0,0,0]
        input = input.replaceAll("\\[|\\]","");
        String[] input_str = input.split(",");
        int[][] maze = new int[m][n]; int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maze[i][j] = Integer.parseInt(input_str[k]); k++;
            }
        }
        System.out.println(countPath(maze,0,0));
    }

    private static int countPath(int[][] maze, int r, int c) {
        if(r==m-1 && c==n-1) //Destination Point
            return 1;
        int ver = 0; int hor=0;
        if(maze[r][c]!=1 && r<m-1) //Go down
            ver = countPath(maze,r+1,c);
        if(maze[r][c]!=1 && c<n-1) //Go side
            hor = countPath(maze,r,c+1);
        return ver+hor;
    }
}
