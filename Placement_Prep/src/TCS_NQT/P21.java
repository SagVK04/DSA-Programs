package TCS_NQT;

import java.util.Arrays;
import java.util.Scanner;

public class P21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String input = sc.nextLine().trim();
        String[] input_array = input.split(" ");
        int[] nums = new int[input_array.length];
        for(int i=0;i<nums.length;i++) nums[i] = Integer.parseInt(input_array[i]);

        System.out.println("Output: ");
        System.out.println(findMajor(nums));
    }
    public static int findMajor(int[] nums){
        int start=-1; int pair=0;
        for(int num: nums){
            if(pair == 0) start = num;
            if(num == start) pair += 1;
            else pair -= 1;
        }
        return (pair==0)? -1:start;
    }
}
