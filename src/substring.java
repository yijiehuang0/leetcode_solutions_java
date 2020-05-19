public class substring {
    public static void main(String[] args) {
        String word = "ab";
        for(int j = 0; j < word.length(); j++){
            String subs = word.substring(0, j) + word.substring(j +1, word.length());
            System.out.println(subs);// the max that it can be is
        }
    }
}
