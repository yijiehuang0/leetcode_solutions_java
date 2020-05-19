public class characterReplacement {

    //  TRUE SLIDING WINDOW QUESTION:
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']); // the max count here helps to fix the size of the window that we are searching for
            while (end - start + 1 - maxCount > k) { // this is really clever
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        characterReplacement("AABACBA", 1);
    }
}
