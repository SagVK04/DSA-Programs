import java.util.Arrays;
import java.util.HashMap;

public class RelativeSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: arr1){
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        int[] res = new int[arr1.length]; int index = 0;
        for(int num: arr2){
            int count = map.get(num);
            while(count > 0){
                res[index++] = num; count--;
            }
            map.remove(num);
        }
        int remsize=0;
        for(int i: map.values())
            remsize += i;
        int ind = 0; int[] rem = new int[remsize];
        for(int i : map.keySet()){
            int count = map.get(i);
            while(count > 0){
                rem[ind++] = i; count--;
            }
        }
        Arrays.sort(rem);
        for(int i: rem)
            res[index++] = i;
        return res;
    }
}
