public class Arraysorted {
  public static void main(String[] args) {
    int[] sortedArray={1,2,4,8,9,7,12};
    System.out.println("Is the array sorted? "+sorted(sortedArray,0));
  }
  static boolean sorted(int[] arr, int index){
    if(index==arr.length-1)
      return true;
    return arr[index]<arr[index+1] && sorted(arr, index+1);
  }
}