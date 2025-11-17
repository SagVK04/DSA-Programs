public class LongestCommonSubstring {
    public int lengthOfLongestSubstring(String s) {
        int l=0; int r=0; int[] hash = new int[256]; int maxlen=0;
        for(int i=0;i<256;i++)
            hash[i] = -1;
        while(r < s.length()){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l)
                    l = hash[s.charAt(r)] + 1;
            }
            int len = r-l+1; hash[s.charAt(r)] = r;
            maxlen = Math.max(len,maxlen); r++;
        }
        return maxlen;
    }
}
