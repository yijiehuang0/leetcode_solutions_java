import java.util.*;
public class spiral {
    public static List<Integer> removeLayer(int[][] matrix, int m, int n, int startn, int startm) {


        m = m -1;
        n = n -1;
        List<Integer> ret = new ArrayList<>();

        if(m == 0 && n == 0) {
            ret.add(matrix[startm][startn]);
            return ret;
        }

        // flat line
        if(m == 0 && n!= 0) {
            for(int i = 0; i<= n; i++) {
                ret.add(matrix[startm][startn + i]);
            }
            return ret;
        }
        if(n == 0 && m!= 0) {
            for(int i = 0; i<= m; i++) {
                ret.add(matrix[startm + i][startn]);
            }
            return ret;
        }

        for(int i = 0; i<n; i++) {        // first top layer
            ret.add(matrix[startm][startn + i]);
        }
        startn = startn + n;
        for(int i = 0; i<m; i++) {
            ret.add(matrix[startm + i][startn]);
        }
        startm = startm + m;
        for(int i = 0; i<n; i++) {        // first top layer
            ret.add(matrix[startm][startn - i]);
        }
        startn = 0;
        for(int i = 0; i<m; i++) {
            ret.add(matrix[startm -i][startn]);
        }
        return ret;


    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startn = 0;
        int startm = 0;
        List<Integer> ret = new ArrayList<>();
        while(m >0 && n >0) {
            List<Integer> temp = removeLayer(matrix, m, n, startn, startm);
            ret.addAll(temp);
            n -=2;
            m-=2;
            startn = startn+1;
            startm = startm+1;
        }
        return ret;

    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{1, 2}, { 15, 16}};
        spiralOrder(a);
    }
}
