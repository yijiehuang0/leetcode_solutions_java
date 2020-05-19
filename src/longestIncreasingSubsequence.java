public class longestIncreasingSubsequence {
    public static  int lengthOfLIS(int[] nums) {
        if(nums.length == 0) { // this is bovious
            return 0;
        }
        int maxmax = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1; // the sequennce has to start with zero since 10 is already the alrgest
        for(int i = 1; i<nums.length; i++) {
            int max = 0; // what does this doe?
            for(int j = 0; j <i; j++) { //
                if( nums[j] < nums[i] && dp[j] > max ){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            if(dp[i] > maxmax) {
                maxmax = dp[i];
            }
        }
        return maxmax;

    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
