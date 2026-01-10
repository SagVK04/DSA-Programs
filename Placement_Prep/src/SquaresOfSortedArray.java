public class SquaresOfSortedArray {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int i=0; int j=nums.length-1;
            int[] res = new int[nums.length]; int k=nums.length-1;
            while(k >= 0){
                if(Math.abs(nums[j]) >= Math.abs(nums[i])){
                    res[k] = nums[j] * nums[j]; j--;
                }
                else{
                    res[k] = nums[i] * nums[i]; i++;
                }
                k--;
            }
            return res;
        }
    }
}
