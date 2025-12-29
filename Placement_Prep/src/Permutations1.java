import java.util.ArrayList;
import java.util.List;

public class Permutations1 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] map = new boolean[nums.length];
        List<List<Integer>> fin = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        find_permute(nums,map,ds,fin);
        return fin;
    }
    public void find_permute(int[] nums, boolean[] map,
                             List<Integer> ds,
                             List<List<Integer>> fin){
        for(int i=0; i<nums.length; i++){
            if(ds.size() == nums.length){
                fin.add(new ArrayList<>(ds));
                return;
            }
            if(!map[i]){
                ds.add(nums[i]); map[i] = true;
                find_permute(nums,map,ds,fin);
                ds.removeLast(); map[i] = false;
            }
        }
    }
}
