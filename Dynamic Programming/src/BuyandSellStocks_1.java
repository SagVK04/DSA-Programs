public class BuyandSellStocks_1 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Maximum profit: "+maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int max_Profit = 0; int buy_price=prices[0];
        for(int i=1;i<prices.length;i++){
            int cur_profit = prices[i] - buy_price;
            max_Profit = Math.max(max_Profit,cur_profit);
            buy_price = Math.min(buy_price,prices[i]);
        }
        return max_Profit;
    }
}

