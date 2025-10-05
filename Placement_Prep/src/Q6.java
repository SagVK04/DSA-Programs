import java.util.*;
public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int input = sc.nextInt();
        if(input>=0 && isPali1(input))
            System.out.println("Palindrome");
        else if(input < 0 )
            System.out.println("Invalid Number");
        else
            System.out.println("Not Palindrome");
    }

    private static boolean isPali1(int input) {
        String st = String.valueOf(input);
        int i = 0; int j = st.length()-1;
        while(i != j){
            if(st.charAt(i) == st.charAt(j)){
                i++; j--;
            }
            else
                return false;
        }
        return true;
    }

    private static boolean isPali(int input){
        int sum = 0; int temp = input;
        while(input > 0){
            int r = input % 10;
            sum = sum*10 + r;
            input /= 10;
        }
        return sum == temp;
    }
}
