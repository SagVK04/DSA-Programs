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
        return findProfit(prices,prices.length,0,1,dp);
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
}
