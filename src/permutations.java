import java.util.*;
public class permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ret;
        }
        recurse(new ArrayList<Integer>(), ret, nums);
        return ret;
    }
    public static void recurse(List<Integer> current, List<List<Integer>> ret, int[] nums) {
        if(current.size() == nums.length) {
            ret.add(new ArrayList<>(current));
            return;
        }
            for(int i = 0; i < nums.length; i++) {
                current.add(nums[i]);
                recurse(current, ret, nums );
                current.remove(current.size() -1);
            }
    }


    // Passing an Index:
    // +1 // then we preserve the indexes and find the subsets of it since we are using an index
    // 1 // then we preserve the indexes and always pick things that are after it or itself

    // Not Using an Index:
    // we are using all possible combinations without assumption of relation

    // if we want to take permutations then that is the same as removing all the things that are repeating from the combinations


    // we prevent duplicates by skipping repeating operations, and this is by skipping the same items at the same levels of recursion, so we skip these
    // we must sort it in this case

    // we use the indicies to keep track of things



    public static void main(String[] args) {

        permute(new int[]{1, 2, 3});
    }
}
