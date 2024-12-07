public class searching1{
    public static void main(String[] args) {
        String name="AKASH";
        char target = 'H';
        System.out.println(search1(name, target));
        System.out.println(search2(name, 'K'));
        System.out.println(searchInRange(name,target,0,2));
    }
    static boolean search1(String str, char target){
        if(str.length() == 0 )
            return false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == target)
                return true;
        }
        return false;
    }
    static boolean search2(String str, char target){
        if(str.length() == 0 )
            return false;
        for(char a : str.toCharArray()){
            if(a == target)
                return true;
        }
        return false;
    }
    static boolean searchInRange(String str, char target,int start,int end){
        if(str.length() == 0)
            return false;
        for(int i=start;i<=end;i++){
            if(str.charAt(i) == target)
                return true;
        }
        return false;
    }
}