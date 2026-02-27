package TCS_NQT;

import java.util.Scanner;

public class P10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        System.out.println(checkArmstrong(n));
    }
    public static boolean checkArmstrong(int n){
        int power = (Integer.toString(n)).length();
        int newNum = 0; int curNum = n;
        while(n>0){
            newNum += (int) Math.pow(n%10,power);
            n /= 10;
        }
        return newNum == curNum;
    }
}
