import java.util.ArrayList;
import java.util.List;

public class greatersequence {
    public static List<List<Integer>> greatersequence (int[] array, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(k > array.length) {
            return ret;
        }
        backtrack(array, k, new ArrayList<Integer>(), ret, 0);
        return ret;
    }
    public static void backtrack(int[] array, int k, ArrayList<Integer> current, List<List<Integer>> ret, int index) {
        if(current.size() >= 2) {
            int in = current.size() -2;
            if(current.get(in) > current.get(in + 1)) {
                return;
            }
        }
        if(current.size() == k) {
            ret.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < array.length; i++) { // we need to save the index on certain problems like this and we can't just assume that it is going to work
            current.add(array[i]);
            backtrack(array, k, current, ret, i+1 );
            current.remove(current.size() -1); // this works only when you remove things from the search space after they have been deamed as unworthy
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = greatersequence(new int[]{1, 2, 3, 4, 5}, 2);
        for(List<Integer> a: ret) {
            System.out.println(a);
        }
    }
}
