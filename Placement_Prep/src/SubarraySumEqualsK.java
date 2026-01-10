import java.util.HashMap;

public class SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            int prefixSum = 0; int count = 0;
            for(int i: nums){
                prefixSum += i;
                int rem = prefixSum - k;
                if(map.containsKey(rem))
                    count += map.get(rem);
                map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
            }
            return count;
        }
    }
}
