import java.util.*;

public class minCostFromLeafValues {

    public static int mctFromLeafValues(int[] A) {

        // this solution actually make sense .. let us run through this and try and find a patter that we can see here
        // move through the problem faster and look for patterns faster!!!!!!!
        int res = 0; // this i the rest
        Stack<Integer> stack = new Stack<>(); // stack to hold everything

        stack.push(Integer.MAX_VALUE); // placement value
        for (int a : A) { // for each values // we add everything ot the stack
            while (stack.peek() <= a) { // if the last is less than the one on top, then we can pop from the stack
                int mid = stack.pop(); // we pop from the stack
                res += mid * Math.min(stack.peek(), a); // we add to the result the the one
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }


    public static int mctFromLeafValues2(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int[][] max = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i ++) {
            int localMax = 0;
            for(int j = i; j < arr.length; j ++) {
                if(arr[j] > localMax) {
                    localMax = arr[j];
                }
                max[i][j] = localMax;
            }
        }
        for(int len = 1; len < arr.length; len ++) {
            for(int left = 0; left + len < arr.length; left ++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                if(len == 1) {
                    dp[left][right] = arr[left]*arr[right];
                } else {
                    for(int k = left; k < right; k ++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k+1][right] + max[left][k]*max[k+1][right]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }

    public static void main(String[] args) {
        mctFromLeafValues(new int[]{6, 2, 4});
    }



}
