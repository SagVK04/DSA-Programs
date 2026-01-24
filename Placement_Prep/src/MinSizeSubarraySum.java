public class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int lb=0; int sum=0; int minLen = Integer.MAX_VALUE;
        for(int ub=0;ub<nums.length;ub++){
            sum += nums[ub];
            while(sum >= target){
                minLen = Math.min(minLen,ub-lb+1);
                sum -= nums[lb]; lb++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
