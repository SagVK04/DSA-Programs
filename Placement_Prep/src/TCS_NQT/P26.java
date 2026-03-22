package TCS_NQT;
import java.util.*;

public class P26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String buffer1 = sc.nextLine().trim().replaceAll(" ","");
        String[] buffer2 = sc.nextLine().trim().split(",");
        int[] encrypted = new int[buffer2.length];
        for(int i=0;i<encrypted.length;i++)
            encrypted[i] = Integer.parseInt(buffer2[i]);

        System.out.println("Output: ");
        System.out.println(findKeyNumber(buffer1,encrypted));
    }
    public static String findKeyNumber(String code, int[] encrypted){
        int min = encrypted[0]; int max = encrypted[0];
        for(int num: encrypted){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int lb = max-26; int ub = min-1;
        int i=0; StringBuilder sb = new StringBuilder();
        for(;i<code.length();i++){
            if(code.charAt(i)-'A'+1>=lb && code.charAt(i)-'A'+1<=ub)
                break;
        }
        int key_val = code.charAt(i)-'A'+1;
        for(int num: encrypted){
            int org_key = num - key_val;
            char org_key_char = (char) ('A' + (org_key-1));
            sb.append(org_key_char); sb.append(" ");
        }
        return sb.toString().trim();
    }
}
