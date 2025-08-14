import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] houses = {9,9,2,1};
        System.out.println("Maximum Loot: "+max_loot(houses)+" Unit(s) money");
    }
    private static int max_loot(int[] houses){
        int[] first = new int[houses.length - 1];
        int[] second = new int[houses.length - 1];
        for(int i=0;i<houses.length - 1;i++){
            first[i] = houses[i];
            second[i] = houses[i+1];
        }
        int[] dp = new int[houses.length-1];
        Arrays.fill(dp,-1);
        int ans1 = find_max_loot_1(houses,dp);
        int ans2 = find_max_loot_1(houses,dp);
        return Math.max(ans1,ans2);
    }

    private static int find_max_loot_1(int[] houses, int[] dp) {
        dp[0] = houses[0]; dp[1] = Math.max(houses[1],houses[0]);
        for(int i=2; i<houses.length-1; i++){
            dp[i] = Math.max(houses[i]+dp[i-2],dp[i-1]);
        }
        return dp[houses.length-2];
    }

    private static int find_max_loot(int[] arr,int[] houses,int[] dp,int n){
        if(n == 0)
            return houses[0];
        if(dp[n] != -1)
            return dp[n];
        int ans1 = find_max_loot(arr,houses,dp,n-1);
        int ans2 = houses[n];
        if(n >= 2)
            ans2 = houses[n] + find_max_loot(arr,houses,dp,n-2);
        dp[n] = Math.max(ans1,ans2);
        return dp[n];
    }
}
