import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        System.out.println("Answer is: "+subSeq1Ascii(" ","ab"));
    }
    static void subSeq(String pro, String org){
        if(org.isEmpty()){
            System.out.println(pro);
            return;
        }
        char ch = org.charAt(0);
        subSeq(pro+ch,org.substring(1)); //Taking it
        subSeq(pro,org.substring(1)); //Ignoring it
    }

    static ArrayList<String> subSeq1(String pro, String org){
        if(org.isEmpty()){
            ArrayList<String> ans = new ArrayList<>(); ans.add(pro);
            return ans;
        }
        char ch = org.charAt(0);
        ArrayList<String> ans1 = subSeq1(pro+ch,org.substring(1)); //Taking it
        ArrayList<String> ans2 = subSeq1(pro,org.substring(1)); //Ignoring it
        ans1.addAll(ans2);
        return ans1;
    }
    static void subSeqAscii(String pro, String org){
        if(org.isEmpty()){
            System.out.println(pro);
            return;
        }
        char ch = org.charAt(0);
        subSeqAscii(pro+ch,org.substring(1)); //Taking it
        subSeqAscii(pro,org.substring(1)); //Ignoring it
        subSeqAscii(pro+(ch+0),org.substring(1)); //Printing ASCII Value
    }
    static ArrayList<String> subSeq1Ascii(String pro, String org){
        if(org.isEmpty()){
            ArrayList<String> ans = new ArrayList<>(); ans.add(pro);
            return ans;
        }
        char ch = org.charAt(0);
        ArrayList<String> first = subSeq1Ascii(pro+ch,org.substring(1)); //Taking it
        ArrayList<String> second = subSeq1Ascii(pro,org.substring(1)); //Ignoring it
        ArrayList<String> third = subSeq1Ascii(pro+(ch+0),org.substring(1)); //Ignoring it
        first.addAll(second); first.addAll(third);
        return first;
    }
}
