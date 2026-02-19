import java.util.Scanner;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("s = ");
        String input = sc.nextLine().trim().replaceAll("\"","");

        System.out.println("Output = ");
        System.out.println(firstUniqChar(input));
    }
    public static int firstUniqChar(String s) {
        if(s.length() <= 1) return 0;
        int[] frq = new int[26];
        for(int i=0;i<s.length();i++)
            frq[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++){
            if(frq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
