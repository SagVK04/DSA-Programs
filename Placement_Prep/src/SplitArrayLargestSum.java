public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int lb=findMax(nums); int ub=findSum(nums);
        if(k > nums.length)
            return -1;
        while(lb <= ub){
            int mid = (lb+ub)/2;
            int st_no = countSt(nums,mid);
            if(st_no > k)
                lb = mid+1;
            else
                ub = mid -1;
        }
        return lb;
    }
    public int countSt(int[] nums, int max_page){
        int student = 1; int page_allotment=0;
        for(int i=0; i<nums.length; i++){
            if(page_allotment+nums[i] <= max_page)
                page_allotment += nums[i];
            else{
                student ++;
                page_allotment=nums[i];
            }
        }
        return student;
    }
    public int findMax(int[] nums){
        int max=0;
        for(int i=0; i<nums.length; i++)
            max = Math.max(max,nums[i]);
        return max;
    }
    public int findSum(int[] nums){
        int sum=0;
        for(int i=0; i<nums.length; i++)
            sum += nums[i];
        return sum;
    }
}
