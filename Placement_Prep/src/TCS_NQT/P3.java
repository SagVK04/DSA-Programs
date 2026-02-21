package TCS_NQT;
import java.util.*;
public class P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] input = original.split(",");
        int[] nums = new int[input.length];
        for(int i = 0 ;i<input.length; i++) nums[i] = Integer.parseInt(input[i]);
        List<Integer> ans = findLeader(nums);
        int[] fin = new int[ans.size()];
        for(int i=ans.size()-1; i >= 0 ;i--) fin[ans.size()-i-1] = ans.get(i);
        System.out.println(Arrays.toString(fin));
    }
    public static List<Integer> findLeader (int[] nums) {
        int max= Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int i=nums.length-1; i >= 0; i--){
            if(nums[i] > max) {
                max = nums[i]; res.add(nums[i]);
            }
        }
        return res;
    }
}
