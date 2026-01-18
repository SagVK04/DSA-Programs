public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i=0; int insert=0;
        while(i < nums.length){
            if(nums[i] != 0)
                nums[insert++] = nums[i++];
            else i++;
        }
        while(insert < nums.length)
            nums[insert++] = 0;
    }
}
