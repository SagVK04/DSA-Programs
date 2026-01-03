public class StringRev {
    public void reverseString(char[] org) {
        int s=0; int e=org.length-1;
        while(s<e){
            char temp = org[s];
            org[s] = org[e];
            org[e] = temp;
            s++; e--;
        }
    }
}
