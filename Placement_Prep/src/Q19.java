import java.util.Arrays;
import java.util.Scanner;

public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //[1,3,2,3,2,4]
        System.out.print("Input: ");
        String input = sc.nextLine();
        input = input.replaceAll("\\[|\\]","");
        String[] input_str = input.split(",");
        int[] nums = new int[input_str.length];
        for(int i=0;i<input_str.length;i++)
            nums[i] = Integer.parseInt(input_str[i].trim());
        System.out.println("Output: "+findSum(nums));
    }
    public static int findSum(int[] nums){
        int[] map = new int[1001]; int sum=0;
        for(int i=0;i<nums.length;i++){
            if(map[nums[i]] == 1) continue;
            map[nums[i]] = 1;
        }
        for(int i=0; i<map.length; i++){
            if(map[i] == 1) sum += i;
        }
        return sum;
    }
}
