import java.util.ArrayList;
import java.util.List;

public class Combination1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findComb(0,candidates,target,ans,ds);
        return ans;
    }
    public void findComb(int i, int[] arr, int tar,
                         List<List<Integer>> ans,
                         List<Integer> ds){
        if(i == arr.length){
            if(tar == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }
        if(arr[i] <= tar){
            ds.add(arr[i]);
            findComb(i,arr,tar - arr[i],ans,ds);
            ds.removeLast();
        }
        findComb(i+1,arr,tar,ans,ds);
    }
}
