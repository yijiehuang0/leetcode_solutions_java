import org.w3c.dom.ls.LSOutput;

public class p5 {

    public static String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        } // edge case that is not considered here.

        boolean[][] result = new boolean[s.length()][s.length()];  // this stores if something is valid
        int start = 0;
        int end = 0;

        // we need to keep track of our indexes as well
        for(int i = 0; i < s.length(); i++) {
            result[i][i] = true;
        }

        // Think baou the order in which these problem smust be solved. And in this case.
        // in this case something that needs to be solved first is the orders


        // I think that you have to develop a way of thinking and a sense with the cod in order to do well in this case.


        for(int i = 1; i< s.length(); i++) {
            for(int j = i -1 ; j>= 0; j--) {
                if(s.charAt(i) == s.charAt(j) && (i - j< 2||result[j+1][i-1])) {
                    result[j][i] = true;
                } else {
                    result[j][i] = false;
                }
                if(result[j][i] && i- j > end - start) {
                    end = i;
                    start = j;
                }
            }

        }


        return s.substring(start, end + 1);
    }


    public static boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(actual);
        if(actual.length() == 0 || actual.length() == 1) {
            return true;
        }
        int back = actual.length()-1;
        for(int i = 0; i<actual.length() / 2 ; i++) {
            String f = actual.substring(i, i+1);
            String ss = actual.substring(back, back +1);
            if(!f.equals(ss)) {
                return false;
            }
            back--;
        }

        return true;

    }
    public static void main(String[] args) {
       isPalindrome("race a car");
    }
}
