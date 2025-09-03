import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s1 = "dbcefgggy";
        String s2 = "bcagyesqt";
        System.out.println("After removing duplicates :"+removeduplicates(s1,s2));
    }
    static String removeduplicates(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(doesnotExist(s1.charAt(i),s2,0))
                sb.append(s1.charAt(i));
        }

        for(int i=0;i<s2.length();i++){
            if(doesnotExist(s2.charAt(i),s1,0))
                sb.append(s2.charAt(i));

        }
        char[] ch = sb.toString().toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    static boolean doesnotExist(char a,String s,int i){
        if(i == s.length())
            return true;
        if(a==s.charAt(i))
            return false;
        return doesnotExist(a,s,i+1);
    }
}
