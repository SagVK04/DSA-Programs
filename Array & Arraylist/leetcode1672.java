public class leetcode1672 {
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for(int person=0;person<accounts.length;person++){
            int total = 0;
            for(int account=0; account<accounts[person].length;account++)
                total += accounts[person][account];
            if(total > maxSum)
                maxSum = total;
        }
        return maxSum;
    }
}
