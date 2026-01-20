import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0)
                return false;
            else{
                int count = map.get(t.charAt(i));
                map.remove(t.charAt(i));
                map.put(t.charAt(i),count-1);
            }
        }
        return true;
    }
    public boolean isAnagramOpt(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count_array = new int[26];
        for(int i=0;i<s.length();i++){
            count_array[s.charAt(i) - 97] += 1;
            count_array[t.charAt(i) - 97] -= 1;
        }
        for(int count: count_array){
            if(count != 0) return false;
        }
        return true;
    }
}
