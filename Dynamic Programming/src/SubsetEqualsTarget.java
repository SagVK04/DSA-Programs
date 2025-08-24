import java.util.Arrays;

public class SubsetEqualsTarget {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 15;
        int[][] dp = new int[arr.length][target+1];
        boolean[][] dp1 = new boolean[arr.length][target+1];
        for(int[] a: dp)
            Arrays.fill(a,-1);
        for(boolean[] a: dp1)
            Arrays.fill(a,false);
        System.out.println("Subset exists?: "+findSubset_opt(arr,target));
    }

    private static boolean findSubset_opt(int[] arr, int target) {
        boolean[] prev = new boolean[target+1];
        prev[0] = true; prev[arr[0]] = true;
        for(int i=1;i< arr.length;i++){
            boolean[] cur = new boolean[target+1];
            cur[0] = true;
            for(int j=1;j<=target;j++){
                boolean notTake = prev[target];
                boolean take = false;
                if(j >= arr[i])
                    take = prev[j-arr[i]];
                cur[j] = notTake || take;
            }
            prev = cur;
        }
        return prev[target];
    }

    private static boolean findSubset_tab(int[] arr, boolean[][] dp, int index, int target) {
        for(int i = 0; i<=index;i++){
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for(int i = 1;i<=index;i++){
            for(int j = 1;j<=target;j++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(j >= arr[i])
                    take = dp[i-1][j-arr[i]];
                dp[i][j] = notTake || take;
            }
        }
        return dp[index][target];
    }

    private static boolean findSubset1(int[] arr, int[][] dp, int index, int target) {
        if(target == 0) return true;
        if(index == 0) return (arr[0] == target);
        if(dp[index][target] != -1){
            return dp[index][target] != 0;
        }

        boolean notTake = findSubset1(arr,dp,index-1,target);
        boolean take = false;
        if(target >= arr[index])
            take = findSubset1(arr,dp,index-1,target-arr[index]);
        dp[index][target] = notTake || take ? 1:0;
        return notTake || take;
    }

    private static boolean findSubset(int[] arr,int index,int target){
        if(target == 0) return true;
        if(index == 0) return (arr[0] == target);
        boolean notTake = findSubset(arr,index-1,target);
        boolean take = false;
        if(target >= arr[index])
            take = findSubset(arr,index-1,target-arr[index]);
        return (notTake || take);
    }
}
