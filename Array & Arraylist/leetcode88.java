class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}; 
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        for(int a: nums1)
            System.out.println(a);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n-1; int j = m-1; int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums2[i] > nums1[j]){
                nums1[k--] = nums2[i--]; 
            }
            else{
                nums1[k--] = nums1[j--];
            }
        }
        while(i>=0)
            nums1[k--] = nums2[i--];
        while(j>=0)
            nums1[k--] = nums1[j--];
    }
}