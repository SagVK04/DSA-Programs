import java.util.Arrays;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int setBit = sc.nextInt(); int count=0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i=1;i<n;i++){
            if(getBitCount(i,n,dp) == setBit)
                count++;
        }
        System.out.println("Total: "+count);
    }
    public static int getBitCount(int num, int n, int[] dp){
        if(dp[num] != -1) return dp[num];
        if(num == 0) return 0;
        dp[num] = 1 + getBitCount(num&(num-1),n,dp);
        return dp[num];
    }
}
