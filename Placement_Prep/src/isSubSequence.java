public class isSubSequence {
    public boolean isSubsequence(String s, String t) {
        int valid_len = 0;
        for(int i=0; i<t.length(); i++){
            if(s.length() == valid_len) return true;
            if(t.charAt(i) == s.charAt(valid_len))
                valid_len++;
        }
        return valid_len == s.length();
    }
}
