import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int lb_dist = 0; int ub_dist = stalls[stalls.length-1] - stalls[0];
        while(lb_dist <= ub_dist){
            int mid = lb_dist + (ub_dist-lb_dist)/2;
            if(findSafe(stalls,mid,k)) lb_dist = mid+1;
            else ub_dist = mid-1;
        }
        return ub_dist;
    }
    public static boolean findSafe(int[] stalls, int min_dist, int cows){
        int k=1; int last_place=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - last_place >= min_dist){
                last_place = stalls[i]; k = k+1;
            }
            if(k == cows) return true;
        }
        return false;
    }
}
