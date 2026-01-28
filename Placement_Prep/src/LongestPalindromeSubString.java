public class LongestPalindromeSubString {
    int left_store=0; int right_store=0;
    int maxLen = 0;
    public String longestPalindrome(String s){
        if(s.length() <= 1) return s;
        for(int i=0;i<s.length();i++){
            findPalEven(s,i,i+1);
            findPalOdd(s,i,i);
        }
        //Same as finPalEven(), only lb=ub=i
        return s.substring(left_store,right_store+1);
    }
    public void findPalEven(String s, int lb, int ub){
        while(lb>=0 && ub<s.length() && s.charAt(lb) == s.charAt(ub)){
            if(ub-lb+1 >= maxLen){
                maxLen = ub-lb+1;
                left_store = lb; right_store = ub;
            }
            lb--; ub++;
        }
    }
    public void findPalOdd(String s, int lb, int ub){
        while(lb>=0 && ub<s.length() && s.charAt(lb) == s.charAt(ub)){
            if(ub-lb+1 >= maxLen){
                maxLen = ub-lb+1;
                left_store = lb; right_store = ub;
            }
            lb--; ub++;
        }
    }
}
