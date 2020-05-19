public class smallestfreq {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freq = new int[12];                   // we are going ot get a len of th freque
        int[] res = new int[queries.length];
        for (String word : words)
            freq[count(word)]++; // we find the frequencies of how many words are in each
        for (int i = 9; i >= 1; i--)
            freq[i] += freq[i + 1];
        int i = 0;
        for (String query : queries)
            res[i++] = freq[count(query) + 1];
        return res;
    }

    public  static int count(String str) {
        int[] freq = new int[26];
        for (char ch : str.toCharArray())
            freq[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return freq[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"});
    }
}
