public class MaxSubArrayProduct {
    public int maxProduct(int[] nums) {
        double max_mul = Integer.MIN_VALUE;
        double pref = 1; double suff = 1;
        for(int i=0;i<nums.length;i++){
            if(pref == 0) pref=1;
            if(suff == 0) suff=1;
            pref *= nums[i];
            suff *= nums[nums.length-i-1];
            max_mul = Math.max(max_mul,Math.max(pref,suff));
        }
        return (int)max_mul;
    }
}
