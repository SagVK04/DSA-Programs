public class GuessNumber {
    public int guessNumber(int n) {
        int lb=1; int ub=n;
        while(lb <= ub){
            int mid = lb + (ub-lb)/2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == -1)
                ub = mid-1;
            else
                lb = mid+1;
        }
        return -1;
    }
    //LeetCode built-in function
    private int guess(int mid) {
        return 1;
    }
}
