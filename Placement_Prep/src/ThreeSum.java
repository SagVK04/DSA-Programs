import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] input_arr = input.split(",");
        int[] nums = new int[input_arr.length];
        for(int i=0;i<input_arr.length;i++)
            nums[i] = Integer.parseInt(input_arr[i]);

        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int lb=i+1; int ub=nums.length-1;
            while(lb<ub){
                long sum = nums[i]; sum += nums[lb];
                sum += nums[ub];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]); res.add(nums[lb]); res.add(nums[ub]);
                    ans.add(res);
                    lb++; ub--;
                    while(lb<ub && nums[lb]==nums[lb-1]) lb++;
                    while(lb<ub && nums[ub]==nums[ub+1]) ub--;
                }
                else if(sum > 0) ub--;
                else lb++;
            }
        }
        return ans;
    }
}
