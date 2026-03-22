package TCS_NQT;

import java.util.Scanner;

public class P25 {
    static int maxlen = 0;
    static int ls = 0; static int rs = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String input = sc.nextLine().trim().replaceAll("\"","");

        System.out.println("Output: ");
        System.out.println(findSacredString(input));
    }
    public static String findSacredString(String s){
        if(s.length() <= 1) return s;
        for(int i=0;i<s.length();i++){
            findOddPal(s,i,i);
            findEvenPal(s,i,i+1);
        }
        return s.substring(ls,rs+1);
    }
    public static void findOddPal(String s,int lb,int ub){
        while(lb>=0 && ub<s.length() && s.charAt(lb) == s.charAt(ub)){
            if(ub-lb+1 > maxlen){
                maxlen = ub-lb+1;
                ls = lb; rs = ub;
            }
            lb--; ub++;
        }
    }
    public static void findEvenPal(String s,int lb,int ub){
        while(lb>=0 && ub<s.length() && s.charAt(lb) == s.charAt(ub)){
            if(ub-lb+1 > maxlen){
                maxlen = ub-lb+1;
                ls = lb; rs = ub;
            }
            lb--; ub++;
        }
    }
}
