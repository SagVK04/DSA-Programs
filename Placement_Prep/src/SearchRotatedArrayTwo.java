/*While finding sorted part, if extreme-position elements
            are both gets matched with mid, we can't determine sorted part.
            Hence we need to reduce search size and check extreme-most elements
            once again to be sure.
            e.g. nums = [3,4,1,3,3,3,3]
            nums[mid] == nums[lb] == nums[ub] == 3
            reduce it to nums = [4,1,3,3,3]
            nums[mid] = 3, nums[lb] = 4, nums[ub] == 3
            --> hence right part can be considered as sorted because nums[lb] > nums[mid]
            --> now we can work on nums[mid] to nums[ub]
            */
public class SearchRotatedArrayTwo {
    public boolean search(int[] nums, int target) {
        int lb=0; int ub=nums.length-1;
        while(lb<=ub){
            int mid = (lb+ub)/2;
            if(nums[mid] == target) return true;
            if(nums[lb] == nums[mid] && nums[mid] == nums[ub]){
                lb++; ub--; continue; //Check once more before executing later parts
            }

            //Check left is sorted or not
            if(nums[lb] <= nums[mid]){
                if(nums[lb] <= target && target <=nums[mid]) //If target is in range
                    ub = mid-1;
                else
                    lb = mid+1;
            }
            //right is definitely sorted
            else{
                if(nums[mid] <= target && target <= nums[ub])
                    lb = mid+1;
                else
                    ub = mid-1;
            }
        }
        return false;
    }
}
