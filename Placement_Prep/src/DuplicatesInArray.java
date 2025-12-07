public class DuplicatesInArray {
    public int removeDuplicates(int[] nums) {
        int p1=0; int p2=1;
        while(p2<nums.length){
            if(nums[p2] != nums[p1]){
                nums[p1+1] = nums[p2]; p1++;
            }
            p2++;
        }
        return p1+1;
    }
}
