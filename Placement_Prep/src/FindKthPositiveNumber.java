public class FindKthPositiveNumber {
    public int findKthPositive1(int[] arr, int k) {
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= k) k++;
            else break;
        }
        return k;
    }
    public int findKthPositive2(int[] arr, int k) {
        int lb = 0;
        int ub = arr.length-1;
        /*for i-th index: missing = a[i] - i+1;
          more_left = k - missing;
          whenever ub < lb loop breaks out: take a[ub] element because it has less missing
          hence return ans = a[ub] + more_left
          substitute more_left: ans = k+ub+1 --> (i = ub)
        */
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] - (mid + 1) < k)
                lb = mid + 1;
            else
                ub = mid - 1;
        }
        return k + ub + 1;
    }
}
