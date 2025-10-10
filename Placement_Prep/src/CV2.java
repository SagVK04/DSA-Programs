import java.util.*;
public class CV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String number = String.valueOf(n);
        String pattern = sc.next();
        StringBuilder res = new StringBuilder();
        if(number.length() != pattern.length())
            return;
        else {
            for(int i=0;i<number.length();i++){
                Character resFun = mirror(number.charAt(i),pattern.charAt(i));
                if(resFun != null)
                    res.append(resFun);
            }
        }
        char[] resSt = res.toString().toCharArray();
        Arrays.sort(resSt);
        String resultString = new String(resSt);
        System.out.println(Long.parseLong(resultString));
    }
    public static Character mirror(char digit, char dir){
        if(dir == 'S')
            return digit;
        if(dir == 'L' || dir == 'R'){
            if(digit == '0' || digit == '1' || digit == '8')
                return digit;
            else
                return null;
        }
        if(dir == 'U'){
            if(digit == '0' || digit == '1' || digit == '8')
                return digit;
            else if(digit == '9')
                return '6';
            else
                return null;
        }
        if(dir == 'D'){
            if(digit == '0' || digit == '1' || digit == '8')
                return digit;
            else if(digit == '2')
                return '5';
            else if(digit == '5')
                return '2';
            else
                return null;
        }
        return null;
    }
}
