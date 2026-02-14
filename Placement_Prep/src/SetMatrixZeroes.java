public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        boolean rowzero = false; boolean colzero = false;
        //Check for first row and mark
        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                rowzero = true; break;
            }
        }
        //Check for first column and mark
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                colzero = true; break;
            }
        }
        //Mark rows and columns set to be zero for rest
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    //mark starting of row and column to zero
                    matrix[i][0] = 0; matrix[0][j] = 0;
                }
            }
        }
        //Now update according to start of row and column
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    //mark each element to zero
                    matrix[i][j] = 0;
                }
            }
        }
        //Update first row
        if(rowzero){
            for(int j=0;j<n;j++)
                matrix[0][j] = 0;
        }
        //Update first column
        if(colzero){
            for(int i=0;i<m;i++)
                matrix[i][0] = 0;
        }
    }
}
