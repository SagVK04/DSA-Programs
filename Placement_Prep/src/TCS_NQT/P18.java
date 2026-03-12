package TCS_NQT;

import java.util.Scanner;

public class P18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String bufferinput = sc.nextLine().trim();
        int res_i = findChar(bufferinput);

        System.out.println("Output: ");
        if(res_i == -1) System.out.println(res_i);
        else System.out.println(bufferinput.charAt(res_i));
    }
    public static int findChar(String s){
        if(s.length()<=1) return 0;
        int[] char_map = new int[26];
        for(int i=0;i<s.length();i++) char_map[s.charAt(i)-'a']++;
        int ind=-1;
        for(int i=0;i<s.length();i++) {
            if(char_map[s.charAt(i)-'a'] == 1) return i;
        }
        return ind;
    }
}
