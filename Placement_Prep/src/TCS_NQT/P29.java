package TCS_NQT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<int[]> nums = new ArrayList<>();
        String[] buffer = sc.nextLine().trim().split(",");
        for(int i=0;i< buffer.length;i++){
            String[] inter = buffer[i].split(" ");
            nums.add(
                    new int[]{
                        Integer.parseInt(inter[0]),
                        Integer.parseInt(inter[1])
                    }
            );
        }
        List<int[]> res = sortPairs(nums);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)[0]+" "+res.get(i)[1]);
            if(i != res.size()-1) System.out.print(",");
        }
    }
    public static List<int[]> sortPairs(List<int[]> pairs){
        int n = pairs.size();
        for(int i=0;i<n;i++){
            int min_ind = i;
            for(int j=i+1;j<n;j++){
                if(isSmaller(pairs.get(j),pairs.get(min_ind))) min_ind = j;
            }
            int[] temp = pairs.get(min_ind);
            pairs.set(min_ind,pairs.get(i));
            pairs.set(i,temp);
        }
        return pairs;
    }
    public static boolean isSmaller(int[] a, int[] b){
        if(a[0] != b[0]) return a[0]<b[0];
        return a[1]<b[1];
    }
}
