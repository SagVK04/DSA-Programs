public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int low=0; int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid] == target)
                return mid;
            //Check left is sorted or not
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]) //target in between sorted part
                    high = mid-1;
                else
                    low = mid+1;
            }
            //Check right is sorted or not
            else{
                if(nums[mid] <= target && target <= nums[high]) //target in between sorted part
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
