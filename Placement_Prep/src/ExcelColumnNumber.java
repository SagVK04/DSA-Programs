public class ExcelColumnNumber {
    public int titleToNumber(String title) {
        int res = 0;
        for(int i=0;i<title.length();i++){
            res = res*26 + (title.charAt(i) - 64);
        }
        return res;
        /*if(title.length() == 1) return (title.charAt(0) - 64);
        int firstNumValue = title.charAt(0)-64;
        int goUpto = 26*firstNumValue;
        int finalNum = goUpto + (title.charAt(1)-64);
        return finalNum;*/
    }
}
