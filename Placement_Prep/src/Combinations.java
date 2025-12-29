import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> fin = new ArrayList<>();
        find_combine(1,n,k,ds,fin);
        return fin;
    }
    public void find_combine(int start, int n,int k,
                             List<Integer> ds,
                             List<List<Integer>> fin){
        if(ds.size() == k){
            fin.add(new ArrayList<>(ds));
            return;
        }
        for(int i=start;i<=n;i++){
            ds.add(i);
            find_combine(i+1,n,k,ds,fin);
            ds.removeLast();
        }
    }
}
