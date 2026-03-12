package TCS_NQT;

import java.util.Arrays;
import java.util.Scanner;

public class P20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String input = sc.nextLine().trim();
        String[] input_array = input.split(" ");
        int[] nums = new int[input_array.length];
        for(int i=0;i<nums.length;i++) nums[i] = Integer.parseInt(input_array[i]);
        int target = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Output: ");
        String res = Arrays.toString(findOccur(nums,target));
        res = res.replace(",","");
        System.out.println(res.substring(1,res.length()-1));
    }
    public static int[] findOccur(int[] nums, int target){
        int first = findIndex(nums,target,true);
        int second = findIndex(nums,target,false);
        return new int[]{first,second};
    }
    public static int findIndex(int[] nums, int target, boolean searchFirst){
        int lb=0; int ub=nums.length-1; int index=-1;
        while(lb <= ub){
            int mid = lb + (ub-lb)/2;
            if(target < nums[mid]) ub = mid-1;
            else if(target > nums[mid]) lb = mid+1;
            else{
                index = mid;
                if(searchFirst) ub = mid-1;
                else lb = mid+1;
            }
        }
        return index;
    }
}
