import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of days: ");
        int days = sc.nextInt();
        System.out.println("Enter no. of flower beds: ");
        int n = sc.nextInt();
        System.out.println("Enter no. of flowers in each bed: ");
        int[] flower = new int[n];
        for (int i = 0; i < n; i++)
            flower[i] = sc.nextInt();

        for(int ind=1;ind<=days;ind++){
            for(int fl=0; fl<n;fl++)
                flower[fl] *= 2;
        }
        int total = 0;
        for(int fl=0;fl<n;fl++)
            total += flower[fl];
        System.out.println("Total flowers: "+total);
    }
}
