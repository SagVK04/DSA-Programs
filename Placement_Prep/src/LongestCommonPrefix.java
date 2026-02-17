import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.println("strs= ");
        String input = sc.nextLine().trim();
        input = input.substring(1,input.length()-1).replaceAll("\"","");
        String[] input_str = input.split(",");
        System.out.println(Arrays.toString(input_str));

        //Problem Solving
        String res = longestCommonPrefix(input_str);

        //Output Presentation Format
        StringBuilder fin = new StringBuilder();
        fin.append("\"");
        for(int i=0;i<res.length();i++)
            fin.append(res.charAt(i));
        fin.append("\"");
        System.out.println("Output= "+fin);
    }
    public static String longestCommonPrefix(String[] strs) {
        String res="";
        for(int i=0; i<strs[0].length(); i++){
            for(int string=1 ; string<strs.length; string++){
                if(i == strs[string].length() ||
                        strs[string].charAt(i) != strs[0].charAt(i))
                    return res;
            }
            res += strs[0].charAt(i);
        }
        return res;
    }
}
