package TCS_NQT;

import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bufferinput = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] bufferarray = bufferinput.split(",");
        int[] nums = new int[bufferarray.length];
        for(int i=0; i<bufferarray.length; i++) nums[i] = Integer.parseInt(bufferarray[i]);

        System.out.println(findMissingNumber(nums));
    }
    public static int findMissingNumber(int[] nums){
        int n = nums.length;
        int total=0; int preSum = 0;
        if(n%2 == 0)
            total = (n+1) * (n/2);
        else
            total = n * ((n+1)/2);
        for(int num: nums) preSum += num;
        return total-preSum;
    }
}