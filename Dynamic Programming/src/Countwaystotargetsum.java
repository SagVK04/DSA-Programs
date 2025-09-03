import java.util.*;
public class Countwaystotargetsum {
    public static void main(String[] args) {
        int[] arr = {2,2,1}; int target = 3;
        System.out.println("No of ways: "+findways(arr,arr.length-1,target));
    }
    static int findways(int[] arr, int ind, int target){
        int[][] dp = new int[arr.length][target+1];
        for(int[] a : dp)
            Arrays.fill(a,-1);
        //return countways_1(arr,dp,ind,target);
        //return countways_2(arr,ind,target);
        return countways_3(arr,ind,target);
    }

    static int countways_1(int[] arr,int[][] dp,int ind,int target){
        if(ind == 0)
            return (target % arr[0] == 0? 1:0);
        if(target == 0)
            return 1;
        if(dp[ind][target] != -1)
            return dp[ind][target];
        int notTake = countways_1(arr,dp,ind-1,target);
        int Take = 0;
        if(arr[ind] <= target)
            Take = countways_1(arr,dp,ind,target-arr[ind]);
        return dp[ind][target] = notTake + Take;
    }

    static int countways_2(int[] arr,int ind,int target){
        int[][] dp = new int[arr.length][target+1];
        for(int t=0;t<=target;t++){
            dp[0][t] = (t % arr[0] == 0? 1:0);
        }
        for(int i=0;i<=ind;i++)
            dp[i][0]=1;
        for(int i=1;i<=ind;i++){
            for(int t=1;t<=target;t++){
                int notTake = dp[i-1][t];
                int Take = 0;
                if(arr[i] <= t)
                    Take = dp[i][t-arr[i]];
                dp[i][t] = notTake + Take;
            }
        }
        return dp[ind][target];
    }

    static int countways_3(int[] arr,int ind,int target){
        int[] prev = new int[target+1];
        for(int t=0;t<=target;t++){
            prev[t] = (t % arr[0] == 0? 1:0);
        }
        prev[0]=1;
        for(int i=1;i<=ind;i++){
            int[] cur = new int[target+1];
            cur[0] = 1;
            for(int t=1;t<=target;t++){
                int notTake = prev[t];
                int Take = 0;
                if(arr[i] <= t)
                    Take = cur[t-arr[i]];
                cur[t] = notTake + Take;
            }
            prev = cur;
        }
        return prev[target];
    }
}
