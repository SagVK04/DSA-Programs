public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] ascii = new int[26];
        for(int i=0; i<s.length(); i++)
            ascii[s.charAt(i) - 97] += 1;
        for(int i=0; i<s.length(); i++){
            if(ascii[s.charAt(i) - 97] == 1) return i;
        }
        return -1;
    }
}
