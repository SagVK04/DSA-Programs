import java.util.Arrays;
public class leetcode832 {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 0 , 1, 1},
                { 1, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 1 } };
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        image = flipAndInvertImage(image);
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] a : image) {
            int j = a.length-1;
            for(int i=0;i<a.length/2;i++){
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
                j--;
            }
            for(int i=0;i<a.length;i++){
                a[i] = a[i]^1;
            }
        }
        return image;
    }
}