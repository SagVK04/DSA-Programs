public class BuyingStocks {
    public int maxProfit(int[] prices) {
        int totalProfit = 0; int min_buy_price=prices[0];
        for(int i=1;i<prices.length;i++){
            int cur_profit = prices[i] - min_buy_price;
            totalProfit = Math.max(totalProfit,cur_profit);
            min_buy_price = Math.min(min_buy_price,prices[i]);
        }
        return totalProfit;
    }
}
