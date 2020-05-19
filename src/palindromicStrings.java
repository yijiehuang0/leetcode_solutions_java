public class palindromicStrings {

    int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();
        for(int i = 0; i<len; i++) {
            enumerate(i, i, s);
            enumerate(i, i+1, s);
        }
        return count;
    }
    public void enumerate(int left, int right, String s){
        while(left >= 0 && right <= s.length() -1 && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}


/*



// this is the classic expand outwarts formula
i had no idea how to approach this solution, and it would be better if I had drawn out a diagram or found this pattern before hadn, and thsu that would enable for me to solve this matter

 */
