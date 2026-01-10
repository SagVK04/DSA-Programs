import java.util.Arrays;
import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k=0; int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            if(arr[i] != 0)
                arr[k++] = arr[i];
        }
        for(;k<n;k++)
            arr[k] = 0;
        System.out.println(Arrays.toString(arr));
    }
}
