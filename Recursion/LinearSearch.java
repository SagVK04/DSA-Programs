public class LinearSearch{
  public static void main(String [] args){
    int[] sortedArray={1,2,4,8,9,7,12,5,2,7,4,6};
    int target = 12;
    System.out.println("Item is found at "+(search(sortedArray, target, 0)+1)+" position");
  }
  static int search(int[] arr, int target, int index){
    if(index==arr.length)
      return -1;
    if(arr[index]==target)
      return index;
    return search(arr,target,index+1);
  }
}