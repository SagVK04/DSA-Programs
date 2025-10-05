import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[4];
        for(int i=0;i<4;i++)
            input[i] = sc.nextInt();
        for(int i=0;i<4;i++){
            System.out.println(input[i]+" - "+(char)input[i]);
        }
    }
}
