package TCS_NQT;
import java.util.*;

public class P7 {
    public static String removeCharacters(String s1, String s2){
        if(s1.length() < s2.length()) return removeCharacters(s2,s1);
        //S1 > S2
        HashSet<Character> map = new HashSet<>();
        for(char c : s2.toCharArray()) map.add(c);
        StringBuilder sb = new StringBuilder();
        for(char c : s1.toCharArray()){
            if(!map.contains(c)) sb.append(c);
        }
        return sb.toString();
    }
}

class Solution7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine().trim();
        String str2 = sc.nextLine().trim();

        System.out.println(P7.removeCharacters(str1,str2));
    }
}