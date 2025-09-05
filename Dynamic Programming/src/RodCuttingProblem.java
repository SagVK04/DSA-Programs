import java.util.Arrays;
public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] price = {7,5,7,8,10};
        int rodLength = price.length;
        int[][] dp = new int[price.length][rodLength+1];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        System.out.println("Maximum Profit: "+findMaxProfit2(price,price.length-1,rodLength));
    }

    private static int findMaxProfit(int[] price, int length_section_index, int targetRodLength, int[][] dp) {
        if(length_section_index == 0)
            return targetRodLength*price[length_section_index];
        if(dp[length_section_index][targetRodLength] != -1)
            return dp[length_section_index][targetRodLength];
        int notTake = findMaxProfit(price,length_section_index-1,targetRodLength,dp);
        int take = -1;
        if(length_section_index+1 <= targetRodLength)
            take = price[length_section_index] +
                    findMaxProfit(
                            price,length_section_index-1,
                            targetRodLength-(length_section_index+1),
                            dp);
        return dp[length_section_index][targetRodLength] = Math.max(take,notTake);
    }

    private static int findMaxProfit1(int[] price, int length_section_index, int targetRodLength) {
        int[][] dp = new int[length_section_index+1][targetRodLength+1];
        for(int l=0;l<=targetRodLength;l++){
            dp[0][l] = l*price[0];
        }

        for(int ind=1;ind<=length_section_index;ind++){
            for(int l=1;l<=targetRodLength;l++){

                int notTake = dp[ind-1][l];
                int take = -1;
                if(ind+1 <= l)
                    take = price[ind] + dp[ind][l - (ind+1)];
                dp[ind][l] = Math.max(take,notTake);
            }
        }

        return dp[length_section_index][targetRodLength];
    }

    private static int findMaxProfit2(int[] price, int length_section_index, int targetRodLength) {
        int[] prev = new int[targetRodLength+1];
        for(int l=0;l<=targetRodLength;l++){
            prev[l] = l*price[0];
        }

        for(int ind=1;ind<=length_section_index;ind++){
            int[] cur = new int[targetRodLength+1];
            for(int l=1;l<=targetRodLength;l++){
                int notTake = prev[l];
                int take = -1;
                if(ind+1 <= l)
                    take = price[ind] + cur[l - (ind+1)];
                cur[l] = Math.max(take,notTake);
            }
            prev = cur;
        }

        return prev[targetRodLength];
    }
}
