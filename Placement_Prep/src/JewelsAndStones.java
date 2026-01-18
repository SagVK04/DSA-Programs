import java.util.HashMap;

public class JewelsAndStones {
    public int numJewelsInStones1(String jewels, String stones) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<stones.length();i++){
            if(map.containsKey(stones.charAt(i)))
                map.put(stones.charAt(i),map.get(stones.charAt(i))+1);
            else
                map.put(stones.charAt(i),1);
        }
        for(int i=0;i<jewels.length();i++){
            if(map.containsKey(jewels.charAt(i))){
                count += map.get(jewels.charAt(i));
                map.remove(jewels.charAt(i));
            }
        }
        return count;
    }
}
