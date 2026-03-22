package TCS_NQT;

import java.util.Scanner;

public class P27 {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Your Input:");
        int n = sc.nextInt(); int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();
        wareHouse(nums,n);

        System.out.println("Your Output:");
        for(int num: nums)
            System.out.print(num+" ");
    }
    public static void wareHouse(int[] nums, int n){
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>ind;i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        reverse(nums,ind+1,n-1);
    }
    public static void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}
