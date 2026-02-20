package TCS_NQT;
import java.util.*;
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        int[] E = new int[n]; int[] L = new int[n];
        String string1 = sc.nextLine().trim().
                         replaceAll("\\[|\\]","");
        String[] str1 = string1.split(",");
        for(int i=0; i<n; i++) E[i] = Integer.parseInt(str1[i]);
        String string2 = sc.nextLine().trim().
                         replaceAll("\\[|\\]","");
        String[] str2 = string2.split(",");
        for(int i=0; i<n; i++) L[i] = Integer.parseInt(str2[i]);

        System.out.println(findMaxPerson(E,L));
    }
    public static int findMaxPerson(int[] e, int[] l){
        int maxPerson = 0; int currentPerson = 0;
        for(int i=0;i<e.length;i++){
            currentPerson += e[i] - l[i];
            maxPerson = Math.max(maxPerson,currentPerson);
        }
        return currentPerson;
    }
}
