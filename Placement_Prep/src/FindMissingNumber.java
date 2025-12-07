public class FindMissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (nums.length*(nums.length+1))/2;
        int cur_sum=0;
        for(int e: nums)
            cur_sum += e;
        return Math.abs(sum - cur_sum);
    }
}
