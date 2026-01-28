public class StrringDiff {
    public char findTheDifference(String s, String t) {
        if(s.isEmpty()) return t.charAt(0);
        int charSum = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            // We subtract from s and add from t
            // This treats t as the "positive" and s as the "negative"
            charSum += t.charAt(i);
            charSum -= s.charAt(i);
        }
        // Add the very last character of t which was missed by the loop
        charSum += t.charAt(i);

        // No Math.abs needed. The remaining value is strictly the extra char.
        return (char) charSum;
    }
}
