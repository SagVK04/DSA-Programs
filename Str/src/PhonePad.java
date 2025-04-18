import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        //pad("","12");
        //System.out.println("Combinations: "+pad1("","12"));
        System.out.println("Combinations: "+pad2("",""));
    }
    static void pad(String pro, String org){
        if(org.isEmpty()){
            System.out.println(pro);
            return;
        }
        int digit = org.charAt(0)-'0'; //converts '1' into 1
        for(int i=(digit-1)*3; i<(digit)*3;i++){
            char chtoAdd = (char)('a'+i);
            pad(pro+chtoAdd,org.substring(1));
        }
    }
    static ArrayList<String> pad1(String pro, String org){
        if(org.isEmpty()){
            ArrayList<String> res = new ArrayList<>();
            res.add(pro);
            return res;
        }
        int digit = org.charAt(0)-'0'; //converts '1' into 1
        ArrayList<String> fin = new ArrayList<>();
        for(int i=(digit-1)*3; i<(digit)*3;i++){
            char chtoAdd = (char)('a'+i);
            fin.addAll(pad1(pro+chtoAdd,org.substring(1)));
        }
        return fin;
    }
    static List<String> pad2(String pro, String org){
        if(org.isEmpty()){
            List<String> res = new ArrayList<>();
            res.add(pro);
            return res;
        }
        int digit = org.charAt(0)-'0'; //converts '1' into 1
        int i = (digit-2)*3;
        if(digit>7)
            i += 1;
        int length = i+3;
        if(digit == 7 || digit == 9)
            length += 1;
        List<String> fin = new ArrayList<>();
        for(; i<length;i++){
            char chtoAdd = (char)('a'+i);
            fin.addAll(pad2(pro+chtoAdd,org.substring(1)));
        }
        return fin;
    }
}
