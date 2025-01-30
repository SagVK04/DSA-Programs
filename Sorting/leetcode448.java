import java.util.ArrayList;
import java.util.List;
class leetcode448 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> a = findDisappearedNumbers(arr);
        System.out.println("Missing numbers are: "+a);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] != nums[nums[i]-1])
                swapValues(nums, i, nums[i]-1);
            else
                i++;
        }
        List<Integer> resList = new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            if(nums[index] != index+1)
                resList.add(index+1);
        }
        return resList;
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}