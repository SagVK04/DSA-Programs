import java.util.*;
public class BuyandSellStocks_2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Maximum profit: "+maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        return findProfit2(prices,prices.length,1);
    }
    public static int findProfit(int[] prices, int length, int ind, int canBuy,int[][] dp){
        if(ind == length)
            return 0;
        if(dp[ind][canBuy] != -1)
            return dp[ind][canBuy];
        int profit = 0;
        if(canBuy==1){
            profit = Math.max(
                    findProfit(prices,length,ind+1,0,dp)-prices[ind],
                    findProfit(prices,length,ind+1,1,dp));
        }
        else{
            profit = Math.max(
                    findProfit(prices,length,ind+1,1,dp)+prices[ind],
                    findProfit(prices,length,ind+1,0,dp));
        }
        return dp[ind][canBuy] = profit;
    }
    public static int findProfit1(int[] prices, int length,int canBuy){
        int[][] dp = new int[length+1][2];
        dp[length][0] = 0; dp[length][1] = 0;
        for(int ind=length-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max(
                            dp[ind+1][0]-prices[ind],
                            dp[ind+1][1]);
                }
                else{
                    profit = Math.max(
                            dp[ind+1][1]+prices[ind],
                            dp[ind+1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
    public static int findProfit2(int[] prices, int length,int canBuy){
        int[] ahead = new int[2];
        for(int ind=length-1;ind>=0;ind--){
            int[] cur = new int[2];
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max(
                            ahead[0]-prices[ind],
                            ahead[1]);
                }
                else{
                    profit = Math.max(
                            ahead[1]+prices[ind],
                            ahead[0]);
                }
                cur[buy] = profit;
            }
            ahead = cur;
        }
        return ahead[1];
    }
}
