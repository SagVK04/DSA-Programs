package TCS_NQT;

import java.util.Scanner;

public class P24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        int M = Integer.parseInt(sc.nextLine().trim());
        int N = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Output: ");
        System.out.println(findTotalKriya(M,N));
    }
    public static int findTotalKriya(int M, int N){
        if(M == 1 || N == 1) return M*N;
        int unitKriya = 0;
        for(int i=N;i>1;i--){
            if(N%2 == 0){
                if(i%2 == 0) unitKriya += i;
            }
            else {
                if(i%2 != 0) unitKriya += i;
            }
        }
        return unitKriya*M;
    }
}
