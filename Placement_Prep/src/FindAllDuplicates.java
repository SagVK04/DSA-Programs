import java.util.*;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
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
