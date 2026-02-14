import java.util.*;
public class Q18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //4,9
        String input = sc.nextLine();
        String[] input_str = input.split(",");
        int a = Integer.parseInt(input_str[0]);
        int b = Integer.parseInt(input_str[1]);
        int sum=0;
        for(int i=a;i<=b;i++)
            sum += (i*i*i);
        System.out.print(sum);
    }
}
