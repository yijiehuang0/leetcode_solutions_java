import java.util.*;
public class longestSubstringWOrepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int j = 0; // second pointer
        int max = 0; // max
        HashMap<Character, Integer> index = new HashMap<>(); // this contains the next position that the string must start at and thus has to be one greater than
        for(int i = 0; i<s.length(); i++) {
            char a = s.charAt(i); // location of char
            if(index.containsKey(a)) {
                j = Math.max(j, index.get(a));    // update the second pointer to gmax
            }
            max = Math.max(max, i - j +1);
            index.put(a, i + 1); // this puts it at position 1

        }
        return max;
    }
    public static void main(String[]args) {
        lengthOfLongestSubstring("aba");
    }


}
