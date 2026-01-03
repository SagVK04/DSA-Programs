public class RecursiveBinarySearch {
    public int search(int[] nums, int target) {
        int lb=0; int ub=nums.length-1;
        return b_search(nums,target,lb,ub);
    }
    public int b_search(int[] nums, int target, int lb, int ub){
        if(lb<=ub){
            int mid = (lb+ub)/2;
            if(nums[mid] == target) return mid;
            else if(target >= nums[mid])
                return b_search(nums,target,mid+1,ub);
            else
                return b_search(nums,target,lb,mid-1);
        }
        else return -1;
    }
}
