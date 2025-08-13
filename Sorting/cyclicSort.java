import java.util.Arrays;
import java.util.Scanner;
public class cyclicSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4};
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i] != i+1) {
                swapValues(arr, i, arr[i] - 1);
                i = i;
            }
            else
                i++;
        }
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
