import java.util.*;
public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ranges: ");
        int r1=sc.nextInt();
        int r2=sc.nextInt();
        if(r1 < 2 || r2 > 15)
            System.out.println("Enter between 2 and 15!");
        else {
            for(int i=r1+1;i<r2;i++){
                if(isPrime(i))
                    System.out.println(i);
            }
        }
    }
    private static boolean isPrime(int i){
        for(int j=2;j<=i/2;j++){
            if(i%j == 0) {
                return false;
            }
        }
        return true;
    }
}
