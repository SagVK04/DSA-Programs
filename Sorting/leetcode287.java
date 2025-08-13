import java.util.Arrays;
public class leetcode287 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3};
        System.out.println("Duplicate number is: "+findDuplicate(arr));
    }
    static int findDuplicate(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i] != i+1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swapValues(nums, i, nums[i] - 1);
                    i = i;
                }
                else
                    return nums[i];
            }
            else
                i++;
        }
        return -1;
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
