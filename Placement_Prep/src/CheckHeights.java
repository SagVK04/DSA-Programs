import java.util.Arrays;

public class CheckHeights {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int notMatched = 0; int[] expected = new int[n];
        for(int i=0; i<n; i++)
            expected[i] = heights[i];
        Arrays.sort(expected);
        for(int k=0; k<n; k++){
            if(heights[k] != expected[k])
                notMatched++;
        }
        return notMatched;
    }
}
