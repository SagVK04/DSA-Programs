import java.util.*;
public class rotationNumber {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,2};
        System.out.println("Enter target: ");
        Scanner sc = new Scanner(System.in);
        int res = findPivot(nums,sc.nextInt());
        System.out.println("No of rotations: "+(res+1));
    }
    public static int findPivot(int[] nums, int target){
        int start=0; int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && nums[mid+1]<nums[mid])
                return mid;
            else if(mid>start && nums[mid-1]>nums[mid])
                return mid-1;
            else if(nums[start]>=nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}
