public class BombDefuse {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        for(int i=0; i<code.length; i++){
            res[i] = findSum(code,i,k);
        }
        return res;
    }
    public int findSum(int[] code, int ind, int k){
        if(k==0) return k;
        else if(k > 0){
            int i=(ind+1)%code.length;
            int sum1=0;
            while(k != 0){
                sum1 += code[i]; i = (i+1)%code.length; k--;
            }
            return sum1;
        }
        else{
            int sum2=0;
            k = Math.abs(k);
            int start = ind-1;
            while(k != 0){
                if(start < 0)
                    start = (code.length + start) % code.length;
                else{
                    sum2 += code[start--]; k--;
                }
            }
            return sum2;
        }
    }
}
