import java.util.ArrayList;
import java.util.HashMap;
/*
1. Determine shorter array and count frequency of each
2. Find each element in longer array, if found add in arraylist(Arraylist contains only common elements)
3. After adding array list, remove that element with current count, push that same element
   with count-1 value in map
4. Copy all list elements to res array
*/
public class InterSectionofArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        //nums1 < nums2
        if(nums1.length > nums2.length)
            return intersect(nums2,nums1);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums1){
            if(map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num) && map.get(num)>0){
                list.add(num);
                int count = map.get(num);
                map.remove(num);
                map.put(num,count-1);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}
