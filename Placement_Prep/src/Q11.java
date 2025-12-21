import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l1_cap = sc.nextInt();
        int l1_pri = sc.nextInt();
        int l2_cap = sc.nextInt();
        int l2_pri = sc.nextInt();

        int min = Integer.MAX_VALUE;
        for(int i=0; l1_cap*i<=n;i++){
            int rem = n - l1_cap*i;
            if(rem % l2_cap == 0){
                int price = l1_pri*i + l2_pri*(rem/l2_cap);
                min = Math.min(price,min);
            }
        }
        System.out.println(min);
    }
}
