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
        int max=0; int cur=0;
        for(int i=0;i<l;i++) cur++;
        max = Math.max(max,cur);
        for(int i=l;i<s.length();i++){
            if(s.charAt(i) == 'a') cur += 1;
            if(s.charAt(i-l) == 'a') cur -= 1;
            max = Math.max(max,cur);
        }
        return max;
    }
}
