import java.util.*; 
class selectionsort{
    public static void main(String[] args){
        int arr[]={4,3,2,1};
        selection(arr, arr.length, 0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr, int r, int c,int maxIndex){
        if(r==0)
                return;
        if(c<r){
                if(arr[c] > arr[maxIndex])
                    selection(arr, r, c+1,c);
                else
                    selection(arr, r, c+1,maxIndex);
        }else{
                int temp=arr[maxIndex];
                arr[maxIndex]=arr[r-1];
                arr[r-1]=temp;
                selection(arr, r-1, 0,0);
        }
    }
}