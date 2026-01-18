public class ReverseInteger {
    public int reverse(int x) {
        int digit = 0;
        while(x != 0){
            int rem = x%10;
            if(digit > Integer.MAX_VALUE/10 || digit < Integer.MIN_VALUE/10)
                return 0;
            digit = (digit*10) + rem;
            x /= 10;
        }
        return digit;
    }
}
