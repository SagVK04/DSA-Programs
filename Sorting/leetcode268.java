import java.util.Arrays;
public class leetcode268 {
    public static void main(String[] args) {
        int[] arr = {1,0,3,2};
        System.out.println("Missing number is: "+missingNumber(arr));
    }
    public static int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] != i && nums[i]!=nums.length) {
                swapValues(nums, i, nums[i]);
                i=i;
            }
            else
                i++;
        }
        int j=0;
        for(;j<nums.length;j++){
            if(nums[j] != j)
                break;
        }
        return j;
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
