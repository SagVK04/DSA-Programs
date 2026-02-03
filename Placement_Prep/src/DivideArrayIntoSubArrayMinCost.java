public class DivideArrayIntoSubArrayMinCost {
    public int minimumCost(int[] nums) {
        int second_start = Integer.MAX_VALUE;
        int third_start = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < second_start){
                third_start = second_start;
                second_start = nums[i];
            }
            else if(nums[i] < third_start)
                third_start = nums[i];
        }
        return nums[0]+second_start+third_start;
    }
}
