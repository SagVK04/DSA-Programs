public class RemoveDuplicatesFromArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int p1=1; int p2=1;
        while(p2<nums.length){
            if(nums[p2] != nums[p2-1]){
                nums[p1++] = nums[p2];
            }
            p2++;
        }
        return p1;
    }
}
