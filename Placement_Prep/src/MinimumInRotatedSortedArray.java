public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lb=0; int ub=nums.length-1; int min=nums[0];
        while(lb <= ub){
            //If portion of array already sorted, just consider leftmost value
            //sorted portion can have all same  elements or  same elements
            if(nums[lb] <= nums[ub]){
                min = Math.min(min,nums[lb]);
                break;
            }
            int mid = lb + (ub - lb)/2;
            //If mid-element is greater than leftmost element, move to right to find  next minimum number
            if(nums[mid] >= nums[lb])
                lb = mid+1;
            //Otherwise this number can be an answer, store it and search to its left portion
            else{
                min = Math.min(min,nums[mid]);
                ub = mid-1;
            }
        }
        return min;
    }
}
