package TCS_NQT;
import java.util.*;

public class P17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");

        String buf_in_1 = sc.nextLine().trim();
        String[] buf_in_array = buf_in_1.split(" ");
        int m = Integer.parseInt(buf_in_array[0]);
        int n = Integer.parseInt(buf_in_array[1]);

        int[][] records = new int[m][n];
        for(int i=0;i<m;i++){
            int index=0;
            String buf_in_2 = sc.nextLine().trim();
            String[] buf_array = buf_in_2.split(" ");
            for(int j=0;j<n;j++) {
                records[i][j] = Integer.parseInt(buf_array[index++]);
            }
        }

        System.out.println("Output: ");
        System.out.println(countPass(records,m,n));
    }
    public static int countPass(int[][] records, int m, int n){
        double[] colaverage = new double[n];
        for(int j=0;j<n;j++){
            double sum=0;
            for(int i=0;i<m;i++)
                sum += records[i][j];
            colaverage[j] = sum/m;
        }
        int student=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(records[i][j] > colaverage[j]){
                    student += 1; break;
                }
            }
        }
        return student;
    }
}
