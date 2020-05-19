import java.util.*;
public class findallanagrams {
    public static List<Integer> findAnagrams(String s, String p) { // the main idea here is that we move from each substring combination that still has something valueable that we want to look at, and then we continue
        ArrayList<Integer> soln = new ArrayList<Integer>(); // we first intialize everything athat we need to initialize
        int[] counts = new int[26];
        for(Character c: p.toCharArray()) {
            counts[c -'a']++;
        }
        char[] haystack = s.toCharArray();
        int targ = p.length();
        int start = 0;
        int end = 0;
        int count = 0;

        // we set up our invariency that positive numbers represent a need, and negative represent what we have
        while(end < haystack.length) { // we move the ends
            // we start with everything first at 1 and that represents a need for something
            if(counts[haystack[end] - 'a'] > 0 ) {   // we are going to decrease everyting since we represent that it is added, therefore if something is positive beforehand, then the count must go up
                count++;
            }
            counts[haystack[end] - 'a']--;
            end++; // move the end ovviously
            while(count == targ){ // we want to check each case that this is true, but we also want to decrease our window as well, moving to the next window
                if(end - start == targ) { // if it is such then we add it to the target
                    soln.add(start);
                }
                counts[haystack[start] - 'a']++; // and we move from the start if the count is still equal to the target

                if(counts[haystack[start] - 'a'] > 0 ) { // we know that one important one must have left, thus now we look at the rest of the substring
                    count--;
                }

                start++;
            }

        }

        return soln;

    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abcdefcbabca", "abc"));
    }
}
