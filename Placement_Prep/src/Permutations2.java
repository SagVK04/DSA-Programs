import java.util.*;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] map = new boolean[nums.length];
        List<List<Integer>> fin = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        HashMap<List<Integer>, List<Integer>> freq = new HashMap<>();
        find_permute(nums,map,ds,freq,fin);
        return fin;
    }
    public void find_permute(int[] nums, boolean[] map,
                             List<Integer> ds,
                             HashMap<List<Integer>, List<Integer>> freq,
                             List<List<Integer>> fin){
        for(int i=0; i<nums.length; i++){
            if(ds.size() == nums.length){
                if( !freq.containsKey(new ArrayList<>(ds)) ){
                    fin.add(new ArrayList<>(ds));
                    freq.put(new ArrayList<>(ds), new ArrayList<>(ds));
                }
                return;
            }
            if(!map[i]){
                ds.add(nums[i]); map[i] = true;
                find_permute(nums,map,ds,freq,fin);
                ds.removeLast(); map[i] = false;
            }
        }
    }
}
