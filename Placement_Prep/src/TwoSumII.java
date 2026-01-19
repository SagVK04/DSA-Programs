public class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        int lb=0; int ub=nums.length-1;
        while(lb < ub){
            int sum = nums[lb] + nums[ub];
            if(sum == target) return new int[]{lb+1,ub+1};
            if(target < sum) ub--;
            else lb++;
        }
        return new int[]{-1,-1};
    }
}
