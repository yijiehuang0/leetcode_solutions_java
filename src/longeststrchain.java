import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longeststrchain {
    public static int longestStrChain(String[] words) {
        int max = 0;
        Arrays.sort(words, (String p1, String p2) -> p1.length() - p2.length()); // i also forgot to include this since its important that when we are working on bottom up that we use the smallest strings first
        Map<String,Integer> set = new HashMap<>();
        int index = 0;
        int[] dp  = new int[words.length];
        for(String s: words) {
            dp[index] = 1;
            set.put(s, index++);
        }

        // the problem that i had was recongizing that any string could be a starting point and thus that any string can word to solving this problem

        for(int i = 0; i< words.length; i++) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                String subs = word.substring(0, j) + word.substring(j +1, word.length());
                if(set.containsKey(subs)){
                    dp[i] = Math.max(1 + dp[set.get(subs)], dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
    }
}
