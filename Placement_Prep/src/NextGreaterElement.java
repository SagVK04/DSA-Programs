import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length]; Stack<Integer> st = new Stack<>();
        for(int i=0; i<nge.length; i++)
            nge[i] = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++)
            map.put(nums1[i],i);
        for(int i=0; i<nums2.length; i++){
            while( !st.isEmpty() && st.peek() <= nums2[i]){
                int val = st.pop(); //Remove small element
                int ind = map.get(val); //Find its index
                nge[ind] = nums2[i]; /*As nums2[i] > st.top() element,nums2[i] will be the next
                greater element of st.top(),
                as per the result, find index of st.top() from hashmap,
                st.top() will be be surely in nums1,
                place on the same index of result array as the next greater element*/
            }
            if(map.containsKey(nums2[i]))
                st.push(nums2[i]); /*Only if element exists in nums1,
                then only its next greater element exists,
                then only push in stack*/
        }
        return nge;
    }
}
