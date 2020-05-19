public class findword {

    public static boolean exist(char[][] board, String word) {
        // boolean array to see if we have gone to this condition
        if(word == "") {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] seen = new boolean[board.length][board[0].length];
        boolean hasSeen = false;
        char first = word.charAt(0);
        String rest = word.substring(1, word.length());
        for(int i = 0; i < m; i++) {
            for(int j =0; j< n; j++) {
                if(board[i][j] == first) {
                    seen[i][j] = true;
                    if(rest.equals("")) {
                        return true;
                    }
                    boolean one = dfs(board, seen, i + 1, j, rest,  m,  n);
                    boolean two = dfs(board, seen, i -1, j, rest,  m,  n);
                    boolean three = dfs(board, seen, i, j + 1, rest,  m,  n);
                    boolean four = dfs(board, seen, i, j -1, rest,  m,  n);
                    boolean numbers = four || one || two || three;
                    if(numbers == false) {
                        seen[i][j] = false;
                    }
                    hasSeen = numbers || hasSeen;

                }
            }
            if(hasSeen == true) {
                return true;
            }
        }
        return hasSeen;
    }

    public static boolean dfs(char[][] board, boolean[][] seen, int mpos, int npos, String word, int m, int n) {
        if(word.equals("")) return true;
        if(mpos <0 || mpos >= m || npos < 0 || npos >=n || seen[mpos][npos] || word.charAt(0) != board[mpos][npos]) {
            return false;
        }
        String rest = "";
        if(word.length() > 1) {
            rest = word.substring(1, word.length());
        }

        seen[mpos][npos] = true;

        boolean one = dfs(board, seen, mpos + 1, npos, rest,  m,  n);
        boolean two = dfs(board, seen, mpos -1, npos, rest,  m,  n);
        boolean three = dfs(board, seen, mpos, npos + 1, rest,  m,  n);
        boolean four = dfs(board, seen, mpos, npos -1, rest,  m,  n);


        if(one || two || three || four){
            return true;
        } else {
            seen[mpos][npos] = false;
            return false;
        }
        // increment increasement and decremnt xpos, ypos and call it using dfs
        // check if it has the final part of the string
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{{ 'a', 'a'}};
        String b = "aaa";
        exist(a, b);
    }
}
