import java.util.Arrays;

public class QS {
    public static void main(String[] args) {
        int[] arr = {5,2,7,4,6};
        quicksort(arr,0, arr.length-1);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }
    static void quicksort(int[] arr, int low, int hi){
        if(low>=hi){
            return;
        }
        int s = low; int e = hi; int m = (e-s)+s/2; int pivot = arr[m];
        while(s<=e){
            //if it's already sorted it will not swap
            while(arr[s]<pivot)
                s++;
            while (arr[e]>pivot)
                e--;
            //swap only both violated items are also in wrong sides
            if(s<e){
                int temp=arr[e]; arr[e]=arr[s]; arr[s]=temp;
                s++;e--;
            }
        }
        //pivot is in its correct index so sort two halves
        quicksort(arr,low,e);
        quicksort(arr,s,hi);
    }
}
