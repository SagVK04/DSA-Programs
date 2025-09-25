import java.util.Objects;

public class Q1 {
    public static void main(String[] args) {
        String exp = "aabbccccdeefffgg";
        System.out.println(reduceExp(exp,exp.length()));
    }

    private static String  reduceExp(String exp, int n) {
        StringBuilder str = new StringBuilder(); int count = 1;
        if(Objects.equals(exp, ""))
            return "";
        for(int i=0;i<n-1;i++){
            if(exp.charAt(i) == exp.charAt(i+1))
                count++;
            else{
                str.append(exp.charAt(i));
                if(count!=1)
                    str.append(count);
                count = 1;
            }
        }
        str.append(exp.charAt(n-1));
        if(count!=1)
            str.append(count);
        return new String(str);
    }

}
