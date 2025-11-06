import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            int more = target - nums[i];
            if(map.containsKey(more))
                return new int[] {map.get(more),i};
            else
                map.put(cur,i);
        }
        //No value found
        return new int[]{};
    }
}
