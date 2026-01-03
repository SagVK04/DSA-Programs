public class FindPower {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            x = 1/x; N = -N;
        }
        return findPow(x,N);
    }
    public double findPow(double x, long n){
        if(n == 0) return 1.0;
        double t = findPow(x,n/2);
        if(n%2 == 0) return t*t;
        else return t*t*x;
    }
}
