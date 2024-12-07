public class leetcode1295 {
    class Solution {
        public int findNumbers(int[] nums) {
            int count = 0;
            for(int a : nums){
                if(even(a))
                    count++;
            }
            return count;       
        }
        static boolean even(int a){
            int count = 0;
            while(a > 0){
                count++; a = a/10;
            }
            if(count%2 == 0)
                return true;
            return false;
        }
        boolean even1(int a){
            int count = digits(a);
            return (count%2 == 0);
        }
        int digits(int a){
            if(a < 0)
                a = a*(-1);
            return (int)(Math.log10(a))+1;
        }
    }
}