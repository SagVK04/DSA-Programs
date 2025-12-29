import java.util.*;

public class Q13{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println("Maximum Signal Strength: "+max_signal(n,s));
    }
    public static int max_signal(int len, String str){
        int i=1; //Ignore First Index
        int j=1; int count = 1; int maxi = 1;
        while(i < len-1){ //Before last index
            if(str.charAt(i) - '0' == 1) {
                j = i+1;
                if(j < len - 1 && str.charAt(i) - '0' == str.charAt(j) - '0')
                    count += 1;
                else
                    count = 1;
            }
            maxi = Math.max(maxi,count);
            i++;
        }
        return maxi;
    }
}