import java.util.*;
public class contiguousArray {
    public static  int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        // the idea here is that we keep track of each of the indices and sums
        // if the sums overlap then that it means that we have something that works in this case
        // if two things add up to the same thing that means that there has to be a case

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            // then we know that something like this can occur in this case
            else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test = new int[] {0,1,1,0,1,1,1,0};
        findMaxLength(test);
    }
}
