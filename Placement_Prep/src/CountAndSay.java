import java.util.Scanner;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n = ");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Output = \""+countAndSay2(n)+"\"");
    }
    public static String countAndSay1(int n) {
        return findRLE(n);
    }
    public static String findRLE(int n){
        if(n == 1) return "1";
        String rle = findRLE(n-1);
        return findNewRLE(rle);
    }
    public static String countAndSay2(int n) {
        if(n == 1) return "1";
        String current = "1";
        for(int i=1;i<n;i++)
            current = findNewRLE(current);
        return current;
    }
    public static String findNewRLE(String s){
        StringBuilder ans = new StringBuilder();
        int i=0;
        while(i<s.length()){
            int count = 1;
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                i++; count++;
            }
            ans.append(count).append(s.charAt(i));
            i++;
        }
        return ans.toString();
    }
}
