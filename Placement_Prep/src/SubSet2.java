import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(arr);
        outer.add(new ArrayList<>()); int start=0; int end=0;
        for(int i=0;i< arr.length;i++){
            start = 0;
            //if current and previous item are same then s=e+1
            if(i>0 && arr[i] == arr [i-1])
                start = end + 1;
            end = outer.size()-1;
            for(int j=start; j<=end; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j)); //Copy of the j-th list in the outer list
                internal.add(arr[i]); outer.add(internal);
            }
        }
        return outer;
    }
}
