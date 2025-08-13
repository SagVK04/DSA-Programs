import java.util.*;
public class leetcode35 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target)
                return i;
        }
        return insert(nums,target);
    }
    int insert(int[] nums, int target){
        int resIndex=0;
        List<Integer> A = new ArrayList<Integer>(nums.length);
        for(int a : nums)
            A.add(a);
        A.add(target);
        int[] a = new int[A.size()];
        for(int i=0; i<A.size();i++)
            a[i] = A.get(i);
        Arrays.sort(a);
        for(int i=0; i<a.length;i++){
            if(target == a[i])
                resIndex = i;
        }
        return resIndex;
    }
}
