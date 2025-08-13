import java.util.*;
class ceilingNumber{
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your target: ");
        int target = sc.nextInt();
        sc.close();
        System.out.println("Ceiling of "+target+" is: "+findCeiling(arr,target));
        System.out.println("Floor of "+target+" is: "+findFloor(arr,target));
    }
    static int findCeiling(int[] a, int target){
        int start=0; int end=a.length-1;
        if(target > a[a.length-1])
            return -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < a[mid])
                end = mid - 1;
            else if(target > a[mid])
                start = mid + 1;
            else 
                return a[mid];
        }
        return a[start];
    }
    static int findFloor(int[] a, int target){
        int start=0; int end=a.length-1;
        if(target > a[a.length-1])
            return -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < a[mid])
                end = mid - 1;
            else if(target > a[mid])
                start = mid + 1;
            else 
                return a[mid];
        }
        return a[end];
    }
}
