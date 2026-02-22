import java.util.*;
public class MergeSortedArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input_1 = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] input_1_ar = input_1.split(",");
        int[] nums1 = new int[input_1_ar.length];
        for(int i=0;i<input_1_ar.length;i++) nums1[i] = Integer.parseInt(input_1_ar[i]);

        int m = Integer.parseInt(sc.nextLine().trim());

        String input_3 = sc.nextLine().trim().replaceAll("\\[|\\]","");
        String[] input_2_ar = input_3.split(",");
        int[] nums2 = new int[input_2_ar.length];
        for(int i=0;i<input_2_ar.length;i++) nums2[i] = Integer.parseInt(input_2_ar[i]);

        int n = Integer.parseInt(sc.nextLine().trim());

        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1; int j=n-1; int k=m+n-1; //->Only merge m+n elements
        while(i>=0 && j>=0){
            if(nums2[j] > nums1[i])
                nums1[k--] = nums2[j--];
            else
                nums1[k--] = nums1[i--];
        }
        while(i>=0)
            nums1[k--] = nums1[i--];
        while(j>=0)
            nums1[k--] = nums2[j--];
    }
}
