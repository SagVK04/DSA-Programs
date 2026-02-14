import java.util.Scanner;

public class BinarySubarrayWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nums = ");
        String input = sc.nextLine().trim();
        input = input.replaceAll("\\[|\\]","");
        String[] input_str = input.split(",");
        int[] nums = new int[input_str.length];
        for(int i=0;i<input_str.length;i++)
            nums[i] = Integer.parseInt(input_str[i]);

        System.out.println("goal = ");
        String input_goal = sc.nextLine().trim();
        int goal = Integer.parseInt(input_goal);

        System.out.println("Output = ");
        System.out.println(numSubarraysWithSum(nums,goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return findCount(nums,goal)-findCount(nums,goal-1);
    }
    public static int findCount(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0; int r=0; int sum=0; int count=0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l]; l++;
            }
            count += (r-l+1); r++;
        }
        return count;
    }
}
