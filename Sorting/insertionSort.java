import java.util.Arrays;
public class insertionSort {
    public static void main(String[] args) {
        int[] arr={5,2,7,4,6,1,9,3,8,0};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insert(int[] arr){
        for(int i=0; i< arr.length-1; i++){
            int j=i+1;
            while(j>0){
                if(arr[j]<arr[j-1]){
                   swap(arr,j,j-1);
                   j--;
                }
                else
                    break;
            }
        }
    }
    static void swap(int[] arr,int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];arr[b]=temp;
    }
}
