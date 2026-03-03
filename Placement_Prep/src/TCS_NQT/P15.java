package TCS_NQT;
import java.util.*;

public class P15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = Integer.parseInt(sc.nextLine().trim());
        int W = Integer.parseInt(sc.nextLine().trim());
        int[] res = findVehicles(W,V);
        if(res[0]==-1 || res[1]==-1 ){
            StringBuilder sb = new StringBuilder();
            sb.append('"');
            sb.append("INVALID INPUT");
            sb.append('"');
            System.out.println(sb);
        }
        else {
            System.out.println(res[0]);
            System.out.println(res[1]);
        }
    }
    public static int[] findVehicles(int tw, int tv){
        if(tv*4 == tw) return new int[]{0,tv};
        int tw_count=0; int fw_count=0;
        int excess_w = (Math.max(tv*4,tw) - Math.min(tv*4,tw));
        if(excess_w%2 != 0)
            return new int[]{-1,-1};
        tw_count = excess_w/2;
        fw_count = tv - tw_count;
        if(fw_count<0)
            return new int[]{-1,-1};
        return new int[]{tw_count,fw_count};
    }
}
