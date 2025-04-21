public class rotated_binary {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println("Item found at position: "+search(arr,2,0,arr.length-1));
    }
    static int search(int[] arr, int target,int s,int e){
        if(s>e)
            return -1;
        int m = s + (e-s)/2;
        if(arr[m] == target)
            return m;
        if(arr[s] <= arr[m]){ //first half of the array is sorted
            if(target >= arr[s] && target<=arr[m]) //If key is in first half
                return search(arr,target,s,m-1);
            else
                return search(arr,target,m+1,e); //If key is in second half
        }
        if(target >= arr[m] && target <=arr[e]) //second half is sorted and target is in that second half
            return search(arr,target,m+1,e);
        else
            return search(arr,target,s,m-1); //larger values are rotated
    }
}
