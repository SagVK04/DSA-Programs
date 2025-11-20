public class FindPeakElement {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==1)
            return 0;
        else if(arr[0] > arr[1])
            return 0;
        else if(arr[n-1] > arr[n-2])
            return n-1;
        int lb=1; int ub=n-2;
        while(lb <= ub){
            int mid=(lb+ub)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return mid;
            else if(arr[mid+1] > arr[mid]) //mid is on increasing slope
                lb = mid+1;
            else if(arr[mid-1] > arr[mid] ) //mid is on decreasing slope
                ub = mid-1;
        }
        return -1;
    }
}
