public class leetcode33 {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums,target);
        int res = search(nums,target,pivot); 
        return res;  
    }
    public int search(int[] nums, int target, int pivot){
        if(pivot == -1)
            return Binary(nums,target,0,nums.length-1);
        else if(nums[pivot] == target)
            return pivot;
        else if(target >= nums[0])
            return Binary(nums,target,0,pivot-1);
        else 
            return Binary(nums,target,pivot+1,nums.length-1);
    }
    public int findPivot(int[] nums, int target){
        int start=0; int end = nums.length-1; int pivotIndex=0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && nums[mid+1]<nums[mid])
                return mid;
            else if(mid>start && nums[mid-1]>nums[mid])
                return mid-1;
            else if(nums[start]>=nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
    public int Binary(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < nums[mid])
                end = mid - 1;
            else if(target > nums[mid])
                start = mid + 1;
            else 
                return mid;
        }
        return -1;
    }
}
