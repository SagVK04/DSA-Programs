package TCS_NQT;
import java.util.*;

public class P13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String bufferinput = sc.nextLine().trim();
        String[] bufferArray = bufferinput.split(" ");
        int a = Integer.parseInt(bufferArray[0]);
        int b = Integer.parseInt(bufferArray[1]);

        System.out.println((a/findGCD1(a,b)) * b);
    }
    public static int findGCD(int a, int b){
        if(b==0) return a;
        return findGCD(b,a%b);
    }
    public static int findGCD1(int a, int b){
        int min = Math.min(a,b);
        for(int i=min;i>0;i--){
            if(a%i==0 && b%i==0) return i;
        }
        return 1;
    }
}
