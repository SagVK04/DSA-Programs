public class PivotIndexPrefixSum {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length+2];
        prefix[0] = 0; prefix[prefix.length-1] = 0;
        for(int i=1; i<=nums.length; i++)
            prefix[i] = nums[i-1] + prefix[i-1];
        for(int i=1; i<=nums.length; i++){
            int left = prefix[i-1];
            int right = prefix[nums.length] - prefix[i];
            if(left == right) return i-1;
        }
        return -1;
    }
}
