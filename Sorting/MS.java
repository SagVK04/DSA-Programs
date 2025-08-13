import java.util.Arrays;

public class MS {
    public static void main(String[] args) {
        int[] arr = {5,2,7,4,6};
        //System.out.println("Sorted array is: "+Arrays.toString(mergesort(arr)));
        mergesortInPlace(arr,0, arr.length-1);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }
    static int[] mergesort(int[] arr){
        if(arr.length==1)
            return arr;
        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid)); //Copies left subarray
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length)); //Copies right subarray
        return merge(left,right);
    }
    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length+ second.length];
        int i=0; int j=0; int k=0;
        while(i< first.length && j< second.length){
            if(first[i]<second[j]){
                mix[k]=first[i]; i++;
            }
            else{
                mix[k]=second[j]; j++;
            }
            k++;
        }
            //First array is finished copy remaining of second array
            while (j != second.length){
                mix[k]=second[j]; j++; k++;
            }
            //Second array is finished copy reimagining of first array
            while (i != first.length){
                mix[k]=first[i]; i++; k++;
            }
        return mix;
    }


    static void mergesortInPlace(int[] arr,int s, int e){
        if(e-s==1)
            return;
        int mid = (s + e) / 2;
        mergesortInPlace(arr,s,mid); //left subarray
        mergesortInPlace(arr,mid,e); //right subarray
        mergeInPlace(arr,s,mid,e); //merging both
    }
    static void mergeInPlace(int[] arr,int s,int mid,int e){
        int[] mix = new int[e-s];
        int i=s; int j=mid; int k=0;
        while(i<mid && j<e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i]; i++;
            }
            else{
                mix[k]=arr[j]; j++;
            }
            k++;
        }
        //First array is finished copy remaining of second array
            while (j < e){
                mix[k]=arr[j]; j++; k++;
            }
        //Second array is finished copy reimagining of first array
            while (i < mid) {
                mix[k] = arr[i];
                i++; k++;
            }
        //Copy new array elements to the first array
        for(k=0;k<mix.length;k++){
            arr[s+k]=mix[k];
        }
    }
}
