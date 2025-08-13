public class leetcode202 {
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        do{
            slow=addSquare(slow);
            fast=addSquare(addSquare(fast));
        }while(slow!=fast);
        if(slow==1)
            return true;
        return false;
    }
    int addSquare(int n){
        int res=0;
        while(n>0){
            int rem = n%10;
            res += rem*rem;
            n=n/10;
        }
        return res;
    }
}
