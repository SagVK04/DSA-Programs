import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        System.out.println("Month: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if(input < 1 || input > 12)
            System.out.println("Invalid Month");
        if(input <= 5 && input >= 3)
            System.out.println("Season: Spring");
        if(input <= 8 && input >= 6)
            System.out.println("Season: Summer");
        if(input <= 11 && input >= 9)
            System.out.println("Season: Autumn");
        if(input < 3 || input == 12)
            System.out.println("Season: Winter");
    }
}
