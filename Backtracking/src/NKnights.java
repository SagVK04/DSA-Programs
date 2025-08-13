import java.util.Scanner;

public class NKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of knights: ");
        int n = sc.nextInt();
        boolean[][] board = new boolean[n][n];
        Knights(board,0,0,n);
    }
    static void Knights(boolean[][] board, int row, int col, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length) //Checking if whole board is completed
            return;
        if(col == board.length) { //Checking next row if current row completed and col is out of bound
            Knights(board, row + 1, 0, knights);
            return;
        }
        if(isSafe(board,row,col)){ //Checking if knight can be placed
            board[row][col] = true; //Knight is placed
            Knights(board,row,col+1,knights-1); //Check next column
            board[row][col] = false; //Reverting changes
        }
        Knights(board,row,col+1,knights); //Check next column by default
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]) //If valid then check if any knight present in that two-half distance
                return false;
        }
        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1])
                return false;
        }
        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2])
                return false;
        }
        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2])
                return false;
        }
        return true;
    }

    //Avoiding repeating calculation
    static boolean isValid(boolean[][] board, int row,int col){
        //Checking two-half distance measure of knight is possible or not
        return (row >= 0 && row < board.length && col >= 0 && col < board.length);
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean ele : row){
                if(ele)
                    System.out.print("K ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
}
