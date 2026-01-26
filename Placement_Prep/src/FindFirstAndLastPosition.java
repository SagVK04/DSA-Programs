public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int start=search(nums,target,true);
        int end=search(nums,target,false);
        return new int[]{start,end};
    }
    int search(int[] nums, int target, boolean findStartIndex){
        int ans=-1;
        int start=0; int end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            //Normal Binary Search Condition
            if(target < nums[mid]) end = mid - 1;
            else if(target > nums[mid]) start = mid + 1;
            else{
                ans = mid;
                //If finding start index(findStartIndex = true) move left
                if(findStartIndex) end = mid - 1;
                    //Otherwise move to right
                else start = mid + 1;
            }
        }
        return ans;
    }
}
