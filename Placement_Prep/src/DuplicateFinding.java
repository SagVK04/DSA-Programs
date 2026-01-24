import java.util.HashSet;

public class DuplicateFinding {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (!map.add(num)) return true;
        }
        return false;
    }
}
