package TCS_NQT;

import java.util.Scanner;

public class P28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sizes = sc.nextLine().trim().split(" ");

        int r = Integer.parseInt(sizes[0]); int c = Integer.parseInt(sizes[1]);
        int[][] nums = new int[r][c];
        int i=0;
        while(i<r){
            String row = sc.nextLine().trim();
            if(row.isEmpty()) continue;
            String[] row_num = row.split(" ");
            int j=0; int col_val=0;
            while(col_val<c){
                if(!row_num[j].isEmpty()) {
                    nums[i][col_val] = Integer.parseInt(row_num[j]);
                    col_val++;
                }
                j++;
            }
            i++;
        }

        System.out.println("Output: ");
        int[][] res = findRev(nums,r,c);
        for(int[] arr : res){
            for(int num : arr) System.out.print(num+" ");
            System.out.println();
        }
    }
    public static int[][] findRev(int[][] nums, int r, int c){
        int[][] res = new int[r][c];
        for(int i=0;i<r;i++){
            for(int k=0;k<c;k++){
                if((i+1)%2 == 0) res[i][k] = nums[i][c-k-1];
                else res[i][k] = nums[i][k];
            }
        }
        return res;
    }
}
