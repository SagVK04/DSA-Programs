import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] act = {
                {10,40,70},
                {20,50,80},
                {30,60,90}
        };
        int days = act.length;
        System.out.println("Max merit points: "+ninjaTr(act,days));
    }
    private static int ninjaTr(int[][] act, int days){
        int[][] dp = new int[days][act[0].length+1];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        //return find_max_pts(days-1, act[0].length, act,dp);
        return find_max_pts_1(days,act,dp);
    }

    private static int find_max_pts_1(int n,int[][] act,int[][] dp) {
        dp[0][0] = Math.max(act[0][1],act[0][2]);
        dp[0][1] = Math.max(act[0][0],act[0][2]);
        dp[0][2] = Math.max(act[0][0],act[0][1]);
        dp[0][3] = Math.max(act[0][0],Math.max(act[0][1],act[0][2]));

        for(int days=1;days<n;days++){
            for(int task_visi=0; task_visi<act[0].length+1;task_visi++){
                dp[days][task_visi] = 0;
                for(int future_task=0;future_task<act[0].length;future_task++){
                    if(future_task != task_visi){
                        int pts = act[days][future_task] + dp[days-1][future_task];
                        dp[days][task_visi] = Math.max(dp[days][task_visi],pts);
                    }
                }
            }
        }
        return dp[n-1][act[0].length];
    }

    private static int find_max_pts(int days,int task_vis,int[][] act,int[][] dp){
        if(dp[days][task_vis] != -1)
            return dp[days][task_vis];
        if(days == 0){
            int max_fin = 0;
            for(int future_task=0;future_task<act[0].length;future_task++){
                if(future_task != task_vis)
                    max_fin = Math.max(max_fin,act[days][future_task]);
            }
            dp[days][task_vis] = max_fin;
            return dp[days][task_vis];
        }

        int max_fin = 0;
        for(int future_task=0;future_task<act[0].length;future_task++){
            if(future_task != task_vis){
                int pts = act[days][future_task] + find_max_pts(days-1,future_task,act,dp);
                max_fin = Math.max(max_fin,pts);
            }
        }
        dp[days][task_vis] = max_fin;
        return dp[days][task_vis];
    }
}
