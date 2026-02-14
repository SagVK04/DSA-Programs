public class HappyNumber {
    public boolean isHappy(int n) {
        int f=n; int s=n;
        do{
            s = square(s); f = square(square(f));
        }while(s != f);
        return s==1;
    }
    public int square(int n){
        int res=0;
        while(n > 0){
            res += (n%10)*(n%10); n /= 10;
        }
        return res;
    }
}
