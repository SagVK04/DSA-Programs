import java.util.*;
public class TwoStacks {
    static int twoStacks(int sum, int[] a, int[] b){
        return twoStacks(sum,a,b,0,0)-1;
    }
    private static int twoStacks(int sum,int[] a,int[] b,int sumSoFar,int count){
        if(sumSoFar>sum)
            return count;
        if (a.length==0 || b.length==0)
            return count;
        int ans1=twoStacks(sum,Arrays.copyOfRange(a,1,a.length),b,sumSoFar+a[0],count+1);
        int ans2=twoStacks(sum,a,Arrays.copyOfRange(b,1,b.length),sumSoFar+b[0],count+1);
        return Math.max(ans1,ans2);
    }

    public static void main(String[] args) {
        int[] arr1={4,2,4,6,1};
        int[] arr2={2,1,8,5};
        int maxSum=10;
        System.out.println("No. of maximum moves: "+twoStacks(maxSum,arr1,arr2));
    }
}
