public class LongestRepeatingCharacterReplace {
    public int characterReplacement(String s, int k) {
        int l=0; int r=0; int max_f=0; int maxlen=0;
        int[] map = new int[26];
        while(r < s.length()){
            map[s.charAt(r)-'A']++;
            max_f = Math.max(max_f,map[s.charAt(r)-'A']);
            if((r-l+1)-max_f > k){
                map[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-max_f <= k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
