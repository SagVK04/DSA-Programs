import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bufferRead1 = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] bufferArray = bufferRead1.split(",");
        int[] nums = new int[bufferArray.length];
        for(int i=0; i<bufferArray.length; i++) nums[i] = Integer.parseInt(bufferArray[i]);

        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        int max_len=0;
        HashSet<Integer> map = new HashSet<>();
        for(int i:nums) map.add(i);
        for(int i:map){
            //Found the first occurence
            if(!map.contains(i-1)){
                int cur=i; int count=1;
                //Now check for all its consecutive elements
                while(map.contains(cur+1)){
                    cur +=1; count +=1;
                }
                max_len = Math.max(max_len,count);
            }
        }
        return max_len;
    }
}
