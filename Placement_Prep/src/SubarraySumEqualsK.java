import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); map.put(0,1);
        int count=0; int prefix=0;
        for(int num: nums){
            prefix += num;
            int rem = prefix - k;
            if(map.containsKey(rem)) count += map.get(rem);
            if(map.containsKey(prefix)) map.put(prefix,map.get(prefix)+1);
            else map.put(prefix,1);
        }
        return count;
    }
    public int subarraySum2(int[] nums, int k) {
        int count=0; int preSum=0;
        HashMap<Integer,Integer> map = new HashMap<>(); map.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            if(map.containsKey(preSum-k)) count += map.get(preSum-k);
            if(map.containsKey(preSum)) map.put(preSum,map.get(preSum)+1);
            else map.put(preSum,1);
        }
        return count;
    }
}
