import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
    public int[][] merge(int[][] inter) {
        if(inter.length == 1) return inter;
        Arrays.sort(inter,(a, b)->Integer.compare(a[0],b[0]));
        int f = inter[0][0]; int s = inter[0][1];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=1;i<inter.length;i++){
            if(inter[i][0] <= s){
                s = Math.max(s, inter[i][1]);
            }
            else{
                list.add(new int[]{f,s});
                f=inter[i][0]; s=inter[i][1];
            }
        }
        list.add(new int[]{f,s});
        return list.toArray(new int[list.size()][]);
    }
}
