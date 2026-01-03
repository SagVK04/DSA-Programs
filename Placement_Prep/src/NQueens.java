import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> show = nqueens(4);
        System.out.println(show);
    }

    private static List<List<String>> nqueens(int n) {
        List<List<String>> fin = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        place_queens(fin,ans,board,0);
        return fin;
    }

    private static void place_queens(List<List<String>> fin,
                                     List<String> ans,
                                     int[][] board, int row) {
        if(row == board.length){

            for(int[] a: board){
                for(int ele: a){
                    if(ele == 1)
                        System.out.print("Q ");
                    else
                        System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int col=0;col< board.length;col++){
            if(isSafe(board,row,col)) {
                board[row][col] = 1;
                place_queens(fin,ans,board,row+1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        for(int i=0;i<row;i++){
            if(board[i][col] == 1)
                return false;
        }
        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i] == 1)
                return false;
        }
        int maxRight = Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i] == 1)
                return false;
        }
        return true;
    }
}
