import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class leetcode645 {
    public static void main(String[] args) {
        int[] arr = {3,2,2};
        int[] a = setMismatch(arr);
        System.out.println("Duplicate numbers are: "+ Arrays.toString(a));
    }
    public static int[] setMismatch(int[] nums) {
        int[] res = new int[2];
        int i=0;
        while(i<nums.length){
            if(nums[i] != i+1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swapValues(nums, i, nums[i] - 1);
                }
                else
                    i++;
            }
            else
                i++;
        }
        for(int index=0;index<nums.length;index++){
            if(nums[index] != index+1) {
                res[0] = nums[index];
                res[1] = index + 1;
                break;
            }
        }
        return res;
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
