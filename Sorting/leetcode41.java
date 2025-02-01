import java.util.Arrays;
public class leetcode41 {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println("First missing positive is: "+firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] < nums.length){
                if(nums[i] >0 && nums[i] != i+1) {
                    if (nums[i] != nums[nums[i] - 1]) {
                        swapValues(nums, i, nums[i] - 1);
                    }
                    else
                        i++;
                }
                else
                    i++;
            }
            else
                i++;
        }
        int index=0;
        for(;index<nums.length;index++){
            if(nums[index] != index+1)
                break;
        }
        return index+1;
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
