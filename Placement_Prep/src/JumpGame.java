public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int i=0; int max_jump=0; //-> indicates how far I can jump;
        while(i < nums.length){
            if(i > max_jump) return false; //Reached index beyong jump limit
            max_jump = Math.max(max_jump,i+nums[i]);
            if(max_jump == nums.length-1) break; //Reached last index
            i++;
        }
        return true;
    }
}
