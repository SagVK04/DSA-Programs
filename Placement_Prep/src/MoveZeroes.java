import java.util.*;
public class MoveZeroes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] input = original.split(",");
        int[] nums = new int[input.length];
        for(int i=0;i<input.length;i++) nums[i] = Integer.parseInt(input[i]);

        System.out.println(Arrays.toString(allocZero(nums)));
    }
    public static int[] allocZero(int[] nums) {
        int i=0; int insert=0;
        while(i < nums.length){
            if(nums[i] != 0)
                nums[insert++] = nums[i++];
            else i++;
        }
        while(insert < nums.length)
            nums[insert++] = 0;
        return nums;
    }
}
