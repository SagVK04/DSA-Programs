public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left=0; int right=s.length()-1;
        while(left < right){
            while(!Character.isLetterOrDigit(s.charAt(left))
                    && left<right) left++;
            while(!Character.isLetterOrDigit(s.charAt(right))
                    && left<right) right--;
            if(lowerCase(s.charAt(left)) != lowerCase(s.charAt(right)))
                return false;
            left++; right--;
        }
        return true;
    }
    public char lowerCase(char c){
        if(c >= 'A' && c <= 'Z')
            return (char)(c-65+97);
            //return (char)(c-'A'+'a');
        else return c;
    }
}
