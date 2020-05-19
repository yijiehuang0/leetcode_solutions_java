public class coinchange2 {
    public static int change(int amount, int[] coins) {
        // we woudl want to sort the coints that we have as well
        int[] dp = new int[amount +1];
        dp[0] = 1;
        for(int i = 0; i< coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i] <= j) {
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return dp[amount];


    }

    public static void main(String[] args) {
        change(5, new int[]{1, 2, 5});
    }
}
