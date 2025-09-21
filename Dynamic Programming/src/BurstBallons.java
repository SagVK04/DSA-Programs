import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBallons {
    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        System.out.println("Max coins can be earned: "+maxCoins(arr));
    }
    private static int maxCoins(int[] a){
        int n = a.length;
        List<Integer> intarray = new ArrayList<>();
        for(int i: a)
            intarray.add(i);
        intarray.addFirst(1);
        intarray.addLast(1);
        int[][] dp = new int[n+1][n+1];
        for(int[] b:dp)
            Arrays.fill(b,-1);
        return f1(intarray,1,n,dp);
    }

    private static int f1(List<Integer> a, int i, int j, int[][] dp) {
        if(i>j) return 0; int Max = -1;
        if(dp[i][j] != -1)
            return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost = a.get(i - 1)*a.get(ind)*a.get(j+1) + f1(a,i,ind-1,dp) + f1(a,ind+1,j,dp);
            Max = Math.max(Max,cost);
        }
        return dp[i][j] = Max;
    }

}
