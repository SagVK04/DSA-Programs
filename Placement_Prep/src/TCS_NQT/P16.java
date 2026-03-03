package TCS_NQT;
import java.util.*;

public class P16 {
    public static void main(String[] args) {
        System.out.println("Input: ");
        Scanner sc = new Scanner(System.in);
        String bufferinput = sc.nextLine().trim();
        String[] buffer_array = bufferinput.split(" ");
        int L = Integer.parseInt(buffer_array[0]);
        int R = Integer.parseInt(buffer_array[1]);
        int result = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=L;i<=R;i++){
            if(i%7==0 && i%5!=0 && checkNotPalindrome(i) && isNotRepeated(i)){
                result=i;
                sb.append(i);
                sb.append(' ');
            }
        }
        System.out.println("Output: ");
        if(result == -1) System.out.println(result);
        else{
            String out = sb.toString().trim();
            System.out.println(out);
        }
    }
    public static boolean checkNotPalindrome(int num){
        int temp = num; int res_num=0;
        while(num > 0){
            res_num = (res_num*10) + num%10;
            num /= 10;
        }
        return !(res_num==temp);
    }
    public static boolean isNotRepeated(int num){
        HashMap<Integer,Integer> map = new HashMap<>();
        num = Math.abs(num);
        while(num > 0){
            int digit = num%10;
            if(map.containsKey(digit)) return false;
            else map.put(digit,1);
            num /= 10;
        }
        return true;
    }
}
