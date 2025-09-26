import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();
        String str1 = "";
        String str2 = "";
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '#')
                str1 += str.charAt(i);
            else
                str2 += str.charAt(i);
        }
        System.out.println("Final Output: "+str1.concat(str2));
    }
}
