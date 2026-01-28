public class LongestPalindromLength {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;
        int[] map = new int[58];
        for(int i=0;i<s.length();i++)
            map[s.charAt(i) - 65]++;
        int len=0;
        for(int i=0;i<map.length;i++){
            if(map[i] != 0 && map[i]%2 == 0) len += map[i];
            else if(map[i] != 0 && map[i]%2 !=0){
                while(map[i] != 1){
                    len++;
                    map[i]--;
                }
            }
        }
        for(int num: map){
            if(num == 1){
                len++;
                break;
            }
        }
        return len;
    }
}
