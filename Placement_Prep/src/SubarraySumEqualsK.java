import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); int count=0; int prefix=0;
        for(int num: nums){
            prefix += num;
            int rem = prefix - k;
            if(map.containsKey(rem)) count += map.get(rem);
            if(map.containsKey(prefix)) map.put(prefix,map.get(prefix)+1);
            else map.put(prefix,1);
        }
        return count;
    }
}
