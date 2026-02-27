package TCS_NQT;

import java.util.*;
class P14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        String bufferinput = sc.nextLine().trim().replaceAll("\\[|\\]", "");
        String[] buf_array = bufferinput.split(",");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(buf_array[i]);

        int k = Integer.parseInt(sc.nextLine().trim());

        String ans = Arrays.toString(findMinLoad(nums, n, k));
        System.out.print(
                ans.substring(1, ans.length() - 1)
        );
    }
    public static int[] findMinLoad(int[] nums, int n, int k) {
        if (nums==null || n==0) return new int[0];
        int[] output = new int[n-k+1];
        Deque<Integer> queue = new ArrayDeque<>(); // Stores indices
        for (int i = 0; i < n; i++) {
            //Remove indices that are out of the current window range:
            //Current Index - first index of occurrence from queue + 1 > k
            //remove first element
            if(!queue.isEmpty() && i-queue.peekFirst()+1>k) queue.pollFirst();
            //Remove indices of elements larger than the current element
            //until a lesser value comes
            while (!queue.isEmpty() && nums[queue.peekLast()]>=nums[i])
                queue.pollLast();
            queue.offerLast(i);
            //Once checked first full window, add in array
            if(i >= k-1) {
                output[i-k+1] = nums[queue.peekFirst()];
            }
        }
        return output;
    }
}
