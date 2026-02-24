package TCS_NQT;
import java.util.*;

public class P8 {
    public static List<Integer> findUniques(int[] nums, int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        List<Integer> res = new ArrayList<>();
        for(int num : nums){ if(map.get(num) == 1) res.add(num); }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        String bufferReader = sc.nextLine().trim();
        String[] buffer_array = bufferReader.split(" ");
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = Integer.parseInt(buffer_array[i]);
        List<Integer> ans = findUniques(nums,n);
        if(ans.isEmpty()) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            for (Integer i : ans) { sb.append(i); sb.append(" "); }
            System.out.println(sb.toString().trim());
        }
    }
}

