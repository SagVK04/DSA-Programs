import java.util.Scanner;

public class PermutationInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String input = sc.nextLine().
                trim().replaceAll("\"","");
        String[] input_str = input.split(" ");
        String s1 = input_str[0]; String s2 = input_str[1];

        System.out.print("Output: ");
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] map1 = new int[26]; int[] map2 = new int[26];
        for(int i=0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++; map2[s2.charAt(i)-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(map1[i] == map2[i]) matches += 1;
        }
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            if(matches == 26) return true;

            map2[s2.charAt(r)-'a'] += 1;
            if(map2[s2.charAt(r)-'a'] == map1[s2.charAt(r)-'a'])
                matches += 1;
            else if(map1[s2.charAt(r)-'a']+1 == map2[s2.charAt(r)-'a'])
                matches -= 1;

            map2[s2.charAt(l)-'a'] -= 1;
            if(map2[s2.charAt(l)-'a'] == map1[s2.charAt(l)-'a'])
                matches += 1;
            else if(map1[s2.charAt(l)-'a']-1 == map2[s2.charAt(l)-'a'])
                matches -= 1;
            l++;
        }
        return matches==26;
    }
}
