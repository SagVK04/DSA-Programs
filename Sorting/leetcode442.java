import java.util.*;
class leetcode442 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> a = findDuplicates(arr);
        System.out.println("Duplicate numbers are: "+a);
    }
    public static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        List<Integer> resList = new ArrayList<>();
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
            if(nums[index] != index+1)
                resList.add(nums[index]);
        }
        return resList.reversed();
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}