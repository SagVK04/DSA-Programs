import java.util.*;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> map = new HashSet<>();
        int l=0;
        for(int r=0; r<nums.length; r++){
            //Check for previous window
            if(map.contains(nums[r])) return true;
            map.add(nums[r]); //Add current index element
            if(r-l >= k) //If window size is >= k remove leftmost 'l' element
                map.remove(nums[l]); l++;//Move 'l' ptr
        }
        return false;
    }
}
