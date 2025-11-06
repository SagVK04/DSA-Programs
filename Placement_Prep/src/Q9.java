import java.util.*;
public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements and enter non integer value to end: ");
        ArrayList<Integer> a = new ArrayList<>();
        while (sc.hasNextInt())
            a.add(sc.nextInt());
        int count = 1;
        for(int i=1; i<a.size(); i++){
            if(isMax(a,i))
                count++;
        }
        System.out.println("Counted numbers: "+count);
    }

    private static boolean isMax(ArrayList<Integer> a, int ind) {
        for(int i=0;i<ind;i++){
            if(a.get(ind) < a.get(i))
                return false;
        }
        return true;
    }
}
