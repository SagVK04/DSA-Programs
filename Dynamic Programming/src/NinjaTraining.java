import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] act = {
                {2,1,3,4},
                {3,4,6,7},
                {10,1,6,9},
                {8,3,7,8}
        };
        int days = act.length;
        System.out.println("Max merit points: "+ninjaTr(act,days));
    }
    private static int ninjaTr(int[][] act, int days){
        int[][] dp = new int[days][act[0].length+1];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        return find_max_pts(days-1, act[0].length, act,dp);
    }
    private static int find_max_pts(int days,int vis,int[][] act,int[][] dp){
        if(dp[days][vis] != -1)
            return dp[days][vis];
        if(days == 0){
            int max_fin = 0;
            for(int i=0;i<act[0].length;i++){
                if(i != vis)
                    max_fin = Math.max(max_fin,act[days][i]);
            }
            dp[days][vis] = max_fin;
            return dp[days][vis];
        }

        int max_fin = 0;
        for(int i=0;i<act[0].length;i++){
            if(i != vis){
                int pts = act[days][i] + find_max_pts(days-1,i,act,dp);
                max_fin = Math.max(max_fin,pts);
            }
        }
        dp[days][vis] = max_fin;
        return dp[days][vis];
    }
}
