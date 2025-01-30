import java.util.Arrays;
public class selectionSort {
    public static void main(String[] args) {
        int[] arr={5,2,7,4,6};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void select(int[] arr){
        for(int i=0; i< arr.length; i++){
            int last= arr.length-i-1;
            int max=getMaxIndex(arr,last);
            swapValues(arr,max,last);
        }
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    static int getMaxIndex(int[] arr,int b){
        int max=0;
        for(int i=0;i<=b;i++){
            if(arr[i]>arr[max])
                max=i;
        }
        return max;
    }
}
