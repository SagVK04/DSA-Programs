class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[2];
        a[0]=-1;a[1]=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                a[0] = i; a[1] = i;
                while(i+1<nums.length && nums[i+1] == target){
                    i++; a[1] = i;
                }
            }
        }
        return a;
    }
}