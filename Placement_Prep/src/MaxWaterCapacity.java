public class MaxWaterCapacity {
    public int maxArea(int[] height) {
        int lb=0; int ub=height.length-1;
        int maxWater=0;
        while(lb < ub){
            if(height[lb] < height[ub]){
                maxWater =
                        Math.max(findWater(height[lb],Math.abs(ub-lb)),maxWater);
                lb++;
            }
            else{
                maxWater =
                        Math.max(findWater(height[ub],Math.abs(ub-lb)),maxWater);
                ub--;
            }
        }
        return maxWater;
    }
    public int findWater(int height, int width){
        return height*width;
    }
}
