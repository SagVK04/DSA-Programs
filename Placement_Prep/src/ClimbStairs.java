public class ClimbStairs {
    //Iteration
    public int climbStairs1(int n) {
        if (n <= 1) return 1;
        int first = 1;  // Ways to reach step 0
        int second = 1; // Ways to reach step 1
        for (int i = 2; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }
    //Recursion
    public int climbStairs2(int n){
        if(n <= 1) return 1;
        return climbStairs2(n-1) + climbStairs2(n-2);
    }
}
