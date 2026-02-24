package TCS_NQT;
import java.util.*;
public class P5 {
    public static int findMax(List<Integer> nums, int k){
        int max_gain = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            int gain=0;
            for(int j=i; j<nums.size(); j+=k)
                gain += nums.get(j);
            max_gain = Math.max(max_gain,gain);
        }
        return max_gain;
    }
}
class solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bufferRead1 = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] bufferArray = bufferRead1.split(",");
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<bufferArray.length; i++) nums.add(Integer.parseInt(bufferArray[i]));

        int k = Integer.parseInt(sc.nextLine().trim());
        System.out.println(P5.findMax(nums,k));
    }
}
