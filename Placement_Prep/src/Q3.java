import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of guests: ");
        int n = sc.nextInt();
        System.out.println("Enter no. of balloons requested: ");
        int[] req = new int[n];
        for(int i=0;i<n;i++)
            req[i] = sc.nextInt();
        int total = 0;
        for(int i=0;i<n;i++){
            if(req[i] <= 5)
                total += req[i];
            else
                total += req[i]*2;
        }
        System.out.println("Total balloons: "+total);
    }
}
