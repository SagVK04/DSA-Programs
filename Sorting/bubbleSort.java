import java.util.Arrays;
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr={5,2,7,4,6};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j])
                    swapValues(arr,j-1,j);
            }
        }
    }
    static void swapValues(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
