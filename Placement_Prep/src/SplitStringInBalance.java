public class SplitStringInBalance {
    public int balancedStringSplit(String s) {
        int count=0; int total=0;
        for(char ch: s.toCharArray()){
            if(ch=='R') count++;
            else count--;
            if(count==0) total++;
        }
        return total;
    }
}
