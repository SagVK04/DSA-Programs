import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {3,2,5}; int[] val = {30,40,60};
        int bag_wt = 6;
        int[][] dp = new int[wt.length][bag_wt+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        System.out.println("Max Profit by 0/1 Knapsack: "+knapsack_1(wt,val,wt.length-1,bag_wt,dp));
        System.out.println("Max Profit by 0/1 Knapsack_Tab: "+knapsack_tab(wt,val,wt.length-1,bag_wt));
        System.out.println("Max Profit by 0/1 Knapsack_Opt: "+knapsack_opt(wt,val,wt.length-1,bag_wt));
    }

    private static int knapsack_opt(int[] wt, int[] val, int ind, int bagWt) {
        int[] prev = new int[bagWt+1];
        for(int i=wt[0];i<=bagWt;i++)
            prev[i] = val[0];
        for(int i=1;i<=ind;i++){
            int[] cur = new int[bagWt+1];
            for(int w=bagWt;w>=0;w--){
                int notTake = prev[w];
                int Take = -1;
                if(wt[i]<=w)
                    Take = val[i] + prev[w-wt[i]];
                prev[w] = Math.max(notTake,Take);
            }
        }
        return prev[bagWt];
    }

    private static int knapsack_tab(int[] wt, int[] val, int ind, int bagWt) {
        int[][] dp = new int[ind+1][bagWt+1];
        for(int i=wt[0];i<=bagWt;i++)
            dp[0][i] = val[0];
        for(int i=1;i<=ind;i++){
            for(int w=0;w<=bagWt;w++){
                int notTake = dp[i-1][w];
                int Take = -1;
                if(wt[i]<=w)
                    Take = val[i] + dp[i-1][w-wt[i]];
                dp[i][w] = Math.max(notTake,Take);
            }
        }
        return dp[ind][bagWt];
    }

    private static int knapsack_1(int[] wt, int[] val, int ind, int bagWt,int[][] dp) {
        if(ind == 0){
            if(wt[0] <= bagWt)
                return val[0];
            else
                return 0;
        }
        if(dp[ind][bagWt] != -1)
            return dp[ind][bagWt];
        int notTake = knapsack_1(wt,val,ind-1,bagWt,dp);
        int Take = -1;
        if(wt[ind]<=bagWt)
            Take = val[ind] + knapsack_1(wt,val,ind-1,bagWt-wt[ind],dp);
        return dp[ind][bagWt] = Math.max(notTake,Take);
    }
}
