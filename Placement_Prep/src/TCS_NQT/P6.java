package TCS_NQT;
import java.util.*;

public class P6 {
    public static int[] findRank(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ranks = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            ranks[i] = nums[i];
        Arrays.sort(nums); int rank=1;
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, rank++);
        }
        for(int i=0;i<ranks.length;i++)
            ranks[i] = map.get(ranks[i]);
        return ranks;
    }
}
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        String buffer_input = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] buffer_array = buffer_input.split(",");
        int[] nums = new int[buffer_array.length];
        for(int i=0;i<buffer_array.length;i++) nums[i] = Integer.parseInt(buffer_array[i]);
        System.out.println(Arrays.toString(P6.findRank(nums)));
    }
}
