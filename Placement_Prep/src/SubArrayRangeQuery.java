public class SubArrayRangeQuery {
    int[] prefix = new int[]{};
    public SubArrayRangeQuery(int[] nums) {
        if(nums.length == 0) return;
        prefix = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i>0) prefix[i] = nums[i] + prefix[i-1];
            else prefix[i] = nums[i];
        }
    }
    public int sumRange(int left, int right) {
        if(left == 0) return prefix[right];
        return prefix[right] - prefix[left-1];
    }
}

/*
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
*/
