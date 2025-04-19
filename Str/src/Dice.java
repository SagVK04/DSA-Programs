import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        //noOfRollsforTargetSum("",4);
        System.out.println("Dice combinations are: "+noOfRollsforTarget("",12));
        System.out.println("Dice cobinations with custom face: "+customDiceFace("",12,8));
    }
    static void noOfRollsforTargetSum(String pro, Integer target){
        if(target==0){
            System.out.println(pro);
            return;
        }
        for(int i=1;i<=6;i++){
            if(i<=target)
                noOfRollsforTargetSum(pro+i, target-i);
        }
    }
    static ArrayList<String> noOfRollsforTarget(String pro, Integer target){
        if(target == 0){
            ArrayList<String> ans = new ArrayList<>(); ans.add(pro);
            return ans;
        }
        ArrayList<String> fin = new ArrayList<>();
        for(int i=1;i<=6;i++){
            if(i<=target)
                fin.addAll(noOfRollsforTarget(pro+i, target-i));
        }
        return fin;
    }
    static ArrayList<String> customDiceFace(String pro, Integer target,Integer face){
        if(target == 0){
            ArrayList<String> ans = new ArrayList<>(); ans.add(pro);
            return ans;
        }
        ArrayList<String> fin = new ArrayList<>();
        for(int i=1;i<=face;i++){
            if(i<=target)
                fin.addAll(noOfRollsforTarget(pro+i, target-i));
        }
        return fin;
    }
}
