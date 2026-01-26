public class RotateArray {
    public void rotate(int[] nums, int k) {
        //1,2,3,4,5 k=3  ->  5,4,3,2,1 -> 3,4,5,1,2
        //Reverse the array
        k = k % nums.length;
        nums = revArray(nums,0,nums.length-1);
        //Reverse first k elements
        nums = revArray(nums,0,k-1);
        //Reverse remaining elements
        nums = revArray(nums,k,nums.length-1);
    }
    public int[] revArray(int[] arr,int lb, int ub){
        while(lb < ub){
            int temp=arr[lb];
            arr[lb] = arr[ub];
            arr[ub] = temp;
            lb++; ub--;
        }
        return arr;
    }
}
