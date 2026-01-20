import java.util.Arrays;

public class LongestCommonSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left=0; int right=0; int[] hash = new int[256]; int len=0;
        Arrays.fill(hash,-1);
        while(right < s.length()){
            if(hash[s.charAt(right)] != -1){
                if(hash[s.charAt(right)] >= left)
                    left = hash[s.charAt(right)]+1;
            }
            len = Math.max(len,right-left+1);
            hash[s.charAt(right)] = right; right++;
        }
        return len;
    }
}
