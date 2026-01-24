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
    public static int findMax(int[] stalls){
        int max=Integer.MIN_VALUE;
        for(int num: stalls)
            max = Math.max(max,num);
        return max;
    }
    public static int findMin(int[] stalls){
        int min=Integer.MAX_VALUE;
        for(int num: stalls)
            min = Math.min(min,num);
        return min;
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
