public class OptimalStringPartition {
    public int partitionString(String s) {
        int count=1; boolean[] map = new boolean[26];
        for(char ch: s.toCharArray()){
            if(!map[ch-'a']) map[ch-'a'] = true;
            else{
                count++;
                map = new boolean[26]; map[ch-'a'] = true;
            }
        }
        return count;
    }
}
