public class prob1 {
    public static void main(String[] args) {
        //fun(5);
        //fun1(5);
        funboth(5);
    }
    static void fun(int n){
        if(n==0)
            return;
        System.out.println(n);
        fun(n-1);
    }
    static void fun1(int n){
        if(n==0){
            return;
        }
        fun(n-1); System.out.println(n);
    }
    static void funboth(int n){
        if(n==0){
            return;
        }
        System.out.println(n); funboth(n-1); System.out.println(n);
    }
}
