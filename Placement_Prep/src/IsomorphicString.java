public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 1) return true;
        int[] index_occur_1 = new int[256];
        int[] index_occur_2 = new int[256];
        for(int i=0;i<s.length();i++){
            if(index_occur_1[s.charAt(i)] != index_occur_2[t.charAt(i)])
                return false;
            index_occur_1[s.charAt(i)] = s.length() - i;
            index_occur_2[t.charAt(i)] = t.length() - i;
        }
        return true;
    }
}
