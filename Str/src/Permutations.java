import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        //permutations("","abc");
        System.out.println("After permutation: "+permutationsReturn("","abc"));
        System.out.println("No of permutations: "+permutationsCount("","abc"));
    }
    static void permutations(String pro, String org){
        if(org.isEmpty()){
            System.out.println(pro);
            return;
        }
        char ch = org.charAt(0);
        for(int i=0; i<=pro.length();i++){
            String f = pro.substring(0,i);
            String s = pro.substring(i,pro.length());
            permutations(f+ch+s,org.substring(1));
        }
    }
    static ArrayList<String> permutationsReturn(String pro, String org){
        if(org.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        char ch = org.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<=pro.length();i++){
            String f = pro.substring(0,i);
            String s = pro.substring(i,pro.length());
            ans.addAll(permutationsReturn(f+ch+s,org.substring(1)));
        }
        return ans;
    }
    static int permutationsCount(String pro, String org){
        if(org.isEmpty()){
            return 1;
        }
        char ch = org.charAt(0); int count = 0;
        for(int i=0; i<=pro.length();i++){
            String f = pro.substring(0,i);
            String s = pro.substring(i,pro.length());
            count = count + permutationsCount(f+ch+s,org.substring(1));
        }
        return count;
    }
}
