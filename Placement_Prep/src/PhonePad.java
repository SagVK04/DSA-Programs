import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        return pad2("",digits);
    }
    public static List<String> pad2(String pro, String org){
        if(org.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(pro);
            return ans;
        }
        int digit = org.charAt(0) - '0';
        int start_index = (digit - 2)*3;
        if(digit > 7) start_index += 1;
        int len = start_index + 3;
        if(digit == 7 || digit == 9) len += 1;
        List<String> fin = new ArrayList<>();
        for(;start_index < len; start_index++){
            char ch_add = (char)('a' + start_index);
            fin.addAll(pad2(pro+ch_add,org.substring(1)));
        }
        return fin;
    }
}
