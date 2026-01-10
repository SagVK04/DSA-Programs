public class BadVersion {
    public int firstBadVersion(int n) {
        int lb=1; int ub=n; int result=n;
        while(lb <= ub){
            int mid = lb+(ub-lb)/2;
            if(isBadVersion(mid)) {
                ub = mid-1;
                result = mid;
            }
            else lb = mid+1;
        }
        return result;
    }

    //LeetCode In-built Function, not real implementation
    private boolean isBadVersion(int mid) {
        return true;
    }
}
