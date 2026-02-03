public class MaxSubarrayAverage {
    public double findMaxAverage1(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<k; i++) //First Window
            sum += nums[i];
        int max = sum;
        //From next window: sum = sum + a[i] - a[i-k]
        for(int i=k; i<nums.length; i++){
            sum = sum+nums[i]-nums[i-k];
            max = Math.max(sum,max);
        }
        return (double)max/k;
    }
    public double findMaxAverage2(int[] nums, int k) {
        int i=0; int sum=0; int max=Integer.MIN_VALUE;
        while(i < nums.length){
            if(i < k) sum += nums[i];
            else sum = sum + nums[i] - nums[i-k];
            if(i >= k-1)
                max = Math.max(max,sum);
            i++;
        }
        return (double)max/k;
    }
}
