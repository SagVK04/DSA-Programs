import java.util.*;
public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int r = sc.nextInt();
        System.out.println("Enter columns: ");
        int c = sc.nextInt();
        System.out.println("Enter elements: ");
        int[][] arr = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j=0; j<c; j++)
                arr[i][j] = sc.nextInt();
        }
        int max_sum_ind = 0;
        int max_sum = 0;
        for(int j=0; j<c; j++)
            max_sum += arr[0][j];
        for(int i=1;i<r;i++){
            int sum = 0;
            for(int j=0;j<c;j++)
                sum += arr[i][j];
            if(sum > max_sum) {
                max_sum = sum;
                max_sum_ind = i;
            }
        }
        System.out.println("Maximum filled row number: "+(max_sum_ind+1));
    }
}
