public class q1 {
    public static void main(String[] args) {
        System.out.println("Final: "+skip1("bcdappfg"));
    }
    static String skip1(String org){
        if(org.isEmpty())
            return " ";
        if(org.startsWith("app") && !org.startsWith("apple"))
            return skip1(org.substring(3));
        else
            return org.charAt(0) + skip1(org.substring(1));
    }
}