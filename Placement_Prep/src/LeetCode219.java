import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if( Math.abs(i - map.get(nums[i])) <= k)
                    return true;
                else
                    map.remove(nums[i]);
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> map = new HashSet<>();
        int l=0;
        for(int r=0; r<nums.length; r++){
            if(map.contains(nums[r])){
                return true;
            }
            map.add(nums[r]);
            if(r-l >= k){
                map.remove(nums[l]); l++;
            }
        }
        return false;
    }
}
