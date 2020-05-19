public class maximalSubArray {
    public static int maxSubArray(int[] nums) { // i think that you forgot how to do this recurrance relation. to find the max of the arrary you either t
        // take the first element or the previously largest thing.
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = max;
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(dp[i - 1] + nums[i], nums[i]);
            dp[i] = current;
            max = Math.max(current, max);

        }
        return max;
    }

    public static void main(String[] args) {
        maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println();
    }
}
