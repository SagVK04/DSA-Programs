public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 1; int right = 1;
        for(int i=0;i<nums.length;i++){
            ans[i] = left;
            left *= nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        int left_product=1; int right_product=1;
        for(int i=0;i<nums.length;i++){
            ans[i] = left_product; //No right multiply exists, only store left multiply
            left_product *= nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            ans[i] = right_product * ans[i]; //Multiply right with already stored multiply of lefter elements
            right_product *= nums[i];
        }
        return ans;
    }
}
