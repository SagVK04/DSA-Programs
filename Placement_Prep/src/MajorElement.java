import java.util.HashMap;
/*
Core Idea (Cancellation Logic)->
	1. Majority element appears more than all other elements combined
	2. Pair different elements and cancel them
	3. Majority element will remain at the end
*/
public class MajorElement {
    public int majorityElement1(int[] nums) {
        if(nums.length == 1) return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>(); int i=0;
        for(; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])+1 > (nums.length/2)) return nums[i];
                else map.put(nums[i],map.get(nums[i])+1);
            }
            else map.put(nums[i],1);
        }
        return -1;
    }
    public int majorityElement2(int[] nums) {
        int count=0; int start=nums[0];
        for(int num: nums){
            if(count == 0) start = num; //Change start of pair
            if(start == num) count++; //Increase group length is matching found
            else count--; //Decrease group length
        }
        return start;
    }
}
