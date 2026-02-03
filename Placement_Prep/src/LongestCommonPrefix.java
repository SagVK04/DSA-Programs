public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res="";
        for(int i=0; i<strs[0].length(); i++){
            for(int string=0; string<strs.length; string++){
                if(i == strs[string].length() ||
                        strs[string].charAt(i) != strs[0].charAt(i))
                    return res;
            }
            res += strs[0].charAt(i);
        }
        return res;
    }
}
