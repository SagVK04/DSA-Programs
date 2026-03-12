package TCS_NQT;
import java.util.*;

public class P22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String[] input = sc.nextLine().trim().split(" ");
        int[] nums = new int[input.length];
        for(int i=0;i<nums.length;i++) nums[i] = Integer.parseInt(input[i]);
        int target = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Output: ");
        int res_ind = findElement(nums,target);
        System.out.println(res_ind);
    }
    public static int findElement(int[] nums, int target){
        int lb=0; int ub=nums.length-1;
        while(lb<=ub){
            int mid = lb + (ub-lb)/2;
            if(nums[mid] == target) return mid;
            if(nums[lb] <= nums[mid]){
                if(nums[lb]<=target && target<nums[mid]) ub = mid-1;
                else lb = mid+1;
            }
            else{
                if(nums[mid]<target && target<=nums[ub]) lb = mid+1;
                else ub = mid-1;
            }
        }
        return -1;
    }
}
