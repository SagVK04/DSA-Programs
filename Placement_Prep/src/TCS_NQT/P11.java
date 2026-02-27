package TCS_NQT;
import java.util.*;

public class P11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int bufferinput = Integer.parseInt(sc.nextLine().trim());

        System.out.println(perfectNumber(bufferinput));
    }
    public static boolean perfectNumber(int n){
        int totalSum=0;
        for(int i=1;i<=n/2;i++){
            if(n%i == 0) totalSum += i;
        }
        return totalSum==n;
    }
}
