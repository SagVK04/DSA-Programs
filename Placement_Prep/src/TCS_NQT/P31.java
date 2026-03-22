package TCS_NQT;

import java.util.Arrays;

public class P31 {
    public static void main(String[] args) {
        int[] nums = {5,2,7,4,6,3};
        placePivot(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void placePivot(int[] nums,int start, int end){
        if(start >= end) return;
        int pivot = nums[start+(end-start)/2];
        int s=start; int e=end;
        while(s <= e){
            while(nums[s] < pivot) s++;
            while(nums[e] > pivot) e--;
            if(s <= e) {
                swap(nums,s,e); s++; e--;
            }
        }
        placePivot(nums,start,e);
        placePivot(nums,s,end);
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
