package TCS_NQT;
import java.util.*;
public class P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String input_l = sc.nextLine().trim();
        int l = Integer.parseInt(input_l);

        System.out.println(findMaxCurtain(input,l));
    }
    public static int findMaxCurtain(String s, int l){
        int max=0;
        for(int i=0;i<s.length();i+=l){
            if(s.length()-i < l) break;
            int cur=0;
            for(int j=i;j<i+l;j++){
                if(s.charAt(j)=='a'){
                    cur += 1; max = Math.max(max,cur);
                }
            }
        }
        return max;
    }
}
