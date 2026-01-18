public class MaxSubarrayAverage {
    public double findMaxAverage(int[] nums, int k) {
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
}
