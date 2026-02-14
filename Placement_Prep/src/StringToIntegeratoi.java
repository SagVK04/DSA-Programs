import java.util.*;
public class StringToIntegeratoi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("s=");
        String input = sc.nextLine();
        System.out.println("Output: \n"+myAtoi(input));
    }
    public static int myAtoi(String s) {
        boolean isNegative = false;
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== ' ' && i>0){
                if(s.charAt(i-1) != ' ') break;
            }
            if(s.charAt(i) == ' ') continue;
            if((s.charAt(i) == '-' || s.charAt(i) == '+') && i>0){
                if(s.charAt(i-1) != ' ') break;
                else if(s.charAt(i) == '-'){
                    isNegative = true; continue;
                }
            }
            if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(s.charAt(i) == '-') isNegative = true;
            }
            else
            if(!Character.isDigit(s.charAt(i))) break;
            else
            if(Character.isDigit(s.charAt(i))){
                if(num <= ((Integer.MAX_VALUE-(s.charAt(i)-'0'))/10))
                    num = (num*10)+(s.charAt(i)-'0');
                else{
                    return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
            }
        }
        return isNegative?(num*(-1)):num;
    }
}
