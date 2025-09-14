import java.util.*;
public class BuyandSellStocks_3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("Maximum profit: "+maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] a: dp){
            for(int[] b: a){
                Arrays.fill(b,-1);
            }
        }
        return findProfit(prices,prices.length,0,1,2,dp);
    }
    public static int findProfit(int[] prices, int n, int ind, int buy, int cap,int[][][] dp){
        if(ind == n || cap == 0) return 0;
        if(dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit = 0;
        if(buy == 1)
            profit = Math.max(
                    -prices[ind] + findProfit(prices,n,ind+1,0,cap,dp),
                    findProfit(prices,n,ind+1,1,cap,dp)
            );
        else
            profit = Math.max(
                    prices[ind] + findProfit(prices,n,ind+1,1,cap-1,dp),
                    findProfit(prices,n,ind+1,0,cap,dp)
            );
        return dp[ind][buy][cap] = profit;
    }
}
