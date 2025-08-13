import java.util.*;
public class search2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {23,4,1,5},
            {18,12,3,9},
            {78,99,34,56},
            {18,12,22,41},
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your target value: ");
        int target = sc.nextInt();
        System.out.println(Arrays.toString(search(arr,target)));
        System.out.println("Max value: "+findMax(arr));
        System.out.println("Min value: "+findMin(arr));
    }
    static int[] search(int[][] arr, int target){
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if(arr[row][col] == target)
                    return new int[]{row,col};
            }
        }
        return new int[]{-1,-1};
    }
    static int findMax(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if(arr[row][col] > max)
                    max = arr[row][col];
            }
        }
        return max;
    }
    static int findMin(int[][] arr){
        int min = Integer.MAX_VALUE;
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if(arr[row][col] < min)
                    min = arr[row][col];
            }
        }
        return min;
    }
}
