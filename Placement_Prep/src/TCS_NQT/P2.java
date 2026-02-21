package TCS_NQT;
import java.util.*;
public class P2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine().trim();
        int key = Integer.parseInt(sc.nextLine().trim());
        if(key <= 0) System.out.println("INVALID INPUT");
        else System.out.println(returnCipher(original,key));
    }
    public static String returnCipher(String org, int key){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<org.length(); i++){
            if(org.charAt(i) >= 'A' && org.charAt(i) <= 'Z'){
                //Uppercase
                sb.append((char)((org.charAt(i)-'A'+key)%26 + 'A'));
            }
            else if(org.charAt(i) >= 'a' && org.charAt(i) <= 'z'){
                //Lowercase
                sb.append((char)((org.charAt(i)-'a'+key)%26 + 'a'));
            }
            else if(org.charAt(i) >= '0' && org.charAt(i) <= '9'){
                //Digit
                sb.append((char)((org.charAt(i)-'0'+key)%10 + '0'));
            }
            else sb.append(org.charAt(i));
        }
        return sb.toString();
    }
}
