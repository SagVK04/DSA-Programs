package TCS_NQT;

import java.util.Arrays;

public class P30 {
    public static void main(String[] args) {
        int[] nums = {5,2,7,4,6,3};
        mergeSortInPlace(nums,0,nums.length);
        System.out.print(Arrays.toString(nums));
    }
    public static int[] mergeSort(int[] nums){
        if(nums.length == 1) return nums;
        int mid = nums.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }
    private static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        int i=0; int j=0; int k=0;
        while(i<first.length && j<second.length){
            if(first[i] < second[j]) mix[k++] = first[i++];
            else mix[k++] = second[j++];
        }
        while(i<first.length) mix[k++] = first[i++];
        while(j<second.length) mix[k++] = second[j++];
        return mix;
    }
    public static void mergeSortInPlace(int[] nums, int start, int end){
        if(end-start == 1) return;
        int mid = (end+start)/2;
        mergeSortInPlace(nums,start,mid);
        mergeSortInPlace(nums,mid,end);
        mergeInPlace(nums,start,mid,end);
    }
    private static void mergeInPlace(int[] nums, int start, int mid, int end){
        int[] mix = new int[end-start];
        int i=start; int j=mid; int k=0;
        while(i<mid && j<end){
            if(nums[i] < nums[j]) mix[k++] = nums[i++];
            else mix[k++] = nums[j++];
        }
        while(i<mid) mix[k++] = nums[i++];
        while(j<end) mix[k++] = nums[j++];
        for(int l=0;l<mix.length;l++) nums[start+l] = mix[l];
    }
}
