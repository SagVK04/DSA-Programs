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
        return findProfit1(prices,prices.length,0,1,2,dp);
    }
    public static int findProfit1(int[] prices, int n, int ind, int buy, int cap,int[][][] dp){
        if(ind == n || cap == 0) return 0;
        if(dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit = 0;
        if(buy == 1)
            profit = Math.max(
                    -prices[ind] + findProfit1(prices,n,ind+1,0,cap,dp),
                    findProfit1(prices,n,ind+1,1,cap,dp)
            );
        else
            profit = Math.max(
                    prices[ind] + findProfit1(prices,n,ind+1,1,cap-1,dp),
                    findProfit1(prices,n,ind+1,0,cap,dp)
            );
        return dp[ind][buy][cap] = profit;
    }
    public static int findProfit2(int[] prices,int n,int[][][] dp){
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap = 1;cap<=2;cap++){
                    if(buy == 1)
                        dp[ind][buy][cap] = Math.max(
                                -prices[ind] + dp[ind+1][0][cap],
                                dp[ind+1][1][cap]
                        );
                    else
                        dp[ind][buy][cap] = Math.max(
                                prices[ind] + dp[ind+1][1][cap-1],
                                dp[ind+1][0][cap]
                        );
                }
            }
        }
        return dp[0][1][2];
    }
    public static int findProfit3(int[] prices,int n,int[][][] dp){
        int[][] ahead = new int[2][3];
        for(int ind=n-1;ind>=0;ind--){
            int[][] cur = new int[2][3];
            for(int buy=0;buy<=1;buy++){
                for(int cap = 1;cap<=2;cap++){
                    if(buy == 1)
                        cur[buy][cap] = Math.max(
                                -prices[ind] + ahead[0][cap],
                                ahead[1][cap]
                        );
                    else
                        cur[buy][cap] = Math.max(
                                prices[ind] + ahead[1][cap-1],
                                ahead[0][cap]
                        );
                }
            }
            ahead = cur;
        }
        return ahead[1][2];
    }
}
