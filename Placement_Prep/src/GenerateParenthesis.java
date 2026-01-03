import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        find_parentheses("",n,res,0,0);
        return res;
    }
    public void find_parentheses(String ans,int len,
                                 List<String> res,
                                 int open_number,int close_number){
        if(ans.length() == 2*len){
            res.add(ans);
            return;
        }
        if(open_number < len) //Add '('
            find_parentheses(ans+"(",len,res,open_number+1,close_number);
        if(close_number < open_number) //Add ')' only when '(' is available
            find_parentheses(ans+")",len,res,open_number,close_number+1);
    }
}
