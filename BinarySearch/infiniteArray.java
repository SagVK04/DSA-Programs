public class infiniteArray {
    public static void main(String[] args) {
        int[] a = {3,5,7,9,10,90,100,130,140,160,170,176,179,183,275,376};
        int target = 10;
        System.out.println("Target index: "+ans(a,target));
    }
    static int ans(int[] nums, int target){
        int start=0; 
        int end=1;
        while (target > nums[end]) {
            int chunkSize = end - start + 1;
            start = end+1; end += chunkSize*2;            
        }
        return binarysearch(nums, target, start, end);
    }
    static int binarysearch(int[] nums, int target, int start, int end){
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